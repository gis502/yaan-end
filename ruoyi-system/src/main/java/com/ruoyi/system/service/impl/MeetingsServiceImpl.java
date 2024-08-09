package com.ruoyi.system.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ruoyi.system.mapper.MeetingsMapper;
import com.ruoyi.system.domain.export.Meetings;
import com.ruoyi.system.service.MeetingsService;
@Service
public class MeetingsServiceImpl extends ServiceImpl<MeetingsMapper, Meetings> implements MeetingsService{

}
