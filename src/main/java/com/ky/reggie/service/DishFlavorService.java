package com.ky.reggie.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ky.reggie.entity.DishFlavor;

import java.util.List;

public interface DishFlavorService extends IService<DishFlavor> {
    void deleteDishFlavorsByIds(List<Long> ids);
}
