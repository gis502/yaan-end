package com.ruoyi.system.service.impl;

import com.alibaba.fastjson2.JSON;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ruoyi.common.core.domain.entity.SysUser;
import com.ruoyi.common.exception.ServiceException;
import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.system.domain.YaanFiles;
import com.ruoyi.system.mapper.YaanFilesMapper;
import com.ruoyi.system.service.ISysUserService;
import com.ruoyi.system.service.IYaanFilesService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class YaanFilesServiceImpl extends ServiceImpl<YaanFilesMapper, YaanFiles> implements IYaanFilesService {
    private final  ISysUserService userService;
    @Override
    public List<YaanFiles> selectFilesAll() {
        return baseMapper.selectList(null);
    }

    @Override
    public List<YaanFiles> selectFilesByUserId() {
        Long userId = SecurityUtils.getUserId();
        //如果用户id为空或者不存在
        if (userId == null) {
            throw new ServiceException("用户id为空或者不存在");
        }
       //查询当前用户的文件
        SysUser sysUser = userService.selectUserById(userId);
        List<Integer> userFileIds = JSON.parseArray(sysUser.getFileIds(), Integer.class);
        if (userFileIds == null || userFileIds.size() == 0) {
            return Collections.emptyList();
        }
        return baseMapper.selectList(Wrappers.<YaanFiles>lambdaQuery().in(YaanFiles::getFileId, userFileIds));
    }
}
