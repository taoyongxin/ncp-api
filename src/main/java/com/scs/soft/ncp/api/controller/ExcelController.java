package com.scs.soft.ncp.api.controller;


import com.scs.soft.ncp.api.domain.entity.DXYArea;
import com.scs.soft.ncp.api.util.ExcelUtils;
import org.springframework.web.multipart.MultipartFile;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * 2019-10-07 18:35
 * author: 编程小石头
 * wechat:2501902696
 * desc: 把excel里的数据保存到mysql数据库里
 */

public class ExcelController {

    public static String uploadExcel( MultipartFile file) {

        Map<String, Object> map=null;
        String name = file.getOriginalFilename();
        if (name.length() < 6 || !name.substring(name.length() - 4).equals(".xls")) {
            System.out.println(name);
            return "文件格式错误";
        }
        List<DXYArea> list = null;

        try {

            list = ExcelUtils.excelToShopIdList(file.getInputStream());
            System.out.println(list);
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
                PreparedStatement prep = conn.prepareStatement("INSERT INTO t_address(id,provinceName,provinceEnglishName,province_zipCode,cityName,cityEnglishName,city_zipCode,province_confirmedCount,province_suspectedCount,province_curedCount,province_deadCount,city_confirmedCount,city_suspectedCount,city_curedCount,city_deadCount)  VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)"); //需要替换
                int num=0;
                for (DXYArea value : list) {
                    num++;
                    prep.setInt(1,num);
                    prep.setString(2,value.getProvinceName());
                    prep.setString(3,value.getProvinceEnglishName());
                    prep.setInt(4, value.getProvinceZipCode());
                    prep.setString(5,value.getCityName());
                    prep.setString(6,value.getCityEnglishName());
                    prep.setDouble(7, value.getCityZipCode());
                    prep.setInt(8,value.getProvinceConfirmedCount());
                    prep.setInt(9,value.getProvinceSuspectedCount());
                    prep.setInt(10,value.getProvinceCuredCount());
                    prep.setInt(11,value.getProvinceDeadCount());
                    prep.setInt(12,value.getCityConfirmedCount());
                    prep.setInt(13,value.getCitySuspectedCount());
                    prep.setInt(14,value.getCityCuredCount());
                    prep.setInt(15,value.getCityDeadCount());
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
