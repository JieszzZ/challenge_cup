package com.zarry.competition.dao;

import com.zarry.competition.model.Activity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

@Mapper
public interface UserDao {

    @Select("select ")
    List<Activity> getAllActList();

    Map getActListByAct(String param);
}
