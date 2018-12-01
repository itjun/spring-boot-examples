# 运行说明

## 安装参考

```bash
docker run -d -p 8161:8161 -p 61616:61616 -e ACTIVEMQ_ADMIN_LOGIN=admin -e ACTIVEMQ_ADMIN_PASSWORD=admin --restart=always --name activemq webcenter/activemq
```

## 访问地址

[http://127.0.0.1:8161/](http://127.0.0.1:8161/)


## 配置参考

```properties
spring.activemq.broker-url=tcp://localhost:61616
spring.activemq.user=admin
spring.activemq.password=admin
```
