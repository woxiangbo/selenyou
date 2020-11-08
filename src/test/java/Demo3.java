import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author : woxiangbo
 * @date :2020/9/29 15:14
 */

public class Demo3 {
    @Test
    public void demo3() throws MalformedURLException {
        URL hubURL = new URL("http://localhost:4444/wd/hub");
        DesiredCapabilities capability = new DesiredCapabilities();
        capability.setBrowserName("chrome");
        capability.setPlatform(Platform.WINDOWS);

        WebDriver driver = new RemoteWebDriver(hubURL, capability);
        driver.get("http://www.baidu.com");

    }
}