package com.example.as4.repository;

import com.example.as4.dto.RekeningProjection;
import com.example.as4.dto.TrainingProjection;
import com.example.as4.models.Rekening;
import com.example.as4.models.Training;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface TrainingRepository extends CrudRepository<Training, Long> {

    @Query("SELECT t.id AS id , t.tema AS tema, t.pengajar as pengajar, " +
            " t.created_date AS created_date, t.updated_date as updated_date," +
            " t.deleted_date as deleted_date " +
            " FROM Training t " +
            " WHERE t.id = :id ")
    TrainingProjection findDetailById(@Param("id") Long id);

    @Query(value = "SELECT t.id AS id , t.tema AS tema, t.pengajar as pengajar, " +
            " t.created_date AS created_date, t.updated_date as updated_date," +
            " t.deleted_date as deleted_date " +
            " FROM training t ",
            countQuery = "SELECT count(t.id) FROM training t ", nativeQuery = true)
    Page<TrainingProjection> getPageable(Pageable pageable);
}
