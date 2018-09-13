package com.holley.emcpshare.common.util;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import javax.annotation.Resource;

import org.apache.log4j.Logger;

import com.holley.emcp.common.constants.ppf.SwitchTypeEnum;
import com.holley.emcpshare.model.ObjPoint;
import com.holley.emcpshare.service.share.CommonService;

public class JobInitBase {

    private final static Logger logger          = Logger.getLogger(JobInitBase.class);
    private ExecutorService     fixThreadPool   = Executors.newFixedThreadPool(2);
    private ExecutorService     cacheThreadPool = Executors.newCachedThreadPool();
    @Resource
    private LocalCacheUtil      localCacheUtil;
    @Resource
    private CommonService       commonService;

    private void init() {
        initJob();
    }

    public <T> T call(Callable<T> c) {
        try {
            return cacheThreadPool.submit(c).get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        return null;
    }

    public <T> T call(Callable<T> c, long timeout) {
        try {
            return cacheThreadPool.submit(c).get(timeout, TimeUnit.SECONDS);
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void execute(Runnable r) {
        cacheThreadPool.execute(r);
    }

    public void executeRemoteDisConnect(ObjPoint point, SwitchTypeEnum switchType) {
        execute(new DisconnectJob(this.commonService, point, switchType));
    }

    private void initJob() {
        System.out.println("init==================");
        // 计数任务
        // CountJob countJob = new CountJob(operatorID, localCacheUtil, commonService);
        // threadPool.execute(countJob);
        // 桩状态推送任务
        // PushStatusJob pushStatusJob = new PushStatusJob(operatorID, localCacheUtil, commonService);
        // threadPool.execute(pushStatusJob);

        // 充电任务暂时不添加
        // StartChargeJob startChargeJob = new StartChargeJob(operatorID, localCacheUtil, commonService);
        // cachedThreadPool.execute(startChargeJob);
    }

    /**
     * 停止Fix线程池
     */
    private void stopFixJob() {
        if (fixThreadPool != null) {
            fixThreadPool.shutdown();
        }
    }

    /**
     * 停止Cache线程池
     */
    private void stopCacheJob() {
        if (cacheThreadPool != null) {
            cacheThreadPool.shutdown();
        }
    }

}
