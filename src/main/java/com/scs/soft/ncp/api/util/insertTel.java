package com.scs.soft.ncp.api.util;

import com.scs.soft.ncp.api.domain.entity.DXYRumors;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class insertTel {
    /**
     * 批量插入到数据库
     * @param list
     */
    public static void insertTel(List<DXYRumors> list) throws SQLException {
        Connection conn = null;
        // 遍历查询结果集
        // 加载驱动程序
        try {
            Class.forName("com.mysql.jdbc.Driver");
            // 连接MySQL数据库！！
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_ncp?useSSL=false&characterEncoding=utf8", "root", "root");
            conn.setAutoCommit(false);
            PreparedStatement prep = conn.prepareStatement("INSERT INTO t_rumor(idc,body,id,mainSummary,rumorType,sourceUrl,summary,title)  VALUES (?,?,?,?,?,?,?,?)"); //需要替换
            int num=0;
            for (DXYRumors value : list) {
                System.out.println(value.getBody());
                num++;
                prep.setString(1, value.getIdc());
                prep.setString(2,value.getBody());
                prep.setInt(3,value.getId());
                prep.setString(4, value.getMainSummary());
                prep.setInt(5,value.getRumorType());
                prep.setString(6,value.getSourceUrl());
                prep.setString(7, value.getSummary());
                prep.setString(8,value.getTitle());
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
    }

}
