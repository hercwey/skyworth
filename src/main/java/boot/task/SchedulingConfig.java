package boot.task;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

/**

* 定时任务

* @author Administrator

*

*/

@Configuration

@EnableScheduling

public class SchedulingConfig {

   @Scheduled(cron = "0/2 * * * * ?") // 每20秒执行一次

   public void scheduler() {

       System.out.println(">>>>>>>>> SchedulingConfig.scheduler()");

   }

}


