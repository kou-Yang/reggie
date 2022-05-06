package com.ky.reggie.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ky.reggie.common.R;
import com.ky.reggie.dto.SetmealDto;
import com.ky.reggie.entity.Setmeal;

import java.util.List;

public interface SetmealService extends IService<Setmeal> {

    // 新增套餐，同时需要保存套餐和菜品的关联关系
    void saveWithDish(SetmealDto setmealDto);

    // 批量修改status
    void updateStatusByIds(int status, List<Long> idList);

    // 修改套餐信息
    R<SetmealDto> getSetmealDto(Long id);

    // 删除套餐，同时需要删除套餐和菜品的关联数据
    void removeWithDish(List<Long> ids);
}
