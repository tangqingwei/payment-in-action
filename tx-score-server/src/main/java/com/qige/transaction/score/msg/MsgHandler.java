package com.qige.transaction.score.msg;

import com.alibaba.fastjson.JSON;
import com.qige.transaction.commons.enums.MsgEnum;
import com.qige.transaction.msg.api.MsgApi;
import com.qige.transaction.msg.dto.MsgDTO;
import com.qige.transaction.score.dto.ScoreDTO;
import com.qige.transaction.score.entity.ScoreAccount;
import com.qige.transaction.score.entity.ScoreDetail;
import com.qige.transaction.score.mapper.ScoreAccountMapper;
import com.qige.transaction.score.mapper.ScoreDetailMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(bindings=@QueueBinding(
        value= @Queue(value="${mq.msg.queue.name}",autoDelete="false"),
        exchange=@Exchange(value="${mq.msg.exchange}",type= ExchangeTypes.DIRECT),
        key="${mq.msg.queue.routing.key}"
)
)
public class MsgHandler {

    @Autowired
    private MsgApi msgApi;

    @Autowired
    private ScoreAccountMapper scoreAccountMapper;

    @Autowired
    private ScoreDetailMapper scoreDetailMapper;

    private static final Logger LOGGER = LoggerFactory.getLogger(MsgHandler.class);

    @RabbitHandler
    public void process(String content){
        ScoreDTO scoreDTO = JSON.parseObject(content,ScoreDTO.class);
        LOGGER.info("接收到积分：" + scoreDTO.getScore());
        //第二步：幂等性校验
        ScoreDetail scoreDetail = new ScoreDetail();
        scoreDetail.setOrderNo(scoreDTO.getOrderNo());
        ScoreDetail temp = this.scoreDetailMapper.selectOne(scoreDetail);
        if (temp!=null && temp.getType().intValue()==1){
            LOGGER.warn("送积分的订单号存在！" + temp.getOrderNo());
            //删除消息
            this.deleteMsg(scoreDTO);
            return;
        }
        //第三步：插入积分明细
        BeanUtils.copyProperties(scoreDTO,scoreDetail);
        scoreDetail.setType((byte)1);
        this.scoreDetailMapper.insertSelective(scoreDetail);

        //第四步：新增积分
        ScoreAccount updateScoreAccount = new ScoreAccount();
        updateScoreAccount.setUserId(scoreDTO.getUserId());
        updateScoreAccount.setTotalScore(scoreDTO.getScore());
        this.scoreAccountMapper.addScore(updateScoreAccount);


        //最后删除消息  对应设计图的步骤9
        this.deleteMsg(scoreDTO);
    }

    private void deleteMsg(ScoreDTO scoreDTO){
//        String msgid= MsgEnum.SCORE.getCode()+"-"+scoreDTO.getOrderNo();
//        MsgDTO msgDTO=new MsgDTO();
//        msgDTO.setMsgId(msgid);
//        this.msgApi.deleteMsg(msgDTO);
    }
}
