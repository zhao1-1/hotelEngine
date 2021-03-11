package com.ruyuan.little.project.rocketmq.api.pay.service;

import com.ruyuan.little.project.rocketmq.api.pay.dto.PayTransaction;

/**
 * @author <a href="mailto:little@163.com">little</a>
 * version: 1.0
 * Description:支付流水记录service接口组件
 **/
public interface PayTransactionService {

    /**
     * 保存支付流水记录
     *
     * @param payTransaction 支付流水
     * @param phoneNumber    手机号
     * @return 记录流水结果
     */
    Boolean save(PayTransaction payTransaction, String phoneNumber);
}
