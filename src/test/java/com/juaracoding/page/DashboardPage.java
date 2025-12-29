package com.juaracoding.page;

import org.openqa.selenium.WebDriver;

import com.juaracoding.page.components.SidebarComponent;

public class DashboardPage extends BasePage {

    private SidebarComponent sidebarComponent;

    public DashboardPage(WebDriver driver) {
        super(driver);
        sidebarComponent = new SidebarComponent(driver);
    }

    public SidebarComponent getSidebarComponent() {
        return sidebarComponent;
    }

    public String getPathURL() {
        String[] path = driver.getCurrentUrl().split("/");
        return "/" + path[path.length - 1];
    }

}
