package com.isoft.action;

import com.isoft.service.IUserService;
import com.isoft.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/user")

public class UserAction {
    @Autowired
    IUserService userService;
    @RequestMapping("/login.do")
    @ResponseBody
    public Map<String,Object> login(String uname, String upwd) {
        /*硬编码*/
        List<Map<String,Object>> list = userService.login(uname, upwd);
        Map map=new HashMap();
        List roleList=new ArrayList();
        List emailList=new ArrayList();
        List idList=new ArrayList();
        List pwdList=new ArrayList();
       // List regeisterTimeList=new ArrayList();
       // List lastLoginTimeList=new ArrayList();
        List unameList=new ArrayList();
        for(Map mp :list){
            pwdList.add(mp.get("upwd"));
            idList.add(mp.get("id"));
            roleList.add(mp.get("role"));
            unameList.add(mp.get("uname"));
            emailList.add(mp.get("email"));
            //regeisterTimeList.add(mp.get("regeisterTime"));
            //lastLoginTimeList.add(map.get("lastLoginTime"));

        }
        map.put("pwdList",pwdList);
        map.put("idList",idList);
        map.put("roleList",roleList);
        map.put("unameList",unameList);
        map.put("emailList",emailList);
       // map.put("regeisterTimeList",regeisterTimeList);
       // map.put("lastLoginTimeList",lastLoginTimeList);
//        System.out.println(map);
        return map;

    }
    @RequestMapping("/searchUserInfoByUname.do")
    @ResponseBody
    public Map<String,Object> searchUserInfoByUname(int page,int limit,String uname) {
        List<Map<String ,Object>> list=userService.searchUserInfoByUname(page,limit,uname);
        Map<String,Object> userCount=userService.findUserCount();
//        Map map=new HashMap();
//        map.put("code", 0);
//        map.put("msg", "用户信息");
//        map.put("count", userCount.get("count"));
//        map.put("data", list);
//        return map;
//        List<Map<String ,Object>> list=userService.searchUserInfoByUname(uname);
        Map map=new HashMap();
//        List roleList=new ArrayList();
//        List emailList=new ArrayList();
//        List regeisterTimeList=new ArrayList();
//        List lastLoginTimeList=new ArrayList();
//        List unameList=new ArrayList();
//        for(Map mp :list){
//            roleList.add(mp.get("role"));
//            unameList.add(mp.get("uname"));
//            emailList.add(mp.get("email"));
//            regeisterTimeList.add(mp.get("regeisterTime"));
//            lastLoginTimeList.add(map.get("lastLoginTime"));
//        }
        map.put("code",0);
        map.put("msg","用户信息");
//        map.put("roleList",roleList);
        map.put("data", list);
        map.put("count",userCount.get("count"));
        return map;//返回json格式数据，但是不能转换，因为找不到json消息转换器
    }

    @RequestMapping("/register.do")
    @ResponseBody
    public String register(String uname, String upwd, String email) {
        /*硬编码*/
        boolean temp = userService.register(uname,upwd,email);
          if (temp)
            return "success";
        else
            return "fault";
    }
    @RequestMapping("/changeUserPwd.do")
    @ResponseBody
    public String changeUserPwd(String uname, String upwd) {
        /*硬编码*/
        boolean temp = userService.changeUserPwd(uname,upwd);
        if (temp)
            return "success";
        else
            return "fault";
    }
    @RequestMapping("/adduser.do")
    @ResponseBody
    public String adduser(String uname,String email, String role) {
        /*硬编码*/
        boolean temp = userService.adduser(uname,email,role);
        if (temp)
            return "success";
        else
            return "fault";
    }
    @RequestMapping("/updateUserInfo.do")
    @ResponseBody
    public String updateUserInfo(String uname,String email, String role,int id) {
        /*硬编码*/
        boolean temp = userService.updateUserInfo(uname,email,role,id);
        if (temp)
            return "success";
        else
            return "fault";
    }
    @RequestMapping("/findAllUser.do")
    @ResponseBody
    public Map<String,Object> findAllUser(int page, int limit) {
        List<Map<String ,Object>> list=userService.findAllUser(page,limit);
        Map<String,Object> userCount=userService.findUserCount();
        Map map=new HashMap();
        map.put("code", 0);
        map.put("msg", "用户信息");
        map.put("count", userCount.get("count"));//用户表中总记录数
        map.put("data", list);
        return map;//返回json格式数据，但是不能转换，因为找不到json消息转换器
    }

    @RequestMapping("/deleteUserInfoById.do")
    @ResponseBody
    public String deleteUserInfoById(String id) {
        String result="success";
        int i=0;
        try {
            String [] arr=id.split(",");
            for (String index:arr) {
                i=userService.deleteUserInfoById(Integer.parseInt(index));
            }
        }catch (Exception e){
            i=0;
            e.printStackTrace();
        }
        if(i == 0)
        {
            result= "fault";
        }
        return result;
        //返回json格式数据，但是不能转换，因为找不到json消息转换器
    }
    @RequestMapping("/userTotal.do")
    @ResponseBody
    public Map<String,Object> userTotal() {
        List<Map<String,Object>> list=userService.userTotal();
        Map map=new HashMap();
        List roleList=new ArrayList();
        List countList=new ArrayList();
        for(Map mp :list){
            roleList.add(mp.get("role"));
            countList.add(mp.get("count"));
        }
        map.put("roleList",roleList);
        map.put("countList",countList);
        return map;//返回json格式数据，但是不能转换，因为找不到json消息转换器
    }
}
