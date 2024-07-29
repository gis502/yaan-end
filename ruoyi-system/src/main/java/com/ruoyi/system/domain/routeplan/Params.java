package com.ruoyi.system.domain.routeplan;

import java.util.List;

public class Params {
    public double[][] pathWay;

    public List<Area> hardAreas;

    public List<Area> getHardAreas() {
        return hardAreas;
    }

    public void setHardAreas(List<Area> hardAreas) {
        this.hardAreas = hardAreas;
    }

    public double[][] getPathWay() {
        return pathWay;
    }

    public void setPathWay(double[][] pathWay) {
        this.pathWay = pathWay;
    }

}
