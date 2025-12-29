package com.juaracoding.definition;

import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.juaracoding.page.DashboardPage;
import com.juaracoding.page.ImportStrukturUser;
import com.juaracoding.page.LoginPage;
import com.juaracoding.utils.DriverUtil;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class ImportStrukturUserStepDefinition {

    private LoginPage loginPage;
    private DashboardPage dashboardPage;
    private ImportStrukturUser importStrukturUser;

    @Given("Saya buka browser dan mengakses halaman login web.")
    public void openBrowserAndLogin() {
        loginPage = new LoginPage(DriverUtil.getInstance());
        dashboardPage = new DashboardPage(DriverUtil.getInstance());
        importStrukturUser = new ImportStrukturUser(DriverUtil.getInstance());
        DriverUtil.getInstance().get("https://magang.dikahadir.com/authentication/login");
    }

    @When("input username {string} dan password {string} login.")
    public void loginWeb(String username, String password) {
        loginPage.inputUsername(username);
        loginPage.inputPassword(password);
        loginPage.clickButtonLogin();
    }

    @And("Masuk di dashboard dan akses import di sidebar.")
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

    @And("Pilih Import Struktur User.")
    public void selectImportAbsen() {
        dashboardPage.getSidebarComponent().clickImportStrukturUser();

        String expectedUrl = "https://magang.dikahadir.com/imports/import-struktur-users";
        WebDriverWait wait = new WebDriverWait(DriverUtil.getInstance(), Duration.ofSeconds(2));
        wait.until(ExpectedConditions.urlToBe(expectedUrl));
        String currentUrl = loginPage.getCurrentURL();
        Assert.assertEquals(currentUrl, expectedUrl);
    }

    @And("Pilih Download Template Struktur User.")
    public void chooseDownloadTemplate() {
        importStrukturUser.selectDownloadTemplate();
    }

    @And("Upload file {string} ke kolom Struktur User.")
    public void uploadFile(String upload_file) {
        String projectDir = System.getProperty("user.dir");
        String filePath = projectDir + "/src/test/resources/data/" + upload_file;
        importStrukturUser.uploadExcel(filePath);

    }

    @And("Tekan tombol import untuk upload file ke Struktur User.")
    public void importFile() {
        importStrukturUser.importExcel();
    }

    @And("Keluar pesan dengan isi {string} jika status {string}.")
    public void getMessage(String message, String status) {
        if (status.equals("sukses")) {
            Assert.assertEquals(importStrukturUser.alertMessage(), message);
        } else {
            Assert.assertEquals(importStrukturUser.alertMessage(), message);
        }
    }

    
}
