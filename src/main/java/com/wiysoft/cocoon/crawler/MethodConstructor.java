package com.wiysoft.cocoon.crawler;

import com.wiysoft.cocoon.crawler.config.Config;
import org.apache.commons.httpclient.HttpMethodBase;

/**
 * Created by weiliyang on 6/19/15.
 */
public interface MethodConstructor {

    HttpMethodBase getHttpMethod(Config config);
    
}
