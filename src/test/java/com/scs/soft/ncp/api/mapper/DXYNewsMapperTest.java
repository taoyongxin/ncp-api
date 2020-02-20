package com.scs.soft.ncp.api.mapper;

import com.scs.soft.ncp.api.NcpApiApplication;
import com.scs.soft.ncp.api.domain.entity.DXYNews;
import com.scs.soft.ncp.api.domain.entity.DXYNews1;
import com.scs.soft.ncp.api.util.CreateFileUtil;
import net.sf.json.JSONArray;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
@SpringBootTest(classes = NcpApiApplication.class)
class DXYNewsMapperTest {
    @Resource
    private DXYNewsMapper dxyNewsMapper;
    @Test
    void getNews() throws SQLException {
        List<DXYNews> dxyNewsList = dxyNewsMapper.getNews();
        List<DXYNews1> dxyNewsList1=new ArrayList<>();
        for (DXYNews group:dxyNewsList){
            DXYNews1 group1=new DXYNews1();
            group1.setIdc(group.getIdc());
            java.sql.Date date=group.getPubDate();
            java.util.Date sqlNow = new java.util.Date(date.getTime());
            group1.setPubDate(sqlNow);
            group1.setTitle(group.getTitle());
            group1.setSummary(group.getSummary());
            group1.setInfoSource(group.getInfoSource());
            group1.setSourceUrl(group.getSourceUrl());
            group1.setProvinceId(group.getProvinceId());
            group1.setProvinceName(group.getProvinceName());
            dxyNewsList1.add(group1);
        }
        JSONArray jsonObject = JSONArray.fromObject(dxyNewsList1);
        String jsonString1 = jsonObject.toString();
        Boolean isTrue= CreateFileUtil.createJsonFile(jsonString1, "F:\\dev\\ncp", "DXYNews");
        System.out.println(isTrue);
    }
}