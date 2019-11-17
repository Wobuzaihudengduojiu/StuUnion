package com.ctgu.exception;

import com.ctgu.pojo.param.ErrorEnum;
import com.ctgu.pojo.param.ResultVO;
import lombok.Getter;


@Getter
public class StuUnionException extends RuntimeException {

    private ResultVO resultVO;

    public StuUnionException(ErrorEnum errorEnum) {
        this.resultVO = new ResultVO();
        this.resultVO.setCode(errorEnum.getCode());
        this.resultVO.setMsg(errorEnum.getMsg());
    }

    public StuUnionException(){}
}
