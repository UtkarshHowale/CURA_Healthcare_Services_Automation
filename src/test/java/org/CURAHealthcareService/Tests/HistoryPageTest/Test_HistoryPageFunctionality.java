package org.CURAHealthcareService.Tests.HistoryPageTest;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.CURAHealthcareService.BaseTest.BaseTest;
import org.CURAHealthcareService.Pages.HistoryPage.HistoryPage;
import org.CURAHealthcareService.Pages.HomePage.HomePage;
import org.CURAHealthcareService.Utils.Helper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

public class Test_HistoryPageFunctionality extends BaseTest {

    HistoryPage historyPage = new HistoryPage();
    Helper helper = new Helper();
    private static final Logger logger = LogManager.getLogger(Test_HistoryPageFunctionality.class);

    @Owner("Utkarsh Howale")
    @Description("Verify correct history page ")
    @Test(priority = 1)
    public void HistoryPageText() {

        logger.info("Click on side panel");
        historyPage.Side_MenuPanel();

        logger.info("Click on history button");
        historyPage.HistoryPage_Button();

        String ActualHistoryPageText = historyPage.HistoryPageText();
        String ExpectedHistoryPageText = "History";

        logger.info("Verify profile page text");
        helper.setSoftAssert(ActualHistoryPageText, ExpectedHistoryPageText);

    }

    @Description("Verify able to go to dashboard page from history page")
    @Test(priority = 2)
    public void GoToDashboardFromHistoryPage() {

        logger.info("Click on side panel");
        historyPage.Side_MenuPanel();

        logger.info("Click on history button");
        historyPage.HistoryPage_Button();

        logger.info("Go to dashboard page");
        historyPage.GoRoDashboardPage();

        String AfterLogoutActualResult = new HomePage().HomePageText();
        String AfterLogoutExpectedResult = new HomePage().HomePageText();

        logger.info("Verify homepage text");
        helper.setSoftAssert(AfterLogoutActualResult, AfterLogoutExpectedResult);
    }
}
