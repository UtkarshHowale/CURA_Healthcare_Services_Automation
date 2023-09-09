package org.CURAHealthcareService.Tests.ProfilePageTest;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.CURAHealthcareService.BaseTest.BaseTest;
import org.CURAHealthcareService.Pages.HomePage.HomePage;
import org.CURAHealthcareService.Pages.ProfilePage.ProfilePage;
import org.CURAHealthcareService.Utils.Helper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

public class Test_ProfilePageFunctionality extends BaseTest {

    ProfilePage profilePage = new ProfilePage();
    Helper helper = new Helper();
    private static final Logger logger = LogManager.getLogger(Test_ProfilePageFunctionality.class);

    @Owner("Utkarsh Howale")
    @Severity(SeverityLevel.MINOR)
    @Description("Verify correct profile page")
    @Test(groups = "Regression", priority = 1)
    public void ProfilePageText() {

        logger.info("Click on side panel");
        profilePage.Side_MenuPanel();

        logger.info("Click on profile button");
        profilePage.ProfilePage_Button();

        String ActualProfilePageText = profilePage.ProfilePageText();
        String ExpectedProfilePageText = "Profile";

        logger.info("Verify profile page text");
        helper.setSoftAssert(ActualProfilePageText, ExpectedProfilePageText);

    }

    @Owner("Utkarsh Howale")
    @Severity(SeverityLevel.NORMAL)
    @Description("Verify able to logout from the profile page")
    @Test(groups = "Regression", priority = 2)
    public void LogoutFromProfilePage() {

        logger.info("Click on side panel");
        profilePage.Side_MenuPanel();

        logger.info("Click on profile button");
        profilePage.ProfilePage_Button();

        logger.info("Click on logout button");
        profilePage.Logout_Button();

        String AfterLogoutActualResult = new HomePage().HomePageText();
        String AfterLogoutExpectedResult = "CURA Healthcare Service";

        logger.info("Verify homepage text");
        helper.setSoftAssert(AfterLogoutActualResult, AfterLogoutExpectedResult);
    }

}
