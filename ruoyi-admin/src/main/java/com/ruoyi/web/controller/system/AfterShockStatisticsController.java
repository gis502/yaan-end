package com.ruoyi.web.controller.system;

import com.ruoyi.common.core.domain.R;
import com.ruoyi.system.domain.export.YaanAftershockStatistics;
import com.ruoyi.system.domain.export.YaanCasualties;
import com.ruoyi.system.service.impl.YaanCasualtiesServiceImpl;
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

    @Resource
    private YaanCasualtiesServiceImpl casualtiesService;


    @PostMapping("/getAfterShockStatistics/{userName}&{filename}")
    public R getAfterShockStatistics(@RequestParam("file") MultipartFile file, @PathVariable(value = "userName") String userName, @PathVariable(value = "filename") String filename) throws IOException {
        System.out.println(filename);
        try  {
            if (filename.equals("震情灾情统计表")) {
                System.out.println("1111");
                List<YaanAftershockStatistics> yaanAftershockStatistics = afterShockStatisticsService.importExcel(file, userName);
                return R.ok(yaanAftershockStatistics);
            }
            if (filename.equals("人员伤亡统计表")){
                System.out.println("22222");
                List<YaanCasualties> yaanCasualties = casualtiesService.importExcel(file, userName);
                return R.ok(yaanCasualties);
            }else{
                return R.fail("上传文件名称错误");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return R.fail("文件上传失败: " + e.getMessage());
        }
    }

}
