package com.ruyuan.little.project.rocketmq.api;

import com.ruyuan.little.project.common.dto.CommonResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author <a href="mailto:little@163.com">little</a>
 * version: 1.0
 * Description:健康检查的controller
 **/
@RestController
public class HealthController {

    @RequestMapping(value = "/")
    public CommonResponse health() {
        return CommonResponse.success();
    }
}