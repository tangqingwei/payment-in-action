package com.qige.transaction.msg.job;

import com.qige.transaction.msg.entity.Msg;
import com.qige.transaction.msg.handle.MsgHandler;
import com.qige.transaction.msg.service.MsgService;
import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.IJobHandler;
import com.xxl.job.core.handler.annotation.JobHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


@JobHandler(value="consumeMsgJobHandler")
@Component
public class ConsumeMsgJobHandler extends IJobHandler {

	private static final Logger LOGGER = LoggerFactory.getLogger(ConsumeMsgJobHandler.class);
	@Autowired
	private MsgHandler msgHandler;

	@Autowired
	private MsgService msgService;

	//过期时间 单位分钟
	private static final int VERDUE_TIME=1;
	@Override
	public ReturnT<String> execute(String param) throws Exception {
		LOGGER.info("进入消费定时任务..........................");
		this.processMsg();
		return SUCCESS;
	}

	public void processMsg() {
		//1.消息服务定期轮询，过期的“已发送”消息（过期一般是根据业务规则来自行调整，例如2min）
		List<Msg> msgList = this.msgService.selectOverdueMsgBySend(VERDUE_TIME);
		for (Msg msg : msgList) {
			//2.消息服务重新将过期的“已发送”消息，发送到消息中间件MQ中。
			msgHandler.send(msg.getRoutingKey(),msg.getJsonMsg());
		}
	}
}
