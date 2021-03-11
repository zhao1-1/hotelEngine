package com.ruyuan.little.project.rocketmq.api.hotel.service;

import com.ruyuan.little.project.common.dto.CommonResponse;
import com.ruyuan.little.project.rocketmq.api.hotel.dto.HotelRoom;

/**
 * @author <a href="mailto:little@163.com">little</a>
 * version: 1.0
 * Description:酒店房间管理service组件
 **/
public interface HotelRoomService {

    /**
     * 根据小程序房间id查询房间详情
     *
     * @param id          房间id
     * @param phoneNumber 手机号
     * @return 结果
     */
    CommonResponse<HotelRoom> getRoomById(Long id, String phoneNumber);
}
