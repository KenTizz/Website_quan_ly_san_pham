package com.example.assignment.repository;

import com.example.assignment.entity.ChucVu;
import com.example.assignment.entity.CuaHang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.UUID;

public interface CuaHangRepository extends JpaRepository<CuaHang, UUID> {
    @Query("select obj from CuaHang obj where obj.ma = :ma")
    CuaHang findByMa(String ma);
}
