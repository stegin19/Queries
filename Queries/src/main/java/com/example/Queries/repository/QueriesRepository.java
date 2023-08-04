package com.example.Queries.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.Queries.model.Queries;


public interface QueriesRepository extends JpaRepository<Queries, Long> {
    @Query("select q from Queries q")
    List<Queries> findAllData();

    @Query("select q from Queries q where q.actives=false")
    List<Queries> findAlldetail();

    @Query("select q from Queries q where q.actives=:actives and q.description in :describe")
    List<Queries> findData(@Param("actives") Boolean actives, @Param("describe") List<String> describe);

    @Modifying
    @Query("update Queries q set q.actives = ?1 where q.id in ?2")
    int updateData(Boolean actives, List<Long> idList);
}
