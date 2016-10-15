package cn.ray;

import cn.ray.servlet.CodeServlet;
import cn.ray.userDefined.StudentSettings;
import cn.ray.userDefined.TeacherSettings;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

/**
 * Created by Rayest on 2016/10/8 0008.
 */
@SpringBootApplication // 必须的注解，使得spring boot自动给程序进行必要的配置
@ServletComponentScan // 该注解扫描注解注册的 servlet：AnnotationServlet
@EnableConfigurationProperties({StudentSettings.class, TeacherSettings.class}) // 获取自定义配置
public class Application {

    @Bean // 代码注册 servlet： CodeServlet
    public ServletRegistrationBean CodeServlet(){
        return new ServletRegistrationBean(new CodeServlet(), "/codeServlet");
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
