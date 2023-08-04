package com.example.Queries.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Queries.model.Queries;
import com.example.Queries.repository.QueriesRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class QueriesService {
     
    @Autowired
     QueriesRepository queriesRepository;
    
    public List<Queries> getTableDatas(){
        return queriesRepository.findAllData();
    }
    public List<Queries> getDetail(Boolean actives, List<String> describe){
        return queriesRepository.findData(actives,describe);
    }
    public List<Queries> getTableData(){
        return queriesRepository.findAlldetail();
    }
    public int updateDatas(Boolean actives, List<Long> idList) {
        return queriesRepository.updateData(actives, idList);
    }
}
