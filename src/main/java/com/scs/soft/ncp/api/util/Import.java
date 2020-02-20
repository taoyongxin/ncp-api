package com.scs.soft.ncp.api.util;

import com.scs.soft.ncp.api.domain.entity.DXYRumors;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class Import {
    /**
     * 把数据从csv中读取到list
     * @return
     */ public static List<DXYRumors> readCSV(String fileName) {
        List<DXYRumors> dxyRumorsList=new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader("F:\\dev\\ncp\\"+fileName));// 文件名

            reader.readLine();//第一行信息，为标题信息，不用,如果需要，注释掉
            String line = null;
            while ((line = reader.readLine()) != null) {

                Object item[] = line.split(",");// CSV格式文件为逗号分隔符文件，这里根据逗号切分
               DXYRumors dxyRumors=DXYRumors.builder()
                       .idc((String) item[0])
                       .body((String)item[1])
                       .id(Integer.parseInt((String) item[2]))
                       .mainSummary((String)item[3])
                       .rumorType(Integer.parseInt((String) item[4]))
                       .sourceUrl((String)item[5])
                       .summary((String)item[6])
                       .title((String)item[7])
                       .build();
                dxyRumorsList.add(dxyRumors);

            }
//                System.out.println("从CSV中读取到的数据：" + kgInfoList);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dxyRumorsList;
    }
}
