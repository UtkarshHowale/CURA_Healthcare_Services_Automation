package org.CURAHealthcareService.Utils;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.Assertion;
import org.testng.asserts.SoftAssert;


public class Helper {

    public WebDriver driver;
    public Select select;
    public Actions actions;
    public Assertion assertion = new Assertion();
    public SoftAssert softAssert = new SoftAssert();

    public Helper() {

    }

    public void selectVisibleText(WebElement element, String key) {

        select = new Select(element);
        select.selectByVisibleText(key);
    }

    public void selectByIndex(WebElement element, int value) {

        select = new Select(element);
        select.selectByIndex(value);
    }

    public void setAssert(String Actual, String Expected) {

        assertion.assertEquals(Actual, Expected);
    }

    public void setSoftAssert(String Actual, String Expected) {

        softAssert.assertEquals(Actual, Expected);
    }

}
