package org.CURAHealthcareService.Pages.ProfilePage;

import org.CURAHealthcareService.BasePage.BasePage;
import org.CURAHealthcareService.Driver.DriverManager;
import org.openqa.selenium.By;

public class ProfilePage extends BasePage {

    protected By SideMenu = By.id("menu-toggle");
    protected By ProfileButton = By.xpath("//a[normalize-space()='Profile']");
    protected By LogoutButton = By.xpath("//a[@class='btn btn-default']");
    protected By ProfilePageText = By.xpath("//h2");

    public void Side_MenuPanel() {

        presenceOfElement(SideMenu);
        clickElement(SideMenu);
    }

    public void ProfilePage_Button() {
        presenceOfElement(ProfileButton);
        clickElement(ProfileButton);
    }

    public String ProfilePageText() {

        presenceOfElement(ProfilePageText);
        return DriverManager.getDriver().findElement(ProfilePageText).getText();

    }

    public void Logout_Button() {

        presenceOfElement(LogoutButton);
        clickElement(LogoutButton);
    }


}
