package com.wiysoft.cocoon.crawler;

import com.wiysoft.cocoon.crawler.config.Config;
import org.apache.commons.httpclient.HttpMethodBase;

/**
 * Created by weiliyang on 6/19/15.
 */
public abstract class MethodConstructorBase implements MethodConstructor {

    public abstract HttpMethodBase prepare(Config config);

    public HttpMethodBase getHttpMethod(Config config) {
        HttpMethodBase method = prepare(config);
        if (config != null && method != null) {
            method.setFollowRedirects(config.isFollowRedirect());
        }

        return method;
    }
}
