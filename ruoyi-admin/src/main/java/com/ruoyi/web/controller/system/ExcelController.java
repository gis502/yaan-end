package com.ruoyi.web.controller.system;

import com.alibaba.excel.EasyExcel;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.domain.R;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.exception.ServiceException;
import com.ruoyi.system.domain.SysOperLog;
import com.ruoyi.system.domain.bto.RequestBTO;
import com.ruoyi.system.domain.export.YaanAftershockStatistics;
import com.ruoyi.system.domain.export.YaanCasualties;
import com.ruoyi.system.mapper.SysOperLogMapper;
import com.ruoyi.system.domain.export.YaanRelocationResettlementDisasterReliefGroup;
import com.ruoyi.system.service.IYaanCasualtiesService;
import com.ruoyi.system.service.impl.YaanAftershockStatisticsServiceImpl;
import com.ruoyi.system.service.impl.YaanRelocationResettlementDisasterReliefGroupService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.List;

/**
 * 导入导出控制层
 * @author 方
 */
@RestController
@RequestMapping("/excel")
@RequiredArgsConstructor
public class ExcelController {
    private final IYaanCasualtiesService iCasualtiesService;
    private final YaanAftershockStatisticsServiceImpl yaanAftershockStatisticsServiceImpl;
    private final YaanRelocationResettlementDisasterReliefGroupService yaanRelocationResettlementDisasterReliefGroupService;

    @Resource
    private SysOperLogMapper sysOperLogMapper;

    @PostMapping("/getData")
    public AjaxResult getYaanCasualties(@RequestBody RequestBTO requestBTO) {
        String flag = requestBTO.getFlag();
        switch (flag) {
            case "1":
                return AjaxResult.success(yaanAftershockStatisticsServiceImpl.getPage(requestBTO));
            case "2":
                return AjaxResult.success(iCasualtiesService.getPage(requestBTO));
            case "3":
                return AjaxResult.success(yaanRelocationResettlementDisasterReliefGroupService.getPage(requestBTO));
            default:
                throw new ServiceException("系统执行异常请联系管理员");

        }

    }

    @PostMapping("/exportExcel")
    public void exportExcel(HttpServletResponse response, @RequestBody RequestBTO RequestBTO) throws IOException {
        String flag = RequestBTO.getFlag();
        Class<?> clazz = null;
        List<?> dataList = null;
        switch (flag) {
            case "1":
                clazz = YaanAftershockStatistics.class;
                dataList = yaanAftershockStatisticsServiceImpl.exportExcelGetData(RequestBTO);
                break;
            case "2":
                clazz = YaanCasualties.class;
                dataList = iCasualtiesService.exportExcelGetData(RequestBTO);
                break;
            case "3":
                clazz = YaanRelocationResettlementDisasterReliefGroup.class;
                dataList = yaanRelocationResettlementDisasterReliefGroupService.exportExcelGetData(RequestBTO);
                break;
            default:
                throw new ServiceException("系统执行异常请练习管理员");

        }
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        response.setCharacterEncoding("utf-8");
        // 这里URLEncoder.encode可以防止中文乱码 当然和easyexcel没有关系
        String fileName = URLEncoder.encode("地震数据信息统计表", "UTF-8").replaceAll("\\+", "%20");
        response.setHeader("Content-disposition", "attachment;filename*=utf-8''" + fileName + ".xlsx");

        EasyExcel.write(response.getOutputStream(), clazz)
                .includeColumnFiledNames(Arrays.asList(RequestBTO.getFields()))
                .sheet("地震数据信息统计表")
                .doWrite(dataList);
    }
    @PostMapping("/importExcel/{userName}&{filename}")
    @Log(title = "导入数据", businessType = BusinessType.IMPORT)
    public R getAfterShockStatistics(@RequestParam("file") MultipartFile file, @PathVariable(value = "userName") String userName, @PathVariable(value = "filename") String filename) throws IOException {

        try  {
            if (filename.equals("震情灾情统计表")) {
                List<YaanAftershockStatistics> yaanAftershockStatistics = yaanAftershockStatisticsServiceImpl.importExcel(file, userName);
                return R.ok(yaanAftershockStatistics);
            }
            if (filename.equals("人员伤亡统计表")){
                List<YaanCasualties> yaanCasualties = iCasualtiesService.importExcel1(file, userName);
                return R.ok(yaanCasualties);
            }else{
                return R.fail("上传文件名称错误");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return R.fail("文件上传失败: " + e.getMessage());
        }
    }

    @PostMapping("/getExcelUploadByTime")
    public R getExcelUploadByTime(@RequestParam("time") String time){
        List<SysOperLog> message = null;

        switch (time) {
            case "今日":
                message = sysOperLogMapper.getMessageByDay();
                break;
            case "近七天":
                message = sysOperLogMapper.getMessageByWeek();
                System.out.println(message);
                break;
            case "近一个月":
                message = sysOperLogMapper.getMessageByMonth();
                break;
            case "近三个月":
                message = sysOperLogMapper.getMessageByThreeMonth();
                break;
            case "近一年":
                message = sysOperLogMapper.getMessageByYear();
                break;
        }
        return R.ok(message);
    }

}
