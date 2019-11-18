package com.ctgu.service.impl;

import com.ctgu.dao.GradeDao;
import com.ctgu.pojo.Grade;
import com.ctgu.pojo.param.ScoreEnum;
import com.ctgu.service.GradeService;
import com.ctgu.utils.Constant;
import com.sargeraswang.util.ExcelUtil.ExcelLogs;
import com.sargeraswang.util.ExcelUtil.ExcelUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.*;

/**
 *
 */
@Service
@Slf4j
public class GradeServiceImpl implements GradeService {

    @Autowired
    private GradeDao gradeDao;

    @Override
    public List<Grade> getAllGradeListByName(String a_name) {
        return gradeDao.getAllGradeListByName(a_name);
    }

    @Override
    public void saveGrade(Grade grade) {
        gradeDao.saveGrade(grade);
    }

    @Override
    public List<Grade> getGradeByNum(String s_num) {
        return gradeDao.getGradeByNum(s_num);
    }

    @Override
    public List<Grade> getAllGrade() {
        return gradeDao.getAllGrade();
    }

    @Override
    public Grade getGrade(int g_id) {
        return gradeDao.getGrade(g_id);
    }

    @Override
    public void updateStatus(int g_id, String g_status) {
        gradeDao.updateStatus(g_id, g_status);
    }

    @Override
    public Double getGradeSign(String s_num) {
        return gradeDao.getGradeSign(s_num);
    }

    @Override
    public Double getGradeJoin(String s_num) {
        return gradeDao.getGradeJoin(s_num);
    }

    @Override
    public Double getGradeOrg(String s_num) {
        return gradeDao.getGradeOrg(s_num);
    }

    @Override
    public Double getGradePrize(String s_num) {
        return gradeDao.getGradePrize(s_num);
    }

    @Override
    public Double getGradeSum(String s_num) {
        return gradeDao.getGradeSum(s_num);
    }

    @Override
    public List<Grade> getGradeByClass(String g_class, String s_num) {
        return gradeDao.getGradeByClass(g_class, s_num);
    }

    @Override
    public Boolean importExcel(MultipartFile file) {
        File directory = new File(".");
        String path = null;
        try {
            path = directory.getCanonicalPath() + Constant.UPLOAD_PATH;
        } catch (IOException e) {
            e.printStackTrace();
        }

        //上传文件名
        String filename = file.getOriginalFilename();

        log.info(filename + "---->");

        // 判断存放上传文件的目录是否存在（不存在则创建）
        File dir = new File(path);
        if (!dir.exists()) {
            dir.mkdir();
        }
        log.info("path=" + path);

        //将上传文件保存到一个目标文件当中
        String realPath = path + File.separator + filename;
        try {
            file.transferTo(new File(realPath));
        } catch (IOException e) {
            log.info("创建Excel失败");
            e.printStackTrace();
        }


        /**
         * 根据学号和活动名称添加相应的分值
         */
        //获取
        List<Grade> stus = parseExcel(realPath);

        if(gradeDao.insertExcel(stus)>0){

            return true;
        }else{

            return false;
        }

    }

    /**
     * 解析Excel,获取学号
     */
    private List<Grade> parseExcel(String path) {

        File f = new File(path);
        InputStream inputStream = null;
        try {
            inputStream = new FileInputStream(f);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        ExcelLogs logs = new ExcelLogs();
        Collection<Map> importExcel = ExcelUtil.importExcel(Map.class, inputStream, "yyyy/MM/dd HH:mm:ss", logs, 0);

        List<Grade> sids = new ArrayList<>();

        for (Map m : importExcel) {

            String a_name = (String) m.get("活动名称");

            String s_name = (String) m.get("姓名");

            String s_num = (String) m.get("学号");

            String s_class = (String) m.get("班级");

            String type=(String)m.get("加分类型");

            String score = typeTransfer((String)m.get("加分类型")).toString();

            sids.add(new Grade(a_name,type,score,s_num,s_name,s_class));
        }

        return sids;
    }


    private Integer typeTransfer(String type) {

        Integer types = Integer.parseInt(type);

        //校级
        if (types.equals(ScoreEnum.SCHOOL_LEVEL.getType())) {
            return ScoreEnum.SCHOOL_LEVEL.getScore();
        } else if (types.equals(ScoreEnum.HSOPITAL_LEVEL.getType())) {

            //院级
            return ScoreEnum.HSOPITAL_LEVEL.getScore();
        } else {
            return 0;
        }
    }

}
