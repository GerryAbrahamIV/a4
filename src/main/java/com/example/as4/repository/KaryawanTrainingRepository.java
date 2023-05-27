package com.example.as4.repository;

import com.example.as4.dto.KaryawanTrainingProjection;
import com.example.as4.dto.TrainingProjection;
import com.example.as4.models.KaryawanTraining;
import com.example.as4.models.Training;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface KaryawanTrainingRepository extends CrudRepository<KaryawanTraining, Long> {

    @Query("SELECT kt.id AS id , kt.id_karyawan AS id_karyawan, kt.id_training as id_training, kt.tanggal as tanggal, " +
            " kt.created_date AS created_date, kt.updated_date as updated_date," +
            " kt.deleted_date as deleted_date " +
            " FROM KaryawanTraining kt " +
            " WHERE kt.id = :id ")
    KaryawanTrainingProjection findDetailById(@Param("id") Long id);

    @Query(value = "SELECT kt.id AS id , kt.id_karyawan AS id_karyawan, kt.id_training as id_training, kt.tanggal as tanggal, " +
            " kt.created_date AS created_date, kt.updated_date as updated_date," +
            " kt.deleted_date as deleted_date " +
            " FROM karyawan_training kt ",
            countQuery = "SELECT count(kt.id) FROM karyawan_training kt ", nativeQuery = true)
    Page<KaryawanTrainingProjection> getPageable(Pageable pageable);
}
