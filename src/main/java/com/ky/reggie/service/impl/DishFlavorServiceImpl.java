package com.ky.reggie.service.impl;

import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ky.reggie.entity.DishFlavor;
import com.ky.reggie.mapper.DishFlavorMapper;
import com.ky.reggie.service.DishFlavorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DishFlavorServiceImpl extends ServiceImpl<DishFlavorMapper, DishFlavor> implements DishFlavorService {

    @Autowired
    private DishFlavorMapper flavorMapper;

    /**
     * 批量删除菜品口味
     * @param ids
     */
    @Override
    public void deleteDishFlavorsByIds(List<Long> ids) {
        LambdaUpdateWrapper<DishFlavor> updateWrapper = new LambdaUpdateWrapper<>();
        updateWrapper.in(!ids.isEmpty(), DishFlavor::getDishId, ids);
        flavorMapper.delete(updateWrapper);
    }
}
