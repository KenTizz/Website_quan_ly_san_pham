package com.example.assignment.service;

import com.example.assignment.entity.CuaHang;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;

public interface CuaHangService {
    List<CuaHang> getALL();

    Page<CuaHang> getAll(Pageable pageable);

    void add(CuaHang cuaHang);

    CuaHang detail(UUID id);

    void update(CuaHang cuaHang);

    void remove(UUID id);

    CuaHang findByMa(String ma);
}
