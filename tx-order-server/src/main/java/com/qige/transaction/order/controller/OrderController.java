package com.qige.transaction.order.controller;


import com.qige.transaction.commons.utils.DatetimeUtil;
import com.qige.transaction.order.api.OrderApi;
import com.qige.transaction.order.dto.OrderDTO;
import com.qige.transaction.order.entity.Order;
import com.qige.transaction.order.service.OrderService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RestController
public class OrderController implements OrderApi {

    @Autowired
    private OrderService orderService;

    public String createOrder(@RequestParam("c") Integer c){
        System.out.println("---------------->"+c);

        OrderDTO obj=new OrderDTO();
        obj.setUserId(1);
        obj.setProductId(1);
        obj.setPaymentMoney(new BigDecimal(100));
        obj.setProductCount(1);
        //扣除2个积分
        obj.setDecreaseScore(2);
        obj.setLargessScore(20);
        //抵扣优惠卷
        obj.setCouponReceiveId(c);

        Random rand = new Random();
        //随机 1000-9999的数字
        int n = rand.nextInt(8999)+1000;
        String orderno=DatetimeUtil.getCurrentDatetime()+n;
        obj.setOrderNo(orderno);
        this.orderService.createOrder(obj);

        return  "OK";
    }

    public List<OrderDTO> unpayOrderList(){
//        List<Order> orders= this.orderService.unpayOrderList();
//        List<OrderDTO> orderList= new ArrayList<OrderDTO>();
//        for(Order order:orders){
//            OrderDTO obj=new OrderDTO();
//            BeanUtils.copyProperties(order,obj);
//            orderList.add(obj);
//        }
//        return  orderList;
        return null;
    }

    /**
     * 查找所有的订单信息
     * @return
     */
    public List<OrderDTO> orderList(){
        List<Order> orders= this.orderService.findAll();
        List<OrderDTO> orderList= new ArrayList<OrderDTO>();
        for(Order order:orders){
            OrderDTO obj=new OrderDTO();
            BeanUtils.copyProperties(order,obj);
            orderList.add(obj);
        }
        return  orderList;
    }

    public OrderDTO findOrderNo(String orderno){
        Order order=this.orderService.findOrderNo(orderno);
        OrderDTO obj=new OrderDTO();
        BeanUtils.copyProperties(order,obj);
        return obj;
    }
}
