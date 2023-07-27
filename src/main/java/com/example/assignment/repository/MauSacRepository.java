package com.example.assignment.repository;

import com.example.assignment.entity.MauSac;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.UUID;

public interface MauSacRepository extends JpaRepository<MauSac, UUID> {
    @Query("select obj from MauSac obj where obj.ma = :ma")
    MauSac findByMa(String ma);
}
