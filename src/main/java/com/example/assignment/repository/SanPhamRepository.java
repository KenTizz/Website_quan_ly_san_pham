package com.example.assignment.repository;

import com.example.assignment.entity.SanPham;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.UUID;

public interface SanPhamRepository extends JpaRepository<SanPham, UUID> {
    @Query("select obj from SanPham obj where obj.ma = :ma")
    SanPham findByMa(String ma);
}
