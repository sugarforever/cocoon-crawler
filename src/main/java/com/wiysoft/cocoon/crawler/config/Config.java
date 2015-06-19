package com.wiysoft.cocoon.crawler.config;

import org.apache.commons.lang.StringUtils;

import java.util.Hashtable;
import java.util.List;

/**
 * Created by weiliyang on 6/19/15.
 */
public class Config {

    public static enum HttpMethod {
        GET, POST
    }

    private HttpMethod method;
    private String responseDecodeCharset;
    private String uri;
    private Hashtable<String, List<String>> parameters = new Hashtable<String, List<String>>();

    public HttpMethod getMethod() {
        return method;
    }

    public void setMethod(HttpMethod method) {
        this.method = method;
    }

    public String getResponseDecodeCharset() {
        return responseDecodeCharset;
    }

    public void setResponseDecodeCharset(String responseDecodeCharset) {
        this.responseDecodeCharset = responseDecodeCharset;
    }

    public boolean isValid() {
        return this.method != null && StringUtils.isNotEmpty(this.uri);
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public Hashtable<String, List<String>> getParameters() {
        return parameters == null ? new Hashtable<String, List<String>>() : new Hashtable<String, List<String>>(this.parameters);
    }

    public void setParameters(Hashtable<String, List<String>> parameters) {
        if (parameters == null) {
            this.parameters = new Hashtable<String, List<String>>();
        } else {
            this.parameters = new Hashtable<String, List<String>>(parameters);
        }
    }
}
