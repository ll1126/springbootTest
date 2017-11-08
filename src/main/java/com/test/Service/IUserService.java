package com.test.Service;

import com.baomidou.mybatisplus.service.IService;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;

import java.util.Map;

@CacheConfig(cacheNames = "user")
public interface IUserService extends IService {

    //@Cacheable(cacheNames = "users1",key = "#id",condition="#id=1")
    //@Cacheable(cacheNames = "users",key = "#id",condition="#id>1")
    Map getUser(Integer id);


    @Cacheable(key = "#id")
    Map getUser2(Integer id);

    void addUser();
}
