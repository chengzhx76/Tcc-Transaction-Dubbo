/*
 * ========================================================================
 * 龙果学院： www.roncoo.com （微信公众号：RonCoo_com）
 * 超级教程系列：《微服务架构的分布式事务解决方案》视频教程
 * 讲师：吴水成（水到渠成），840765167@qq.com
 * 课程地址：http://www.roncoo.com/course/view/7ae3d7eddc4742f78b0548aa8bd9ccdb
 * ========================================================================
 */
package org.mengyun.tcctransaction.spring.recover;

import org.mengyun.tcctransaction.recover.RecoverConfig;

/**
 * 默认事务恢复配置.
 * Created by changming.xie on 6/1/16.
 */
public class DefaultRecoverConfig implements RecoverConfig {

    public static final RecoverConfig INSTANCE = new DefaultRecoverConfig();

    /**
     * 一个事务最多尝试恢复次数（超过将不在自动恢复，需要人工干预，默认是30次）
     */
    private int maxRetryCount = 30;

    /**
     * 一个事务日志当超过一定时间间隔后没有更新就会被认为是发生了异常，需要恢复，
     * 恢复Job将扫描超过这个时间间隔依旧没有更新的事务日志，并对这些事务进行恢复，时间单位是秒，默认是120秒
     */
    private int recoverDuration = 120; //120 seconds

    /**
     * 恢复Job触发间隔配置，默认是(每分钟)
     */
    private String cronExpression = "0 */1 * * * ?";

    @Override
    public int getMaxRetryCount() {
        return maxRetryCount;
    }

    @Override
    public int getRecoverDuration() {
        return recoverDuration;
    }

    @Override
    public String getCronExpression() {
        return cronExpression;
    }

    public void setMaxRetryCount(int maxRetryCount) {
        this.maxRetryCount = maxRetryCount;
    }

    public void setRecoverDuration(int recoverDuration) {
        this.recoverDuration = recoverDuration;
    }

    public void setCronExpression(String cronExpression) {
        this.cronExpression = cronExpression;
    }
}