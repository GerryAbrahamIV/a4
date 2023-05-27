package com.example.as4.repository;

import com.example.as4.models.Test;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

public interface TestRepository extends Repository<Test, Long> {

    @Query("SELECT t FROM Test t "
            + "WHERE t.name = :nama")
    Test findByName(@Param("nama") String nama);


}
