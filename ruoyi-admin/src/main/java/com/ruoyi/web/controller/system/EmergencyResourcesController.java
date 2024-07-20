package com.ruoyi.web.controller.system;

import com.ruoyi.system.domain.SituationPlot;
import com.ruoyi.system.domain.YaanDisasterReserves;
import com.ruoyi.system.service.SituationPlotService;
import com.ruoyi.system.service.impl.YaanDisasterReservesServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@RequestMapping("/system/emergency/")
public class EmergencyResourcesController {

    @Resource
    private YaanDisasterReservesServiceImpl yaanDisasterReservesService;

    @GetMapping("/getEmergency")
    public List<YaanDisasterReserves> getDisasterReserves(){
        return yaanDisasterReservesService.list().stream().filter(it -> !it.getLongitude().equals("0.00000000")).collect(Collectors.toList());
    }
}
