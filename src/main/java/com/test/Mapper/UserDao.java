package com.test.Mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

import java.util.Map;
@Repository   //它用于将数据访问层 ( DAO 层 ) 的类标识为 Spring Bean
public interface UserDao extends BaseMapper {

    //根据ID找人
    //@Select("select * from InvestmentUser where ID = #{id}")
    Map findUser(String id);

    int addUser(String phone);

}
