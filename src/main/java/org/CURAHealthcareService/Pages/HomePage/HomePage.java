package org.CURAHealthcareService.Pages.HomePage;

import org.CURAHealthcareService.BasePage.BasePage;
import org.CURAHealthcareService.Driver.DriverManager;
import org.CURAHealthcareService.Pages.LoginPage.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage {


    public HomePage() {

    }

    protected By HomePageText = By.xpath("//h1");
    protected By MakeAppointmentButton = By.id("btn-make-appointment");


    public void clickMakeAppointmentButton() {

        presenceOfElement(MakeAppointmentButton);
        clickElement(MakeAppointmentButton);
    }

    public String HomePageText() {

        presenceOfElement(HomePageText);
        return DriverManager.getDriver().findElement(HomePageText).getText();

    }

    public WebElement MakeAppointmentButton() {

        presenceOfElement(MakeAppointmentButton);
        return getElement(MakeAppointmentButton);
    }

    public LoginPage afterClickingGoToNewPage() {

        return new LoginPage();
    }
}
