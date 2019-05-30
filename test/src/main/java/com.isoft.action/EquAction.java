package com.isoft.action;

import com.isoft.service.IEquService;
import com.isoft.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/equ")
public class EquAction {
    @Autowired
    IEquService equService;
    @RequestMapping("/insertday.do")
    @ResponseBody
    public String insertday(String checker,String equ) {
        /*硬编码*/
        boolean temp = equService.insertday(checker,equ);
        if (temp)
            return "success";
        else
            return "fault";
    }
    @RequestMapping("/addEqu.do")
    @ResponseBody
    public String addEqu(String equ,String dep_of,int num,String Manager_cla,String check_f) {
        /*硬编码*/
        boolean temp = equService.addEqu(equ,dep_of,num,Manager_cla,check_f);
        if (temp)
            return "success";
        else
            return "fault";

    }
    @RequestMapping("/updateEquInfo.do")
    @ResponseBody
    public String updateEquInfo(int num,String equ_status ,String check_status,String check_f,int id) {
        /*硬编码*/
        boolean temp = equService.updateEquInfo(num,equ_status ,check_status,check_f,id);
        if (temp)
            return "success";
        else
            return "fault";

    }
    @RequestMapping("/findcheck.do")
    @ResponseBody
    public Map<String,Object> findcheck(int page, int limit) {
//        System.out.println(page+","+limit);
        List<Map<String,Object>> list=equService.findcheck(page,limit);
        Map<String,Object> userCount = equService.findcheckCount();
        Map map=new HashMap();
        map.put("code",0);
        map.put("msg","用户信息");
        map.put("count",userCount.get("count"));//用户表中得总记录数
        map.put("data",list);
//        System.out.println(map);
        return map;//返回json格式数据，但是不能转换，因为找不到json消息转换器
    }
    @RequestMapping("/findChcekequ.do")
    @ResponseBody
    public Map<String,Object> findChcekequ(int page,int limit) {
//        System.out.println(page+","+limit);
        List<Map<String,Object>> list=equService.findChcekequ(page,limit);
        Map<String,Object> userCount =equService.findequCount();
        Map map=new HashMap();
        map.put("code",0);
        map.put("msg","用户信息");
        map.put("count",userCount.get("count"));//用户表中得总记录数
        map.put("data",list);
//        System.out.println(map);
        return map;//返回json格式数据，但是不能转换，因为找不到json消息转换器
    }
    @RequestMapping("/findAllequ.do")
    @ResponseBody
    public Map<String,Object> findAllequ(int page,int limit) {
//        System.out.println(page+","+limit);
        List<Map<String,Object>> list=equService.findAllequ(page,limit);
        Map<String,Object> userequCount = equService.findequCount();
        Map map=new HashMap();
        map.put("code",0);
        map.put("msg","用户信息");
        map.put("count",userequCount.get("count"));//用户表中得总记录数
        map.put("data",list);
//        System.out.println(map);
        return map;//返回json格式数据，但是不能转换，因为找不到json消息转换器
    }
    @RequestMapping("/deleteequInfoById.do")
    @ResponseBody
    public String deleteequInfoById(String id) {
        String result="success";
        int i=0;
        try{
            String [] arr=id.split(",");
            for(String index:arr){
                i=equService.deleteequInfoById(Integer.parseInt(index));
                System.out.println("正在删除第"+index+"条");
            }
        }catch (Exception e){
            i=0;
            e.printStackTrace();
        }
        if (i==0)
            result = "fault";
        return result;
    }
    @RequestMapping("/equTotal.do")
    @ResponseBody
    public Map<String,Object> equTotal() {
        List<Map<String,Object>> list=equService.equTotal();
        Map map=new HashMap();
        List dep_ofList=new ArrayList();
        List countList=new ArrayList();
        for(Map mp :list){
            dep_ofList.add(mp.get("dep_of"));
            countList.add(mp.get("count"));
        }
        map.put("dep_ofList",dep_ofList);
        map.put("countList",countList);
        return map;
    }
    @RequestMapping("/searchEuqByEqu.do")
    @ResponseBody
    public Map<String,Object> searchEuqByEqu(int page,int limit,String equ) {
        List<Map<String,Object>> list=equService.searchEuqByEqu(page,limit,equ);
        Map<String,Object> userequCount = equService.findequCount();
        Map map=new HashMap();
        map.put("code",0);
        map.put("msg","设备信息");
        map.put("data",list);
        map.put("count",userequCount.get("count"));
        return map;
    }
}
