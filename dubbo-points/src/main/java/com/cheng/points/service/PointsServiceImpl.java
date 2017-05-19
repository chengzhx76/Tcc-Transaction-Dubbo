package com.cheng.points.service;

import com.cheng.api.points.model.Points;
import com.cheng.api.points.model.PointsRecord;
import com.cheng.api.points.service.PointsService;
import com.cheng.points.dao.PointsDaoMapper;
import com.cheng.points.dao.PointsRecordDaoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Desc: 积分
 * Author: 光灿
 * Date: 2017/5/13
 */
@Service("pointsService")
public class PointsServiceImpl implements PointsService {

    @Autowired
    private PointsDaoMapper pointsDao;
    @Autowired
    private PointsRecordDaoMapper pointsRecordDao;

    @Override
    public Points getPointsByUserId(int userId) {
        Points points = new Points();
        points.setUserId(userId);
        return pointsDao.load(points);
    }

    @Override
    public void updatePoints(Points points) {
        pointsDao.update(points);
    }

    @Override
    public void savePointsRecord(PointsRecord record) {
        pointsRecordDao.save(record);
    }

    @Override
    public void updatePointsRecord(PointsRecord record) {
        pointsRecordDao.update(record);
    }

    @Override
    public String saveRecord(int userId, int orderNo, int cost) {

        Points points = getPointsByUserId(userId);
        points.transferPoints(cost);
        updatePoints(points);

        PointsRecord record = new PointsRecord();
        record.setPointsId(points.getPointsId());
        record.setOrderNo(orderNo);
        record.setCost(cost);
        record.setState("SUCCESS");
        savePointsRecord(record);

        return "SUCCESS";
    }
}
