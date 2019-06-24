package com.zarry.competition.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
@RequestMapping(value = "root")
public class RootController {

    private final String NOT_LOGIN = "notLogIn";
    private final String SUCCESS = "success";

    @RequestMapping(value = "getActivityList")
    public String getActivityList(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session == null) {
            return NOT_LOGIN;
        }
        return SUCCESS;
    }

    @RequestMapping(value = "confirm")
    public String confirm(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session == null) {
            return NOT_LOGIN;
        }
        return SUCCESS;
    }

    @RequestMapping(value = "getCompanyList")
    public String getCompanyList(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session == null) {
            return NOT_LOGIN;
        }
        return SUCCESS;
    }

}
