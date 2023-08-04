package com.example.Queries.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Queries.model.Queries;
import com.example.Queries.service.QueriesService;

@RestController
@RequestMapping("/api")
public class QueriesController {
    
    @Autowired
     QueriesService queriesService;
    @GetMapping("/show")
    public List<Queries> getDetails(){
        return queriesService.getTableDatas();
    }

    @GetMapping("/showData")
    public List<Queries> getdetail(){
        return queriesService.getTableData();
    }

    @GetMapping("/showData/{actives}/{describe}")
    public List<Queries> getData(@PathVariable Boolean actives, @PathVariable List<String> describe){
        return queriesService.getDetail(actives, describe);
    }
    @PutMapping("/updateData/{actives}/{idList}")
    public int updateData(@PathVariable Boolean actives, @PathVariable List<Long> idList){
        return queriesService.updateDatas(actives, idList);
    }
}
