import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.dingcheng.confirms.publish.PublishService;  
  
  
@RunWith(SpringJUnit4ClassRunner.class)  
@ContextConfiguration(locations = {"classpath:application-context.xml"})  
public class TestConfirm {  
    @Autowired  
    private PublishService publishService;  
    
    private static String exChange = "DIRECT_EX";
      
//    @Test  
    public void test1() throws InterruptedException{  
    	String message = "currentTime:"+System.currentTimeMillis();
    	System.out.println("test1---message:"+message);
    	//exchange,queue 都正确
    	publishService.send(exChange,"CONFIRM_TEST",message);  
//        Thread.sleep(10000);
    }  
    
//    @Test  
    public void test2() throws InterruptedException{  
    	String message = "currentTime:"+System.currentTimeMillis();
    	System.out.println("test2---message:"+message);
    	//exchange 错误,queue 正确
    	publishService.send(exChange+"NO","CONFIRM_TEST",message);  
//        Thread.sleep(10000);
    }  
    
    @Test  
    public void test3() throws InterruptedException{  
    	String message = "currentTime:"+System.currentTimeMillis();
    	System.out.println("test3---message:"+message);
    	//exchange 正确,queue 错误
    	publishService.send(exChange,"",message);  
//        Thread.sleep(10000);
    }  
    
//    @Test  
    public void test4() throws InterruptedException{  
    	String message = "currentTime:"+System.currentTimeMillis();
    	System.out.println("test4---message:"+message);
    	//exchange 错误,queue 错误
    	publishService.send(exChange+"NO","CONFIRM_TEST",message);  
//        Thread.sleep(10000);
    }  
}  