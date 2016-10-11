package cn.ray.controller;

import cn.ray.model.People;
import com.alibaba.fastjson.JSONObject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Rayest on 2016/10/8 0008.
 * 不用 springboot 自带的 json 框架；引入 alibaba 的 json 解析框架，处理 json 对象
 */

@RestController
public class FastJsonController {
    private People people = new People();

    @RequestMapping(value = "/fastjson", method = RequestMethod.GET)
    public String getFastJson(){
        people.setId(2);
        people.setName("ray");
        return JSONObject.toJSONString(people); // 返回json 字符串
    }
}
