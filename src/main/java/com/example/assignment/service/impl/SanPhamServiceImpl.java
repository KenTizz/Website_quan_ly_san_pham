package com.example.assignment.service.impl;

import com.example.assignment.entity.SanPham;
import com.example.assignment.repository.SanPhamRepository;
import com.example.assignment.service.SanPhamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class SanPhamServiceImpl implements SanPhamService {
    @Autowired
    private SanPhamRepository sanPhamRepository;

    @Override
    public List<SanPham> getAll() {
        return sanPhamRepository.findAll();
    }

    @Override
    public Page<SanPham> getAll(Pageable pageable) {
        return sanPhamRepository.findAll(pageable);
    }

    @Override
    public void add(SanPham sanPham) {
        sanPhamRepository.save(sanPham);
    }

    @Override
    public SanPham detail(UUID id) {
        return sanPhamRepository.findById(id).orElse(null);
    }

    @Override
    public void update(SanPham sanPham) {
        sanPhamRepository.save(sanPham);
    }

    @Override
    public void remove(UUID id) {
        sanPhamRepository.deleteById(id);
    }

    @Override
    public SanPham findByMa(String ma) {
        return sanPhamRepository.findByMa(ma);
    }


}
