package com.example.assignment.service.impl;

import com.example.assignment.entity.CuaHang;
import com.example.assignment.repository.CuaHangRepository;
import com.example.assignment.service.CuaHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CuaHangServiceImpl implements CuaHangService {
    @Autowired
    private CuaHangRepository cuaHangRepository;

    @Override
    public List<CuaHang> getALL() {
        return cuaHangRepository.findAll();
    }

    @Override
    public Page<CuaHang> getAll(Pageable pageable) {
        return cuaHangRepository.findAll(pageable);
    }

    @Override
    public void add(CuaHang cuaHang) {
        cuaHangRepository.save(cuaHang);
    }

    @Override
    public CuaHang detail(UUID id) {
        return cuaHangRepository.findById(id).orElse(null);
    }

    @Override
    public void update(CuaHang cuaHang) {
        cuaHangRepository.save(cuaHang);
    }

    @Override
    public void remove(UUID id) {
        cuaHangRepository.deleteById(id);
    }

    @Override
    public CuaHang findByMa(String ma) {
        return cuaHangRepository.findByMa(ma);
    }
}
