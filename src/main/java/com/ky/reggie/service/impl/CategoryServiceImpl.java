package com.ky.reggie.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ky.reggie.entity.Category;
import com.ky.reggie.entity.Dish;
import com.ky.reggie.entity.Setmeal;
import com.ky.reggie.exception.CustomException;
import com.ky.reggie.mapper.CategoryMapper;
import com.ky.reggie.mapper.DishMapper;
import com.ky.reggie.mapper.SetmealMapper;
import com.ky.reggie.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements CategoryService {

    @Autowired
    private DishMapper dishMapper;
    @Autowired
    private SetmealMapper setmealMapper;

    @Override
    public void delete(Long ids) {
        // 查询当前分类是否关联了菜品
        LambdaQueryWrapper<Dish> dishLambdaQueryWrapper = new LambdaQueryWrapper<>();
        dishLambdaQueryWrapper.eq(Dish::getCategoryId, ids);
        Integer count1 = dishMapper.selectCount(dishLambdaQueryWrapper);
        if (count1 > 0) {
            throw new CustomException("当前分类关联了菜品，不能删除。");
        }
        // 查询当前分类是否关联了套餐
        LambdaQueryWrapper<Setmeal> setmealLambdaQueryWrapper = new LambdaQueryWrapper<>();
        setmealLambdaQueryWrapper.eq(Setmeal::getCategoryId, ids);
        Integer count2 = setmealMapper.selectCount(setmealLambdaQueryWrapper);
        if (count2 > 0) {
            throw new CustomException("当前分类关联了套餐，不能删除。");
        }

        super.removeById(ids);
    }
}
