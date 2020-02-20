package com.scs.soft.ncp.api.util;


import com.scs.soft.ncp.api.domain.entity.DXYArea;
import org.apache.poi.ss.usermodel.*;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

;

/*
 * 操作excel
 * */
public class ExcelUtils {

    public static List<DXYArea> excelToShopIdList(InputStream inputStream) {
        System.out.println(inputStream);
        List<DXYArea> list = new ArrayList<>();
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
            for (int i = 1; i <= rowLength; i++) {
                DXYArea dxyArea = new DXYArea();
                row = sheet.getRow(i);
                dxyArea.setId(i);
                for (int j = 0; j < colLength; j++) {
                    //列： 0姓名	1人员编号	2餐补 3部门
                    cell = row.getCell(j);
                    //                    System.out.print(cell + ",");
                    if (cell != null) {
                        cell.setCellType(Cell.CELL_TYPE_STRING);
                        String data = cell.getStringCellValue();
                        data = data.trim();
                        //                        System.out.print(data);
                        //                        if (StringUtils.isNumeric(data)) {
                        if (j == 0) {
                            dxyArea.setProvinceName(data);
                        } else if (j == 1) {
                            dxyArea.setProvinceEnglishName(data);
                        } else if (j == 2) {
                            dxyArea.setProvinceZipCode(Integer.parseInt(data));
                        } else if (j == 3) {
                            dxyArea.setCityName(data);
                        }else if (j == 4) {
                            dxyArea.setCityEnglishName(data);
                        } else if (j == 5) {
                            dxyArea.setCityZipCode(Double.parseDouble(data));
                        } else if (j == 6) {
                            dxyArea.setProvinceConfirmedCount(Integer.parseInt(data));
                        }else if (j == 7) {
                            dxyArea.setProvinceSuspectedCount(Integer.parseInt(data));
                        } else if (j == 8) {
                            dxyArea.setProvinceCuredCount(Integer.parseInt(data));
                        } else if (j == 9) {
                            dxyArea.setProvinceDeadCount(Integer.parseInt(data));
                        }else if (j == 10) {
                            dxyArea.setCityConfirmedCount(Integer.parseInt(data));
                        } else if (j == 11) {
                            dxyArea.setCitySuspectedCount(Integer.parseInt(data));
                        } else if (j == 12) {
                            dxyArea.setCityCuredCount(Integer.parseInt(data));
                        }
                        else if (j == 13) {
                            dxyArea.setCityDeadCount(Integer.parseInt(data));
                        }
                        //                        }
                    }
                }
                list.add(dxyArea);
                //                System.out.println("====");
            }
        } catch (Exception e) {
            System.out.println("有错");
        }
        return list;
    }
}