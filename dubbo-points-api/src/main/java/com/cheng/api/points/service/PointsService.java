package com.cheng.api.points.service;

import com.cheng.api.points.model.Points;
import com.cheng.api.points.model.PointsRecord;

/**
 * Desc: 积分
 * Author: 光灿
 * Date: 2017/5/13
 */
public interface PointsService {
    /**
     * 获取积分
     * @param userId
     * @return
     */
    Points getPointsByUserId(int userId);

    /**
     * 更新积分
     * @param points
     * @return
     */
    void updatePoints(Points points);

    /**
     * 保存积分记录
     * @param record
     */
    void savePointsRecord(PointsRecord record);

    /**
     * 更新积分记录
     * @param record
     */
    void updatePointsRecord(PointsRecord record);

    /**
     * 花费积分
     * @param userId
     * @param orderNo
     * @param cost
     */
    String saveRecord(int userId, int orderNo, int cost);
}
