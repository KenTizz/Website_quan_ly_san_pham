package com.example.assignment.repository;

import com.example.assignment.entity.ChucVu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.UUID;

public interface ChucVuRepository extends JpaRepository<ChucVu, UUID> {
    @Query("select obj from ChucVu obj where obj.ma = :ma")
    ChucVu findByMa(String ma);
}
