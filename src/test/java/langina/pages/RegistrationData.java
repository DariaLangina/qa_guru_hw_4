package langina.pages;

import com.github.javafaker.Faker;
import java.util.Locale;

public class RegistrationData {

  Faker faker = new Faker(new Locale("ru"));
  public String firstName = faker.name().firstName();
  public String lastName = faker.name().lastName();
  public String email = faker.internet().emailAddress("test");
  public String mobile = faker.phoneNumber().subscriberNumber(10);
  public String address = faker.address().streetAddress();
}
