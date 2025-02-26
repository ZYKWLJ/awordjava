# 一句话：Spring完成对象的创建、装配、管理

# 一、引出
## 1.痛点
基于以下痛点：
如果你有一个接口，假设是数据库连接接口，现在提供了MySQL、Oracle等等很多厂商的实现，那么每一次你与一个新的实现建立连接，是不是需要new一个该实现的对象？那如果有一万个实现呢？就很麻烦！
![alt text](img/spring引出之前的痛点.png)

## 2.改进——IOC——字段只声明不创建!
### 2.1定义：
IOC是控制反转的意思，含义为将需要程序员手动new对象的过程，改为由IOC这个容器来完成！
(完成创建、装配、管理等)，程序员直接从里面取出来用就好了！

# 3.从三个环节理解Spring的前世今生

## 3.1硬编码时代
每次换一个实现就改一次代码！
```java
package com.spring;
public interface basicInterface {
    void showDBContect();
}

public class ImplMysql implements basicInterface{
    @Override
    public void showDBContect(){
        System.out.println("this is MySQL~");
    }
}

public class ImplOracle implements basicInterface{
    @Override
    public void showDBContect(){
        System.out.println("this is oracle!");
    }
}

public class testSpring {
    basicInterface db=new ImplMysql();//最大的问题在这里，没换一个实现，就要改一次
    @Test   
    public void testMysql(){
        // 调用MySQL的数据库
        db.showDBContect();
    }

    // 
    // @Test   
    // public void testOracle(){
    //     // 调用Oracle的数据库，就需要更改上面的db，所以很麻烦！
    //     db.showDBContect();
    // }
}

```


## 3.2简单代码示例理解IOC
软编码，只声明不初始化，将对象字段的初始化延迟到setter里面

```java
package com.spring;
public interface basicInterface {
    void showDBContect();
}

public class DBImpl implements basicInterface {
    private basicInterface DBInterface;//最大的区别在这，这里只声明不创建，实例由后面的setter创建(就这一步！)
    // 利用set实现
    public void setDB(basicInterface DBInterface){
        this.DBInterface=DBInterface;
    }
    @Override
    public void showDBContect(){
        this.DBInterface.showDBContect();
    }
}

public class testSetter {
    private DBImpl db =new DBImpl();
    // 最大的区别就是将创建对象的工作封装了起来，成为了一个接口！
    // 这样我们创建对象就是在接口里面完成的了，不再是由程序员直接创建了!
    @Test
    public void test(){
        db.setDB(new ImplMysql());
        db.showDBContect();
        db.setDB(new ImplOracle());
        db.showDBContect();
    }
}

```


## 3.3真正的Spring使用

### 实现类
```java
@Component
//@Service 注解用于将 EmailService 类标记为 Spring 管理的服务组件，Spring 会自动扫描并将其注册到应用上下文中。
public class DBImpl implements basicInterface{
    private final basicInterface bInterface;
    @Autowired
    public DBImpl(basicInterface bInterface){
        this.bInterface=bInterface;
    }
    public void showDBContect() {
        bInterface.showDBContect();
    }
    
}

```

### 组件扫描
```java
@Configuration
// @Configuration 注解表示这是一个 Spring 配置类
@ComponentScan(basePackages = "com.spring.v1_beforeSpring")
// @ComponentScan 注解指定了要扫描的包路径，Spring 会自动扫描该路径下的所有带有 @Component、@Service 等注解的类。
public class AppConfig {

}
```

### 从容器中取出、创建
```java
public class testRealSpring {
    @Test
    public void test(){
        // 创建 Spring 应用上下文
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        // 创建并返回实例
        basicInterface bean = context.getBean(ImplOracle.class);
        bean.showDBContect();
        bean=context.getBean(ImplMysql.class);
        bean.showDBContect();
    }
}
```




# 4.总结Spring的全流程
## 一、组件扫描+自动装配
 spring会扫描指定配置包下的注解，将注解下面的Bean，加入Spring中，用在之前只声明而没有创建的接口上，完成Bean的依赖；
## 二、AOP
 通过注解完成AOP的额外切片操作



# 二、IOC
## IOC——组件扫描+放入容器+自动装配
## (一).
### 1.基于注解
### 1.0.常见注解：
注入容器注解(组件注解)：@Component、@Service、@Controller、@Repository
自动装配注解：@Autowire、@Resource
作用域注解：@Scope
属性赋值注解：@Value

### 1.1.扫描包，搜寻注解
需要指定扫描哪个包下的文件(文件中的所有注解会被Spring发现并管理)，通过这样完成Bean加入容器等
体现在配置类中如下的字段：
```java
@ComponentScan(basePackages = "com.spring.v1_beforeSpring")
```


### 1.2.在Bean上加注解
方便将Bean加入容器中

### 1.3.在实现类构造函数上加自动装配注解，让自动从容器中取出Bean并装配
## 自动装配注解的分类

## @Autowired
1.属于Spring
2.机制：先byType，加上@Qualifier注解后可以实现byname注入
## @Resource
1.属于JAVA
2.机制：先byName，失败后再by type

### 2.基于XML(放弃，过时了)


# 三、AOP
# 本质——通过代理给访问真实类的方法加一些切片，额外的功能！
# 常见用途
### 日志
### 安全验证
### 性能监控
### 事务

## 静态代理
### 特点：
将代理的功能写死，比较死板，比如实现多级代理时，就很麻烦！

### 示例代码
这只是一级代理，如果有50级代理，并且他们之间可以随意组合的话，将会创建50!的代理类！
```java

public interface Subject {
    void rent();  
} 

public class Host implements Subject{
    @Override
    public void rent(){
        System.out.println("hey, this is Host, my houst is rent to you~");
    }
}

public class Agent implements Subject{
    Subject host=new Host();
    
    public Agent(Subject host) {
        this.host = host;
    }

    @Override
    public void rent() {
       System.out.println("hey, this is agent, i will contect you with the host~~");
       this.host.rent();
    }
}

public class Client {
    private Subject subject=new Agent(new Host());
    public static void main(String[] args) throws InterruptedException {
        Client client = new Client();
        client.subject.rent();   
    }
}
```


## 动态代理
### 优点：

将代理的方法用反射创建，很方便的完成多级代理的功能！
### 示例代码
仅仅需要将每一个切片实现一个代理类，后面可以随机组合而不会硬编码
### 一级代理
```java
public interface Subject {
    void rent();  
} 
public class Host implements Subject{
    @Override
    public void rent(){
        System.out.println("hey, this is Host, my houst is rent to you~");
    }
}
// 实现 InvocationHandler 接口
class AgentMethod implements InvocationHandler {
    private Object subject;

    public AgentMethod(Subject target) {
        this.subject = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("ProxyHandler: Before request.");
        Object result = method.invoke(subject, args);
        System.out.println("ProxyHandler: After request.");
        return result;
    }
}
public class Client {
    public static void main(String[] args) throws InterruptedException {
        // 创建真实对象
        Subject subject = new Host();
        
        // 创建代理对象的增强型方法
        AgentMethod agentMethod = new AgentMethod(subject);

        // 创建代理对象实例
        Subject newProxyInstance = 
                (Subject) Proxy.newProxyInstance
                (Host.class.getClassLoader(),
                Host.class.getInterfaces(), 
                agentMethod);

        // 调用代理的接口！
        newProxyInstance.rent();
    }
}

```

### 二级代理
```java
public interface Subject {
    void rent();  
} 
public class Host implements Subject{
    @Override
    public void rent(){
        System.out.println("hey, this is Host, my houst is rent to you~");
    }
}
// 实现 InvocationHandler 接口——一级代理方法
class AgentMethod1 implements InvocationHandler {
    private Object subject;

    public AgentMethod1(Object target) {
        this.subject = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("进行权限验证...");
        Object result = method.invoke(subject, args);
        System.out.println("权限验证成功...");
        return result;
    }
}

// 实现 InvocationHandler 接口——二级代理方法
class AgentMethod2 implements InvocationHandler {
    private Object subject;

    public AgentMethod2(Object target) {
        this.subject = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("进行身份验证...");
        Object result = method.invoke(subject, args);
        System.out.println("身份验证成功...");
        return result;
    }
}

```
可以看到，如果想要切换代理顺序或者功能，仅需增加代理类而已，但是静态代理就会修改代理类！这就是动态代理的优点！

# Spring中的AOP


# Bean的作用域


# 四、事务