package com.juaracoding.page.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SidebarComponent extends BaseComponent {
    private By importSidebar = By.xpath("//div[contains(@class, 'sidebar__wrapper')]//p[text()='Import']");

    private By importAbsen = By.xpath("//p[contains(text(), 'Import Absen')]");
    private By importStatusAktif = By.xpath("//p[contains(text(), 'Import Status Aktif')]");

    private By importStrukturUser = By.xpath("//p[contains(text(), 'Import Struktur User')]");

    private By importCuti = By.xpath("//p[contains(text(), 'Import Cuti')]");

    public SidebarComponent(WebDriver driver) {
        super(driver);
    }

    public void clickImport() {
        WebElement element = waitingElementReady(importSidebar);
        element.click();
    }

    public void clickImportAbsen() {
        WebElement element = waitingElementReady(importAbsen);
        element.click();
    }

    public void clickImportStatusAktif() {
        WebElement element = waitingElementReady(importStatusAktif);
        element.click();
    }

    public void clickImportStrukturUser() {
        WebElement element = waitingElementReady(importStrukturUser);
        element.click();
    }

    public void clickImportCuti() {
        WebElement element = waitingElementReady(importCuti);
        element.click();
    }
}
