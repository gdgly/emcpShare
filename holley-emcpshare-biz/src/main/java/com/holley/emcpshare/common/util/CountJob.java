package com.holley.emcpshare.common.util;

import java.util.concurrent.TimeUnit;

import com.holley.emcpshare.service.share.CommonService;

/**
 * Description: 用于1秒内计数
 *
 * @author shen.cheng@holley.cn
 */
public class CountJob extends JobBase {

    public CountJob(String operatorID, LocalCacheUtil localCacheUtil, CommonService commonService) {
        super(operatorID, localCacheUtil, commonService);
    }

    @Override
    public void run() {

        while (isRun) {
            try {
                if (ShareGloblas.TIME_STTEMP > 0) {
                    if ((System.currentTimeMillis() - ShareGloblas.TIME_STTEMP) > 999) {
                        ShareGloblas.TIME_STTEMP = 0;
                        ShareGloblas.COUNT_TIME = 0;
                    }
                }
                TimeUnit.MILLISECONDS.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

}
