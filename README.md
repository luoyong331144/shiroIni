The most simple example of shiro.
=================================
It be running in java environment. Use the ini comfiguration file.
==================================================================

java code :
```java
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
```

shiro.ini :
[users]
luoyong=1234
LiuXiang=123

