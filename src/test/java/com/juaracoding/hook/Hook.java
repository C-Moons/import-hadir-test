package com.juaracoding.hook;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.juaracoding.utils.DriverUtil;

import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.Scenario;


public class Hook {

    @BeforeAll
    public static void beforeHook() {
        DriverUtil.getInstance();
    }

    @AfterAll
    public static void afterHook() {
        DriverUtil.destroy();
    }

    @After
    public static void tearDown(Scenario scenario) {

    final byte[] screenshot = ((TakesScreenshot)
    DriverUtil.getInstance()).getScreenshotAs(OutputType.BYTES);
    scenario.attach(screenshot, "image/png", scenario.getName());

    }
}
