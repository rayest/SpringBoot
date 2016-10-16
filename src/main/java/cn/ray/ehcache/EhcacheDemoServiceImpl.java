package cn.ray.ehcache;

import cn.ray.foundation.Scenario;
import javassist.NotFoundException;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by Rayest on 2016/10/16 0016.
 */
@Service
public class EhcacheDemoServiceImpl implements EhcacheDemoService {

    public static final String CACHE_KEY = "'ehcacheDemo'";
    public static final String DEMO_CACHE_NAME = "demo";

    @Resource
    private EhcacheDemoRepository ehcacheDemoRepository;

    @Scenario("value属性表示选择使用的缓存策略，缓存策略在ehcache.xml配置文件中")
    @CacheEvict(value = DEMO_CACHE_NAME, key = CACHE_KEY)
    @Override
    public EhcacheDemo save(EhcacheDemo ehcacheDemo) {
        return ehcacheDemoRepository.save(ehcacheDemo);
    }

    @Scenario("清除缓存")
    @CacheEvict(value = DEMO_CACHE_NAME, key = "'ehcacheDemo_'+#id")
    @Override
    public void delete(Long id) {
        ehcacheDemoRepository.delete(id);
    }

    @Scenario("@Cacheable注解会检查是否存在相同key的缓存元素")
    @Cacheable(value = DEMO_CACHE_NAME, key = "'ehcacheDemo_'+#id")
    @Override
    public EhcacheDemo findById(Long id) {
        System.err.print("没有走缓存" + id);
        return ehcacheDemoRepository.findOne(id);
    }

    @Scenario("@CachePut注解不会检查是否存在缓存")
    @CachePut(value = DEMO_CACHE_NAME, key = "'ehcacheDemo_'+#updated.getId()")
    @Override
    public EhcacheDemo update(EhcacheDemo updated) throws NotFoundException {
        EhcacheDemo ehcacheDemo = ehcacheDemoRepository.findOne(updated.getId());
        if (ehcacheDemo == null) {
            throw new NotFoundException("Not found");
        }
        ehcacheDemo.setName(updated.getName());
        ehcacheDemo.setPassword(updated.getPassword());
        return ehcacheDemo;
    }
}
