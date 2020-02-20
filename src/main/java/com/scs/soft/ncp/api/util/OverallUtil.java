package com.scs.soft.ncp.api.util;

import com.scs.soft.ncp.api.domain.entity.DXYOverall;
import org.apache.poi.ss.usermodel.*;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class OverallUtil {
    public static List<DXYOverall> excelToShopIdList(InputStream inputStream) {
        System.out.println(inputStream);
        List<DXYOverall> list = new ArrayList<>();
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
                DXYOverall dxyOverall = new DXYOverall();
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
                            dxyOverall.setIdc(data);
                        } else if (j == 1) {
                            dxyOverall.setInfectSource(data);
                        } else if (j == 2) {
                            dxyOverall.setPassWay(data);
                        } else if (j == 3) {
                            dxyOverall.setDailyPic(data);
                        }else if (j == 4) {
                            dxyOverall.setDailyPics(data);
                        } else if (j == 5) {
                            dxyOverall.setSummary(data);
                        }else if (j == 6) {
                            dxyOverall.setCountRemark(data);
                        } else if (j == 7) {
                            dxyOverall.setCurrentConfirmedCount(Integer.parseInt(data));
                        } else if (j == 8) {
                            dxyOverall.setConfirmedCount(Integer.parseInt(data));
                        }else if (j == 9) {
                            dxyOverall.setSuspectedCount(Integer.parseInt(data));
                        } else if (j == 10) {
                            dxyOverall.setCuredCount(Integer.parseInt(data));
                        } else if (j == 11) {
                            dxyOverall.setDeadCount(Integer.parseInt(data));
                        }else if (j == 12) {
                            dxyOverall.setSeriousCount(Integer.parseInt(data));
                        }else if (j == 13 && data!=null) {
                            dxyOverall.setSuspectedIncr(Integer.parseInt(data));
                        } else if (j == 14) {
                            dxyOverall.setCurrentConfirmedIncr(Integer.parseInt(data));
                        } else if (j == 15) {
                            dxyOverall.setConfirmedIncr(Integer.parseInt(data));
                        }else if (j == 16) {
                            dxyOverall.setCuredIncr(Integer.parseInt(data));
                        }else if (j == 17) {
                            dxyOverall.setDeadIncr(Integer.parseInt(data));
                        }else if (j == 18) {
                            dxyOverall.setSeriousIncr(Integer.parseInt(data));
                        }else if (j == 19) {
                            dxyOverall.setVirus(data);
                        }else if (j == 20) {
                            dxyOverall.setRemark1(data);
                        }else if (j == 21) {
                            dxyOverall.setRemark2(data);
                        }else if (j == 22) {
                            dxyOverall.setRemark3(data);
                        }else if (j == 23) {
                            dxyOverall.setRemark4(data);
                        }else if (j == 24) {
                            dxyOverall.setRemark5(data);
                        }else if (j == 25) {
                            dxyOverall.setNote1(data);
                        }else if (j == 26) {
                            dxyOverall.setNote2(data);
                        }else if (j == 27) {
                            dxyOverall.setNote3(data);
                        }else if (j == 28) {
                            dxyOverall.setGeneralRemark(data);
                        }else if (j == 29) {
                            dxyOverall.setAbroadRemark(data);
                        }else if (j == 30) {
                            dxyOverall.setMarquee(data);
                        }else if (j == 31) {
                            dxyOverall.setQuanguoTrendChart(data);
                        }else if (j == 32) {
                            dxyOverall.setHbFeiHbTrendChart(data);
                        }

                        //                        }
                    }
                }
                list.add(dxyOverall);
                //                System.out.println("====");
            }
        } catch (Exception e) {
            System.out.println("有错");
        }
        return list;
    }
}
