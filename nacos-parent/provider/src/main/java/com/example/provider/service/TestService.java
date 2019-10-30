package com.example.provider.service;

import com.example.provider.entity.Test;
import com.example.provider.repository.JpaTestDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestService {

    @Autowired
    private JpaTestDao testDao;

    public Test getTest(){
        return testDao.getOne("0");
    }

    public List<Test> getAll(){
        return testDao.findAll();
    }


}
