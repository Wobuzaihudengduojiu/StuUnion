package com.ctgu.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

/**
 * 加分实体
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Grade {
    private Integer g_id;
    private String a_name;//活动名称
    private String g_class;//加分类别
    private String g_value;//加分值
    private String s_num;//学生学号
    private String s_name;//学生姓名
    private String s_class;//学生班级
    private Timestamp g_time;//加分时间
    private String g_status;//加分状态
    private String g_decide_name;//审核人
    private String g_prove;//加分证明


    public Grade(String a_name, String g_class, String g_value, String s_num, String s_name, String s_class) {
        this.a_name = a_name;
        this.g_class = g_class;
        this.g_value = g_value;
        this.s_num = s_num;
        this.s_name = s_name;
        this.s_class = s_class;
    }
}
