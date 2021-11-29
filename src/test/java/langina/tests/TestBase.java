package langina.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import langina.config.SelenoidConfig;
import langina.helpers.Attach;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;

public class TestBase {

  @BeforeAll
  public static void config() {
    SelenoidConfig credentials = ConfigFactory.create(SelenoidConfig.class);
    SelenideLogger.addListener("AllureSelenide", new AllureSelenide());

    Configuration.startMaximized = true;
    Configuration.remote = String.format("https://%s:%s@%s", credentials.login(),
                                         credentials.password(), System.getProperty("selenoidUrl")
                                        );

    DesiredCapabilities capabilities = new DesiredCapabilities();
    capabilities.setCapability("enableVNC", true);
    capabilities.setCapability("enableVideo", true);
    Configuration.browserCapabilities = capabilities;
  }

  @AfterEach
  public void tearDown() {
    Attach.screenshotAs("Last screenshot");
    Attach.pageSource();
    Attach.browserConsoleLogs();
    Attach.addVideo();
  }
}
