package com.qige.transaction.coupon.api;


import com.qige.transaction.coupon.dto.CouponDTO;
import org.dromara.hmily.annotation.Hmily;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;
/**
 * @author 阿甘
 * @see https://study.163.com/course/courseMain.htm?courseId=1209367806&share=2&shareId=1016671292
 * @version 1.0
 * 注：如有任何疑问欢迎加入QQ群977438372 进行讨论
 */
@FeignClient("tx-coupon")
@RequestMapping("/coupon")
//@Component
public interface CouponApi {

    //@RequestMapping(value = "/decrease", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
    @PostMapping(value = "/decrease")
    @Hmily
    public String decrease(@RequestBody CouponDTO obj);

}


