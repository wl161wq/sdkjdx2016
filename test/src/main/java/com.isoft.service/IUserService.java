package com.isoft.service;

import java.util.List;
import java.util.Map;

public interface IUserService {
    List<Map<String,Object>> login(String uname, String upwd);
    List<Map<String,Object>> searchUserInfoByUname(int page,int pageSize,String uname);
    boolean register(String uname, String upwd, String email);
    boolean adduser(String uname,String email, String role);
    boolean updateUserInfo(String uname,String email,String role,int id);
    boolean changeUserPwd(String uname,String upwd);;
    List<Map<String,Object>> findAllUser(int page,int pageSize);
    Map<String,Object> findUserCount();
    int deleteUserInfoById(int id);
    List<Map<String,Object>> userTotal();
}
