package com.example.as4.repository;

import com.example.as4.dto.KaryawanProjection;
import com.example.as4.models.DetailKaryawan;
import com.example.as4.models.Karyawan;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface DetailKaryawanRepository extends CrudRepository<DetailKaryawan, Long> {
}
