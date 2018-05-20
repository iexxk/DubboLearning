package exxk.dubbo.consumer;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.realm.text.IniRealm;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.AbstractFactory;
import org.apache.shiro.util.Factory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ConsumerApplicationTests {
	@Test
	public void contextLoads() {
	}
    @Test
	public void shiroLogin(){
		//此方法1.4之前
		//Factory<SecurityManager> factory=new IniSecurityManagerFactory("classpath:shiro.ini");
		//shiro 1.4之后的版本
		IniRealm iniRealm=new IniRealm("classpath:shiro.ini");  //读取配置文件
		SecurityManager securityManager=new DefaultSecurityManager(iniRealm);
		SecurityUtils.setSecurityManager(securityManager);
		Subject currentUser=SecurityUtils.getSubject();
		if (!currentUser.isAuthenticated()){
			//登陆的用户名密码
			UsernamePasswordToken token=new UsernamePasswordToken("root","rootroot");
			token.setRememberMe(true); //记住密码功能
			try {
				currentUser.login(token);  //登陆
			}catch (UnknownAccountException una){
				System.out.print("用户名不存在"+una.getMessage());
			}catch (IncorrectCredentialsException ice){
				System.out.print("无效的认证"+ice.getMessage());
			}catch (LockedAccountException lae){
				System.out.print("你的账户被锁定"+lae.getMessage());
			}catch (AuthenticationException ae){
				System.out.print("未知错误"+ae.getMessage());
			}

		}

	}
}
