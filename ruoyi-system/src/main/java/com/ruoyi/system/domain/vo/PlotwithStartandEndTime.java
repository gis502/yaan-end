package com.ruoyi.system.domain.vo;

import lombok.Data;

import java.io.Serializable;

@Data
public class PlotwithStartandEndTime implements Serializable {
    private String plotid;
    private String plottype;
    private String drawtype;
    private String longitude;
    private String latitude;
    private String height;
    private String img;

    private String starttime;
    private String endtime;
}
