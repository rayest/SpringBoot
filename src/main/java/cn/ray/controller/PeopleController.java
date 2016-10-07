package cn.ray.controller;

import cn.ray.model.People;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Rayest on 2016/10/8 0008.
 */
@RestController
public class PeopleController {
    private People people = new People();

    @RequestMapping(value = "/people", method = RequestMethod.GET)
    public People getPeopleInfo() { // 返回值设置为 People，结果为 json 对象
        people.setId(1);
        people.setName("lee");
        return people; // 返回的是 json 对象
    }
}
