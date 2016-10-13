package cn.ray.thymeleaf;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

/**
 * Created by Rayest on 2016/10/14 0014.
 */
@Controller
@RequestMapping("/thymeleaf")
public class ThymeleafController {
    @RequestMapping("/helloHtml")
    public String helloHtml(Map<String, Object> map){
        map.put("hello", "The content is from ThymeleafController.helloHtml");
        return "/helloHtml";
    }
}
