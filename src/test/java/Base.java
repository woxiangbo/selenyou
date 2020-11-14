import com.woxiangbo.anno.Video;
import com.woxiangbo.listeners.TestngListener;
import com.woxiangbo.selenium.BaseDriver;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(TestngListener.class)
@Video(store = "c:\\aabbccdd\\")
public class Base {
    public WebDriver webDriver;
    public BaseDriver baseDriver;
    public String routedIpAndPort;

    @BeforeClass
    public void beforeClass() {
        baseDriver = new BaseDriver();
        webDriver = baseDriver.getWebDriver();

    }

    @Test
    public void test() {
        webDriver.get("http://www.baidu.com");
    }
}
