package com.ruoyi.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ruoyi.system.domain.YaanFiles;

import java.util.List;

public interface IYaanFilesService extends IService<YaanFiles> {

    /**
     * 查询所有文件
     * @return
     */
    List<YaanFiles> selectFilesAll();

    /**
     * 获取当前用户可访问的文件
     * @return
     */
    List<YaanFiles> selectFilesByUserId();
}
