package cn.ray.runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * Created by Rayest on 2016/10/15 0015.
 */
@Component
@Order(value = 2)
public class MyStartupRunner2 implements CommandLineRunner{
    @Override
    public void run(String... strings) throws Exception {
        System.out.println("22222222 服务启动执行，执行加载数据等操作 22222222");
    }
}
