package com.example.assignment.repository;

import com.example.assignment.entity.NhaSanXuat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.UUID;

public interface NhaSanXuatRepository extends JpaRepository<NhaSanXuat, UUID> {
    @Query("select obj from NhaSanXuat obj where obj.ma = :ma")
    NhaSanXuat findByMa(String ma);
}
