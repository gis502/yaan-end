package com.ruoyi.system.service;

import com.alibaba.fastjson2.JSONObject;
import com.ruoyi.system.domain.PlotIconManagement;
import com.ruoyi.system.domain.SituationPlot;
import com.ruoyi.system.domain.YaanSituationPlot;
import com.ruoyi.system.domain.YaanSituationPlotInfo;
import com.ruoyi.system.domain.vo.PlotwithStartandEndTime;

import java.util.List;

public interface SituationPlotService {

    public List<SituationPlot> selectPlot(String eqid);

    public int addPlotIcon(PlotIconManagement pim);

    public int deletePlotIcon(String id);

    public int updataPlotIcon(PlotIconManagement pim);

    public List<PlotIconManagement>selectPlotIcon();

//-----------------------------------------------------------------
    public int insertPlotAndInfo(JSONObject param);
    public List<YaanSituationPlot> getPlot(String eqid);
    public List<YaanSituationPlotInfo> getPlotInfos(String plotid);
    public int addPlotInfo(YaanSituationPlotInfo param);
    public int deletePlotAndInfo(String plotid);
    public int deletePlotInfo(String id);
    public int updataPlotInfo(YaanSituationPlotInfo param);
    public List<PlotwithStartandEndTime> getPlotwithStartandEndtime(String eqid);
}
