package com.example.assignment.service.impl;

import com.example.assignment.entity.KhachHang;
import com.example.assignment.repository.KhachHangRepository;
import com.example.assignment.service.KhachHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class KhachHangServiceImpl implements KhachHangService {
    @Autowired
    private KhachHangRepository khachHangRepository;

    @Override
    public List<KhachHang> getAll() {
        return khachHangRepository.findAll();
    }

    @Override
    public Page<KhachHang> getAll(Pageable pageable) {
        return khachHangRepository.findAll(pageable);
    }

    @Override
    public void add(KhachHang khachHang) {
        khachHangRepository.save(khachHang);
    }

    @Override
    public KhachHang detail(UUID id) {
        return khachHangRepository.findById(id).orElse(null);
    }

    @Override
    public void update(KhachHang khachHang) {
        khachHangRepository.save(khachHang);
    }

    @Override
    public void remove(UUID id) {
        khachHangRepository.deleteById(id);
    }

    @Override
    public KhachHang findByMa(String ma) {
        return khachHangRepository.findByMa(ma);
    }


}
