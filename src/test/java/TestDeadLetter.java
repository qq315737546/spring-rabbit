import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.dingcheng.confirms.publish.DeadLetterPublishService;  
  
@RunWith(SpringJUnit4ClassRunner.class)  
@ContextConfiguration(locations = {"classpath:application-context.xml"})  
public class TestDeadLetter {  
    @Autowired  
    private DeadLetterPublishService publishService;  
    
    @Test  
    public void test1() throws InterruptedException{  
    	String message = "currentTime:"+System.currentTimeMillis();
    	System.out.println("test1---message:"+message);
    	publishService.send("dead-letter-queue",message);  
        Thread.sleep(10000);
    }  
    
}  