package com.example.assignment.repository;

import com.example.assignment.entity.DongSanPham;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.UUID;

public interface DongSanPhamRepository extends JpaRepository<DongSanPham, UUID> {
    @Query("select obj from DongSanPham obj where obj.ma = :ma")
    DongSanPham findByMa(String ma);
}
