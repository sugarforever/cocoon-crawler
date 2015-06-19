package com.wiysoft.cocoon.crawler;


import com.wiysoft.cocoon.crawler.config.Config;
import org.apache.commons.httpclient.HttpMethodBase;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.List;

/**
 * Created by weiliyang on 6/19/15.
 */
public class PostMethodConstructor extends MethodConstructorBase {

    @Override
    public HttpMethodBase prepare(Config config) {
        if (config == null) {
            return null;
        }

        if (config.getMethod() == null || config.getMethod() != Config.HttpMethod.POST) {
            return null;
        }

        if (!config.isValid()) {
            return null;
        }

        PostMethod method = new PostMethod(config.getUri());
        Hashtable<String, List<String>> parameters = config.getParameters();
        Enumeration<String> e = parameters.keys();
        while (e.hasMoreElements()) {
            String key = e.nextElement();
            List<String> values = parameters.get(key);
            for (String value : values) {
                method.addParameter(new NameValuePair(key, value));
            }
        }
        
        return method;
    }
}
