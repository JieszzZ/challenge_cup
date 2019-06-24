package com.zarry.competition.service;

import com.zarry.competition.model.Activity;
import com.zarry.competition.model.Company;

public interface CompanyService {

    String SUCCESS = "success";
    String FAIL = "fail";

    String signIn(String username, String password);

    String signUp(Company company);

    Company getInfo(String company);

    String setAccount(String company, String account);

    String addActivity(Activity activity);

    String withdraw(String amount);
}
