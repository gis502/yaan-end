package com.ruoyi.system.service.impl;

import com.ruoyi.system.domain.export.YaanDisasterReserves;
import com.ruoyi.system.mapper.YaanDisasterReservesMapper;
import com.ruoyi.system.service.YaanDisasterReservesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class YaanDisasterReservesServiceImpl implements YaanDisasterReservesService {

    @Autowired
    private YaanDisasterReservesMapper yaanDisasterReservesMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return yaanDisasterReservesMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(YaanDisasterReserves record) {
        return yaanDisasterReservesMapper.insert(record);
    }

    @Override
    public int insertSelective(YaanDisasterReserves record) {
        return yaanDisasterReservesMapper.insertSelective(record);
    }

    @Override
    public YaanDisasterReserves selectByPrimaryKey(Integer id) {
        return yaanDisasterReservesMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(YaanDisasterReserves record) {
        return yaanDisasterReservesMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(YaanDisasterReserves record) {
        return yaanDisasterReservesMapper.updateByPrimaryKey(record);
    }

}
