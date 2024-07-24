package com.ruoyi.web.controller.system;

import com.ruoyi.common.core.domain.R;
import com.ruoyi.system.domain.export.YaanAftershockStatistics;
import com.ruoyi.system.service.impl.YaanAftershockStatisticsServiceImpl;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.List;


@RestController
@RequestMapping("AfterShockStatistics")
public class AfterShockStatisticsController {

    @Resource
    private YaanAftershockStatisticsServiceImpl afterShockStatisticsService;


    @PostMapping("/getAfterShockStatistics/{userName}")
    public R getAfterShockStatistics(@RequestParam("file") MultipartFile file, @PathVariable(value = "userName") String userName) throws IOException {
        try  {
            List<YaanAftershockStatistics> list = afterShockStatisticsService.importExcel(file, userName);
            return R.ok("文件上传成功"+list);
        } catch (Exception e) {
            e.printStackTrace();
            return R.fail("文件上传失败: " + e.getMessage());
        }
    }

}
