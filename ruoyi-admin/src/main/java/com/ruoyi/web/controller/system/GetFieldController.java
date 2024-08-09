package com.ruoyi.web.controller.system;

import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.system.service.IExcelFileService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Field")
@RequiredArgsConstructor
public class GetFieldController {
    private final IExcelFileService excelFileService;

    @GetMapping()
    public AjaxResult getField() {
      return AjaxResult.success(excelFileService.selectFilesByUserId());
    }
}
