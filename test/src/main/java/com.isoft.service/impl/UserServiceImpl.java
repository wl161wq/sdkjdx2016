package com.isoft.service.impl;

import com.isoft.dao.IUserDAO;
import com.isoft.dao.impl.UserDAOImpl;
import com.isoft.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("userService")
public class UserServiceImpl implements IUserService {
    @Autowired
    IUserDAO userDAO;
    @Override
    public List<Map<String,Object>> login(String uname, String upwd) {
        try {
            List<Map<String,Object>> list=userDAO.login(uname,upwd);
            return list;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;

    }

    @Override
    public List<Map<String, Object>> searchUserInfoByUname(int page,int pageSize,String uname) {
        try {
//            List<Map<String,Object>> list=userDAO.searchUserInfoByUname(page,pageSize,uname);
//            return list;
            return userDAO.searchUserInfoByUname(page,pageSize,uname);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean register(String uname, String upwd, String email) {

        boolean temp=userDAO.register(uname,upwd,email);
        return temp;
    }
    @Override
    public boolean adduser(String uname, String email, String role) {

        boolean temp=userDAO.adduser(uname, email, role);
        return temp;
    }

    @Override
    public boolean updateUserInfo(String uname, String email, String role, int id) {
        boolean temp=userDAO.updateUserInfo(uname,email,role,id);
        return temp;
    }

    @Override
    public boolean changeUserPwd(String uname, String upwd) {
        boolean temp=userDAO.changeUserPwd(uname,upwd);
        return temp;
    }

    @Override
    public List<Map<String, Object>> findAllUser(int page, int pageSize) {
        return userDAO.findAllUser(page,pageSize);
    }
    @Override
    public Map<String, Object> findUserCount()
    {
        return userDAO.findUserCount();
    }
    @Override
    public int deleteUserInfoById(int id)
    {
        return userDAO.deleteUserInfoById(id);
    }
    @Override
    public List<Map<String, Object>> userTotal()
    {
        return userDAO.userTotal();
    }



}
