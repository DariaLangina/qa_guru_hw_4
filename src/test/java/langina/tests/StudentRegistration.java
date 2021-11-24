package langina.tests;

import static com.codeborne.selenide.Selenide.open;

import langina.pages.RegistrationData;
import langina.pages.RegistrationPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StudentRegistration extends TestBase {

  RegistrationPage registrationPage = new RegistrationPage();
  RegistrationData user = new RegistrationData();

//  @BeforeEach
//  void ensurePrecondition() {
//    registrationPage.openPage();
//  }

  @Test
  @DisplayName("Регистрация с заполнением дополнительных полей")
  void registrationWithAllFields() {
    open("https://demoqa.com/automation-practice-form");
    registrationPage.fillFirstName(user.firstName)
                    .fillLastName(user.lastName)
                    .fillUserEmail(user.email)
                    .chooseGender("Female")
                    .fillMobile(user.mobile)
                    .chooseSubject("Arts")
                    .uploadPicture()
                    .chooseHobbies("Reading")
                    .fillCurrentAddress(user.address)
                    .chooseState("NCR")
                    .chooseCity("Noida")
        .calendar.setDate("11", "10", "1990");
    registrationPage.submitBtnClick();
    registrationPage.checkStudentInformation("Student Name", user.firstName)
                    .checkStudentInformation("Student Email", user.email)
                    .checkStudentInformation("Gender", "Female")
                    .checkStudentInformation("Mobile", user.mobile)
                    .checkStudentInformation("Date of Birth", "11 November,1990")
                    .checkStudentInformation("Subjects", "Arts")
                    .checkStudentInformation("Hobbies", "Reading")
                    .checkStudentInformation("Picture", "RegistrationForm.png")
                    .checkStudentInformation("Address", user.address)
                    .checkStudentInformation("State and City", "NCR Noida");
  }
}