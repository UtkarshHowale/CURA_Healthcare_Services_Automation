package org.CURAHealthcareService.Tests.SideMenuPanelTest;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.CURAHealthcareService.BaseTest.BaseTest;
import org.CURAHealthcareService.Pages.HomePage.HomePage;
import org.CURAHealthcareService.Pages.LoginPage.LoginPage;
import org.CURAHealthcareService.Pages.SideMenuPanel.SideMenuPanel;
import org.CURAHealthcareService.Tests.HomePageTest.Test_HomePage_Functionality;
import org.CURAHealthcareService.Utils.Helper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

public class Test_SideMenuPanel extends BaseTest {

    SideMenuPanel sideMenuPanel = new SideMenuPanel();
    Helper helper = new Helper();
    private static final Logger logger = LogManager.getLogger(Test_HomePage_Functionality.class);

    @Owner("Utkarsh Howale")
    @Description("Verify we able to visit to the login page from side menu panel or not")
    @Severity(SeverityLevel.MINOR)
    @Test(groups = "Regression", priority = 1)
    public void VisitLoginPageFromSideMenuPanel() {

        logger.info("Click on side menu bar");
        sideMenuPanel.Side_MenuPanel();

        logger.info("Click on login page link");
        sideMenuPanel.SideMenu_LoginPage_Link();

        String OpenLoginPage = sideMenuPanel.afterClickingGoToNewPage().LoginPageText();
        String ExpectedPage = new LoginPage().LoginPageText();

        helper.setSoftAssert(OpenLoginPage, ExpectedPage);
    }

    @Owner("Utkarsh Howale")
    @Description("Verify we able to visit to the homepage from side menu panel or not")
    @Severity(SeverityLevel.NORMAL)
    @Test(groups = "Regression", priority = 2)
    public void VisitToHomePageFromMenuPanel() {

        logger.info("Click on side menu bar");
        sideMenuPanel.Side_MenuPanel();

        logger.info("Click on homepage link");
        sideMenuPanel.SideMenu_HomePage_Link();

        String OpenHomePage = sideMenuPanel.HomePageText();
        String ExpectedPage = new HomePage().HomePageText();

        helper.setSoftAssert(OpenHomePage, ExpectedPage);
    }

}
