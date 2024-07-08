package com.ruoyi.system.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ruoyi.system.domain.EqList;
import com.ruoyi.system.mapper.EqListMapper;
import com.ruoyi.system.service.EqListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EqListServiceImpl extends ServiceImpl<EqListMapper, EqList> implements EqListService {

    @Autowired
    private EqListMapper eqListMapper;

    @Override
    public int addEq(EqList eq) {
        return eqListMapper.addEq(eq);
    }

    @Override
    public int deleteEq(String eqid) {
        return eqListMapper.deleteEq(eqid);
    }

    @Override
    public int updataEq(EqList eq) {
        return eqListMapper.updataEq(eq);
    }

    @Override
    public List<EqList> selectAllEq() {
        return eqListMapper.selectAllEq();
    }

}
