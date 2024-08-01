package com.ruoyi.system.domain;

import java.sql.Timestamp;

public class YaanSituationPlotInfo {

    private String plotid;
    private Timestamp starttime;
    private Timestamp endtime;
    private String info;
    private String id;

    public String getPlotid() {
        return plotid;
    }

    public void setPlotid(String plotid) {
        this.plotid = plotid;
    }

    public Timestamp getStarttime() {
        return starttime;
    }

    public void setStarttime(Timestamp starttime) {
        this.starttime = starttime;
    }

    public Timestamp getEndtime() {
        return endtime;
    }

    public void setEndtime(Timestamp endtime) {
        this.endtime = endtime;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "YaanSituationPlotInfo{" +
                "plotid='" + plotid + '\'' +
                ", starttime='" + starttime + '\'' +
                ", endtime='" + endtime + '\'' +
                ", info='" + info + '\'' +
                ", id='" + id + '\'' +
                '}';
    }
}
