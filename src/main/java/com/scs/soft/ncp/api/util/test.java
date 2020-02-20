package com.scs.soft.ncp.api.util;

import com.scs.soft.ncp.api.controller.OverallController;
import org.apache.http.entity.ContentType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class test {
    public static void main(String[] args) {
        /*List<DXYRumors> dxyRumorsList=Import.readCSV("DXYRumors.csv");
        try {
            insertTel.insertTel( dxyRumorsList);
        } catch (SQLException e) {
            e.printStackTrace();
        }*/
    /*    try {
            PoiDemo.PoiDemo();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }*/
       /* String filePath = "F:\\dev\\ncp\\DXYArea.xls";
        File excel = new File(filePath);
        FileInputStream fileInputStream=null;
        try {
             fileInputStream = new FileInputStream(excel);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        MultipartFile multipartFile = null;
        try {
            multipartFile = new MockMultipartFile(excel.getName(),excel.getName(), ContentType.APPLICATION_OCTET_STREAM.toString(),fileInputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(multipartFile.getName());
        ExcelController.uploadExcel(multipartFile);*/

/*        String filePath = "F:\\dev\\ncp\\DXYNews.xls";
        File excel = new File(filePath);
        FileInputStream fileInputStream=null;
        try {
             fileInputStream = new FileInputStream(excel);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        MultipartFile multipartFile = null;
        try {
            multipartFile = new MockMultipartFile(excel.getName(),excel.getName(), ContentType.APPLICATION_OCTET_STREAM.toString(),fileInputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(multipartFile.getName());
        NewsController.uploadExcel(multipartFile);*/

        String filePath = "F:\\dev\\SpringBoot\\ncp-api\\src\\main\\resources\\DXYOverall.xls";
        File excel = new File(filePath);
        FileInputStream fileInputStream=null;
        try {
             fileInputStream = new FileInputStream(excel);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        MultipartFile multipartFile = null;
        try {
            multipartFile = new MockMultipartFile(excel.getName(),excel.getName(), ContentType.APPLICATION_OCTET_STREAM.toString(),fileInputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(multipartFile.getName());
        OverallController.uploadExcel(multipartFile);

    }
}
