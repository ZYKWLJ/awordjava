# 一、@SpringBootApplication

@SpringBootApplication包含以下三个注解:

### 1.@Configuration: 
`Tags the class` as a source of bean definitions for the application context.

---
### 2.@EnableAutoConfiguration: 
Tells Spring Boot **to start adding beans based on classpath settings, other beans, and various property settings**. For example, if spring-webmvc is on the classpath, this annotation flags the application as a web application and activates key behaviors, such as setting up a DispatcherServlet.  • 

---
### 3.@ComponentScan: 
Tells Spring to **look for other components, configurations, and services in the com/example package**, letting it find the controllers.

why com.example?

```text
<groupId>
标识项目或组织，类似 Java 包名，常采用**反域名**形式。如 org.springframework.boot 表明依赖属于 Spring Boot 项目组织。

<artifactId>
指定组内唯一的项目名称。
再加上版本号，三者唯一定位构成 Maven 中央仓库的依赖坐标
```

