package org.CURAHealthcareService.Pages.LoginPage;

import org.CURAHealthcareService.BasePage.BasePage;
import org.CURAHealthcareService.Driver.DriverManager;
import org.CURAHealthcareService.Pages.MakeAppointmentPage.AppointmentPage;
import org.CURAHealthcareService.Utils.PropertyReader;
import org.openqa.selenium.By;

public class LoginPage extends BasePage {

    public LoginPage() {

        super();
    }

    protected By Username = By.id("txt-username");
    protected By Password = By.id("txt-password");
    protected By LoginButton = By.id("btn-login");
    protected By FaildLoginErrorMessage = By.xpath("//p[@class=\"lead text-danger\"]");
    protected By LoginPageText = By.xpath("//h2");

    public void loginToCURAHealthcareService() {


        try {

            enterInput(Username, PropertyReader.readKeys("UserName"));
            enterInput(Password, PropertyReader.readKeys("Password"));
            clickElement(LoginButton);
        } catch (Exception e) {

            e.printStackTrace();
        }

    }

    public void InvalidLoginTest() {

        try {

            enterInput(Username, PropertyReader.readKeys("InvalidUserName"));
            enterInput(Password, PropertyReader.readKeys("InvalidPassword"));
            clickElement(LoginButton);
        } catch (Exception e) {

            e.printStackTrace();
        }

    }

    public String ErrorMessageText() {

        visibilityOfElement(FaildLoginErrorMessage);
        return DriverManager.getDriver().findElement(FaildLoginErrorMessage).getText();
    }

    public String LoginPageText() {

        visibilityOfElement(LoginPageText);
        return getElement(LoginPageText).getText();
    }

    public AppointmentPage afterLoginGoToNewPage() {

        return new AppointmentPage();
    }

}
