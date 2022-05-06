package com.ky.reggie.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ky.reggie.entity.Category;

public interface CategoryService extends IService<Category> {
    void delete(Long ids);
}
