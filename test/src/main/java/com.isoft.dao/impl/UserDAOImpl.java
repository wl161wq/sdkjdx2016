package com.isoft.dao.impl;

import com.isoft.dao.IUserDAO;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository("userDAO")
public class UserDAOImpl implements IUserDAO {
    @Autowired
    SqlSessionFactory sessionFactoryBean;
    @Override
    public List<Map<String,Object>> login(String uname, String upwd) throws Exception{
        SqlSession sqlSession=sessionFactoryBean.openSession(true);
        String statment="com.isoft.mapping.userMapper.login";
        Map map=new HashMap();
        map.put("uname",uname);
        map.put("upwd",upwd);
        List list=sqlSession.selectList(statment,map);
//        System.out.println(list);
        if(list!=null){
            statment="com.isoft.mapping.userMapper.updateLoginTime";
            sqlSession.update(statment,uname);
            return list;
        }
        else {
            return null;
        }
    }

    @Override
    public List<Map<String, Object>> searchUserInfoByUname(String uname) throws Exception {
        SqlSession sqlSession=sessionFactoryBean.openSession(true);
        String statment="com.isoft.mapping.userMapper.searchUserInfoByUname";
        List list=sqlSession.selectList(statment,uname);
//        System.out.println(list);
            return list;
    }

    @Override
    public boolean register(String uname, String upwd, String email) {
        SqlSession sqlSession=sessionFactoryBean.openSession(true);
        String statment="com.isoft.mapping.userMapper.register";
        Map map=new HashMap();
        map.put("uname",uname);
        map.put("upwd",upwd);
        map.put("email",email);
        int i=sqlSession.insert(statment,map);
        if(i>0)
            return true;
        else
            return false;
    }
    @Override
    public boolean adduser(String uname,String email, String role) {
        SqlSession sqlSession=sessionFactoryBean.openSession(true);
        String statment="com.isoft.mapping.userMapper.adduser";
        Map map=new HashMap();
        map.put("uname",uname);
        map.put("email",email);
        map.put("role",role);
        int i=sqlSession.insert(statment,map);
        if(i>0)
            return true;
        else
            return false;
    }

    @Override
    public boolean updateUserInfo(String uname, String email, String role,int id) {
        SqlSession sqlSession=sessionFactoryBean.openSession(true);
        String statment="com.isoft.mapping.userMapper.updateUserInfo";
        Map map=new HashMap();
        map.put("uname",uname);
        map.put("email",email);
        map.put("role",role);
        map.put("id",id);
        int i=sqlSession.update(statment,map);
        if(i>0)
            return true;
        else
            return false;
    }

    @Override
    public List<Map<String,Object>> findAllUser(int page,int pageSize) {
        SqlSession sqlSession=sessionFactoryBean.openSession(true);
        String statment="com.isoft.mapping.userMapper.findAllUser";
        Map map=new HashMap();
        map.put("page",(page-1)*pageSize);
        map.put("pageSize",pageSize);
        List<Map<String,Object>> list=sqlSession.selectList(statment,map);
        return list;
    }
    @Override
    public  Map<String,Object> findUserCount() {

       try {
           SqlSession sqlSession = sessionFactoryBean.openSession(true);
           String statment = "com.isoft.mapping.userMapper.findUserCount";
           Map map = sqlSession.selectOne(statment);
           return map;
       }catch (Exception e){
           e.printStackTrace();
       }
       return null;
    }
    @Override
    public int deleteUserInfoById(int id){

        try {
            SqlSession sqlSession = sessionFactoryBean.openSession(true);
            String statment = "com.isoft.mapping.userMapper.deleteUserInfoById";
            int i= sqlSession.delete(statment,id);
            return i;
        }catch (Exception e){
            e.printStackTrace();
        }
        return 0;
    }



    @Override
    public  List<Map<String,Object>> userTotal() {

        try {
            SqlSession sqlSession = sessionFactoryBean.openSession(true);
            String statment = "com.isoft.mapping.userMapper.userTotal";
            List<Map<String,Object>> list=sqlSession.selectList(statment);
            return list;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
