package com.ruoyi.web.controller.system;

import com.ruoyi.system.domain.EqList;
import com.ruoyi.system.domain.TiltPhotographyModel;
import com.ruoyi.system.service.TiltPhotographyModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/system/model")
public class TiltPhotographyModelController {

    @Autowired
    private TiltPhotographyModelService tiltPhotographyModelService;

    @GetMapping("/getmodel")
    public List<TiltPhotographyModel> selectAllModel(){
        List<TiltPhotographyModel> data = tiltPhotographyModelService.selectAllModel();
        return data;
    }
    @GetMapping("/deletemodel")
    public int deleteModel(String modelid){
        int data = tiltPhotographyModelService.deleteModel(modelid);
        return data;
    }
    @PostMapping("/addmodel")
    public int addModel(@RequestBody TiltPhotographyModel model){
        int data = tiltPhotographyModelService.addModel(model);
        return data;
    }
    @PostMapping("/updatamodel")
    public int updataModel(@RequestBody TiltPhotographyModel model){
        int data = tiltPhotographyModelService.updataModel(model);
        return data;
    }
    @PostMapping("/updatamodelnoelevation")
    public int updataModelNoElevation(@RequestBody TiltPhotographyModel model){
        int data = tiltPhotographyModelService.updataModelNoElevation(model);
        return data;
    }
    @PostMapping("/updatamodelelevation")
    public int updataModelElevation(@RequestBody TiltPhotographyModel model){
        int data = tiltPhotographyModelService.updataModelElevation(model);
        return data;
    }

}
