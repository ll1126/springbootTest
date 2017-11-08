package com.test.Controller;


import com.test.Service.IUserService;
import com.test.Util.EhcacheUtil;
import com.test.Util.JsonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Api(description = "登录接口",value = "登录接口")   //类注解
@RestController      //注解相当于@ResponseBody ＋ @Controller合在一起的作用。
@RequestMapping("/user")
@EnableAutoConfiguration   //此注释自动载入应用程序所需的所有Bean
public class TestController {

    @Autowired
    private IUserService userService;
//    @Autowired
//    private CacheManager cacheManager;



    @ApiOperation(value = "登录")   //方法名注解
    @RequestMapping(value="/login.do")   //和以前一样
    public JsonResult login(String name,HttpServletResponse response){
        Integer id = 1;
        //第一次查询
        SimpleDateFormat sdf = new SimpleDateFormat();
        Long l1 = new Date().getTime();
        System.out.println("第一次开始时间："+l1);
        Map a = userService.getUser(id);
        Long l2 = new Date().getTime();
        System.out.println("第一次结束时间："+l2);
        System.out.println("第一次耗时："+(l2-l1));
        System.out.println(EhcacheUtil.getInstance().get("user",id));
        //第二次查询
Long l3 = new Date().getTime();
        Long l3 = new Date().getTime();
        System.out.println("111");
        System.out.println("第二次开始时间："+l3);
        id = 7;
        Map a1 = userService.getUser(id);
        Long l4 = new Date().getTime();
        System.out.println("第二次结束时间："+l4);
        System.out.println("第二次耗时："+(l4-l3));
        System.out.println(EhcacheUtil.getInstance().get("user",id));

        return new JsonResult(0,name,"成功");
    }

    @ApiOperation(value = "登录2")   //方法名注解
    @RequestMapping(value="/login2.do")   //和以前一样
    public JsonResult login2(String name,HttpServletResponse response){


        Integer id = 1;
//        System.out.println(cacheManager.getCacheNames());
//        System.out.println(cacheManager.getCache("user").get(id));
        Object a1 = userService.getUser2(id);
        System.out.println(a1);
        id = 7;
        Object a2 = userService.getUser2(id);
        System.out.println(a2);
        return new JsonResult(0,name,"成功");
    }




    @ApiOperation(value = "添加人")
    @RequestMapping("/add.do")
    public JsonResult add(){
//      userService.addUser();
        Map a = new HashMap();
       // return "2";
        a.put("a",1);
        a.put("b",2);
        return new JsonResult(0,a,"成功");
    }



}
