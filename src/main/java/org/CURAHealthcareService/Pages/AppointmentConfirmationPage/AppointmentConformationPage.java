package org.CURAHealthcareService.Pages.AppointmentConfirmationPage;

import org.CURAHealthcareService.BasePage.BasePage;
import org.openqa.selenium.By;

public class AppointmentConformationPage extends BasePage {

    protected By AppointmentConformation_Text = By.xpath("//h2");


    public String ConfirmAppointmentText() {

        return getElement(AppointmentConformation_Text).getText();

    }
}

