package com.qige.transaction.inventory.mapper;

import com.qige.transaction.inventory.entity.Inventory;
import tk.mybatis.mapper.common.Mapper;

public interface InventoryMapper extends Mapper<Inventory> {

    public  void decrease(Inventory obj);
}