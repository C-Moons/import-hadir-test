package com.juaracoding.definition;

import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.juaracoding.page.DashboardPage;
import com.juaracoding.page.ImportAbsen;
import com.juaracoding.page.LoginPage;
import com.juaracoding.utils.DriverUtil;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class ImportAbsenStepDefinition {
    private LoginPage loginPage;
    private DashboardPage dashboardPage;
    private ImportAbsen importAbsen;

    @Given("Saya membuka browser dan mengakses halaman login.")
    public void openBrowserAndLogin() {
        loginPage = new LoginPage(DriverUtil.getInstance());
        dashboardPage = new DashboardPage(DriverUtil.getInstance());
        importAbsen = new ImportAbsen(DriverUtil.getInstance());
        DriverUtil.getInstance().get("https://magang.dikahadir.com/authentication/login");

    }

    @When("Saya memasukkan username {string} dan password {string} login.")
    public void loginWeb(String username, String password) {
        loginPage.inputUsername(username);
        loginPage.inputPassword(password);
        loginPage.clickButtonLogin();
    }

    @And("Masuk dashboard dan akses import di sidebar.")
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

    @And("Pilih Import Absen.")
    public void selectImportAbsen() {
        dashboardPage.getSidebarComponent().clickImportAbsen();

        String expectedUrl = "https://magang.dikahadir.com/imports/import-absen-hadir";
        WebDriverWait wait = new WebDriverWait(DriverUtil.getInstance(), Duration.ofSeconds(2));
        wait.until(ExpectedConditions.urlToBe(expectedUrl));
        String currentUrl = loginPage.getCurrentURL();
        Assert.assertEquals(currentUrl, expectedUrl);
    }

    @And("Pilih Download Template.")
    public void chooseDownloadTemplate() {
        importAbsen.selectDownloadTemplate();
    }

    @And("Upload file {string} .")
    public void uploadFile(String upload_file) {
        String projectDir = System.getProperty("user.dir");
        String filePath = projectDir + "/src/test/resources/data/" + upload_file;
        importAbsen.uploadExcel(filePath);
    }

    @And("Tekan tombol import.")
    public void importFile() {
        importAbsen.importExcel();
    }

    @And("Keluar pesan dengan {string} jika status {string}.")
    public void getMessage(String message, String status) {
        if (status.equals("sukses")) {
            Assert.assertEquals(importAbsen.alertMessage(), message);
        } else {
            Assert.assertEquals(importAbsen.alertMessage(), message);
        }
    }

}
