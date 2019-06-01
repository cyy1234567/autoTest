package com.auto.dao;

import com.auto.entity.UserAndRole;
import org.springframework.stereotype.Repository;

@Repository
public interface UserAndRoleMapper {
    int deleteByPrimaryKey(Long id);

    int insert(UserAndRole record);

    int insertSelective(UserAndRole record);

    UserAndRole selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(UserAndRole record);

    int updateByPrimaryKey(UserAndRole record);
}