package cn.rayest.userSetting;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Rayest on 2016/8/30 0030.
 */
@RestController
@SpringBootApplication
public class TypeSafeBasedConfigApplication {
    @Autowired
    private UserSettings userSettings;

    @RequestMapping("/userSettings")
    public String userInfo(){
        return "userName: " + userSettings.getUserName() + ", password: " + userSettings.getPassword();
    }

    public static void main(String[] args) {
        SpringApplication.run(TypeSafeBasedConfigApplication.class, args);
    }
}

