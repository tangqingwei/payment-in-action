//package com.qige.transaction.order.msg;
//
//
//import com.alibaba.fastjson.JSON;
//import com.qige.transaction.commons.enums.MsgEnum;
//import com.qige.transaction.inventory.api.InventoryApi;
//import com.qige.transaction.inventory.dto.InventoryDTO;
//import com.qige.transaction.msg.api.MsgApi;
//import com.qige.transaction.msg.dto.MsgDTO;
//import com.qige.transaction.order.dto.OrderDTO;
//import com.qige.transaction.order.entity.Order;
//import com.qige.transaction.order.enums.OrderStatusEnum;
//import com.qige.transaction.order.mapper.OrderMapper;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.amqp.core.ExchangeTypes;
//import org.springframework.amqp.rabbit.annotation.*;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//@Component
//@RabbitListener(bindings = @QueueBinding(
//        value = @Queue(value = "${mq.msg.queue.name}", autoDelete = "false"),
//        exchange = @Exchange(value = "${mq.msg.exchange}", type = ExchangeTypes.DIRECT),
//        key = "${mq.msg.queue.routing.key}"
//))
//public class MsgHandler {
//
//    @Autowired
//    private OrderMapper orderMapper;
//
//    @Autowired
//    private MsgApi msgApi;
//
//    private static final Logger LOGGER = LoggerFactory.getLogger(MsgHandler.class);
//
//
//    @RabbitHandler
//    public void process(String content){
//        LOGGER.info("接受到支付消息：" + content);
//        //处理本地业务
//        OrderDTO orderDTO = JSON.parseObject(content,OrderDTO.class);
//        Order order = new Order();
//        order.setOrderNo(orderDTO.getOrderNo());
//        Order obj = this.orderMapper.selectOne(order);
//        obj.setStatus(OrderStatusEnum.PAY_SUCCESS.getCode());
//        this.orderMapper.updateByPrimaryKeySelective(obj);
//        //TODO 以下删除消息记录代码会出现空指针异常，暂未排查出问题所在
//        //最后删除消息
//        String msgId= MsgEnum.ORDER.getCode()+"-"+orderDTO.getOrderNo();
//        MsgDTO msgDTO = new MsgDTO();
//        msgDTO.setMsgId(msgId);
//        this.msgApi.deleteMsg(msgDTO);
//    }
//}
