package com.ctgu.service;

import com.ctgu.pojo.Position;

import java.util.List;

/**
 
 */
public interface PositionService {
    /*获取所有职位*/
    List<Position> getPositionList();

    /*插入职位*/
    void savePosition(Position position);

    /*更新职位*/
    void updatePosition(Position position);

    /*删除职位*/
    void deletePosById(int p_id);

    /*查找职位*/
    Position getPositionById(int p_id);
}
