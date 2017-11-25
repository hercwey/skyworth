package boot.task;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import boot.entity.DeviceInfo;
import boot.service.UserService;

/**

* 定时任务

* @author Administrator

*

*/

@Configuration

@EnableScheduling

public class SchedulingConfig {
	
	@Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;
	
	@Autowired
	private UserService userService;

   //@Scheduled(cron = "0 41 21 ? * *") // 每20秒执行一次

   public void scheduler() {
	   
	   System.err.println("===============================开始执行定时导入MQ任务=======================");
	   List<DeviceInfo> devices = this.userService.getDeviceId();
	   
	   for (DeviceInfo deviceInfo : devices) {
		   String deviceid = deviceInfo.getDeviceid();
		   this.jmsMessagingTemplate.convertAndSend("sh.mail.queue" ,"{\"bindFlag\":true,\"deviceId\":\""+  deviceid +"\"}");
	   }

	   System.err.println("===============================定时导入MQ任务执行=======================");
   }

}


