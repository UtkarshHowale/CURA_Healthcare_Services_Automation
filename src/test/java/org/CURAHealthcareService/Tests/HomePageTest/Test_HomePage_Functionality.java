package org.CURAHealthcareService.Tests.HomePageTest;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.CURAHealthcareService.BaseTest.BaseTest;
import org.CURAHealthcareService.Pages.HomePage.HomePage;
import org.CURAHealthcareService.Pages.LoginPage.LoginPage;
import org.CURAHealthcareService.Utils.Helper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Test_HomePage_Functionality extends BaseTest {
    HomePage homePage = new HomePage();
    Helper helper = new Helper();
    private static final Logger logger = LogManager.getLogger(Test_HomePage_Functionality.class);

    @Owner("Utkarsh Howale")
    @Description("Verify we are on the correct homepage or not")
    @Severity(SeverityLevel.MINOR)
    @Test(priority = 1)
    public void HomePageText() {

        logger.info("Homepage Verification");
        String ExpectedText = "CURA Healthcare Service";
        String ActualText = homePage.HomePageText();

        helper.setSoftAssert(ActualText, ExpectedText);
    }

    @Owner("Utkarsh Howale")
    @Description("Verify make appointment button is present on the homepage or not")
    @Severity(SeverityLevel.MINOR)
    @Test(priority = 2)
    public void MakeAppointmentButtonIsDisplayed() {

        WebElement MakeAppointment_Button = homePage.MakeAppointmentButton();

        if (MakeAppointment_Button.isDisplayed()) {
            logger.info("MakeAppointmentButton is displayed");
        } else {
            logger.error("Error Occurred", new Exception("Button is not present"));
        }
    }

    @Owner("Utkarsh Howale")
    @Description("Verify the clicking functionality od make appointment button is working or not ")
    @Severity(SeverityLevel.CRITICAL)
    @Test(groups = "Smoke", priority = 3)
    public void VerifyFunctionalityOfMakeAppointmentButton() {

        logger.info("Click on make appointment button");
        homePage.clickMakeAppointmentButton();

        String OpenNewPageText = homePage.afterClickingGoToNewPage().LoginPageText();
        String ExpectedPageText = new LoginPage().LoginPageText();

        helper.setSoftAssert(OpenNewPageText, ExpectedPageText);
    }


}

