package com.xmg.mybatis.domain;

import com.xmg.mybatis.mapper.UserMapper;
import com.xmg.mybatis.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.Date;
import java.util.List;

/**
 * Created by kerwin on 2017/9/17.
 */
public class HelloMapperTest {

    public void test(){
        SqlSession session = MybatisUtil.openSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        System.out.println(mapper.getClass());
    }



    @Test
    public void testSave(){
        User u = new User();
        u.setName("name");
        u.setAge(17);
        u.setEmail("email");
        u.setBornDate(new Date());

        SqlSession session = null;
        try{
            //通过factory得到SqlSession
            session = MybatisUtil.openSession();
            //找到Mapper,保存对象
            UserMapper mapper = session.getMapper(UserMapper.class);
            mapper.add(u);
            //提交事务
            session.commit();


        } catch (Exception e) {
            e.printStackTrace();
            if(session!=null) {
               session.rollback();
            }
        } finally{
            //关闭资源
            if(session!=null){
                session.commit();
            }

        }

    }

    @Test
    public void testUpdate(){
        try{
            SqlSession session = MybatisUtil.openSession();
            User u = new User();
            u.setId(1L);
            u.setName("update");
            u.setBornDate(new Date());

            UserMapper mapper = session.getMapper(UserMapper.class);
            mapper.update(u);
            session.commit();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testGet(){
        SqlSession session = MybatisUtil.openSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        User u = mapper.get(2L);
        System.out.println(u);
    }

    @Test
    public void testDelete(){
        SqlSession session = MybatisUtil.openSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        mapper.delete(2L);
        session.commit();
        session.close();
    }

    @Test
    public void testList(){
        SqlSession session = MybatisUtil.openSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        List<User> us = mapper.list();
        System.out.println(us);
    }

}
