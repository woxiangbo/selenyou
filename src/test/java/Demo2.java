import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author : woxiangbo
 * @date :2020/9/29 15:14
 */
public class Demo2 {
    @Test
    public void demo2() throws MalformedURLException {
        String url = "http://localhost:8080";
        URL url1 = new URL(url);
        System.out.println(url1.getPath());
    }
}