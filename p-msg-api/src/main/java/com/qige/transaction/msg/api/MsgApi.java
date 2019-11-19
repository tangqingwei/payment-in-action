package com.qige.transaction.msg.api;

import com.qige.transaction.msg.dto.MsgDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author 阿甘
 * @see https://study.163.com/course/courseMain.htm?courseId=1209367806&share=2&shareId=1016671292
 * @version 1.0
 * 注：如有任何疑问欢迎加入QQ群977438372 进行讨论
 */
@FeignClient("tx-msg")
@RequestMapping("/msg")
public interface MsgApi {

    @PostMapping(value = "/prepareMsg")
    public  void prepareMsg(@RequestBody MsgDTO obj);

    @PostMapping(value = "/confirmMsg")
    public  void confirmMsg(@RequestBody  MsgDTO obj);

    @PostMapping(value = "/deleteMsg")
    public  void deleteMsg(@RequestBody  MsgDTO obj);

}
