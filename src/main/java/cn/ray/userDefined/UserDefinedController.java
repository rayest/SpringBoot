package cn.ray.userDefined;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Rayest on 2016/10/15 0015.
 */
@Controller
public class UserDefinedController {
    @Autowired
    StudentSettings studentSettings;
    @Autowired
    TeacherSettings teacherSettings;

    @RequestMapping("/userDefined")
    @ResponseBody
    public String getUserDefinedParameters() {
        System.out.println(studentSettings.getName() + " === " + studentSettings.getAge());
        System.out.println(teacherSettings.getName() + " === " + teacherSettings.getAge());
        return "ok";
    }
}
