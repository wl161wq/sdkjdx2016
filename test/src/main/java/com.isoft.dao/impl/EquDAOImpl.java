package com.isoft.dao.impl;

import com.isoft.dao.IEquDAO;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository("equDAO")
public class EquDAOImpl implements IEquDAO {
    @Autowired
    SqlSessionFactory sessionFactoryBean;
    @Override
    public boolean addEqu(String equ,String dep_of,int num,String Manager_cla,String check_f) {
        SqlSession sqlSession = sessionFactoryBean.openSession(true);
        String statement ="com.isoft.mapping.equMapper.addEqu";
        Map map=new HashMap();
        map.put("equ",equ);
        map.put("dep_of",dep_of);
        map.put("num",num);
        map.put("Manager_cla",Manager_cla);
        map.put("check_f",check_f);
        int i=sqlSession.insert(statement,map);
        if(i>0)
            return true;
        else
            return false;
    }

    @Override
    public List<Map<String,Object>> searchEuqByEqu(int page,int pageSize,String equ) {
        SqlSession sqlSession=sessionFactoryBean.openSession(true);
        String statment="com.isoft.mapping.equMapper.searchEuqByEqu";
        Map map=new HashMap();
        map.put("equ",equ);
        map.put("page",(page-1)*pageSize);
        map.put("pageSize",pageSize);
        List<Map<String,Object>> list=sqlSession.selectList(statment,map);
//        System.out.println(list);
        return list;
    }

    @Override
    public boolean insertday(String checker, String equ) {
        SqlSession sqlSession = sessionFactoryBean.openSession(true);
        String statment="com.isoft.mapping.equMapper.insertday";
        Map map=new HashMap();
        map.put("equ",equ);
        map.put("checker",checker);
        int i=sqlSession.insert(statment,map);
        if(i>0){return true;}
        else {return false;}
    }

    @Override
    public boolean updateEquInfo(int num,String equ_status ,String check_status,String check_f,int id) {
        SqlSession sqlSession = sessionFactoryBean.openSession(true);
        String statement ="com.isoft.mapping.equMapper.updateEquInfo";
        Map map=new HashMap();
        map.put("num",num);
        map.put("equ_status",equ_status);
        map.put("check_status",check_status);
        map.put("check_f",check_f);
        map.put("id",id);
        int i=sqlSession.insert(statement,map);
        if(i>0)
            return true;
        else
            return false;
    }

    @Override
    public List<Map<String,Object>> findcheck(int page,int pageSize){
        SqlSession sqlSession=sessionFactoryBean.openSession(true);
        String statement ="com.isoft.mapping.equMapper.findcheck";
        Map map=new HashMap();
        map.put("page",(page-1)*pageSize);
        map.put("pageSize",pageSize);
        List<Map<String,Object>> list=sqlSession.selectList(statement,map);
        return list;
    }

    @Override
    public List<Map<String,Object>> findChcekequ(int page,int pageSize){
        SqlSession sqlSession=sessionFactoryBean.openSession(true);
        String statement ="com.isoft.mapping.equMapper.findChcekequ";
        Map map=new HashMap();
        map.put("page",(page-1)*pageSize);
        map.put("pageSize",pageSize);
        List<Map<String,Object>> list=sqlSession.selectList(statement,map);
        return list;
    }
    @Override
    public List<Map<String,Object>> findAllequ(int page,int pageSize){
        SqlSession sqlSession=sessionFactoryBean.openSession(true);
        String statement ="com.isoft.mapping.equMapper.findAllequ";
        Map map=new HashMap();
        map.put("page",(page-1)*pageSize);
        map.put("pageSize",pageSize);
        List<Map<String,Object>> list=sqlSession.selectList(statement,map);
        return list;
    }

    public List<Map<String, Object>> equTotal() {
        try {
            SqlSession sqlSession = sessionFactoryBean.openSession(true);
            String statment = "com.isoft.mapping.equMapper.equTotal";
            List<Map<String, Object>> list = sqlSession.selectList(statment);
            return list;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
    @Override
    public Map<String,Object> findcheckCount(){
        try {
            SqlSession sqlSession = sessionFactoryBean.openSession(true);
            String statement = "com.isoft.mapping.equMapper.findcheckCount";
            Map map = sqlSession.selectOne(statement);
            return map;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
    public Map<String,Object> findequCount(){
        try {
            SqlSession sqlSession = sessionFactoryBean.openSession(true);
            String statement = "com.isoft.mapping.equMapper.findequCount";
            Map map = sqlSession.selectOne(statement);
            return map;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }


    @Override
    public int deleteequInfoById(int id) {
        try {
            SqlSession sqlSession = sessionFactoryBean.openSession(true);
            String statement = "com.isoft.mapping.equMapper.deleteequInfoById";
            int i= sqlSession.delete(statement,id);
            return i;
        }catch (Exception e){
            e.printStackTrace();
        }
        return 0;
    }
}
