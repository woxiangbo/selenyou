## selenyou
a easier way to use selenium with some handy features
* A easier way to use selenium with some handy features
    *  screen record
    *   local invoke with grid
    *   reuse opened Broswer (Only supports Chrome by now)
    
## How to use
Maven:
```
<!-- https://mvnrepository.com/artifact/com.github.woxiangbo/selenyou -->
<dependency>
    <groupId>com.github.woxiangbo</groupId>
    <artifactId>selenyou</artifactId>
    <version>0.0.2</version>
</dependency>
```

#Code Example:
* 2 changes:
    * add Listener `TestngListener.class`
    * add annotation `@Video`
    
```
import com.woxiangbo.anno.Video;
import com.woxiangbo.listeners.TestngListener;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(TestngListener.class)
@Video
public class Demo{
    @Test
    public void test(){
        assert false;
    }
}
```


