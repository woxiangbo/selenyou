
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

/**
 * @author : chenxiangbo
 * @date :2020/9/29 15:14
 */

public class Demo3 extends Base{
	@Test
	public void demo3(){
//		VideoRecorder videoRecord = new VideoRecorder();
		System.out.println("CCCC");
//		throw new RuntimeException("aaaaaaa");
		try {
//			videoRecord.startRecording("D:\\vt", "test444");
			Thread.sleep(2000);
//			System.out.println("test444 videoRecord----->" + videoRecord);
//			videoRecord.stopRecording();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}