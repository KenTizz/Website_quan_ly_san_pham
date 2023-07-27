package com.example.assignment.service.impl;

import com.example.assignment.entity.ChiTietSanPham;
import com.example.assignment.repository.ChiTietSanPhamRepository;
import com.example.assignment.service.ChiTietSanPhamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ChiTietSanPhamServiceImpl implements ChiTietSanPhamService {
    @Autowired
    private ChiTietSanPhamRepository chiTietSanPhamRepository;

    @Override
    public List<ChiTietSanPham> getAll() {
        return chiTietSanPhamRepository.findAll();
    }

    @Override
    public Page<ChiTietSanPham> getAll(Pageable pageable) {
        return chiTietSanPhamRepository.findAll(pageable);
    }

    @Override
    public void add(ChiTietSanPham chiTietSanPham) {
        chiTietSanPhamRepository.save(chiTietSanPham);
    }

    @Override
    public ChiTietSanPham detail(UUID id) {
        return chiTietSanPhamRepository.findById(id).orElse(null);
    }

    @Override
    public void update(ChiTietSanPham chiTietSanPham) {
        chiTietSanPhamRepository.save(chiTietSanPham);
    }

    @Override
    public void remove(UUID id) {
        chiTietSanPhamRepository.deleteById(id);
    }


}
