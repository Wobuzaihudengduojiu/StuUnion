package com.ctgu.pojo.param;


import lombok.Getter;

@Getter
public enum ScoreEnum {

    //校级
    SCHOOL_LEVEL(1,3),

    //院级
    HSOPITAL_LEVEL(2,2);

    ;


    private Integer type;

    private Integer score;

    ScoreEnum(Integer type, Integer score) {
        this.type = type;
        this.score = score;
    }
}
