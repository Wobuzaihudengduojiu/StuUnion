package com.ctgu.dao;

import com.ctgu.pojo.ActivitySign;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ActivitySignDao {

    /*保存学生报名信息*/
    void saveActivitySign(ActivitySign activitySign);

    /*获取某活动的报名情况*/
    List<ActivitySign> gerActivitySignList(String a_name);

}
