package com.scs.soft.ncp.api.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Create {
    public static void main(String[] args) throws Exception
    {
        JDbcUtils jd=new JDbcUtils();
        Connection conn=jd.getConnection();
        System.out.println(conn);
        Statement stat=conn.createStatement();
       /* stat.executeUpdate("create database db_ncp");
*/
        //打开创建的数据库
        stat.close();
        conn.close();
        String url = "jdbc:mysql://localhost:3306/db_ncp?useUnicode=true&characterEncoding=utf-8";
        conn = DriverManager.getConnection(url, "root", "root");
        stat = conn.createStatement();

        //创建谣言表  t_rumor
        /*stat.executeUpdate("create table t_rumor(idc varchar(255) PRIMARY KEY comment '字段的注释'," +
                " body varchar(255) comment '谣言主体内容',id int(11) comment '谣言的排行榜id',mainSummary varchar(255) comment '谣言的解释'," +
                "rumorType tinyint(4) comment '谣言的种类',sourceUrl varchar(255),summary varchar(255)," +
                "title varchar(255) comment '谣言的标题')");*/
        //创建省市区表 t_address
        /*stat.executeUpdate("create table  t_address(id int(10),provinceName varchar(255) ,provinceEnglishName varchar(255)," +
                "province_zipCode int(10),cityName varchar(255),cityEnglishName varchar(255)," +
                "city_zipCode int(10),province_confirmedCount int(10),province_suspectedCount int(10)," +
                "province_curedCount int(10),province_deadCount int(10),city_confirmedCount int(10)," +
                "city_suspectedCount int(10),city_curedCount int(10),city_deadCount int(10))");*/
        //创建新闻表 t_news
        stat.executeUpdate("create table t_news(idc varchar(255) PRIMARY KEY,id int(10),pubDate date,title varchar(255)," +
                "summary text,infoSource varchar(255),sourceUrl varchar(255),provinceId int(10)," +
                "provinceName varchar(255),createTime date,modifyTime date,entryWay int(10)," +
                "adoptType tinyint(4),infoType tinyint(4),dataInfoState tinyint(4),dataInfoOperator varchar(255)," +
                "dataInfoTime date,body varchar(255))");
        //创建全国数据表 t_national_data
      /*  stat.executeUpdate("create table t_national_date(idc varchar(255) PRIMARY KEY,infectSource varchar(255),passWay varchar(255)," +
                "dailyPic text,dailyPics text,summary varchar(255),countRemark varchar(255)," +
                "currentConfirmedCount int(10),confirmedCount int(10),suspectedCount int(10),curedCount int(10), " +
                "deadCount int(10),seriousCount int(10),suspectedIncr int(10),currentConfirmedIncr int(10),confirmedIncr int(10)," +
                "curedIncr int(10),deadIncr int(10),seriousIncr int(10),virus varchar(255),remark1 varchar(255),remark2 varchar(255)," +
                "remark3 varchar(255),remark4 varchar(255),remark5 varchar(255),note1 varchar(255),note2 varchar(255),note3 varchar(255)," +
                "generalRemark varchar(255),abroadRemark varchar(255),marquee text,quanguoTrendChart text,hbFeiHbTrendChart text)");
   */     //关闭数据库
        stat.close();
        conn.close();


    }

}
