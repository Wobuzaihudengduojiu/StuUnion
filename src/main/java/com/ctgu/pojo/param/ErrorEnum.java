package com.ctgu.pojo.param;

import lombok.Getter;

@Getter
public enum ErrorEnum {

    /*
     * 错误信息
     * */
    E_300(300, "未登录"),
    E_301(301, "账号或密码错误"),
    E_302(302, "账号状态异常"),
    E_303(303, "该用户没有角色"),
    E_400(400, "请求处理异常，请稍后再试"),
    E_500(500, "请求方式有误,请检查 GET/POST"),
    E_501(404, "请求路径不存在"),
    E_502(502, "权限不足"),
    E_10008(10008, "角色删除失败,尚有用户属于此角色"),
    E_10009(10009, "账户已存在"),
    E_20011(20011, "登陆已过期,请重新登陆"),
    E_90003(90003, "缺少必填参数");

    private Integer code;

    private String msg;

    ErrorEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
