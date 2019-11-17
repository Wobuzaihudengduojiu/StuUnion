package com.ctgu.handler;

import com.ctgu.exception.StuUnionException;
import com.ctgu.pojo.param.ResultVO;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
@ResponseBody
public class GlobleExceptionHandler {

    /**
     * 本系统自定义错误的拦截器
     * 拦截到此错误之后,就返回这个类里面的json给前端
     * 常见使用场景是参数校验失败,抛出此错,返回错误信息给前端
     */
    @ExceptionHandler(StuUnionException.class)
    public ResultVO commonJsonExceptionHandler(StuUnionException myException) {
        return myException.getResultVO();
    }
}
