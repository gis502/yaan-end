package com.ruoyi.system.mapper;

import com.ruoyi.system.domain.PlotIconManagement;
import com.ruoyi.system.domain.SituationPlot;
import com.ruoyi.system.domain.YaanSituationPlot;
import com.ruoyi.system.domain.YaanSituationPlotInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface SituationPlotMapper {

    List<SituationPlot> selectPlot(@Param("eqid") String eqid);

    int addPlot(SituationPlot sp);

    int addPlotMore(List<SituationPlot> spM);

//    int deletePlot(@Param("id") String id);

    int addPlotIcon(PlotIconManagement pim);

    int deletePlotIcon(@Param("id") String id);

    int updataPlotIcon(PlotIconManagement pim);

    List<PlotIconManagement> selectPlotIcon();

// ----------------------------------------------------------------

    int insertPlot(YaanSituationPlot param);

    int insertPlotInfo(YaanSituationPlotInfo param);

    List<YaanSituationPlot> getPlot(@Param("eqid") String eqid);

    List<YaanSituationPlotInfo> getPlotInfos(@Param("plotid") String plotid);

    int deletePlot(@Param("plotid") String plotid);

    int deletePlotInfo(@Param("plotid") String plotid);

    int deletePlotInfoById(@Param("id") String id);
    int updataPlotInfo(YaanSituationPlotInfo param);

}
