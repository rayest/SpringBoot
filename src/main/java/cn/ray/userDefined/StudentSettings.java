package cn.ray.userDefined;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Created by Rayest on 2016/10/15 0015.
 */
@ConfigurationProperties(prefix = "student")
public class StudentSettings {
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
