package com.scs.soft.ncp.api.domain.entity;

import lombok.Data;

/**
 * @author Tao
 */
@Data
public class DXYOverall {
    private String idc;// 序号
    private String infectSource;// 感染来源
    private String passWay;//    通道
    private String dailyPic;//    4
    private String dailyPics;//    5
    private String summary;//    简要
    private String countRemark;//    评论数量
    private Integer currentConfirmedCount;//   当前确诊数量
    private Integer confirmedCount;//    总确证数量
    private Integer suspectedCount;//    疑似数量
    private Integer curedCount;//    治愈数量
    private Integer deadCount;//    死亡数量
    private Integer seriousCount;//    重症数量
    private Integer suspectedIncr;//    疑似数量增长
    private Integer currentConfirmedIncr;//    当前已确诊数量增长
    private Integer confirmedIncr;//    已确诊数量增长
    private Integer curedIncr;//    治愈数增长
    private Integer deadIncr;//   死亡数增长
    private Integer seriousIncr;//    重症数增长
    private String virus;//    病毒
    private String remark1;//    易感染人群
    private String remark2;//    潜伏期
    private String remark3;//    宿主
    private String remark4;//    评论4
    private String remark5;//    评论5
    private String note1;//    病毒命名
    private String note2;//    传染源
    private String note3;//    传播途径
    private String generalRemark;//    数据来自
    private String abroadRemark;//    海外评论
    private String marquee;
    private String quanguoTrendChart;//    全国趋势图
    private String hbFeiHbTrendChart;//    33
}
