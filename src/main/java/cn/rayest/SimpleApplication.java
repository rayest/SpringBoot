package cn.rayest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Rayest on 2016/8/30 0030.
 */
@RestController
@SpringBootApplication
public class SimpleApplication {

    @RequestMapping("/")
    public String index() {
        return "Hello World";
    }

    @Value("${user.userName}")
    private String userName;
    @Value("${user.password}")
    private String password;
    @RequestMapping("/user")
    public String userInfo(){
        return "userName: " + userName + ", " + "password: " + password;
    }

    public static void main(String[] args) {
        SpringApplication.run(SimpleApplication.class, args);
    }
}
