package com.holley.emcpshare.common.util;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

import com.holley.emcpshare.model.def.AccountInfoBase;

public class EmcpShareDisconnectJob implements Callable<AccountInfoBase> {

    @Override
    public AccountInfoBase call() throws Exception {
        TimeUnit.SECONDS.sleep(5);
        System.out.println(Thread.currentThread());
        AccountInfoBase b = new AccountInfoBase();
        b.setUserId("123");
        return b;
    }

}
