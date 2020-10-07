import com.woxiangbo.anno.Video;
import com.woxiangbo.listeners.TestngListener;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;

@Listeners(TestngListener.class)
@Video(store = "c:\\aabbccdd\\")
public class Base {
	public String name;
	@BeforeClass
	public void beforeClass(){
		ITestResult result = Reporter.getCurrentTestResult();
	}
}
