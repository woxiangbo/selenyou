import org.testng.annotations.Test;


public class Demo extends Base {
    public String a = "av";

    @Test
    public void test() {
        webDriver.get("http://www.baidu.com");
    }
}