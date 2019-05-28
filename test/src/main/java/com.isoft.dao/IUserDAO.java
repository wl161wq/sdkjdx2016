package com.isoft.dao;

import java.util.List;
import java.util.Map;

public interface IUserDAO {
    List<Map<String,Object>> login(String uname, String upwd) throws Exception;
    List<Map<String,Object>> searchUserInfoByUname(String uname) throws Exception;
    boolean register(String uname, String upwd, String email);
    boolean adduser(String uname, String role, String email);
    boolean updateUserInfo(String uname,String email,String role,int id);
    List<Map<String,Object>> findAllUser(int page, int pageSize);
    List<Map<String,Object>> userTotal();
    Map<String,Object> findUserCount();
    int deleteUserInfoById(int id);

}
