package com.isoft.service;

import java.util.List;
import java.util.Map;

public interface IEquService {
    boolean addEqu(String equ,String dep_of,int num,String Manager_cla,String check_f);
    List<Map<String,Object>> searchEuqByEqu(int page,int pageSize,String equ);
    boolean insertday(String checker,String equ );
    boolean updateEquInfo(int num,String equ_status ,String check_status,String check_f,int id);
    List<Map<String,Object>> findcheck(int page, int pageSize);
    List<Map<String,Object>> findChcekequ(int page, int pageSize);
    List<Map<String,Object>> findAllequ(int page, int pageSize);
    List<Map<String,Object>>equTotal();
    Map<String,Object> findcheckCount();
    Map<String,Object> findequCount();
    int deleteequInfoById(int id);
}
