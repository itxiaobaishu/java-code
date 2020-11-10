学习java过程中的记录，以代码为主。欢迎大家留言评论，有不足的地方烦请各位大佬指正，谢谢！

learn-code module

1.使用jdk8的stream流操作list的常用方法(包路径：com.xiaobai.javacode.jdk8.stream)

2.jdk8中LocalDate、LocalTime、LocalDateTime的方法测试(包路径：com.xiaobai.javacode.jdk8.date)

3.增加redis配置，使用双重检测锁解决高并发缓存穿透问题(测试方法：启动项目，访问http://localhost:8080/cache/penetrate)

4.spring的使用@Value注解属性注入的7种方式测试(JavaCodeApplicationTests类中的propertyConfigTest测试方法，涉及的文件PropertyConfig、propertytest.txt、propertytest.properties、PropertyService)

5.条件注解@Conditional的使用测试(运行condition包下的Main类中的main方法，查看结果)

6.properties文件中的属性值如果为中文读取出来会乱码，总结了两种解决方案(涉及到的代码有PropertiesUtil、propertytest.properties两个文件，测试方法运行PropertiesUtil中的main方法)

7.新增jdk8的函数式接口测试类(包路径：com.xiaobai.javacode.jdk8.functionalInterface)

8.自定义线程池异步调用方法(涉及的类ThreadTaskService、ThreadPoolTaskConfig、JavaCodeApplicationTests类中的test12和test34方法)

9.优化System.currentTimeMillis()方法(包路径：com.xiaobai.javacode.systimestamp)

10.sping三种初始化方法执行顺序验证，涉及到的包(com.xiaobai.javacode.init.InitService、JavaCodeApplicationTests测试类中的initTest())

11.synchronized关键字的使用示例(com.xiaobai.javacode.sync包下的测试类)

12.常用设计模式代码示例(详见desigMode包)

13.appium测试(com.xiaobai.javacode.appium.AppiumHelloTest)

14.枚举特性，消除if/eles(示例见包com.xiaobai.javacode.enumspeciality.ifelse)

15.枚举实现单例(com.xiaobai.javacode.enumspeciality.singleton)

springboot-kafka module

1.springboot整合kafka，启动项目，访问localhost:9090/book?name=XX模拟生产者发送消息，查看控制台模拟消费者消费消息