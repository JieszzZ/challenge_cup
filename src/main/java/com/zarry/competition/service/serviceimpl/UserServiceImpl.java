package com.zarry.competition.service.serviceimpl;

import com.alibaba.fastjson.JSON;
import com.zarry.competition.dao.UserDao;
import com.zarry.competition.model.Activity;
import com.zarry.competition.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserDao userDao;

    @Override
    public String getActivityList(String param) {
        String result;
        if ("ALL".equals(param)) {
            List<Activity> list = userDao.getAllActList();
            result = JSON.toJSONString(list);
        } else {
            Map map = userDao.getActListByAct(param);
            result = JSON.toJSONString(map);
        }
        return result;
    }

    @Override
    public String checkStatus(String activity, String area) {
        return null;
    }
}
