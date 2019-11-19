## 搭建msg服务
1.创建数据库
   
## 编码实现《消息服务》与《订单服务》的分布式事务通信
1.设置rabbitmq 交换器的名字
  mq.msg.exchange=msg.exchange
2.统一路由key
  mq.msg.queue.routing.key=order.routing.key
  mq.msg.queue.routing.key=score.routing.key
  由支付服务在"1.发送消息"的时候就已经统一设置了路由key
  然后 订单服务和积分服务都必须配置统一的路由key
  
  
## 编码实现《支付》、《消息》、《积分》3大服务的分布式事务
1.变更积分数据库
ALTER TABLE `tx_score`.`tx_score_detail`
  ADD COLUMN `type` TINYINT(4) DEFAULT 0  NOT NULL  COMMENT '积分类型 0=消耗，1=新增' AFTER `score`;
2.按设计图流程来编