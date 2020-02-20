package com.scs.soft.ncp.api.mapper;

import com.scs.soft.ncp.api.NcpApiApplication;
import com.scs.soft.ncp.api.domain.entity.DXYArea;
import com.scs.soft.ncp.api.util.CreateFileUtil;
import net.sf.json.JSONArray;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.sql.SQLException;
import java.util.List;
@SpringBootTest(classes = NcpApiApplication.class)
class DXYAreaMapperTest {
    @Resource
    private DXYAreaMapper dxyAreaMapper;
    @Test
    void getArea() throws SQLException {
        List<DXYArea> dxyAreaList = dxyAreaMapper.getArea();

        JSONArray jsonObject = JSONArray.fromObject(dxyAreaList);
        String jsonString1 = jsonObject.toString();
        Boolean isTrue= CreateFileUtil.createJsonFile(jsonString1, "F:\\dev\\ncp", "DXYArea");
        System.out.println(isTrue);
    }
}