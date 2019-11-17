package com.ctgu.pojo.param;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.poi.ss.formula.functions.T;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResultVO {

    /**错误码*/
    private Integer code;

    /**提示信息*/
    private String msg;

    /**具体内容*/
    private T data;

    /**请求url*/
    private String url;
}
