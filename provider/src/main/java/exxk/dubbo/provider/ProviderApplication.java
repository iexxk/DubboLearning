package exxk.dubbo.provider;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ImportResource;

import java.util.concurrent.CountDownLatch;


@SpringBootApplication
@ImportResource({"classpath:dubbo-provider.xml"})
public class ProviderApplication {

	@Bean
	public CountDownLatch closeLatch() {
		return new CountDownLatch(1);
	}

	public static void main(String[] args) throws InterruptedException {
		ApplicationContext context= new SpringApplicationBuilder()
				.sources(ProviderApplication.class)
				.web(WebApplicationType.NONE)  //禁用web服务
				.run(args);

		CountDownLatch closeLatch=context.getBean(CountDownLatch.class);
		closeLatch.await(); //等待所有子线程完成
	}
}
