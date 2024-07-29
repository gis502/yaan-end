package com.ruoyi.system.service.impl;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.metadata.CellExtra;
import com.alibaba.excel.read.listener.ReadListener;
import com.ruoyi.system.domain.export.YaanCasualties;
import com.ruoyi.system.mapper.YaanCasualtiesMapper;
import com.ruoyi.system.webSocket.WebSocketServerExcel;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class YaanCasualtiesListener implements ReadListener<YaanCasualties> {


    private final List<YaanCasualties> list = new ArrayList<YaanCasualties>();
    private YaanCasualtiesMapper yaanCasualtiesMapper;
    private int totalRows;
    private int currentRow = 0;
    private String userName;
    private boolean stopReading = false;


    public YaanCasualtiesListener(YaanCasualtiesMapper yaanCasualtiesMapper, int totalRows, String userName) {
        this.yaanCasualtiesMapper = yaanCasualtiesMapper;
        this.totalRows = totalRows;
        this.userName = userName;
    }

    @Override
    public void onException(Exception e, AnalysisContext analysisContext) throws Exception {
        throw e;
    }


    @Override
    public void invoke(YaanCasualties data, AnalysisContext context) {
        System.out.println(data);
        // 检查当前行的第一个单元格
        if (data.getEarthquake().equals("填写单位")) {
            stopReading = true;
            return;
        }
        if (!stopReading) {
            list.add(data);
            // 更新进度
            currentRow++;
            try {
                int progress = (int) ((double) currentRow / (double) totalRows * 100);
                WebSocketServerExcel.sendInfo(String.valueOf(progress), userName);
            } catch (IOException e) {
                System.out.println("返回进度失败，原因：" + e);
            }
        }
    }

    @Override
    public void extra(CellExtra cellExtra, AnalysisContext analysisContext) {

    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext context) {
        System.out.println("读取完毕");
    }

    @Override
    public boolean hasNext(AnalysisContext analysisContext) {
        return true;
    }

    public List<YaanCasualties> getList() {
        return list;
    }
}
