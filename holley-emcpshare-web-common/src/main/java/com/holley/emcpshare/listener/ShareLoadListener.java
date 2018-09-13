package com.holley.emcpshare.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ShareLoadListener implements ServletContextListener {

    @Override
    public void contextDestroyed(ServletContextEvent arg0) {

    }

    @Override
    public void contextInitialized(ServletContextEvent event) {
        System.out.println("监听器");
    }
}
