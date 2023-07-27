package com.example.assignment.service;

import com.example.assignment.entity.SanPham;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;

public interface SanPhamService {

    List<SanPham> getAll();

    Page<SanPham> getAll(Pageable pageable);

    void add(SanPham SanPham);

    SanPham detail(UUID id);

    void update(SanPham SanPham);

    void remove(UUID id);

    SanPham findByMa(String ma);
}
