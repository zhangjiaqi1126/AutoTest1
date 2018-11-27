import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication

//扫描哪个包下面的类托管给我，注意目录要用到的类必须在被扫描的目录下
@ComponentScan("com.course.server")
public class Application {
   public static void  main(String[] args){
       SpringApplication.run(Application.class,args);
   }
}
