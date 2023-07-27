package com.example.assignment.service;

import com.example.assignment.entity.MauSac;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;

public interface MauSacService {

    List<MauSac> getAll();

    Page<MauSac> getAll(Pageable pageable);

    void add(MauSac MauSac);

    MauSac detail(UUID id);

    void update(MauSac MauSac);

    void remove(UUID id);

    MauSac findByMa(String ma);
}
