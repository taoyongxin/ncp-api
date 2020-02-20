package com.scs.soft.ncp.api.mapper;

import com.scs.soft.ncp.api.domain.entity.DXYRumors;
import org.apache.ibatis.annotations.Select;

import java.sql.SQLException;
import java.util.List;

/**
 * @author Tao
 */
public interface DXYRumorsMapper {
    /**
     *查询谣言数据
     * @return
     * @throws SQLException
     */
    @Select("SELECT * FROM t_rumor ")
    List<DXYRumors> getRumor() throws SQLException;
}
