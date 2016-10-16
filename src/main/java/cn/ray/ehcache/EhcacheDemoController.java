package cn.ray.ehcache;

import javassist.NotFoundException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Created by Rayest on 2016/10/16 0016.
 */
@RestController
public class EhcacheDemoController {

    @Resource
    private EhcacheDemoService ehcacheDemoService;

    @RequestMapping("/ehcache")
    public String testEhcache() {
        // 存入两条数据
        EhcacheDemo ehcacheDemo = new EhcacheDemo();
        ehcacheDemo.setName("Rayest");
        ehcacheDemo.setPassword("9527");
        EhcacheDemo ehcacheDemo2 = ehcacheDemoService.save(ehcacheDemo);
        //不走缓存
        System.out.println(ehcacheDemoService.findById(ehcacheDemo2.getId()));
        // 走缓存
        System.out.println(ehcacheDemoService.findById(ehcacheDemo2.getId()));

        ehcacheDemo = new EhcacheDemo();
        ehcacheDemo.setName("Ray");
        ehcacheDemo.setPassword("3816");
        EhcacheDemo ehcacheDemo3 = ehcacheDemoService.save(ehcacheDemo);
        // 不走缓存
        System.out.println(ehcacheDemoService.findById(ehcacheDemo3.getId()));
        // 走缓存
        System.out.println(ehcacheDemoService.findById(ehcacheDemo3.getId()));

        System.out.println("================修改数据==============");
        EhcacheDemo updated = new EhcacheDemo();
        updated.setName("李锐-updated");
        updated.setPassword("987654");
        updated.setId(ehcacheDemo3.getId());
        try {
            System.out.println(ehcacheDemoService.update(updated));
        } catch (NotFoundException e) {
            e.printStackTrace();
        }
        // 不走缓存
        System.out.println(ehcacheDemoService.findById(updated.getId()));
        return "ok";

    }
}
