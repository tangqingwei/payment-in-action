package com.qige.transaction.pay.controller;

import com.qige.transaction.pay.entity.Pay;
import com.qige.transaction.pay.service.PayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MsgController {

    @Autowired
    private PayService payService;

    /**
     *
     * @param msgId
     * @return true=已支付 false=未支付
     */
    @RequestMapping(value = "/checkMsg/{msgId}", method = RequestMethod.GET)
    public boolean checkMsg(@PathVariable String msgId){
        System.out.println(msgId);
        Pay pay=this.payService.findPayByOrderNo(msgId);
        //status - 支付状态 -1：取消 0 未完成 1已完成 -2:异常
        if(pay!=null && pay.getStatus().byteValue()==1){
            return true;
        }
        return  false;
    }
}
