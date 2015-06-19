package com.wiysoft.cocoon.crawler;

import com.wiysoft.cocoon.crawler.config.Config;

/**
 * Created by weiliyang on 6/19/15.
 */
public class CocoonCrawler {

    private Config config;

    public CocoonCrawler(Config config) {
        this.config = config;
    }

    public void run() {
        if (this.config == null) {
            return;
        }


    }
}
