package org.CURAHealthcareService.Tests.LoginTest;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.CURAHealthcareService.BaseTest.BaseTest;
import org.CURAHealthcareService.Driver.DriverManager;
import org.CURAHealthcareService.Pages.HomePage.HomePage;
import org.CURAHealthcareService.Pages.LoginPage.LoginPage;
import org.CURAHealthcareService.Pages.MakeAppointmentPage.AppointmentPage;
import org.CURAHealthcareService.Utils.Helper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;
import java.lang.reflect.Method;


public class Test_LoginFunctionality extends BaseTest {

    private static final Logger logger = LogManager.getLogger(Test_LoginFunctionality.class);
    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();
    AppointmentPage appointmentPage = new AppointmentPage();
    Helper helper = new Helper();

    @Owner("Utkarsh Howale")
    @Description("Verify login functionality using invalid credentials")
    @Severity(SeverityLevel.CRITICAL)
    @Test(groups = "Smoke", priority = 1)
    public void Invalid_LoginTest(Method method) {

        logger.info("Click on make appointment button");
        homePage.clickMakeAppointmentButton();

        logger.info("Logging into the account");
        loginPage.InvalidLoginTest();
        TakeScreenshot(method.getName(), DriverManager.getDriver());

        String ActualResult = loginPage.ErrorMessageText();
        String ExpectedResult = "Login failed! Please ensure the username and password are valid.";

        helper.setSoftAssert(ActualResult, ExpectedResult);


    }

    @Owner("Utkarsh Howale")
    @Description("Verify login functionality using valid credentials")
    @Severity(SeverityLevel.CRITICAL)
    @Test(groups = "Smoke", priority = 2)
    public void Valid_LoginTest() {

        logger.info("Click on make appointment button");
        homePage.clickMakeAppointmentButton();

        logger.info("Logging into the account");
        loginPage.loginToCURAHealthcareService();

        logger.info("Verify the result");
        String ActualResult = appointmentPage.MakeAppointmentTextMessage();
        String ExpectedResult = "Make Appointment";

        helper.setSoftAssert(ActualResult, ExpectedResult);

    }
}
