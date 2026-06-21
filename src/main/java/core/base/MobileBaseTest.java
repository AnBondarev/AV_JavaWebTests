package core.base;

import com.codeborne.selenide.Configuration;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.Map;

public class MobileBaseTest extends AbstractBaseTest {

    @Override
    protected void configure() {
        Configuration.browser = "chrome";

        ChromeOptions ChromeOptions = new ChromeOptions();
        ChromeOptions.setExperimentalOption("mobileEmulation",
                Map.of("deviceName", "iPhone 12 Pro"));

        Configuration.browserCapabilities = ChromeOptions;
    }
}
