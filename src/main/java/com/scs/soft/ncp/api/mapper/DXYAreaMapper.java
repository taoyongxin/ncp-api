package com.scs.soft.ncp.api.mapper;

import com.scs.soft.ncp.api.domain.entity.DXYArea;
import org.apache.ibatis.annotations.Select;

import java.sql.SQLException;
import java.util.List;

/**
 * @author Tao
 */
public interface DXYAreaMapper {
    /**
     * 查询全国各省市地区病情数据
     * @return
     * @throws SQLException
     */
    @Select("SELECT id,provinceName,cityName,province_confirmedCount,province_suspectedCount,province_curedCount," +
            "province_curedCount,city_confirmedCount,city_confirmedCount,city_curedCount,city_deadCount FROM t_address ")
    List<DXYArea> getArea() throws SQLException;
}
