package com.qige.transaction.msg.controller;


import com.qige.transaction.msg.api.MsgApi;
import com.qige.transaction.msg.dto.MsgDTO;
import com.qige.transaction.msg.service.MsgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author 阿甘
 * @see https://study.163.com/course/courseMain.htm?courseId=1209367806&share=2&shareId=1016671292
 * @version 1.0
 * 注：如有任何疑问欢迎加入QQ群977438372 进行讨论
 */
@RestController
public class MsgController  implements MsgApi {
    @Autowired
    private MsgService msgService;

    /**
     * 接收"待发送"消息，把消息保持为“待发送”状态
     * @param obj
     */
    public  void prepareMsg(MsgDTO obj){
        this.msgService.prepareMsg(obj);
    }

    /**
     * 确认消息可以发送了，
     * 把消息状态改为“已发送”
     * @param obj
     */
    public  void confirmMsg(MsgDTO obj){
        this.msgService.confirmMsg(obj);
    }

    /**
     * 删除消息
     * @param obj
     */
    public  void deleteMsg(MsgDTO obj){
        this.msgService.deleteMsg(obj);
    }



}
