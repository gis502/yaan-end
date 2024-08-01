package com.ruoyi.system.domain;

import java.sql.Timestamp;

public class YaanSituationPlot {

    private String eqid;
    private String plotid;
    private Timestamp time;
    private String plottype;
    private String drawtype;
    private String latitude;
    private String longitude;
    private String height;
    private String img;

    public String getEqid() {
        return eqid;
    }

    public void setEqid(String eqid) {
        this.eqid = eqid;
    }

    public String getPlotid() {
        return plotid;
    }

    public void setPlotid(String plotid) {
        this.plotid = plotid;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    public String getPlottype() {
        return plottype;
    }

    public void setPlottype(String plottype) {
        this.plottype = plottype;
    }

    public String getDrawtype() {
        return drawtype;
    }

    public void setDrawtype(String drawtype) {
        this.drawtype = drawtype;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    @Override
    public String toString() {
        return "YaanSituationPlot{" +
                "eqid='" + eqid + '\'' +
                ", plotid='" + plotid + '\'' +
                ", time='" + time + '\'' +
                ", plottype='" + plottype + '\'' +
                ", drawtype='" + drawtype + '\'' +
                ", latitude='" + latitude + '\'' +
                ", longitude='" + longitude + '\'' +
                ", height='" + height + '\'' +
                ", img='" + img + '\'' +
                '}';
    }
}
