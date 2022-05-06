package com.ky.reggie.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ky.reggie.dto.DishDto;
import com.ky.reggie.entity.Dish;

import java.util.List;

public interface DishService extends IService<Dish> {

    //新增菜品，同时插入菜品对应的口味数据，需要操作两张表：dish、dish_flavor
    void saveWithFlavor(DishDto dishDto);

    //根据id查询菜品信息和对应的口味信息
    DishDto getByIdWithFlavor(Long id);

    //更新菜品信息，同时更新对应的口味信息
    void updateWithFlavor(DishDto dishDto);

    // 批量更新菜品状态
    void updateStatus(int status, List<Long> ids);

    // 批量删除菜品信息
    void deleteDishesById(List<Long> ids);
}
