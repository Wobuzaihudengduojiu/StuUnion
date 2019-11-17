package com.ctgu.service.impl;

import com.ctgu.dao.ActivitySignDao;
import com.ctgu.pojo.Activity;
import com.ctgu.pojo.ActivitySign;
import com.ctgu.pojo.param.SignExcel;
import com.ctgu.service.ActivityService;
import com.ctgu.service.ActivitySignService;
import com.ctgu.utils.Constant;
import com.sargeraswang.util.ExcelUtil.ExcelUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.*;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 *
 */
@Service
@Slf4j
public class ActivitySignServiceImpl implements ActivitySignService {

    @Autowired
    private ActivitySignDao activitySignDao;

    @Autowired
    private ActivityService activityService;

    @Override
    public void saveActivitySign(ActivitySign activitySign) {
        activitySignDao.saveActivitySign(activitySign);
    }

    @Override
    public List<ActivitySign> gerActivitySignList(String a_name) {
        return activitySignDao.gerActivitySignList(a_name);
    }

    @Override
    public Boolean exportExcel(String a_id) {
        Activity activity = activityService.getActivity(Integer.valueOf(a_id));
        log.info("获取 " + activity.getA_name() + " 的报名信息");

        List<SignExcel> data =
                gerActivitySignList(activity.getA_name())
                        .stream()
                        .map(
                                v -> {
                                    SignExcel signExcel = new SignExcel();

                                    signExcel.setS_acd(v.getS_acd());
                                    signExcel.setS_class(v.getS_class());
                                    signExcel.setS_name(v.getS_name());
                                    signExcel.setS_num(v.getS_num());

                                    return signExcel;
                                }
                        )
                        .collect(Collectors.toList());


        Map<String, String> map = new LinkedHashMap<>();
        map.put("s_name", "姓名");
        map.put("s_num", "学号");
        map.put("s_class", "班级");
        map.put("s_acd", "专业");

        File file = new File(Constant.EXPORT_PATH);

        if (!file.exists()) {
            file.mkdir();
        }

        File file1 = new File(Constant.EXPORT_PATH, activity.getA_name() + ".xls");

        OutputStream out = null;
        try {
            out = new FileOutputStream(file1);
            log.info("打印excel");
            ExcelUtil.exportExcel(map, data, out);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return true;
    }
}
