# spring-boot-restful

调用示例
---

**默认参数**

http://localhost/greeting

```json
{
    "id": 4,
    "content": "Hello, World!"
}
```

**自定参数**

http://localhost/greeting?name=Spring%20Boot%202.0
```json
{
    "id": 3,
    "content": "Hello, Spring Boot 2.0!"
}
```