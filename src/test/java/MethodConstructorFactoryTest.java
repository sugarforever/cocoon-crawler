import com.wiysoft.cocoon.crawler.GetMethodConstructor;
import com.wiysoft.cocoon.crawler.MethodConstructorFactory;
import com.wiysoft.cocoon.crawler.PostMethodConstructor;
import com.wiysoft.cocoon.crawler.config.Config;
import org.junit.Test;

/**
 * Created by weiliyang on 6/19/15.
 */
public class MethodConstructorFactoryTest {

    @Test
    public void testGetMethodConstructor() {
        Config config = new Config();
        config.setMethod(Config.HttpMethod.GET);

        assert MethodConstructorFactory.getFactory().getMethodConstructor(config) instanceof GetMethodConstructor;
    }

    @Test
    public void testPostMethodConstructor() {
        Config config = new Config();
        config.setMethod(Config.HttpMethod.POST);

        assert MethodConstructorFactory.getFactory().getMethodConstructor(config) instanceof PostMethodConstructor;
    }

    @Test
    public void testMethodConstructorFactory1() {
        Config config = new Config();
        assert MethodConstructorFactory.getFactory().getMethodConstructor(config) == null;
    }

    @Test
    public void testMethodConstructorFactory2() {
        assert MethodConstructorFactory.getFactory().getMethodConstructor(null) == null;
    }
}
