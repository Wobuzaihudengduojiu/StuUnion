package com.ctgu.service;

import com.ctgu.pojo.ActivitySign;
import com.ctgu.pojo.param.ResultVO;
import com.ctgu.utils.ResultVoUtil;
import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.List;

/**

 */
public interface ActivitySignService {

    /*保存学生报名信息*/
    void saveActivitySign(ActivitySign activitySign);

    /*获取某活动的报名情况*/
    List<ActivitySign> gerActivitySignList(String a_name);

    /**
     * 导出excel
     */
    Boolean exportExcel(String a_id);
}
