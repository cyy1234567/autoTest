package com.auto.dao;

import com.auto.entity.MenuAndResource;
import org.springframework.stereotype.Repository;

@Repository
public interface MenuAndResourceMapper {
    int deleteByPrimaryKey(Long id);

    int insert(MenuAndResource record);

    int insertSelective(MenuAndResource record);

    MenuAndResource selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(MenuAndResource record);

    int updateByPrimaryKey(MenuAndResource record);
}