package com.ctgu.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class ActivitySign {
    private int as_id;
    private String a_name;//活动名称
    private String s_name;//学生姓名
    private String s_num;//学生学号
    private String s_sex;//学生性别
    private String s_acd;//学院
    private String s_class;//班级
    private String s_tel;//手机号
    private String s_mail;//邮箱
    private Timestamp as_time;//报名时间
}
