package com.example.assignment.service;

import com.example.assignment.entity.NhaSanXuat;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;

public interface NhaSanXuatService {

    List<NhaSanXuat> getAll();

    Page<NhaSanXuat> getAll(Pageable pageable);

    void add(NhaSanXuat nhaSanXuat);

    NhaSanXuat detail(UUID id);

    void update(NhaSanXuat nhaSanXuat);

    void remove(UUID id);

    NhaSanXuat findByMa(String ma);
}
