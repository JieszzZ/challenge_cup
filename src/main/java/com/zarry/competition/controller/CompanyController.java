package com.zarry.competition.controller;

import com.alibaba.fastjson.JSON;
import com.zarry.competition.model.Activity;
import com.zarry.competition.model.Company;
import com.zarry.competition.service.CompanyService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
@RequestMapping(value = "company")
public class CompanyController {

    private final String NOT_LOGIN = "notLogin";
    private final String SUCCESS = "success";
    private final String FAIL = "fail";

    @Resource
    private CompanyService companyService;

    @RequestMapping(value = "signIn")
    public String signIn(HttpServletRequest request, @RequestParam String username, @RequestParam String password) {
        HttpSession session = request.getSession(true);
        System.out.println(username + password);
        String result = companyService.signIn(username, password);
        if (SUCCESS.equals(result)) {
            session.setAttribute("company", username);
            return SUCCESS;
        } else {
            session.invalidate();
            return FAIL;
        }
    }

    @RequestMapping(value = "signOut")
    public String signOut(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session == null) {
            return NOT_LOGIN;
        }
        session.invalidate();
        return SUCCESS;
    }

    @RequestMapping(value = "signUp")
    public String signUp(Company company) {
        return companyService.signUp(company);
    }

    @RequestMapping(value = "getInfo")
    public String getInfo(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session == null) {
            return NOT_LOGIN;
        }
        String username = (String) session.getAttribute("company");
        Company company = companyService.getInfo(username);
        company.setPassword(null);
        String jsonString = JSON.toJSONString(company);
        System.out.println(jsonString);
        return jsonString;
    }

    @RequestMapping(value = "setAccount")
    public String setAccount(HttpServletRequest request, String account) {
        HttpSession session = request.getSession(false);
        if (session == null) {
            return NOT_LOGIN;
        }
        String company = (String) session.getAttribute("company");
        return companyService.setAccount(company, account);
    }

    @RequestMapping(value = "withdraw")
    public String withdraw(HttpServletRequest request, String amount) {
        HttpSession session = request.getSession(false);
        if (session == null) {
            return NOT_LOGIN;
        }
        return companyService.withdraw(amount);
    }

    @RequestMapping(value = "addActivity")
    public String addActivity(HttpServletRequest request, Activity activity) {
        HttpSession session = request.getSession(false);
        if (session == null) {
            return NOT_LOGIN;
        }
        String company = (String) session.getAttribute("company");
        activity.setActivityCompany(company);
        return companyService.addActivity(activity);
    }

}
