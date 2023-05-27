package com.example.as4.repository;

import com.example.as4.dto.KaryawanProjection;
import com.example.as4.dto.RekeningProjection;
import com.example.as4.models.Rekening;
import com.example.as4.models.Test;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

public interface RekeningRepository extends CrudRepository<Rekening, Long> {

    @Query("SELECT r.id AS id , r.nama AS nama, r.jenis as jenis, r.alamat as alamat, " +
            " r.rekening AS rekening, r.created_date AS created_date, r.updated_date as updated_date," +
            " r.deleted_date as deleted_date, k.id as idKaryawan, k.nama AS namaKaryawan " +
            " FROM Rekening r " +
            " JOIN Karyawan k ON k.id = r.id_karyawan "
            + "WHERE r.id = :id ")
    RekeningProjection findDetailById(@Param("id") Long id);

    @Query(value="SELECT r.id AS id , r.nama AS nama, r.jenis as jenis,r.alamat as alamat, " +
            " r.rekening AS rekening, r.created_date AS created_date, r.updated_date as updated_date," +
            " r.deleted_date as deleted_date, k.id as idKaryawan, k.nama AS namaKaryawan " +
            " FROM rekening r " +
            " JOIN karyawan k ON k.id = r.id_karyawan ",
            countQuery = "SELECT count(r.id) FROM rekening r ", nativeQuery = true)
    Page<RekeningProjection> getPageable(Pageable pageable);
}
