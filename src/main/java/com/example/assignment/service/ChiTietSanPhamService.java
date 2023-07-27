package com.example.assignment.service;

import com.example.assignment.entity.ChiTietSanPham;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;

public interface ChiTietSanPhamService {

    List<ChiTietSanPham> getAll();

    Page<ChiTietSanPham> getAll(Pageable pageable);

    void add(ChiTietSanPham chiTietSanPham);

    ChiTietSanPham detail(UUID id);

    void update(ChiTietSanPham chiTietSanPham);

    void remove(UUID id);

}
