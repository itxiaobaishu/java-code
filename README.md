学习java过程中的记录，以代码为主。欢迎大家留言评论，有不足的地方烦请各位大佬指正，谢谢！

1.使用jdk8的stream流操作list的常用方法(包路径：com.xiaobai.javacode.jdk8.stream)

2.jdk8中LocalDate、LocalTime、LocalDateTime的方法测试(包路径：com.xiaobai.javacode.jdk8.date)

3.增加redis配置，使用双重检测锁解决高并发缓存穿透问题(测试方法：启动项目，访问http://localhost:8080/cache/penetrate)

4.spring的使用@Value注解属性注入的7种方式测试(JavaCodeApplicationTests类中的propertyConfigTest测试方法，涉及的文件PropertyConfig、propertytest.txt、propertytest.properties、PropertyService)

5.条件注解@Conditional的使用测试(运行condition包下的Main类中的main方法，查看结果)

6.properties文件中的属性值如果为中文读取出来会乱码，总结了两种解决方案(涉及到的代码有PropertiesUtil、propertytest.properties两个文件，测试方法运行PropertiesUtil中的main方法)

7.新增jdk8的函数式接口测试类(包路径：com.xiaobai.javacode.jdk8.functionalInterface)

8.自定义线程池异步调用方法(涉及的类ThreadTaskService、ThreadPoolTaskConfig、JavaCodeApplicationTests类中的test12和test34方法)