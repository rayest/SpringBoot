package cn.ray.runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * Created by Rayest on 2016/10/15 0015.
 */
@Component
@Order(value = 1)
public class MyStartupRunner1 implements CommandLineRunner{
    @Override
    public void run(String... strings) throws Exception {
        System.out.println("11111111 服务启动执行，执行加载数据等操作 11111111");
    }
}
