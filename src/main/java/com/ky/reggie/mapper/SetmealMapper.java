package com.ky.reggie.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ky.reggie.entity.Setmeal;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface SetmealMapper extends BaseMapper<Setmeal> {
}
