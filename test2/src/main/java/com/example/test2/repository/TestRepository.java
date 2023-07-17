package com.example.test2.repository;

import com.example.test2.entity.Test;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

public interface TestRepository extends CrudRepository<Test,Integer> {
    @Query("select id from test order by random() limit 1")
    Integer getRandomId();
}
