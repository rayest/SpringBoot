package cn.ray;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by Rayest on 2016/10/8 0008.
 */
@SpringBootApplication // 必须的注解，使得spring boot自动给程序进行必要的配置
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
