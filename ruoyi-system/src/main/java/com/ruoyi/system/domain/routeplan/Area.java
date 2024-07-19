package com.ruoyi.system.domain.routeplan;

import java.util.Arrays;

public class Area {
    private String name;
    private double[][] area;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double[][] getArea() {
        return area;
    }

    public void setArea(double[][] area) {
        this.area = area;
    }

    @Override
    public String toString() {
        return "Area{" +
                "name='" + name + '\'' +
                ", area=" + Arrays.toString(area) +
                '}';
    }
}
