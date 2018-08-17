# anychatSpringboot
使用到的技术：
1.WebSocket 作为前后端长连接服务，是一款轻量级高性能nio服务器
2.Protobuf 网络传输协议，比xml快100倍，比json快5倍
3.数据过滤 对所有消息内容进行过滤
4.Id获取 根据业务从dcp-sys-id服务获取id，使用多线程编程特性，同步锁，volatile，等。高并发下也能保持数据的准确性
5.Mybatis 数据持久，手写sql，增加sql灵活性
6.线程池 负责消息分发，上下线检测，异常处理，等一些常用的业务的处理
7.队列，List 队列存入数据快，list取数据快，在存取消息与上线下线时充分使用了它们的特性
8.Jdk 1.8，使用1.8新特性Lambda 表达式、集合的流式操作
内部流程图
![Image text](https://github.com/840758192/image/blob/master/2.png)
支持群聊天，上下线，查看聊天记录，离线消息推送，踢人，拉人

用户进入消息功能，从EKP获取用户信息，更新用户信息到DM数据库，更新群组信息，并将用户加入到存活容器中，通知群员已经上线
![Image text](https://github.com/840758192/image/blob/master/1.png)
