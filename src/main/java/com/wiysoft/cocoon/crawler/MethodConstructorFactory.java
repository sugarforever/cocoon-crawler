package com.wiysoft.cocoon.crawler;

import com.wiysoft.cocoon.crawler.config.Config;


/**
 * Created by weiliyang on 6/19/15.
 */
public final class MethodConstructorFactory {

    private static MethodConstructorFactory factory = null;

    public static MethodConstructorFactory getFactory() {
        if (factory == null) {
            synchronized (MethodConstructorFactory.class) {
                if (factory == null) {
                    factory = new MethodConstructorFactory();
                }
            }
        }

        return factory;
    }

    public final MethodConstructor getMethodConstructor(Config config) {
        MethodConstructor constructor = null;
        if (config != null) {
            if (config.getMethod() == Config.HttpMethod.GET) {
                constructor = new GetMethodConstructor();
            } else if (config.getMethod() == Config.HttpMethod.POST) {
                constructor = new PostMethodConstructor();
            }
        }

        return constructor;
    }
}
