package com.vaadin.addon.charts.testbenchtests;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.vaadin.addon.charts.examples.columnandbar.ColumnWithNativeDrilldown;
import com.vaadin.testbench.By;
import com.vaadin.testbench.annotations.BrowserConfiguration;
import com.vaadin.testbench.annotations.RunLocally;
import com.vaadin.testbench.parallel.Browser;

public class ColumnWithNativeDrilldownTBTest extends AbstractParallelTest {

    @Override
    protected String getTestViewName() {
        return ColumnWithNativeDrilldown.class.getSimpleName();
    }

    @Test
    public void test() throws IOException, AssertionError {
        driver.get(getTestUrl());

        waitForVaadin();
        captureAndCompare("before");


        WebElement element =
            driver.findElement(By.cssSelector(".highcharts-drilldown-point"));
        element.click();

        waitForDynamicChanges();
        captureAndCompare("after");
    }

    @Override
    protected String getPackageName() {
        return "columnandbar";
    }

}
