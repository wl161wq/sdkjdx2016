package com.isoft.service.impl;

import com.isoft.dao.IEquDAO;
import com.isoft.service.IEquService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("equService")
public class EquServiceImpl implements IEquService {
    @Autowired
    IEquDAO equDAO;
    @Override
    public boolean addEqu(String equ, String dep_of, int num, String Manager_cla, String check_f) {
        boolean temp=equDAO.addEqu(equ,dep_of,num,Manager_cla,check_f);
        return temp;
    }

    @Override
    public List<Map<String, Object>> searchEuqByEqu(int page,int pageSize,String equ) {
        return equDAO.searchEuqByEqu(page,pageSize,equ);

    }

    @Override
    public boolean insertday(String checker, String equ) {
        boolean temp=equDAO.insertday(checker,equ);
        return temp;
    }

    @Override
    public boolean updateEquInfo(int num, String equ_status, String check_status, String check_f, int id) {
        boolean temp=equDAO.updateEquInfo(num,equ_status ,check_status,check_f,id);
        return temp;
    }

    @Override
    public List<Map<String, Object>> findcheck(int page, int pageSize) {
        return equDAO.findcheck(page,pageSize);
    }

    @Override
    public List<Map<String, Object>> findChcekequ(int page, int pageSize) {
        return equDAO.findChcekequ(page,pageSize);

    }

    @Override
    public List<Map<String, Object>> findAllequ(int page, int pageSize) {
        return equDAO.findAllequ(page,pageSize);

    }

    @Override
    public List<Map<String, Object>> equTotal() {
        return  equDAO.equTotal();

    }

    @Override
    public Map<String, Object> findcheckCount() {
        return  equDAO.findcheckCount();

    }

    @Override
    public Map<String, Object> findequCount() {
        return  equDAO.findequCount();

    }

    @Override
    public int deleteequInfoById(int id) {
        return equDAO.deleteequInfoById(id);
    }
}
