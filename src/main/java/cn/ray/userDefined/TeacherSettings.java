package cn.ray.userDefined;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Created by Rayest on 2016/10/15 0015.
 */
@ConfigurationProperties(prefix = "teacher",locations = "classpath:config/teacher.properties")
public class TeacherSettings {
    private String name;
    private int age;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
