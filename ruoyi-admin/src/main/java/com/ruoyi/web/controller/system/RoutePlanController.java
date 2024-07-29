package com.ruoyi.web.controller.system;

import com.alibaba.fastjson2.JSONObject;
import com.ruoyi.system.domain.routeplan.Params;
import com.ruoyi.system.service.EqListService;
import com.ruoyi.system.service.RoutePlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileNotFoundException;

@RestController
@RequestMapping("/map_test")
public class RoutePlanController {
    @Autowired
    private RoutePlanService routePlanService;
    @PostMapping("/way")
    public JSONObject list(@RequestBody Params params) throws FileNotFoundException {

        JSONObject jsonObject = routePlanService.getWay(params);
        return jsonObject;
    }
}
