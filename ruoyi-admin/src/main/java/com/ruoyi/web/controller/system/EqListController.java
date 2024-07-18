package com.ruoyi.web.controller.system;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.ruoyi.system.domain.EqList;
import com.ruoyi.system.domain.PlotIconManagement;
import com.ruoyi.system.domain.Request;
import com.ruoyi.system.mapper.EqListMapper;
import com.ruoyi.system.service.EqListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/system")
public class EqListController {
    @Autowired
    private EqListMapper eqListMapper;
    @Autowired
    private EqListService eqListService;
    @PostMapping("/addeq")
    public int addPlotIcon(@RequestBody EqList eq){
        int data = eqListService.addEq(eq);
        return data;
    }
    @GetMapping("/deleteeq")
    public int deleteEq(String eqid){
        int data = eqListService.deleteEq(eqid);
        return data;
    }
    @PostMapping("/updataeq")
    public int updataEq(@RequestBody EqList eq){
        int data = eqListService.updataEq(eq);
        return data;
    }
    @GetMapping("/geteq")
    public List<EqList> selectAllEq(){
//        List<EqList> data = eqListService.list();
        List<EqList> data = eqListService.selectAllEq();
        return data;
    }
    @PostMapping("/geteqbyid")
    public EqList selectEqByID(@RequestParam String eqid){
        QueryWrapper<EqList> eqListQueryWrapper = new QueryWrapper<>();
        eqListQueryWrapper.eq("eqid",eqid);
        EqList one = eqListService.getOne(eqListQueryWrapper);
        return one;
    }
}
