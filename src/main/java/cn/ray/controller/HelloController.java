package cn.ray.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Rayest on 2016/10/8 0008.
 */

@RestController // 返回json字符串的数据
public class HelloController {
    @RequestMapping("/hello") // 映射路径
    public String sayHello() {
        return "Hello World"; // 返回的结果是实体内容：Hello World，而非视图
    }
}
