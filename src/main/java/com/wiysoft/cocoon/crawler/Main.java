package com.wiysoft.cocoon.crawler;

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
        HttpClient client = new HttpClient();

        GetMethod method = new GetMethod("http://market.finance.sina.com.cn/downxls.php?date=2015-06-19&symbol=sz300443");

        int returnCode = client.executeMethod(method);
        System.out.println(returnCode);

        BufferedReader br = new BufferedReader(new InputStreamReader(method.getResponseBodyAsStream(), "gb2312"));
        String readLine;
        while(((readLine = br.readLine()) != null)) {
            System.out.println(readLine);
        }
    }
}
