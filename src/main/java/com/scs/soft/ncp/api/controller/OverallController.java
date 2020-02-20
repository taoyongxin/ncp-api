package com.scs.soft.ncp.api.controller;


import com.scs.soft.ncp.api.domain.entity.DXYOverall;
import com.scs.soft.ncp.api.util.OverallUtil;
import org.springframework.web.multipart.MultipartFile;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class OverallController {
    public static String uploadExcel(/*@RequestParam("file")*/ MultipartFile file) {

        Map<String, Object> map=null;
        String name = file.getOriginalFilename();
        if (name.length() < 6 || !name.substring(name.length() - 4).equals(".xls")) {
            System.out.println(name);
            return "文件格式错误";
        }
        List<DXYOverall> list = null;

        try {

            list = OverallUtil.excelToShopIdList(file.getInputStream());
/*            System.out.println(list);*/
            if (list == null || list.size() <= 0) {
                return "导入的数据为空";
            }
            //excel的数据保存到数据库
            Connection conn = null;
            // 遍历查询结果集
            // 加载驱动程序
            try {
                Class.forName("com.mysql.jdbc.Driver");
                // 连接MySQL数据库！！
                conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_ncp?useSSL=false&characterEncoding=utf8", "root", "root");
                conn.setAutoCommit(false);
                PreparedStatement prep = conn.prepareStatement("INSERT INTO t_national_date(idc,infectSource,passWay,dailyPic,dailyPics,summary,countRemark,currentConfirmedCount,confirmedCount,suspectedCount,curedCount,deadCount,seriousCount,suspectedIncr,currentConfirmedIncr,confirmedIncr,curedIncr,deadIncr,seriousIncr,virus,remark1,remark2,remark3,remark4,remark5,note1,note2,note3,generalRemark,abroadRemark,marquee,quanguoTrendChart,hbFeiHbTrendChart)  VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)"); //需要替换
                int num=0;
                for (DXYOverall value1 : list) {
                    /*                    System.out.println(value1.getId());*/
                    num++;
                    prep.setString(1,value1.getIdc());
                    if (value1.getInfectSource()!=null)
                    prep.setString(2,value1.getInfectSource());
                    if (value1.getPassWay()!=null)
                    prep.setString(3, value1.getPassWay());
                    if (value1.getDailyPic()!=null)
                    prep.setString(4, value1.getDailyPic());
                    if (value1.getDailyPics()!=null)
                    prep.setString(5,value1.getDailyPics());

                    prep.setString(6,value1.getSummary());

                    prep.setString(7,value1.getCountRemark());
                    if (value1.getCurrentConfirmedCount()!=null)
                    prep.setInt(8, value1.getCurrentConfirmedCount());
                    if (value1.getConfirmedCount()!=null)
                    prep.setInt(9,value1.getConfirmedCount());
                    if (value1.getSuspectedCount()!=null)
                    prep.setInt(10, value1.getSuspectedCount());
                    if (value1.getCuredCount()!=null)
                    prep.setInt(11, value1.getCuredCount());
                    if (value1.getDeadCount()!=null)
                    prep.setInt(12, value1.getDeadCount());
                    if (value1.getSeriousCount()!=null)
                    prep.setInt(13, value1.getSeriousCount());
                    if (value1.getSuspectedIncr()!=null)
                    prep.setInt(14, value1.getSuspectedIncr());
                    if (value1.getCurrentConfirmedIncr()!=null)
                    prep.setInt(15,value1.getCurrentConfirmedIncr());
                    if (value1.getConfirmedIncr()!=null)
                    prep.setInt(16,value1.getConfirmedIncr());
                    if (value1.getCuredIncr()!=null)
                    prep.setInt(17,value1.getCuredIncr());
                    if (value1.getDeadIncr()!=null)
                    prep.setInt(18,value1.getDeadIncr());
                    if (value1.getSeriousIncr()!=null)
                    prep.setInt(19,value1.getSeriousIncr());
                    if (value1.getVirus()!=null)
                    prep.setString(20, value1.getVirus());
                    if (value1.getRemark1()!=null)
                    prep.setString(21, value1.getRemark1());
                    if (value1.getRemark2()!=null)
                    prep.setString(22, value1.getRemark2());
                    if (value1.getRemark3()!=null)
                    prep.setString(23, value1.getRemark3());

                    prep.setString(24, value1.getRemark4());

                    prep.setString(25, value1.getRemark5());
                    if (value1.getNote1()!=null)
                    prep.setString(26, value1.getNote1());
                    if (value1.getNote2()!=null)
                    prep.setString(27, value1.getNote2());
                    if (value1.getNote3()!=null)
                    prep.setString(28, value1.getNote3());
                    if (value1.getGeneralRemark()!=null)
                    prep.setString(29, value1.getGeneralRemark());
                    prep.setString(30, value1.getAbroadRemark());
                    if (value1.getMarquee()!=null)
                    prep.setString(31, value1.getMarquee());
                    if (value1.getQuanguoTrendChart()!=null)
                    prep.setString(32, value1.getQuanguoTrendChart());
                    if (value1.getHbFeiHbTrendChart()!=null)
                    prep.setString(33, value1.getHbFeiHbTrendChart());

                    prep.addBatch();
                    if(num>50000){
                        System.out.println(prep);
                        prep.executeBatch();
                        conn.commit();
                        num=0;
                    }
                    System.out.println(prep);
                    prep.executeBatch();
                    conn.commit();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }finally {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return e.getMessage();
        }
        return "保存成功";
    }
}
