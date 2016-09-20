package boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.ServletRegistrationBean;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;

import boot.servlet.MyServlet1;

@SpringBootApplication
@ServletComponentScan
public class Server {

	@Bean
	public ServletRegistrationBean MyServlet1() {
		return new ServletRegistrationBean(new MyServlet1(), "/myServlet/*");
	}

	public static void main(String[] args) {
		SpringApplication.run(Server.class, args);
	}
}
