package com.test.Service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.test.Mapper.UserDao;
import com.test.Service.IUserService;
import com.test.Util.EhcacheUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

@Service

public class UserServiceImpl extends ServiceImpl implements IUserService {

    @Autowired
    private UserDao userDao;

    public Map getUser(Integer id){
        if(EhcacheUtil.getInstance().get("user",id)!=null){
            Object value = EhcacheUtil.getInstance().get("user",id);
            System.out.println(value);
            System.out.println("缓存读的");
            return null;
        }

        Map a =  userDao.findUser(id.toString());
        EhcacheUtil.getInstance().put("user",id,a);
        System.out.println("findUser");

        return a;
    }

    public Map getUser2(Integer id){
        System.out.println("读数据库");
        Map a =  userDao.findUser(id.toString());
        System.out.println("读数据库");

        return a;
    }



    @Transactional
    public void addUser() {

        userDao.addUser("13656756566");
        userDao.addUser("13656776776");
        userDao.addUser("13656778866");
        userDao.addUser("13656799966");
        userDao.addUser("136567766666666");
        userDao.addUser("13656776666");

    }
}
