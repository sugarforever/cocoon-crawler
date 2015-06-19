import com.wiysoft.cocoon.crawler.GetMethodConstructor;
import com.wiysoft.cocoon.crawler.config.Config;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Hashtable;
import java.util.List;

/**
 * Created by weiliyang on 6/19/15.
 */

public class GetMethodConstructorTest {

    private GetMethodConstructor constructor;

    @Before
    public void setup() {
        constructor = new GetMethodConstructor();
    }

    @Test
    public void testGetHttpMethod1() {
        Config config = new Config();
        assert constructor.getHttpMethod(config) == null;
    }

    @Test
    public void testGetHttpMethod2() throws Exception {
        Config config = new Config();
        config.setResponseDecodeCharset("gb2312");
        config.setUri("http://www.abc.com");
        config.setMethod(Config.HttpMethod.GET);
        Hashtable<String, List<String>> parameters = new Hashtable<String, List<String>>();
        parameters.put("code", Arrays.asList(new String[] {"600001", "600002"}));
        parameters.put("area", Arrays.asList(new String[] {"sh", "sz"}));
        config.setParameters(parameters);

        String expectedURI = "http://www.abc.com/?area=sh&area=sz&code=600001&code=600002";
        String actualURI = constructor.getHttpMethod(config).getURI().toString();
        assert actualURI.equals(expectedURI);
    }

    @Test
    public void testGetHttpMethod3() throws Exception {
        Config config = new Config();
        config.setResponseDecodeCharset("gb2312");
        config.setMethod(Config.HttpMethod.GET);
        Hashtable<String, List<String>> parameters = new Hashtable<String, List<String>>();
        parameters.put("code", Arrays.asList(new String[] {"600001", "600002"}));
        parameters.put("area", Arrays.asList(new String[] {"sh", "sz"}));
        config.setParameters(parameters);

        Assert.assertNull(constructor.getHttpMethod(config));
    }

    @Test
    public void testGetHttpMethodFollowRedirects1() throws Exception {
        Config config = new Config();
        config.setResponseDecodeCharset("gb2312");
        config.setMethod(Config.HttpMethod.GET);
        Hashtable<String, List<String>> parameters = new Hashtable<String, List<String>>();
        parameters.put("code", Arrays.asList(new String[] {"600001", "600002"}));
        parameters.put("area", Arrays.asList(new String[] {"sh", "sz"}));
        config.setParameters(parameters);
        config.setFollowRedirect(true);
        config.setUri("http://www.abc.com");

        assert constructor.getHttpMethod(config).getFollowRedirects() == true;
    }

    @Test
    public void testGetHttpMethodFollowRedirects2() throws Exception {
        Config config = new Config();
        config.setResponseDecodeCharset("gb2312");
        config.setMethod(Config.HttpMethod.GET);
        Hashtable<String, List<String>> parameters = new Hashtable<String, List<String>>();
        parameters.put("code", Arrays.asList(new String[] {"600001", "600002"}));
        parameters.put("area", Arrays.asList(new String[] {"sh", "sz"}));
        config.setParameters(parameters);
        config.setFollowRedirect(false);
        config.setUri("http://www.abc.com");

        assert constructor.getHttpMethod(config).getFollowRedirects() == false;
    }

    @Test
    public void testGetHttpMethodFollowRedirects3() throws Exception {
        Config config = new Config();
        config.setResponseDecodeCharset("gb2312");
        config.setMethod(Config.HttpMethod.GET);
        Hashtable<String, List<String>> parameters = new Hashtable<String, List<String>>();
        parameters.put("code", Arrays.asList(new String[] {"600001", "600002"}));
        parameters.put("area", Arrays.asList(new String[] {"sh", "sz"}));
        config.setParameters(parameters);
        config.setUri("http://www.abc.com");

        assert constructor.getHttpMethod(config).getFollowRedirects() == false;
    }
}
