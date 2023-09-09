package org.CURAHealthcareService.Pages.HistoryPage;

import org.CURAHealthcareService.BasePage.BasePage;
import org.openqa.selenium.By;

public class HistoryPage extends BasePage {

    protected By SideMenu = By.id("menu-toggle");
    protected By HistoryPageButton = By.xpath("//a[normalize-space()='History']");
    protected By HistoryPageText = By.xpath("//h2");
    protected By GoToDashboard = By.xpath("//a[normalize-space()='Go to Homepage']");

    public void Side_MenuPanel() {

        presenceOfElement(SideMenu);
        clickElement(SideMenu);
    }

    public void HistoryPage_Button() {

        presenceOfElement(HistoryPageButton);
        clickElement(HistoryPageButton);
    }

    public String HistoryPageText() {

        presenceOfElement(HistoryPageText);
        return getElement(HistoryPageText).getText();

    }

    public String GoRoDashboardPage() {

        presenceOfElement(GoToDashboard);
        return getElement(GoToDashboard).getText();
    }


}
