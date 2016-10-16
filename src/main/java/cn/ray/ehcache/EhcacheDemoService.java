package cn.ray.ehcache;

import javassist.NotFoundException;

/**
 * Created by Rayest on 2016/10/16 0016.
 */
public interface EhcacheDemoService {
    EhcacheDemo save(EhcacheDemo ehcacheDemo);

    void delete(Long id);

    EhcacheDemo findById(Long id);

    EhcacheDemo update(EhcacheDemo ehcacheDemo) throws NotFoundException;
}
