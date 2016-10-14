package cn.ray;

import cn.ray.servlet.CodeServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

/**
 * Created by Rayest on 2016/10/8 0008.
 */
@SpringBootApplication // 必须的注解，使得spring boot自动给程序进行必要的配置
@ServletComponentScan // 该注解扫描注解的 servlet：AnnotationServlet
public class Application {

    @Bean // 注册 CodeServlet

    public ServletRegistrationBean CodeServlet(){
        return new ServletRegistrationBean(new CodeServlet(), "/codeServlet");
    }
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
