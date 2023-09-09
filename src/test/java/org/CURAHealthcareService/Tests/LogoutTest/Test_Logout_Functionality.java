package org.CURAHealthcareService.Tests.LogoutTest;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.CURAHealthcareService.BaseTest.BaseTest;
import org.CURAHealthcareService.Pages.HomePage.HomePage;
import org.CURAHealthcareService.Pages.LoginPage.LoginPage;
import org.CURAHealthcareService.Pages.SideMenuPanel.SideMenuPanel;
import org.CURAHealthcareService.Utils.Helper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

public class Test_Logout_Functionality extends BaseTest {

    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();
    Helper helper = new Helper();
    SideMenuPanel sideMenuPanel = new SideMenuPanel();
    private static final Logger logger = LogManager.getLogger(Test_Logout_Functionality.class);

    @Owner("Utkarsh Howale")
    @Description("Verify logout functionality is working fine or not")
    @Severity(SeverityLevel.CRITICAL)
    @Test(groups = "Smoke", priority = 1)
    public void LogoutFunctionality() {

        logger.info("Click on make appointment button");
        homePage.clickMakeAppointmentButton();

        logger.info("Login to the account");
        loginPage.loginToCURAHealthcareService();

        logger.info("Click on side menu panel");
        sideMenuPanel.Side_MenuPanel();

        logger.info("Click on logout button");
        sideMenuPanel.Logout_Button();

        String AfterLogoutActualPage = sideMenuPanel.afterClickingGoToHomePage().HomePageText();
        String AfterLogoutExpectedPage = new HomePage().HomePageText();

        helper.setSoftAssert(AfterLogoutActualPage, AfterLogoutExpectedPage);

    }
}
