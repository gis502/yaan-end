package com.ruoyi.system.service.impl;

import com.ruoyi.system.domain.TiltPhotographyModel;
import com.ruoyi.system.mapper.TiltPhotographyModelMapper;
import com.ruoyi.system.service.TiltPhotographyModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TiltPhotographyModelServiceImpl implements TiltPhotographyModelService {
    @Autowired
    private TiltPhotographyModelMapper tiltPhotographyModelMapper;

    @Override
    public List<TiltPhotographyModel> selectAllModel(){return tiltPhotographyModelMapper.selectAllModel();};
    @Override
    public int addModel(TiltPhotographyModel model){
        return tiltPhotographyModelMapper.addModel(model);
    }
    @Override
    public int deleteModel(String modelid){return tiltPhotographyModelMapper.deleteModel(modelid);}
    @Override
    public int updataModel(TiltPhotographyModel model){return tiltPhotographyModelMapper.updataModel(model);}
    @Override
    // 更新没有高程下的tz和rz
    public int updataModelNoElevation(TiltPhotographyModel model){return tiltPhotographyModelMapper.updataModelNoElevation(model);}
    @Override
    // 更新有高程下的tze和rze
    public int updataModelElevation(TiltPhotographyModel model){return tiltPhotographyModelMapper.updataModelElevation(model);}
}
