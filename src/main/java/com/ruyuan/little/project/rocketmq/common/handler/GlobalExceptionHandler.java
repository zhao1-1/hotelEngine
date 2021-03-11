package com.ruyuan.little.project.rocketmq.common.handler;

import com.ruyuan.little.project.common.dto.CommonResponse;
import com.ruyuan.little.project.common.enums.ErrorCodeEnum;
import com.ruyuan.little.project.rocketmq.common.exception.BusinessException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author little
 */
@RestControllerAdvice
@Order(value = Ordered.HIGHEST_PRECEDENCE)
public class GlobalExceptionHandler {

    private Logger LOGGER = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(value = Exception.class)
    public CommonResponse handleException(Exception e) {
        LOGGER.error("系统内部异常，异常信息", e);
        return CommonResponse.fail();
    }

    @ExceptionHandler(value = BusinessException.class)
    public CommonResponse handleBusinessException(BusinessException e) {
        LOGGER.error("系统业务异常", e);
        return CommonResponse.fail(ErrorCodeEnum.FAIL, e.getMessage());
    }

}
