package langina.pages;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static java.time.Duration.ofSeconds;

import com.codeborne.selenide.SelenideElement;
import langina.components.Calendar;

public class RegistrationPage extends RegistrationData {

  public Calendar calendar = new Calendar();

  //locators and elements
  private final String FORM_TITLE = "Student Registration Form";
  final private SelenideElement
      registrationForm = $("#userForm"),
      formTitle = $(".practice-form-wrapper"),
      firstNameField = $("input#firstName"),
      lastNameField = $("#lastName"),
      emailField = $("input#userEmail"),
      genderRadioBtn = $("#genterWrapper"),
      mobileNumberField = $("input#userNumber"),
      subjectsField = $("#subjectsInput"),
      hobbiesCheckbox = $("#hobbiesWrapper"),
      selectPictureBtm = $("#uploadPicture"),
      currentAddressField = $("#currentAddress"),
      stateField = $("#react-select-3-input"),
      cityField = $("#react-select-4-input"),
      submitBtm = $("#submit"),
      confirmationModal = $(".modal-content"),
      resultsTable = $(".table-responsive");

  //actions
  public void submitBtnClick() {
    submitBtm.click();
    confirmationModal.shouldBe(visible, ofSeconds(5));

  }

  public void openPage() {
    open("https://demoqa.com/automation-practice-form");
    formTitle.shouldHave(text(FORM_TITLE));
    registrationForm.shouldBe(visible);
  }

  public RegistrationPage fillFirstName(String data) {
    firstNameField.setValue(data);
    return this;
  }

  public RegistrationPage fillLastName(String data) {
    lastNameField.setValue(data);
    return this;
  }

  public RegistrationPage fillUserEmail(String data) {
    emailField.setValue(data);
    return this;
  }

  public RegistrationPage chooseGender(String data) {
    genderRadioBtn.find(byText(data)).click();
    return this;
  }

  public RegistrationPage fillMobile(String data) {
    mobileNumberField.setValue(data);
    return this;
  }

  public RegistrationPage chooseSubject(String data) {
    subjectsField.setValue(data).pressEnter();
    return this;
  }

  public RegistrationPage chooseHobbies(String data) {
    hobbiesCheckbox.findElement(byText(data)).click();
    return this;
  }

  public RegistrationPage uploadPicture() {
    selectPictureBtm.uploadFromClasspath("RegistrationForm.png");
    return this;
  }

  public RegistrationPage fillCurrentAddress(String data) {
    currentAddressField.setValue(data);
    return this;
  }

  public RegistrationPage chooseState(String data) {
    stateField.setValue(data).pressEnter();
    return this;
  }

  public RegistrationPage chooseCity(String data) {
    cityField.setValue(data).pressEnter();
    return this;
  }

  public RegistrationPage checkStudentInformation(String key, String value) {
    resultsTable.$(byText(key)).parent().shouldHave(text(value));
    return this;
  }
}

