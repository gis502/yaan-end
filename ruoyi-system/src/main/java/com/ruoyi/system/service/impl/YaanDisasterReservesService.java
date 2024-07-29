package com.ruoyi.system.service.impl;

import com.ruoyi.system.domain.export.YaanDisasterReserves;
public interface YaanDisasterReservesService{

    int deleteByPrimaryKey(Integer id);

    int insert(YaanDisasterReserves record);

    int insertSelective(YaanDisasterReserves record);

    YaanDisasterReserves selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(YaanDisasterReserves record);

    int updateByPrimaryKey(YaanDisasterReserves record);

}
