package exxk.dubbo.consumer;

import exxk.dubbo.commonimpl.DemoService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource({"classpath:dubbo-consumer.xml"})
public class ConsumerApplication {

	public static void main(String[] args) {
		ApplicationContext context= SpringApplication.run(ConsumerApplication.class, args);
		DemoService demoService= (DemoService) context.getBean("demoService");
		String hello= demoService.sayHello("world");
		System.out.print(hello);
	}
}
