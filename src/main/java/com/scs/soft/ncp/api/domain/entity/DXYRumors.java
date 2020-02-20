package com.scs.soft.ncp.api.domain.entity;

import lombok.Builder;
import lombok.Data;

/**
 * @author Tao
 */
@Data
@Builder
public class DXYRumors {
    private String idc;//序号
    private String body;//主题内容
    private Integer id;//排序id
    private String mainSummary;//做出解释
    private Integer rumorType;//谣言类型
    private String sourceUrl;//来源URL
    private String summary;
    private String title;//标题
}
