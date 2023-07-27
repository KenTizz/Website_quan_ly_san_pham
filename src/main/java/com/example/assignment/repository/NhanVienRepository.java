package com.example.assignment.repository;

import com.example.assignment.entity.NhanVien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface NhanVienRepository extends JpaRepository<NhanVien, UUID> {
    @Query("select obj from NhanVien obj WHERE obj.ma = :ma")
    NhanVien findByMa(String ma);

}