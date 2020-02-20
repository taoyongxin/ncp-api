package com.scs.soft.ncp.api.mapper;

import com.scs.soft.ncp.api.domain.entity.DXYOverall;
import org.apache.ibatis.annotations.Select;

import java.sql.SQLException;
import java.util.List;

/**
 * @author Tao
 */
public interface DXYOverallMapper {
    /**
     * 全国疫情概览
     * @return
     * @throws SQLException
     */
    @Select("SELECT idc,currentConfirmedCount,confirmedCount,suspectedCount,curedCount,deadCount,seriousCount," +
            "note1,note2,note3,generalRemark FROM t_national_date")
    List<DXYOverall> getOverAll() throws SQLException;
}
