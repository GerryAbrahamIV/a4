package com.example.as4.repository;

import com.example.as4.dto.KaryawanProjection;
import com.example.as4.models.Karyawan;
import com.example.as4.models.Rekening;
import com.example.as4.response.TestResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

public interface KaryawanRepository extends CrudRepository<Karyawan, Long> {

    @Query("SELECT k.id AS id , k.nama AS nama, k.status AS status, k.alamat AS alamat, " +
            " k.dob AS dob, k.created_date AS created_date, k.updated_date as updated_date," +
            " k.deleted_date as deleted_date, dk.id AS id_detail, dk.nik as nik, dk.npwp as npwp," +
            " dk.created_date AS created_date_detail, " +
            " dk.updated_date AS updated_date_detail, dk.deleted_date AS deleted_date_detail" +
            " FROM Karyawan k " +
            " JOIN DetailKaryawan dk ON k.detail_karyawan = dk.id "
            + "WHERE k.id = :id")
    KaryawanProjection findDetailById(@Param("id") Long id);

    @Query(value="SELECT k.id AS id , k.nama AS nama, k.status AS status, k.alamat AS alamat, " +
            " k.dob AS dob, k.created_date AS created_date, k.updated_date as updated_date," +
            " k.deleted_date as deleted_date, dk.id AS id_detail, dk.nik as nik, dk.npwp as npwp," +
            " dk.created_date AS created_date_detail, " +
            " dk.updated_date AS updated_date_detail, dk.deleted_date AS deleted_date_detail" +
            " FROM karyawan k " +
            " JOIN detail_karyawan dk ON k.detail_karyawan = dk.id ",
            countQuery = "SELECT count(k.id) FROM karyawan k ", nativeQuery = true)
    Page<KaryawanProjection> getPageable(Pageable pageable);
}
