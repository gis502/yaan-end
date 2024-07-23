package com.ruoyi.web.controller.system;

import com.ruoyi.system.domain.PlotIconManagement;
import com.ruoyi.system.domain.SituationPlot;
import com.ruoyi.system.service.SituationPlotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@RestController
@RequestMapping("/system/ploy")
public class SituationPlotController {

    @Autowired
    private SituationPlotService situationPlotService;
    @GetMapping("/geteqploy")
    public List<SituationPlot> getPloy(String id){
        List<SituationPlot> plotData = situationPlotService.selectPlot(id);
        // 2. 对 plotData 进行排序
//        plotData.sort(Comparator.comparing(SituationPlot::getTimestamp));
        System.out.println(plotData);
        // 3. 返回排序后的数据
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

}
