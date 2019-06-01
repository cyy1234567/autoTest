package com.auto.dao;

import com.auto.entity.UserAndMenu;
import org.springframework.stereotype.Repository;

@Repository
public interface UserAndMenuMapper {
    int deleteByPrimaryKey(Long id);

    int insert(UserAndMenu record);

    int insertSelective(UserAndMenu record);

    UserAndMenu selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(UserAndMenu record);

    int updateByPrimaryKey(UserAndMenu record);
}