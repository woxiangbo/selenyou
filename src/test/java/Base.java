import com.chenxiangbo.Video;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;


@Video
public class Base {
	public String name;
	@BeforeClass
	public void beforeClass(){
		ITestResult result = Reporter.getCurrentTestResult();
//		System.out.println(result.getTestClass().getName() + "------>" +  result.getMethod().getMethodName());
	}
}
