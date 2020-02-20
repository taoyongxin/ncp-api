package com.scs.soft.ncp.api.domain.entity;

import lombok.Data;

/**
 * @author Tao
 */
@Data
public class DXYArea {
    private Integer id;//序号
    private String provinceName;//省份
    private String provinceEnglishName;//省份拼音
    private Integer provinceZipCode;//省份邮政编码
    private String cityName;//市区
    private String cityEnglishName;//市区拼音
    private Double cityZipCode;//市区邮政编码
    private Integer provinceConfirmedCount;//省确诊人数
    private Integer provinceSuspectedCount;//省疑似人数
    private Integer provinceCuredCount;//省已治愈人数
    private Integer provinceDeadCount;//省死亡人数
    private Integer cityConfirmedCount;//市确诊人数
    private Integer citySuspectedCount;//市疑似人数
    private Integer cityCuredCount;//市已治愈人数
    private Integer cityDeadCount;//市死亡人数
}
