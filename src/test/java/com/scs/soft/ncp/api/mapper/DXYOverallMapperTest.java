package com.scs.soft.ncp.api.mapper;


import com.scs.soft.ncp.api.NcpApiApplication;
import com.scs.soft.ncp.api.domain.entity.DXYOverall;
import com.scs.soft.ncp.api.util.CreateFileUtil;
import net.sf.json.JSONArray;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.sql.SQLException;
import java.util.List;
@SpringBootTest(classes = NcpApiApplication.class)
class DXYOverallMapperTest {
    @Resource
    private DXYOverallMapper dxyOverallMapper;

    @Test
    void getOverAll() throws SQLException {
        List<DXYOverall> dxyOverallList = dxyOverallMapper.getOverAll();

        JSONArray jsonObject = JSONArray.fromObject(dxyOverallList);
        String jsonString1 = jsonObject.toString();
        Boolean isTrue= CreateFileUtil.createJsonFile(jsonString1, "F:\\dev\\ncp", "DXYOverall");
        System.out.println(isTrue);
    }
}