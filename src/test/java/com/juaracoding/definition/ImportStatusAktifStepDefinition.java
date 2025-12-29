package com.juaracoding.definition;

import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.juaracoding.page.DashboardPage;
import com.juaracoding.page.ImportStatusAktif;
import com.juaracoding.page.LoginPage;
import com.juaracoding.utils.DriverUtil;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class ImportStatusAktifStepDefinition {
    private LoginPage loginPage;
    private DashboardPage dashboardPage;
    private ImportStatusAktif importStatusAktif;

    @Given("Saya buka browser dan mengakses halaman login.")
    public void openBrowserAndLogin() {
        loginPage = new LoginPage(DriverUtil.getInstance());
        dashboardPage = new DashboardPage(DriverUtil.getInstance());
        importStatusAktif = new ImportStatusAktif(DriverUtil.getInstance());
        DriverUtil.getInstance().get("https://magang.dikahadir.com/authentication/login");
    }

    @When("memasukkan username {string} dan password {string} login.")
    public void loginWeb(String username, String password) {
        loginPage.inputUsername(username);
        loginPage.inputPassword(password);
        loginPage.clickButtonLogin();
    }

    @And("Masuk menu dashboard dan akses import di sidebar.")
    public void accessImportSidebar() {
        WebDriverWait wait = new WebDriverWait(DriverUtil.getInstance(), Duration.ofSeconds(15));
        wait.until(ExpectedConditions.urlContains("/dashboards/"));

        String currentUrl = loginPage.getCurrentURL();
        String expectedUrl = "https://magang.dikahadir.com/dashboards/pending";
        Assert.assertEquals(currentUrl, expectedUrl);

        dashboardPage.getSidebarComponent().clickImport();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @And("Pilih Import Status Aktif.")
    public void selectImportAbsen() {
        dashboardPage.getSidebarComponent().clickImportStatusAktif();

        String expectedUrl = "https://magang.dikahadir.com/imports/import-status-aktif";
        WebDriverWait wait = new WebDriverWait(DriverUtil.getInstance(), Duration.ofSeconds(2));
        wait.until(ExpectedConditions.urlToBe(expectedUrl));
        String currentUrl = loginPage.getCurrentURL();
        Assert.assertEquals(currentUrl, expectedUrl);
    }

    @And("Pilih Download Template Status Aktif.")
    public void chooseDownloadTemplate() {
        importStatusAktif.selectDownloadTemplate();
    }

    @And("Upload file {string} ke kolom Status Aktif .")
    public void uploadFile(String upload_file) {
        String projectDir = System.getProperty("user.dir");
        String filePath = projectDir + "/src/test/resources/data/" + upload_file;
        importStatusAktif.uploadExcel(filePath);

    }

    @And("Tekan tombol import untuk upload file ke Status Aktif.")
    public void importFile() {
        importStatusAktif.importExcel();
    }

    @And("Keluar pesan status aktif dengan {string} jika status {string}.")
    public void getMessage(String message, String status) {
        if (status.equals("sukses")) {
            Assert.assertEquals(importStatusAktif.alertMessage(), message);
        } else {
            Assert.assertEquals(importStatusAktif.alertMessage(), message);
        }
    }
}
