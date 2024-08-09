//package com.ruoyi.web.controller.system;
//
//import com.ruoyi.system.domain.YaanDisasterReserves;
//import com.ruoyi.system.domain.YaanDisasterSupplies;
//import com.ruoyi.system.service.impl.YaanDisasterReservesServiceImpl;
//import com.ruoyi.system.service.impl.YaanDisasterSuppliesServiceImpl;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import javax.annotation.Resource;
//import java.util.List;
//import java.util.stream.Collectors;
//
//@RestController
//@RequestMapping("/system/emergency/")
//public class EmergencyResourcesController {
//
//    @Resource
//    private YaanDisasterReservesServiceImpl yaanDisasterReservesService;
//    @Resource
//    private YaanDisasterSuppliesServiceImpl yaanDisasterSuppliesService;
//
////    @GetMapping("/getEmergency")
//////    获取生活类救灾物资储备表：yaan_disaster_reserves
////    public List<YaanDisasterReserves> getDisasterReserves(){
////        return yaanDisasterReservesService.list().stream().filter(it -> !it.getLongitude().equals("0.00000000")).collect(Collectors.toList());
////    }
//    @GetMapping("/getEmergency")
//    public EmergencyDataDTO getEmergencyData(){
//        List<YaanDisasterReserves> disasterReserves = yaanDisasterReservesService.list()
//                .stream().filter(it -> !it.getLongitude().equals("0.00000000")).collect(Collectors.toList());
//
//        List<YaanDisasterSupplies> disasterSupplies = yaanDisasterSuppliesService.list()
//                .stream().filter(it -> !it.getLongitude().equals("0.00000000")).collect(Collectors.toList());
//
//        return new EmergencyDataDTO(disasterReserves, disasterSupplies);
//    }
//}
package com.ruoyi.web.controller.system;

import com.ruoyi.system.domain.YaanDisasterReserves;
import com.ruoyi.system.domain.YaanDisasterSupplies;
import com.ruoyi.system.service.impl.YaanDisasterReservesServiceImpl;
import com.ruoyi.system.service.impl.YaanDisasterSuppliesServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/system/emergency/")
public class EmergencyResourcesController {

    @Resource
    private YaanDisasterReservesServiceImpl yaanDisasterReservesService;

    @Resource
    private YaanDisasterSuppliesServiceImpl yaanDisasterSuppliesService;

    @GetMapping("/getEmergency")
    public Map<String, List<?>> getEmergencyData(){
        List<YaanDisasterReserves> disasterReserves = yaanDisasterReservesService.list()
                // 过滤掉经纬度为0.00000000的数据，不进行展示
                .stream().filter(it -> !it.getLongitude().equals("0.00000000")).collect(Collectors.toList());

        List<YaanDisasterSupplies> disasterSupplies = yaanDisasterSuppliesService.list()
                .stream().filter(it -> !it.getLongitude().equals("0.00000000")).collect(Collectors.toList());

        // Map 是一种键值对集合，用于存储和快速查找数据
        Map<String, List<?>> emergencyData = new HashMap<>();
        emergencyData.put("disasterReserves", disasterReserves);
        emergencyData.put("disasterSupplies", disasterSupplies);
//        System.out.println(emergencyData); 检查是否获得数据，已获得！
        return emergencyData; //该映射包含两个列表，分别是 disasterReserves 和 disasterSupplies
    }
}
