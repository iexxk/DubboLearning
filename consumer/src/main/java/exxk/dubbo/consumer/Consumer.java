package exxk.dubbo.consumer;

import exxk.dubbo.commonimpl.DemoService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Consumer {
    public static void main(String[] args) throws Exception{
        ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext(
                new String[]{"dubbo-consumer.xml"});
        context.start();
        DemoService demoService= (DemoService) context.getBean("demoService");
        String hello= demoService.sayHello("world");
        System.out.print(hello);
    }
}
