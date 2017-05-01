package boot.configure;


import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;

@EnableJms
@Configuration
public class ActiveMQ4Config {


    @Bean
    public ActiveMQConnectionFactory activeMQConnectionFactory (){
        ActiveMQConnectionFactory activeMQConnectionFactory =
                new ActiveMQConnectionFactory(
                        "sh",
                        "P@ssw0rd",
                        "tcp://192.168.70.14:61616");
        return activeMQConnectionFactory;
    }

}
