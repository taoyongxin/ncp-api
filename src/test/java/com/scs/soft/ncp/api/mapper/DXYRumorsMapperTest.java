package com.scs.soft.ncp.api.mapper;


import com.scs.soft.ncp.api.NcpApiApplication;
import com.scs.soft.ncp.api.domain.entity.DXYRumors;
import com.scs.soft.ncp.api.util.CreateFileUtil;
import net.sf.json.JSONArray;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.sql.SQLException;
import java.util.List;

@SpringBootTest(classes = NcpApiApplication.class)
class DXYRumorsMapperTest {

    @Resource
    private DXYRumorsMapper dxyRumorsMapper;
    @Test
    void getRumor() throws SQLException {
        List<DXYRumors> dxyRumors = dxyRumorsMapper.getRumor();

        JSONArray jsonObject = JSONArray.fromObject(dxyRumors);
        String jsonString1 = jsonObject.toString();
        Boolean isTrue= CreateFileUtil.createJsonFile(jsonString1, "F:\\dev\\ncp", "DXYRumors");
        System.out.println(isTrue);
    }


}