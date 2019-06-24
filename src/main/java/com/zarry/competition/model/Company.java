package com.zarry.competition.model;

public class Company {

    //登录名
    private String username;
    //公司名称
    private String companyname;
    //登录密码
    private String password;
    //公司传真
    private String fax;
    //公司地址
    private String address;
    //公司营业许可证号码
    private String number;
    //提现账户
    private String account = "null";

    public Company() {
    }

    public Company(String username, String companyname, String password, String fax, String address, String number) {
        this.username = username;
        this.companyname = companyname;
        this.password = password;
        this.fax = fax;
        this.address = address;
        this.number = number;
    }

    public Company(String username, String companyname, String password, String fax, String address, String number,
                   String account) {
        this.username = username;
        this.companyname = companyname;
        this.password = password;
        this.fax = fax;
        this.address = address;
        this.number = number;
        this.account = account;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getCompanyname() {
        return companyname;
    }

    public void setCompanyname(String companyname) {
        this.companyname = companyname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    @Override
    public String toString() {
        return "Company{" +
                "username='" + username + '\'' +
                ", companyname='" + companyname + '\'' +
                ", password='" + password + '\'' +
                ", fax='" + fax + '\'' +
                ", address='" + address + '\'' +
                ", number='" + number + '\'' +
                ", account='" + account + '\'' +
                '}';
    }
}
