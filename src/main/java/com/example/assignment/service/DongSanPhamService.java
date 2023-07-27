package com.example.assignment.service;

import com.example.assignment.entity.DongSanPham;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;

public interface DongSanPhamService {

    List<DongSanPham> getAll();

    Page<DongSanPham> getAll(Pageable pageable);

    void add(DongSanPham dongSanPham);

    DongSanPham detail(UUID id);

    void update(DongSanPham dongSanPham);

    void remove(UUID id);

    DongSanPham findByMa(String ma);
}
