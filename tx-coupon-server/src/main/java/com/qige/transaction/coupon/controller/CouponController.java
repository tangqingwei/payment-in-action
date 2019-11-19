package com.qige.transaction.coupon.controller;

import com.qige.transaction.coupon.api.CouponApi;
import com.qige.transaction.coupon.dto.CouponDTO;
import com.qige.transaction.coupon.service.CouponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
/**
 * @author 阿甘
 * @see https://study.163.com/course/courseMain.htm?courseId=1209367806&share=2&shareId=1016671292
 * @version 1.0
 * 注：如有任何疑问欢迎加入QQ群977438372 进行讨论
 */
@RestController
public class CouponController implements CouponApi {

    @Autowired
    private CouponService couponService;

    @Override
    public String decrease(CouponDTO obj) {
        this.couponService.decrease(obj);
        return null;
    }
}
