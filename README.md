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
			System.out.println("Error : ���޴��� ��");
		} catch(IncorrectCredentialsException e) {
			System.out.println("Error : �������");
		} catch(AuthenticationException e) {
			System.out.println("Error : ��֤ʧ�ܣ�");
		}
		
		if(subject.isAuthenticated()) {
			System.out.println("ͨ����֤��");
		} else {
			System.out.println("û��ͨ����֤��");
		}
		
		subject.logout();
	}
```

shiro.ini :
[users]
luoyong=1234
LiuXiang=123

