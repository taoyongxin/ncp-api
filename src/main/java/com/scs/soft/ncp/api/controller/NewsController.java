package com.scs.soft.ncp.api.controller;


import com.scs.soft.ncp.api.domain.entity.DXYNews;
import com.scs.soft.ncp.api.util.NewsUtil;
import org.springframework.web.multipart.MultipartFile;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class NewsController {
    public static String uploadExcel(/*@RequestParam("file")*/ MultipartFile file) {

        Map<String, Object> map=null;
        String name = file.getOriginalFilename();
        if (name.length() < 6 || !name.substring(name.length() - 4).equals(".xls")) {
            System.out.println(name);
            return "文件格式错误";
        }
        List<DXYNews> list = null;

        try {

            list = NewsUtil.excelToShopIdList(file.getInputStream());
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
                PreparedStatement prep = conn.prepareStatement("INSERT INTO t_news(idc,id,pubDate,title,summary,infoSource,sourceUrl,provinceId,provinceName,createTime,modifyTime,entryWay,adoptType,infoType,dataInfoState,dataInfoOperator,dataInfoTime,body)  VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)"); //需要替换
                int num=0;
                for (DXYNews value1 : list) {
/*                    System.out.println(value1.getId());*/
                    num++;
                    prep.setString(1,value1.getIdc());
                    prep.setInt(2,value1.getId());
                    prep.setDate(3, value1.getPubDate());
                    prep.setString(4, value1.getTitle());
                    prep.setString(5,value1.getSummary());
                    prep.setString(6,value1.getInfoSource());
                    prep.setString(7,value1.getSourceUrl());
                    prep.setInt(8, value1.getProvinceId());
                    prep.setString(9,value1.getProvinceName());
                    prep.setDate(10, value1.getCreateTime());
                    prep.setDate(11, value1.getModifyTime());
                    if (value1.getEntryWay()!=null) {
                        prep.setInt(12,value1.getEntryWay());
                    }
                    if (value1.getAdoptType()!=null) {
                        prep.setShort(13,value1.getAdoptType());
                    }
                    if (value1.getInfoType()!=null) {
                        prep.setInt(14,value1.getInfoType());
                    }
                    if (value1.getDataInfoState()!=null) {
                        prep.setInt(15,value1.getDataInfoState());
                    }
                    prep.setString(16,value1.getDataInfoOperator());
                    if (value1.getDataInfoTime()!=null) {
                        prep.setDate(17, value1.getDataInfoTime());
                    }
                    prep.setString(18,"备注");
                    prep.addBatch();
                    if(num>50000){
                        System.out.println(prep);
                        prep.executeBatch();
                        conn.commit();
                        num=0;
                    }
                    /*System.out.println(prep);*/
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
