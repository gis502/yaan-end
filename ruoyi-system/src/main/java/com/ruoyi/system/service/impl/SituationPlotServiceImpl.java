package com.ruoyi.system.service.impl;

import com.alibaba.fastjson2.JSONObject;
import com.ruoyi.system.domain.PlotIconManagement;
import com.ruoyi.system.domain.SituationPlot;
import com.ruoyi.system.domain.YaanSituationPlot;
import com.ruoyi.system.domain.YaanSituationPlotInfo;
import com.ruoyi.system.domain.vo.PlotwithStartandEndTime;
import com.ruoyi.system.mapper.SituationPlotMapper;
import com.ruoyi.system.service.SituationPlotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SituationPlotServiceImpl implements SituationPlotService {

    @Autowired
    private SituationPlotMapper situationPlotMapper;

    @Override
    public List<SituationPlot> selectPlot(String eqid){
        return situationPlotMapper.selectPlot(eqid);
    }
    @Override
    public int addPlotIcon(PlotIconManagement pim){
        return situationPlotMapper.addPlotIcon(pim);
    }
    @Override
    public List<PlotIconManagement>selectPlotIcon(){
        return situationPlotMapper.selectPlotIcon();
    }
    @Override
    public int updataPlotIcon(PlotIconManagement pim){
        return situationPlotMapper.updataPlotIcon(pim);
    }
    @Override
    public int deletePlotIcon(String id){
        return situationPlotMapper.deletePlotIcon(id);
    }

//----------------------------------------------------------------------------
    @Override
    public int insertPlotAndInfo(JSONObject param){
        int status = 0;
        JSONObject plot = param.getJSONObject("plot");
        JSONObject plotInfo = param.getJSONObject("plotinfo");

        YaanSituationPlot paramPlot = plot.toJavaObject(YaanSituationPlot.class);//new YaanSituationPlot();
        YaanSituationPlotInfo paramPlotInfo = plotInfo.toJavaObject(YaanSituationPlotInfo.class);//new YaanSituationPlotInfo();
        status = situationPlotMapper.insertPlot(paramPlot);
        if(status==1){
            status = situationPlotMapper.insertPlotInfo(paramPlotInfo);
        }
//        paramPlot.setEqid(plot.getString("eqid"));
        return status;
    }
    @Override
    public List<YaanSituationPlot> getPlot(String eqid){
        return situationPlotMapper.getPlot(eqid);
    }
    @Override
    public List<YaanSituationPlotInfo> getPlotInfos(String plotid){
        return situationPlotMapper.getPlotInfos(plotid);
    }
    @Override
    public int addPlotInfo(YaanSituationPlotInfo param){
        return situationPlotMapper.insertPlotInfo(param);
    }
    @Override
    public int deletePlotAndInfo(String plotid){
        int status = 0;
        status = situationPlotMapper.deletePlot(plotid);
        if(status!=0){
            status = situationPlotMapper.deletePlotInfo(plotid);
        }
        return status;
    }
    @Override
    public int deletePlotInfo(String id){
        return situationPlotMapper.deletePlotInfoById(id);
    }

    @Override
    public int updataPlotInfo(YaanSituationPlotInfo param){
        return situationPlotMapper.updataPlotInfo(param);
    }

    @Override
    public List<PlotwithStartandEndTime> getPlotwithStartandEndtime(String eqid){
        return situationPlotMapper.getPlotwithStartandEndtime(eqid);
    }

}
