package com.example.assignment.service;

import com.example.assignment.entity.NhanVien;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface NhanVienService {

    Page<NhanVien> getAll(Pageable pageable);

    void add(NhanVien nhanVien);

    NhanVien detail(UUID id);

    void update(NhanVien nhanVien);

    void remove(UUID id);

    NhanVien findByMa(String ma);


}
