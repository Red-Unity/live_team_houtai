package com.live.liveteam.mapper;

import com.live.liveteam.entity.Administrator;
import org.apache.ibatis.annotations.Param;

public interface AdministratorMapper {

    Administrator selectByNickName(@Param("nickName") String nickName);

    int deleteByPrimaryKey(Integer adminId);

    int insert(Administrator record);

    int insertSelective(Administrator record);

    Administrator selectByPrimaryKey(Integer adminId);

    int updateByPrimaryKeySelective(Administrator record);

    int updateByPrimaryKey(Administrator record);
}