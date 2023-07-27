package com.example.assignment.service;

import com.example.assignment.entity.ChucVu;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;

public interface ChucVuService {

    List<ChucVu> getAll();

    Page<ChucVu> getAll(Pageable pageable);

    void add(ChucVu chucVu);

    ChucVu detail(UUID id);

    void update(ChucVu chucVu);

    void remove(UUID id);

    ChucVu findByMa(String ma);
}
