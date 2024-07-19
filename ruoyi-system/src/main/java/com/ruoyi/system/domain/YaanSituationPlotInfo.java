package com.ruoyi.system.domain;

public class YaanSituationPlotInfo {

    private String plotid;
    private String starttime;
    private String endtime;
    private String info;
    private String id;

    public String getPlotid() {
        return plotid;
    }

    public void setPlotid(String plotid) {
        this.plotid = plotid;
    }

    public String getStarttime() {
        return starttime;
    }

    public void setStarttime(String starttime) {
        this.starttime = starttime;
    }

    public String getEndtime() {
        return endtime;
    }

    public void setEndtime(String endtime) {
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
