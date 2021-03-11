package com.ruyuan.little.project.rocketmq.api.hotel.controller;

import com.ruyuan.little.project.common.dto.CommonResponse;
import com.ruyuan.little.project.rocketmq.api.hotel.service.HotelRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author <a href="mailto:little@163.com">little</a>
 * version: 1.0
 * Description:提供给小程序房间查询api接口
 **/
@RestController
@RequestMapping(value = "/api/hotel")
public class HotelRoomController {

    @Autowired
    private HotelRoomService hotelRoomService;

    /**
     * 根据酒店房间id查询房间详情
     *
     * @return 结果
     */
    @GetMapping(value = "getRoomById")
    public CommonResponse getRoomById(@RequestParam(value = "id") Long id,
                                      @RequestParam(value = "phoneNumber") String phoneNumber) {
        return hotelRoomService.getRoomById(id, phoneNumber);
    }
}