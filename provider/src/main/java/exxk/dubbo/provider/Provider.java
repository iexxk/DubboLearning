package exxk.dubbo.provider;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Provider {
    public static void main(String[] args) throws Exception {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                new String[]{"dubbo-provider.xml"}); //读取dubbo配置文件
        context.start();
        //按任何键推出
        System.in.read();
    }
}
