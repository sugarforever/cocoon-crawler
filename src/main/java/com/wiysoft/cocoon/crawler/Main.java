package com.wiysoft.cocoon.crawler;

import com.wiysoft.cocoon.crawler.config.Config;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by weiliyang on 6/19/15.
 */
public class Main {

    public static void main(String[] args) throws Exception {
        Config config = new Config();
        config.setMethod(Config.HttpMethod.GET);
        config.setResponseDecodeCharset("gb2312");
        config.setUri("http://market.finance.sina.com.cn/downxls.php?date=2015-06-19&symbol=sz300443");

        CocoonCrawler cc = new CocoonCrawler(config);
        String response = cc.run();

        System.out.println(response);
    }
}
