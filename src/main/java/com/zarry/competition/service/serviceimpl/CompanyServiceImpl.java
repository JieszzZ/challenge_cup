package com.zarry.competition.service.serviceimpl;

import com.alibaba.fastjson.JSON;
import com.mysql.cj.xdevapi.JsonArray;
import com.mysql.cj.xdevapi.JsonString;
import com.zarry.competition.dao.CompanyDao;
import com.zarry.competition.model.Activity;
import com.zarry.competition.model.Company;
import com.zarry.competition.service.CompanyService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.*;
import java.math.BigInteger;
import java.security.MessageDigest;

@Service
public class CompanyServiceImpl implements CompanyService {

    @Resource
    private CompanyDao companyDao;

    @Override
    public String signIn(String username, String password) {
        String pass = companyDao.selectPassByUser(username);
        if (password.equals(pass)) {
            return SUCCESS;
        } else {
            return FAIL;
        }
    }

    @Override
    public String signUp(Company company) {
        int i = companyDao.insertCompany(company.getUsername(), company.getCompanyname(), company.getPassword(),
                company.getFax(), company.getAddress(), company.getNumber(), company.getAccount());
        if (i > 0) {
            return SUCCESS;
        } else {
            return FAIL;
        }
    }

    @Override
    public Company getInfo(String company) {
        return companyDao.getInfoByCompany(company);
    }

    @Override
    public String setAccount(String company, String account) {
        int i = companyDao.setAccount(company, account);
        if (i > 0) {
            return SUCCESS;
        } else {
            return FAIL;
        }
    }

    @Override
    public String addActivity(Activity activity) {
        double[][] seat = activity.getActivitySeat();
        String jsonString = JSON.toJSONString(seat);
        String pic1 = "", pic2 = "", pic3 = "", pic4 = "";
        if (activity.getActivityPic1() != null) {
            pic1 = insertImage(activity.getActivityPic1());
        }
        if (activity.getActivityPic1() != null) {
            pic2 = insertImage(activity.getActivityPic2());
        }
        if (activity.getActivityPic1() != null) {
            pic3 = insertImage(activity.getActivityPic3());
        }
        if (activity.getActivityPic1() != null) {
            pic4 = insertImage(activity.getActivityPic4());
        }

        int i = companyDao.insertActivity(activity.getActivityName(), activity.getActivityTime(),
                activity.getActivityAdd(), activity.getActivityIntroduction(), jsonString, pic1, pic2, pic3, pic4,
                activity.getActivityCompany());
        if (i > 0) {
            return SUCCESS;
        } else {
            return FAIL;
        }
    }

    @Override
    public String withdraw(String amount) {
        return null;
    }

    private String insertImage(MultipartFile file) {
        String filename = "";
        String uploadFilePath = "d:\\temp_upload_file\\";
        try {
            filename = getMd5(file);
            InputStream is = file.getInputStream();
            // 如果服务器已经存在和上传文件同名的文件，则输出提示信息
            File tempFile = new File(uploadFilePath + filename);
            if (tempFile.exists()) {
                boolean delResult = tempFile.delete();
//                System.out.println("删除已存在的文件：" + delResult);
            }
            // 开始保存文件到服务器
            if (filename != null && !filename.equals("")) {
                FileOutputStream fos = new FileOutputStream(uploadFilePath + filename);
                byte[] buffer = new byte[8192]; // 每次读8K字节
                int count = 0;
                // 开始读取上传文件的字节，并将其输出到服务端的上传文件输出流中
                while ((count = is.read(buffer)) > 0) {
                    fos.write(buffer, 0, count); // 向服务端文件写入字节流
                }
                fos.close(); // 关闭FileOutputStream对象
                is.close(); // InputStream对象
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return filename;
    }

    private String getMd5(MultipartFile file) {

        try {
            byte[] uploadBytes = file.getBytes();
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            byte[] digest = md5.digest(uploadBytes);
            return new BigInteger(1, digest).toString(16);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }
}
