package com.ruoyi.web.controller.system;

import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BaseFieldDisplayEnum;
import com.ruoyi.common.enums.FieldDisplayEnum.YaanAftershockStatisticsEnum;
import com.ruoyi.common.enums.FieldDisplayEnum.YaanCasualtiesEnum;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/Field")
public class GetFieldController {
    @GetMapping()
    public AjaxResult getField(@RequestParam() String enumType) {
        Class<? extends BaseFieldDisplayEnum> enumClass;
        switch (enumType) {
            case "YaanAftershockStatistics":
                enumClass = YaanAftershockStatisticsEnum.class;
                break;
            case "YaanCasualties":
                enumClass = YaanCasualtiesEnum.class;
                break;
            default:
                throw new IllegalArgumentException("Unknown enum type: " + enumType);
        }
        // 通过反射调用 BaseFieldDisplayEnum.toMap 方法
        Map<String, String> enumMap = BaseFieldDisplayEnum.toMap(enumClass);
        return AjaxResult.success(enumMap);
    }
}
