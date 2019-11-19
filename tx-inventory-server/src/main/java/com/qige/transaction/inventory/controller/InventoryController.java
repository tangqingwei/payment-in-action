package com.qige.transaction.inventory.controller;

import com.qige.transaction.inventory.service.InventoryService;
import com.qige.transaction.inventory.api.InventoryApi;
import com.qige.transaction.inventory.dto.InventoryDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
/**
 * @author 阿甘
 * @see https://study.163.com/course/courseMain.htm?courseId=1209367806&share=2&shareId=1016671292
 * @version 1.0
 * 注：如有任何疑问欢迎加入QQ群977438372 进行讨论
 */
@RestController
public class InventoryController implements InventoryApi {
    private static final Logger LOGGER = LoggerFactory.getLogger(InventoryController.class);

    @Autowired
    private InventoryService inventoryService;
    /**
     * 减库存
     * @param obj
     * @return
     */
    @Override
    public String  decrease(InventoryDTO obj) {
        LOGGER.info("进入库存的controller..........");
        this.inventoryService.decrease(obj);
        return  "1";
    }

}
