package name.luoyong.shiro.shiroIni;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;

public class TestShiro {
	
	public static void shiroTest() {
		Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro.ini");
		SecurityManager securityManager = factory.getInstance();
		SecurityUtils.setSecurityManager(securityManager);
		
		Subject subject = SecurityUtils.getSubject();
		UsernamePasswordToken token = new UsernamePasswordToken("LiuXiang", "123");
		
		try {
			subject.login(token);
		} catch(UnknownAccountException e) {
			System.out.println("Error : 查无此人 ！");
		} catch(IncorrectCredentialsException e) {
			System.out.println("Error : 密码错误！");
		} catch(AuthenticationException e) {
			System.out.println("Error : 认证失败！");
		}
		
		if(subject.isAuthenticated()) {
			System.out.println("通过认证！");
		} else {
			System.out.println("没有通过认证！");
		}
		
		subject.logout();
	}
	
	public static void main(String[] args) {
		shiroTest();
	}

}
