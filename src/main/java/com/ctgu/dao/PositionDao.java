package com.ctgu.dao;

import com.ctgu.pojo.Position;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface PositionDao {
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
