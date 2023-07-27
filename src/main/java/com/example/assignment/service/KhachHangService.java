package com.example.assignment.service;

import com.example.assignment.entity.KhachHang;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;

public interface KhachHangService {

    List<KhachHang> getAll();

    Page<KhachHang> getAll(Pageable pageable);

    void add(KhachHang khachHang);

    KhachHang detail(UUID id);

    void update(KhachHang khachHang);

    void remove(UUID id);

    KhachHang findByMa(String ma);
}
