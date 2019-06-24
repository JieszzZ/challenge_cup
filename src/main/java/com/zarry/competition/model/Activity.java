package com.zarry.competition.model;

import org.springframework.web.multipart.MultipartFile;

import java.util.Arrays;

public class Activity {

    //活动名称
    private String activityName;
    //活动图片1
    private MultipartFile activityPic1 = null;
    //活动图片2
    private MultipartFile activityPic2 = null;
    //活动图片3
    private MultipartFile activityPic3 = null;
    //活动图片4
    private MultipartFile activityPic4 = null;
    //活动时间
    private String activityTime;
    //活动地点
    private String activityAdd;
    //活动介绍
    private String activityIntroduction;
    //活动座位信息（第一维表示分区，对应第二维标示：行数、列数、价格）
    private double[][] activitySeat;
    //活动所属公司（不需要传参）
    private String activityCompany;

    public Activity() {
    }

    public Activity(String activityName, MultipartFile activityPic1, MultipartFile activityPic2,
                    MultipartFile activityPic3, MultipartFile activityPic4, String activityTime,
                    String activityAdd, String activityIntroduction, double[][] activitySeat) {
        this.activityName = activityName;
        this.activityPic1 = activityPic1;
        this.activityPic2 = activityPic2;
        this.activityPic3 = activityPic3;
        this.activityPic4 = activityPic4;
        this.activityTime = activityTime;
        this.activityAdd = activityAdd;
        this.activityIntroduction = activityIntroduction;
        this.activitySeat = activitySeat;
    }

    public Activity(String activityName, MultipartFile activityPic1, MultipartFile activityPic2,
                    MultipartFile activityPic3, MultipartFile activityPic4, String activityTime, String activityAdd,
                    String activityIntroduction, double[][] activitySeat, String activityCompany) {
        this.activityName = activityName;
        this.activityPic1 = activityPic1;
        this.activityPic2 = activityPic2;
        this.activityPic3 = activityPic3;
        this.activityPic4 = activityPic4;
        this.activityTime = activityTime;
        this.activityAdd = activityAdd;
        this.activityIntroduction = activityIntroduction;
        this.activitySeat = activitySeat;
        this.activityCompany = activityCompany;
    }

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }

    public MultipartFile getActivityPic1() {
        return activityPic1;
    }

    public void setActivityPic1(MultipartFile activityPic1) {
        this.activityPic1 = activityPic1;
    }

    public MultipartFile getActivityPic2() {
        return activityPic2;
    }

    public void setActivityPic2(MultipartFile activityPic2) {
        this.activityPic2 = activityPic2;
    }

    public MultipartFile getActivityPic3() {
        return activityPic3;
    }

    public void setActivityPic3(MultipartFile activityPic3) {
        this.activityPic3 = activityPic3;
    }

    public MultipartFile getActivityPic4() {
        return activityPic4;
    }

    public void setActivityPic4(MultipartFile activityPic4) {
        this.activityPic4 = activityPic4;
    }

    public String getActivityTime() {
        return activityTime;
    }

    public void setActivityTime(String activityTime) {
        this.activityTime = activityTime;
    }

    public String getActivityAdd() {
        return activityAdd;
    }

    public void setActivityAdd(String activityAdd) {
        this.activityAdd = activityAdd;
    }

    public String getActivityIntroduction() {
        return activityIntroduction;
    }

    public void setActivityIntroduction(String activityIntroduction) {
        this.activityIntroduction = activityIntroduction;
    }

    public double[][] getActivitySeat() {
        return activitySeat;
    }

    public void setActivitySeat(double[][] activitySeat) {
        this.activitySeat = activitySeat;
    }

    public String getActivityCompany() {
        return activityCompany;
    }

    public void setActivityCompany(String activityCompany) {
        this.activityCompany = activityCompany;
    }

    @Override
    public String toString() {
        return "Activity{" +
                "activityName='" + activityName + '\'' +
                ", activityPic1=" + activityPic1 +
                ", activityPic2=" + activityPic2 +
                ", activityPic3=" + activityPic3 +
                ", activityPic4=" + activityPic4 +
                ", activityTime='" + activityTime + '\'' +
                ", activityAdd='" + activityAdd + '\'' +
                ", activityIntroduction='" + activityIntroduction + '\'' +
                ", activitySeat=" + Arrays.toString(activitySeat) +
                ", activityCompany='" + activityCompany + '\'' +
                '}';
    }
}
