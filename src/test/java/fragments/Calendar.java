package fragments;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

import com.codeborne.selenide.SelenideElement;

public class Calendar {

  private final SelenideElement dateInput = $("#dateOfBirthInput"),
      monthInCalendar = $(".react-datepicker__month-select"),
      yearInCalendar = $(".react-datepicker__year-select");

  private final String dayInCalendar = ".react-datepicker__day";


  public void setDate(String day, String month, String year) {
    dateInput.click();
    monthInCalendar.selectOptionByValue(month);
    yearInCalendar.selectOptionByValue(year);
    $$(dayInCalendar).find(text(day)).click();
  }
}
