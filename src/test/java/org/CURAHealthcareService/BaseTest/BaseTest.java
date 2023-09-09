package org.CURAHealthcareService.BaseTest;

import io.qameta.allure.Allure;
import org.CURAHealthcareService.BasePage.BasePage;
import org.CURAHealthcareService.Driver.DriverManager;
import org.CURAHealthcareService.Pages.HomePage.HomePage;
import org.CURAHealthcareService.Pages.LoginPage.LoginPage;
import org.CURAHealthcareService.Utils.PropertyReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import java.io.ByteArrayInputStream;


public class BaseTest extends BasePage {

    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();
    private static final Logger logger = LogManager.getLogger(BaseTest.class);

    @BeforeSuite
    protected void setUpMethod() {

        try {

            DriverManager.startDriver(PropertyReader.readKeys("BrowserName"));
            DriverManager.getDriver().get(PropertyReader.readKeys("BaseUrl"));
            WindowMaximize();
            logger.info("Click on make appointment button");
            homePage.clickMakeAppointmentButton();
            logger.info("Login into account");
            loginPage.loginToCURAHealthcareService();

        }
        catch (Exception e) {

            e.printStackTrace();
        }

    }

    @AfterSuite
    protected void tearDownMethod() {

        DriverManager.closeDriver();
    }

    protected void TakeScreenshot(String name, WebDriver driver) {

        Allure.addAttachment(name, new ByteArrayInputStream(((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.BYTES)));
    }

}
