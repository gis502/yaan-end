package com.ruoyi.system.domain;

public class TiltPhotographyModel {
    private String name;
    private String path;
    private Integer rz;
    private Integer tz;
    private Integer rze;
    private Integer tze;
    private String time;
    private String modelid;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Integer getRz() {
        return rz;
    }

    public void setRz(Integer rz) {
        this.rz = rz;
    }

    public Integer getTz() {
        return tz;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setTz(Integer tz) {
        this.tz = tz;
    }

    public Integer getRze() {
        return rze;
    }

    public void setRze(Integer rze) {
        this.rze = rze;
    }

    public Integer getTze() {
        return tze;
    }

    public void setTze(Integer tze) {
        this.tze = tze;
    }


    public String getModelid() {
        return modelid;
    }

    public void setModelid(String modelid) {
        this.modelid = modelid;
    }

    @Override
    public String toString() {
        return "TiltPhotographyModel{" +
                "name='" + name + '\'' +
                ", path='" + path + '\'' +
                ", rz=" + rz +
                ", tz=" + tz +
                ", rze=" + rze +
                ", tze=" + tze +
                ", time='" + time + '\'' +
                ", modelid='" + modelid + '\'' +
                '}';
    }
}
