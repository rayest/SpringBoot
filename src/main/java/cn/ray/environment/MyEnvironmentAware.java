package cn.ray.environment;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.bind.RelaxedPropertyResolver;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

/**
 * Created by Rayest on 2016/10/15 0015.
 */
@Component
public class MyEnvironmentAware implements EnvironmentAware{

    // 将 application.properties 的属性注入到指定变量中
    @Value("${spring.datasource.url}")
    private String datasourceUrl;

    @Override
    public void setEnvironment(Environment environment) {
        System.out.println("datasourceUrl" + datasourceUrl);
        System.out.println(environment.getProperty("JAVA_HOME"));
        System.out.println(environment.getProperty("spring.datasource.url"));

        // 获取到前缀是 "spring.datasource." 的属性列表值
        RelaxedPropertyResolver relaxedPropertyResolver = new RelaxedPropertyResolver(environment, "spring.datasource.");
        System.out.println("spring.datasource.url = " + relaxedPropertyResolver.getProperty("url"));
        System.out.println("spring.datasource.driverClassName = " + relaxedPropertyResolver.getProperty("driver-class-name"));
    }
}
