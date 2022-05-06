package com.ky.reggie.dto;

import com.ky.reggie.entity.Setmeal;
import com.ky.reggie.entity.SetmealDish;
import lombok.Data;
import java.util.List;

@Data
public class SetmealDto extends Setmeal {

    private List<SetmealDish> setmealDishes;

    private String categoryName;
}
