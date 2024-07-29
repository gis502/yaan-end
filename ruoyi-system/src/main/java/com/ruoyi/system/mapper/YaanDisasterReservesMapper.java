package com.ruoyi.system.mapper;

import com.ruoyi.system.domain.export.YaanDisasterReserves;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author 方
 */
@Mapper
public interface YaanDisasterReservesMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(YaanDisasterReserves record);

    int insertSelective(YaanDisasterReserves record);

    YaanDisasterReserves selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(YaanDisasterReserves record);

    int updateByPrimaryKey(YaanDisasterReserves record);
}
