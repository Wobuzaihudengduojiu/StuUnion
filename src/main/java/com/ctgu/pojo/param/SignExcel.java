package com.ctgu.pojo.param;


import com.sargeraswang.util.ExcelUtil.ExcelCell;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SignExcel {


    @ExcelCell(index = 0)
    private String a_name;

    @ExcelCell(index = 1)
    private String s_name;

    @ExcelCell(index = 2)
    private String s_num;

    @ExcelCell(index = 3)
    private String s_class;

    @ExcelCell(index = 4)
    private String s_acd;

    @ExcelCell(index = 5)
    private String score;

}
