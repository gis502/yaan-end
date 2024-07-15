package com.ruoyi.system.mapper;

import com.ruoyi.system.domain.TiltPhotographyModel;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TiltPhotographyModelMapper {

    List<TiltPhotographyModel> selectAllModel();

    int addModel(TiltPhotographyModel model);

    int deleteModel(String modelid);

    int updataModel(TiltPhotographyModel model);

    //    更新没有高程下的tz和rz
    int updataModelNoElevation(TiltPhotographyModel model);
    //    更新有高程下的tze和rze
    int updataModelElevation(TiltPhotographyModel model);

}
