package com.test.Controller;

import com.test.Service.IUserService;
import com.test.Util.JsonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@Api(value = "登录接口1")   //类注解
@RestController      //注解相当于@ResponseBody ＋ @Controller合在一起的作用。
@RequestMapping("/user1")
@EnableAutoConfiguration   //此注释自动载入应用程序所需的所有Bean
public class Test1Controller {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private IUserService userService;

    @ApiOperation(value = "登录")   //方法名注解
    @RequestMapping(value="/login.do",method = RequestMethod.POST)   //和以前一样
    public JsonResult login(@ApiParam(name="phone",value="用户手机号",required = true)String phone,
                            @ApiParam(name="password",value="密码",required = true)String password, HttpServletResponse response){
        userService.getUser(1);

        return new JsonResult(0,6,"成功");
    }

    @ApiOperation(value = "添加人")
    @RequestMapping(value="/add.do")
    public JsonResult add(){
//        userService.addUser();
        Map a = new HashMap();
       // return "2";
        a.put("a",1);
        a.put("b",2);
        return new JsonResult(0,a,"成功");
    }


}
