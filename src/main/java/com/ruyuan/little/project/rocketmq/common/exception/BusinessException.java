package com.ruyuan.little.project.rocketmq.common.exception;

/**
 * @author <a href="mailto:little@163.com">little</a>
 * version: 1.0
 * Description:系统业务异常
 **/
public class BusinessException extends RuntimeException {

    public BusinessException(String message) {
        super(message);
    }
}