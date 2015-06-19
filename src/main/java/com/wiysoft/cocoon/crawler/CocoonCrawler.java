package com.wiysoft.cocoon.crawler;

import com.wiysoft.cocoon.crawler.common.Constants;
import com.wiysoft.cocoon.crawler.config.Config;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpMethodBase;
import org.apache.commons.httpclient.URIException;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by weiliyang on 6/19/15.
 */
public class CocoonCrawler {

    private Config config;

    public CocoonCrawler(Config config) {
        this.config = config;
    }

    public String run() {
        if (this.config == null) {
            return "";
        }

        MethodConstructor methodConstructor = MethodConstructorFactory.getFactory().getMethodConstructor(this.config);
        HttpMethodBase method = methodConstructor.getHttpMethod(this.config);

        StringBuffer buffer = new StringBuffer();
        try {
            HttpClient client = new HttpClient();
            int returnCode = client.executeMethod(method);

            InputStreamReader isReader = null;
            if (StringUtils.isEmpty(this.config.getResponseDecodeCharset())) {
                isReader = new InputStreamReader(method.getResponseBodyAsStream());
            } else {
                isReader = new InputStreamReader(method.getResponseBodyAsStream(), this.config.getResponseDecodeCharset());
            }

            BufferedReader br = new BufferedReader(isReader);
            String readLine;

            while (((readLine = br.readLine()) != null)) {
                buffer.append(readLine + Constants.LINE_SEPARATOR);
            }
        } catch (IOException e) {

        }

        return buffer.toString();
    }
}
