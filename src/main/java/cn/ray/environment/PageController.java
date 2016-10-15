package cn.ray.environment;

import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;

/**
 * Created by Rayest on 2016/10/15 0015.
 * spring 这四个注解功能相似
 * @Controller
 * @Component
 * @Service
 * @Repository
 */
@Controller
public class PageController implements EnvironmentAware {
    @Override
    public void setEnvironment(Environment environment) {
        String JavaHomePath = environment.getProperty("JAVA_HOME");
        System.out.println(JavaHomePath);
    }
}
