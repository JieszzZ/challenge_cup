package com.zarry.competition.dao;

import com.zarry.competition.model.Company;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface CompanyDao {

    @Select("select password from company where username = #{username}")
    String selectPassByUser(String username);

    @Insert("insert into company values(#{username},#{companyname},#{password},#{fax},#{address},#{number},#{account})")
    int insertCompany(String username, String companyname, String password, String fax, String address,
                      String number, String account);

    @Select("select * from company where username = #{company}")
    Company getInfoByCompany(String company);

    @Update("update company set account = #{account} where username = #{company}")
    int setAccount(String company, String account);

    @Insert("insert into activity values(#{activityName},#{activityTime},#{activityAdd},#{activityIntroduction}," +
            "#{activitySeat},#{pic1},#{pic2},#{pic3},#{pic4},#{activityCompany})")
    int insertActivity(String activityName, String activityTime, String activityAdd, String activityIntroduction,
                       String activitySeat, String pic1, String pic2, String pic3, String pic4, String activityCompany);
}
