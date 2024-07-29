package com.ruoyi.web.controller.system;

import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.system.service.IYaanFilesService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Field")
@RequiredArgsConstructor
public class GetFieldController {
    private final IYaanFilesService yaanFilesService;

    @GetMapping()
    public AjaxResult getField() {
      return AjaxResult.success(yaanFilesService.selectFilesByUserId());
    }
}
