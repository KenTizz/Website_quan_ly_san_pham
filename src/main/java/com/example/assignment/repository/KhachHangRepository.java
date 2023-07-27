package com.example.assignment.repository;

import com.example.assignment.entity.KhachHang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.UUID;

public interface KhachHangRepository extends JpaRepository<KhachHang, UUID> {
    @Query("select obj from KhachHang obj where obj.ma = :ma")
    KhachHang findByMa(String ma);
}
