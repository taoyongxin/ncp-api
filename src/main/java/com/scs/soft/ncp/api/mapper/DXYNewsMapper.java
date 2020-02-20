package com.scs.soft.ncp.api.mapper;

import com.scs.soft.ncp.api.domain.entity.DXYNews;
import org.apache.ibatis.annotations.Select;

import java.sql.SQLException;
import java.util.List;

/**
 * @author Tao
 */
public interface DXYNewsMapper {
    /**
     * 查询新闻数据
     * @return
     * @throws SQLException
     */
    @Select("SELECT idc,pubDate,title,summary,infoSource,sourceUrl,provinceId,provinceName FROM t_news ")
    List<DXYNews> getNews() throws SQLException;
}
