在工作中需要实现动态刷新@Value字段值，但是项目使用的是Spring boot，又不想接入Nacos/Apollo等配置中心组件(额外增加成本)，并且项目中只是简单的使用@Value读取一些配置信息进行使用(或者判断状态)，所以写了简单的一个刷新机制，通过接口刷新@Value值

1、启动项目
2、访问接口http://127.0.0.1:8080/tem/calc/test 查看@value属性值
---token---123456
---enable---true
---open---open
3、通过接口http://127.0.0.1:8080/test/update 刷新@value属性值
参数名 name = db.token
参数 value = 123456789
4、在访问接口http://127.0.0.1:8080/tem/calc/test 查看@value属性值变化
---token---123456789
---enable---true
---open---open