package org.CURAHealthcareService.Tests.AppointmentBookingPage;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.CURAHealthcareService.BaseTest.BaseTest;
import org.CURAHealthcareService.Pages.AppointmentConfirmationPage.AppointmentConformationPage;
import org.CURAHealthcareService.Pages.HomePage.HomePage;
import org.CURAHealthcareService.Pages.MakeAppointmentPage.AppointmentPage;
import org.CURAHealthcareService.Pages.SideMenuPanel.SideMenuPanel;
import org.CURAHealthcareService.Tests.LoginTest.Test_LoginFunctionality;
import org.CURAHealthcareService.Utils.Helper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

public class Test_AppointmentBookingFunctionality extends BaseTest {

    private static final Logger logger = LogManager.getLogger(Test_LoginFunctionality.class);
    AppointmentPage appointmentPage = new AppointmentPage();
    AppointmentConformationPage appointmentConformationPage = new AppointmentConformationPage();

    SideMenuPanel sideMenuPanel = new SideMenuPanel();
    Helper helper = new Helper();


    @Owner("Utkarsh Howale")
    @Description("Verify make appointment functionality is working fine or not")
    @Severity(SeverityLevel.CRITICAL)
    @Test(groups = "Smoke", priority = 1)
    public void BookAppointmentFunctionality() {

        logger.info("Select Facility FromDropdown");
        appointmentPage.SelectFacility();

        logger.info("Select HospitalReadmission Checkbox");
        appointmentPage.Check_HospitalReadmission();

        logger.info("Select HealthCareProgram Option");
        appointmentPage.Select_HealthCareProgramOption();

        logger.info("Choose VisitDate From Calender ");
        appointmentPage.Select_VisitDate();

        logger.info("Enter Comment In Comment Box");
        appointmentPage.EnterComment();

        logger.info("Submit Appointment Details");
        appointmentPage.Submit();

        String Expected_AppointmentConformationText = "Appointment Confirmation";
        String Actual_AppointmentConformationText = appointmentConformationPage.ConfirmAppointmentText();

        helper.setAssert(Actual_AppointmentConformationText, Expected_AppointmentConformationText);

        logger.info("Click on side manual panel");
        sideMenuPanel.Side_MenuPanel();

        logger.info("Click on logout button");
        sideMenuPanel.Logout_Button();

        String AfterLogoutActualPage = new HomePage().HomePageText();
        String AfterLogoutExpectedPage = "CURA Healthcare Service";

        if (AfterLogoutActualPage.equalsIgnoreCase(AfterLogoutExpectedPage)){

            logger.info("User logout successfully");
        }
        else {

            logger.info("User unable to log out");
        }
    }
}
