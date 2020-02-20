package com.scs.soft.ncp.api.util;


import com.scs.soft.ncp.api.domain.entity.DXYNews;
import org.apache.poi.ss.usermodel.*;

import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


public class NewsUtil {
    public static List<DXYNews> excelToShopIdList(InputStream inputStream) {
        System.out.println(inputStream);
        List<DXYNews> list = new ArrayList<>();
        Workbook workbook = null;
        try {
            workbook = WorkbookFactory.create(inputStream);
            inputStream.close();
            //工作表对象
            Sheet sheet = workbook.getSheetAt(0);
            //总行数
            int rowLength = sheet.getLastRowNum();
            System.out.println("总行数有多少行" + rowLength);
            //工作表的列
            Row row = sheet.getRow(0);

            //总列数
            int colLength = row.getLastCellNum();
            System.out.println("总列数有多少列" + colLength);
            //得到指定的单元格
            Cell cell = row.getCell(0);
            SimpleDateFormat formatter = new SimpleDateFormat( "yyyy-MM-dd HH-mm-ss");
            String s = "2012-02-18 00-00-00";
            Date date = formatter.parse(s);
            for (int i = 1; i <= rowLength; i++) {
                DXYNews dxyNews = new DXYNews();
                Calendar cal = Calendar.getInstance();
                cal.setTime(date);
                cal.add(Calendar.HOUR, -1);// 24小时制
                date = cal.getTime();
                java.sql.Date sqlNow = new java.sql.Date(date.getTime());
                row = sheet.getRow(i);
                for (int j = 0; j < colLength; j++) {
                    cell = row.getCell(j);
                    //                    System.out.print(cell + ",");
                    if (cell != null) {
                        cell.setCellType(Cell.CELL_TYPE_STRING);
                        String data = cell.getStringCellValue();
                        data = data.trim();
                        //                        System.out.print(data);
                        //                        if (StringUtils.isNumeric(data)) {
                        if (j == 0) {
                            dxyNews.setIdc(data);
                        } else if (j == 1) {
                            dxyNews.setId(Integer.parseInt(data));
                        } else if (j == 2) {
                            dxyNews.setPubDate(sqlNow);
                        } else if (j == 3) {
                            dxyNews.setTitle(data);
                        }else if (j == 4) {
                            dxyNews.setSummary(data);
                        } else if (j == 5) {
                            dxyNews.setInfoSource(data);
                        } else if (j == 6) {
                            dxyNews.setSourceUrl(data);
                        }else if (j == 7) {
                            dxyNews.setProvinceId(Integer.parseInt(data));
                        } else if (j == 8) {
                            dxyNews.setProvinceName(data);
                        } else if (j == 9) {
                            dxyNews.setCreateTime(sqlNow);
                        }else if (j == 10) {
                            dxyNews.setModifyTime(sqlNow);
                        } else if (j == 11) {
                            dxyNews.setEntryWay(Integer.parseInt(data));
                        } else if (j == 12) {
                            dxyNews.setAdoptType(Short.parseShort(data));
                        }
                        else if (j == 13) {
                            dxyNews.setInfoType(Short.parseShort(data));
                        }else if (j == 14) {
                            dxyNews.setDataInfoState(Short.parseShort(data));
                        }else if (j == 15) {
                            dxyNews.setDataInfoOperator(data);
                        }else if (j == 16) {
                            dxyNews.setDataInfoTime(sqlNow);
                        }else if (j == 18) {
                            dxyNews.setBody(data);
                        }
                        //                        }
                    }
                }
                list.add(dxyNews);
                /*System.out.println(list);*/
                //                System.out.println("====");
            }
        } catch (Exception e) {
            System.out.println("有错");
        }
        return list;
    }
}
