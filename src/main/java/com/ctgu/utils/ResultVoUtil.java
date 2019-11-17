package com.ctgu.utils;

import com.ctgu.pojo.param.ErrorEnum;
import com.ctgu.pojo.param.ResultVO;
import org.apache.poi.ss.formula.functions.T;

public class ResultVoUtil {

    public static ResultVO success(T data) {
        ResultVO resultVO = new ResultVO();
        resultVO.setData(data);
        resultVO.setCode(Constant.SUCCESS_CODE);
        resultVO.setMsg(Constant.SUCCESS_MSG);
        return resultVO;
    }

    public static ResultVO success() {
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(Constant.SUCCESS_CODE);
        resultVO.setMsg(Constant.SUCCESS_MSG);
        return resultVO;
    }

    public static ResultVO error(Integer code, String msg) {
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(code);
        resultVO.setMsg(msg);
        return resultVO;
    }

    public static ResultVO error(ErrorEnum errorEnum) {
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(errorEnum.getCode());
        resultVO.setMsg(errorEnum.getMsg());
        return resultVO;
    }
}
