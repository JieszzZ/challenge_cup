package com.zarry.competition.controller;

import com.zarry.competition.service.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping(value = "user")
public class UserController {

    @Resource
    private UserService userService;

    @RequestMapping(value = "getActivityList")
    public String getActivityList(String param) {
        return userService.getActivityList(param);
    }

    @RequestMapping(value = "checkStatus")
    public String checkStatus(String activity, String area) {
        return userService.checkStatus(activity, area);
    }

}
