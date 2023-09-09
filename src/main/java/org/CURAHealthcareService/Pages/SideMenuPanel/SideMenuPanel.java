package org.CURAHealthcareService.Pages.SideMenuPanel;

import org.CURAHealthcareService.BasePage.BasePage;
import org.CURAHealthcareService.Driver.DriverManager;
import org.CURAHealthcareService.Pages.HomePage.HomePage;
import org.CURAHealthcareService.Pages.LoginPage.LoginPage;
import org.openqa.selenium.By;

public class SideMenuPanel extends BasePage {

    protected By MenuPanel = By.xpath("//i[@class='fa fa-bars']");
    protected By LoginPage_link = By.xpath("//a[normalize-space()='Login']");
    protected By HomePage_link = By.xpath("//a[normalize-space()='Home']");
    protected By GoToHomepage = By.xpath("//a[@class=\"btn btn-default\"]");
    protected By SideMenu = By.id("menu-toggle");
    protected By HomepageButton = By.xpath("//a[normalize-space()='Home']");
    protected By ProfileButton = By.xpath("//a[normalize-space()='Profile']");
    protected By HistoryPageButton = By.xpath("//a[normalize-space()='History']");
    protected By LogoutButton = By.xpath("//a[normalize-space()='Logout']");

    protected By HomePageText = By.xpath("//h1");

    public void GoToHomepage_Button() {

        presenceOfElement(GoToHomepage);
        clickElement(GoToHomepage);
    }

    public void Side_MenuPanel() {

        presenceOfElement(SideMenu);
        clickElement(SideMenu);
    }

    public void Homepage_Button() {

        presenceOfElement(HomepageButton);
        clickElement(HomepageButton);
    }

    public void ProfilePage_Button() {
        presenceOfElement(ProfileButton);
        clickElement(ProfileButton);
    }

    public void HistoryPage_Button() {

        presenceOfElement(HistoryPageButton);
        clickElement(HistoryPageButton);
    }

    public void Logout_Button() {

        presenceOfElement(LogoutButton);
        clickElement(LogoutButton);
    }

    public void SideMenu_LoginPage_Link() {

        presenceOfElement(LoginPage_link);
        clickElement(LoginPage_link);
    }

    public void SideMenu_HomePage_Link() {

        presenceOfElement(HomePage_link);
        clickElement(HomePage_link);
    }

    public LoginPage afterClickingGoToNewPage() {

        return new LoginPage();
    }

    public HomePage afterClickingGoToHomePage() {

        return new HomePage();
    }

    public String HomePageText() {

        presenceOfElement(HomePageText);
        return DriverManager.getDriver().findElement(HomePageText).getText();

    }


}
