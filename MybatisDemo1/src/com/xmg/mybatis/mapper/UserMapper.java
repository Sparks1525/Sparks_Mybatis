package com.xmg.mybatis.mapper;

import com.xmg.mybatis.domain.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by kerwin on 2017/9/17.
 */
public interface UserMapper {


    //com.xmg.mybatis.mapper.UserMapper.add
    void add(User u);


    //com.xmg.mybatis.mapper.UserMapper.update
    void update(User u);

    //com.xmg.mybatis.mapper.UserMapper.get
    User get(long id);

    //com.xmg.mybatis.domain.UserMapping.delete
    void delete(long id);

    //com.xmg.mybatis.mapper.UserMapper.list
    List<User> list();

    //User login(Map<String,Object> root);
    User login(@Param("username") String username, @Param("password") String password);

}
