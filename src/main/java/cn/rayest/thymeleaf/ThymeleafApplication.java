package cn.rayest.thymeleaf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rayest on 2016/8/30 0030.
 */
@Controller
@SpringBootApplication
public class ThymeleafApplication {
    @RequestMapping("/")
    public String index(Model model){
        Person single = new Person("aa", 11);
        List<Person> people = new ArrayList<Person>();
        Person person1 = new Person("xx", 11);
        Person person2 = new Person("yy", 22);
        Person person3 = new Person("zz", 33);
        people.add(person1);
        people.add(person2);
        people.add(person3);
        model.addAttribute("singlePerson", single);
        model.addAttribute("people", people);
        return "index";
    }

    public static void main(String[] args) {
        SpringApplication.run(ThymeleafApplication.class, args);
    }
}
