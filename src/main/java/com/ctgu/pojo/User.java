package com.ctgu.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

/**
 * 用户实体

 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private int uid;
    private String username; //用户名
    private String password; //密码
    private String u_number; //学号
    private String salt; //MD5加密
    private Timestamp register_time;//注册时间
    private String u_mail;//邮箱
    private int u_power;//权限


}

