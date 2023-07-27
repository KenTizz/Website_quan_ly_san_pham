package com.example.assignment.repository;

import com.example.assignment.entity.ChiTietSanPham;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.UUID;

public interface ChiTietSanPhamRepository extends JpaRepository<ChiTietSanPham, UUID> {
}
