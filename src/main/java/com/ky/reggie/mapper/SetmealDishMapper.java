package com.ky.reggie.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ky.reggie.entity.SetmealDish;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface SetmealDishMapper extends BaseMapper<SetmealDish> {
}
