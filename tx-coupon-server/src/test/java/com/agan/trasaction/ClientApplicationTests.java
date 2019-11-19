package com.agan.trasaction;

import com.qige.transaction.coupon.CouponApplication;
import com.qige.transaction.coupon.entity.CouponReceive;
import com.qige.transaction.coupon.mapper.CouponMapper;
import com.qige.transaction.coupon.mapper.CouponReceiveMapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = CouponApplication.class)
public class ClientApplicationTests {

	@Autowired
	private CouponMapper couponMapper;
	@Autowired
	private CouponReceiveMapper couponReceiveMapper;

	@Test
	public void test() {
		for(int i=0;i<100;i++){
			CouponReceive couponReceive=new CouponReceive();
			couponReceive.setCouponId(1);
			couponReceive.setCouponMoney(10);
			couponReceive.setUserId(1);
			this.couponReceiveMapper.insertSelective(couponReceive);
		}

	}

}
