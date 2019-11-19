package com.qige.transaction.inventory.api;

import com.qige.transaction.inventory.dto.InventoryDTO;
import org.dromara.hmily.annotation.Hmily;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

/**
 * @author 阿甘
 * @see https://study.163.com/course/courseMain.htm?courseId=1209367806&share=2&shareId=1016671292
 * @version 1.0
 * 注：如有任何疑问欢迎加入QQ群977438372 进行讨论
 */
@FeignClient("tx-inventory")
@RequestMapping("/inventory")
public interface InventoryApi {

    /**
     * 减库存
     * @param obj
     * @return
     */
    @PostMapping(value = "/decrease")
    @Hmily
    public String decrease(@RequestBody InventoryDTO obj);

}
