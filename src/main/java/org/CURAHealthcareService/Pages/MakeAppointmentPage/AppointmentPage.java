package org.CURAHealthcareService.Pages.MakeAppointmentPage;

import org.CURAHealthcareService.BasePage.BasePage;
import org.CURAHealthcareService.Utils.Helper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class AppointmentPage extends BasePage {

    Helper helper = new Helper();

    public AppointmentPage() {

    }

    private static final Logger logger = LogManager.getLogger(AppointmentPage.class);
    protected By MakeAppointmentText = By.xpath("//h2[normalize-space()='Make Appointment']");
    protected By FacilityOption = By.id("combo_facility");
    protected By Hospital_Readmission = By.name("hospital_readmission");
    protected By HealthCareProgramOption = By.xpath("//label[@class=\"radio-inline\"]");
    protected By VisitDate = By.id("txt_visit_date");
    protected By DatePickerDays = By.xpath("//td[normalize-space()='14']");
    protected By Comment = By.id("txt_comment");
    protected By SubmitButton = By.id("btn-book-appointment");

    public String MakeAppointmentTextMessage() {

        presenceOfElement(MakeAppointmentText);
        return getElement(MakeAppointmentText).getText();
    }

    public void SelectFacility() {

        WebElement SelectFacilityDropDown = getElement(FacilityOption);
        helper.selectVisibleText(SelectFacilityDropDown, "Hongkong CURA Healthcare Center");

    }

    public void Check_HospitalReadmission() {

        WebElement HospitalReadmission_CheckBox = getElement(Hospital_Readmission);

        if (!HospitalReadmission_CheckBox.isSelected()) {

            HospitalReadmission_CheckBox.click();

        }
        else {

            logger.error("Error Occurred", new Exception("CheckBox Element Not Found!!"));
        }
    }

    public void Select_HealthCareProgramOption() {

        List<WebElement> HealthCareProgram_RadioButton = getElements(HealthCareProgramOption);

        for (WebElement e : HealthCareProgram_RadioButton) {

            if (e.getText().contains("Medicaid")) {

                e.click();

            }
        }
    }

    public void Select_VisitDate() {

        presenceOfElement(VisitDate);
        clickElement(VisitDate);
        clickElement(DatePickerDays);

    }

    public void EnterComment() {

        enterInput(Comment, "I want to book appointment");

    }

    public void Submit() {

        presenceOfElement(SubmitButton);
        clickElement(SubmitButton);
    }

}
