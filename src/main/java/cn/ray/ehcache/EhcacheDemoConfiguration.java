package cn.ray.ehcache;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.cache.ehcache.EhCacheManagerFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

/**
 * Created by Rayest on 2016/10/16 0016.
 * 缓存配置
 */
@Configuration // 标注配置类
@EnableCaching // 标注启动缓存
public class EhcacheDemoConfiguration {
    @Bean
    public EhCacheCacheManager ehCacheCacheManager(EhCacheManagerFactoryBean bean) {
        System.out.println("EhCacheCacheManager.ehCacheCacheManager()");
        return new EhCacheCacheManager(bean.getObject());
    }
    @Bean
    public EhCacheManagerFactoryBean ehCacheManagerFactoryBean(){
        System.out.println("EhCacheManagerFactoryBean.ehCacheManagerFactoryBean()");
        EhCacheManagerFactoryBean ehCacheManagerFactoryBean = new EhCacheManagerFactoryBean();
        ehCacheManagerFactoryBean.setConfigLocation(new ClassPathResource("config/ehcache.xml")); // 创建一个 ehcache 基地
        ehCacheManagerFactoryBean.setShared(true);
        return ehCacheManagerFactoryBean;
    }

}
