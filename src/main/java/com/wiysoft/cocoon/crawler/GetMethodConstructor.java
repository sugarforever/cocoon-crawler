package com.wiysoft.cocoon.crawler;


import com.wiysoft.cocoon.crawler.config.Config;
import org.apache.commons.httpclient.HttpMethodBase;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.GetMethod;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.List;

/**
 * Created by weiliyang on 6/19/15.
 */
public class GetMethodConstructor implements MethodConstructor {

    @Override
    public HttpMethodBase getHttpMethod(Config config) {
        if (config == null) {
            return null;
        }

        if (config.getMethod() == null || config.getMethod() != Config.HttpMethod.GET) {
            return null;
        }

        if (!config.isValid()) {
            return null;
        }

        GetMethod method = new GetMethod(config.getUri());
        Hashtable<String, List<String>> parameters = config.getParameters();
        List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
        Enumeration<String> e = parameters.keys();
        while (e.hasMoreElements()) {
            String key = e.nextElement();
            List<String> values = parameters.get(key);
            for (String value : values) {
                nameValuePairs.add(new NameValuePair(key, value));
            }
        }
        if (!nameValuePairs.isEmpty()) {
            method.setQueryString(nameValuePairs.toArray(new NameValuePair[]{}));
        }

        return method;
    }
}
