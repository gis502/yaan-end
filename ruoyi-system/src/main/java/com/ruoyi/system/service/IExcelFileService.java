package com.ruoyi.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ruoyi.system.domain.ExcelFile;

import java.util.List;

public interface IExcelFileService extends IService<ExcelFile> {

    /**
     * 查询所有文件
     * @return
     */
    List<ExcelFile> selectFilesAll();

    /**
     * 获取当前用户可访问的文件
     * @return
     */
    List<ExcelFile> selectFilesByUserId();
}
