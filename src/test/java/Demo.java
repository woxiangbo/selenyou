import com.chenxiangbo.listeners.TestngListener;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


@Listeners(TestngListener.class)

public class Demo extends Base{
	@Test
	public void test(){
		System.out.println("aaaaa");
	}
}