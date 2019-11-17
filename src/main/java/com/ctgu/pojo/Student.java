package com.ctgu.pojo;

import lombok.*;

import java.sql.Timestamp;
import java.util.Date;

/**
 * 学生实体
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    private String sid;//学生id
    private String s_name;//姓名
    private String s_num;//学号（用户名）
    private String s_sex;//性别
    private String s_acd;//学院
    private String s_maj;//专业
    private String d_name;//部门名称
    private String p_name;//职位名称
    private String s_birth;//出生日期
    private String s_tel;//电话
    private String s_mail;//邮箱
    private String s_qq;//qq
    private Integer s_power;//权限 主席1 部长2 干事3
    private Date join_time;//加入时间
    //新增
    private String s_class;//班级

}