package boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.boot.web.servlet.ServletComponentScan;


//public class Server {
//
//	@Bean
//	public ServletRegistrationBean MyServlet1() {
//		return new ServletRegistrationBean(new MyServlet1(), "/myServlet/*");
//	}
//
//	public static void main(String[] args) {
//		SpringApplication.run(Server.class, args);
//	}
//}
@SpringBootApplication
@ServletComponentScan
public class Server extends SpringBootServletInitializer implements EmbeddedServletContainerCustomizer {  
	  
    @Override  
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {  
        return builder.sources(Server.class);  
    }  
      
    public static void main(String[] args) {  
        SpringApplication.run(Server.class, args);  
    }  
  
  
    @Override  
    public void customize(ConfigurableEmbeddedServletContainer container) {  
        container.setPort(7890);  
    }  
} 