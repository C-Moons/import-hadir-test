package com.juaracoding.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.juaracoding.page.components.SidebarComponent;

public class ImportCuti extends BasePage {

    private SidebarComponent sidebarComponent;

    private By downloadTemplate = By.xpath("//button[text()='Download Template']");
    private By Upload = By.xpath("//input[@type='file']");
    private By Import = By.xpath("//button[text()='Import']");
    private By Alert = By.xpath("//div[@role='alert' and contains(@class, 'MuiSnackbarContent-root')]");

    public ImportCuti(WebDriver driver){
        super(driver);
        sidebarComponent = new SidebarComponent(driver);
    }

    public SidebarComponent getSidebarComponent() {
        return sidebarComponent;
    }

    public void selectDownloadTemplate(){
        waitingElementReady(downloadTemplate).click();
    }

    public void uploadExcel(String filepath){
        waitingElementReady(Upload).sendKeys(filepath);
    }

    public void importExcel(){
        waitingElementReady(Import).click();
    }

    public String alertMessage(){
        return waitingElementReady(Alert).getText();
    }
}
