# 基于Maven搭建的Spring-SpringMVC-MyBatis项目尝试
工具：IDEA

系统：MacOS
## 1.Spring与MyBatis的整合
遇到的问题
- xml文件中，beans无法被找到。
- 数据库无法连接。
- 测试类爆空指针异常

解决方法
- spring-mybatis.xml中加入 
   
      xmlns="http://www.springframework.org/schema/beans"
      xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
      xsi:schemaLocation="http://www.springframework.org/schema/beas
      http://www.springframework.org/schema/beans/spring-beans-2.5.xsd"
      
 
- jdbc.properties中将url命名改为jdbc.url

- 在pom.xml中加入依赖

        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-test</artifactId>
            <version>4.1.6.RELEASE</version>
        </dependency>
        
      
  并在测试类中注入
  
      @RunWith(SpringJUnit4ClassRunner.class) 
      @ContextConfiguration(locations = {"classpath:spring-mybatis.xml"})
