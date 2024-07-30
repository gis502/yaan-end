package com.ruoyi.system.service;

import com.ruoyi.system.domain.export.YaanDisasterReserves;
import org.springframework.stereotype.Service;

public interface YaanDisasterReservesService {

    int deleteByPrimaryKey(Integer id);

    int insert(YaanDisasterReserves record);

    int insertSelective(YaanDisasterReserves record);

    YaanDisasterReserves selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(YaanDisasterReserves record);

    int updateByPrimaryKey(YaanDisasterReserves record);

}




