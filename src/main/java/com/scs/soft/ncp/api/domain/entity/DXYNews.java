package com.scs.soft.ncp.api.domain.entity;

import lombok.Data;

import java.sql.Date;

/**
 * @author Tao
 */
@Data
public class DXYNews {
   private String idc;//序号
   private Integer id;//排序id
   private Date pubDate;//发布日期
   private String title;//标题
   private String summary;//主题内容
   private String infoSource;//信息源
   private String sourceUrl;//来源URL
   private Integer provinceId;//省id
   private String provinceName;//省名
   private Date createTime;//创建时间
   private Date modifyTime;//修改时间
   private Integer entryWay;//入口通道
   private Short adoptType;//采用类型
   private Short infoType;//信息类型
   private Short dataInfoState;//数据信息状态
   private String dataInfoOperator;
   private Date dataInfoTime;//数据信息时间
   private String body;
}
