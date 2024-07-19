package com.ruoyi.web.controller.system;

import com.alibaba.fastjson2.JSONObject;
import com.ruoyi.system.domain.PlotIconManagement;
import com.ruoyi.system.domain.SituationPlot;
import com.ruoyi.system.domain.YaanSituationPlot;
import com.ruoyi.system.domain.YaanSituationPlotInfo;
import com.ruoyi.system.service.SituationPlotService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/system/ploy")
public class SituationPlotController {

    @Autowired
    private SituationPlotService situationPlotService;
    @GetMapping("/geteqploy")
    public List<SituationPlot> getPloy(String id){
        List<SituationPlot> plotData = situationPlotService.selectPlot(id);
        return plotData;
    }
    @PostMapping("/addploticon")
    public int addPlotIcon(@RequestBody PlotIconManagement pim){
        int data = situationPlotService.addPlotIcon(pim);
        return data;
    }
    @GetMapping("/deleteploticon")
    public int deletePlotIcon(String id){
        int data = situationPlotService.deletePlotIcon(id);
        return data;
    }
    @PostMapping("/updataploticon")
    public int updataPlotIcon(@RequestBody PlotIconManagement pim){
//        System.out.println(pim.getId());
        int data = situationPlotService.updataPlotIcon(pim);
        return data;
    }
    @GetMapping("/getploticon")
    public List<PlotIconManagement>selectPlotIcon(){
        List<PlotIconManagement> plotIcon = situationPlotService.selectPlotIcon();
        return plotIcon;
    }
//---------------------------------------------------------------------------
    @PostMapping("/insertplotandinfo")
    public int insertPlotAndInfo(@RequestBody JSONObject param){
        int data = situationPlotService.insertPlotAndInfo(param);
        return data;
    }

    @GetMapping("/getplot")
    public List<YaanSituationPlot> getPlot(String eqid){
        List<YaanSituationPlot> plotData = situationPlotService.getPlot(eqid);
        return plotData;
    }

    @GetMapping("/getplotinfos")
    public List<YaanSituationPlotInfo> getPlotInfos(String plotid){
        List<YaanSituationPlotInfo> plotInfoData = situationPlotService.getPlotInfos(plotid);
        return plotInfoData;
    }
    @PostMapping("/addplotinfo")
    public int addPlotInfo(@RequestBody YaanSituationPlotInfo param){
        return situationPlotService.addPlotInfo(param);
    }
    @GetMapping("/deleteplotandinfo")
    public int deletePlotAndInfo(String plotid){
        int data = situationPlotService.deletePlotAndInfo(plotid);
        return data;
    }
    @GetMapping("/deleteplotinfo")
    public int deletePlotInfo(String id){
        int data = situationPlotService.deletePlotInfo(id);
        return data;
    }
    @PostMapping("/updataplotinfo")
    public int updataPlotInfo(@RequestBody YaanSituationPlotInfo param){
        int data = situationPlotService.updataPlotInfo(param);
        return data;
    }
}
