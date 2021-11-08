package langina.tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;

public class TestBase {

  @BeforeAll
  public static void config() {
    Configuration.browserSize = "1024x765";
  }

}
