package com.example.assignment.service.impl;

import com.example.assignment.entity.DongSanPham;
import com.example.assignment.repository.DongSanPhamRepository;
import com.example.assignment.service.DongSanPhamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class DongSanPhamServiceImpl implements DongSanPhamService {
    @Autowired
    private DongSanPhamRepository dongSanPhamRepository;

    @Override
    public List<DongSanPham> getAll() {
        return dongSanPhamRepository.findAll();
    }

    @Override
    public Page<DongSanPham> getAll(Pageable pageable) {
        return dongSanPhamRepository.findAll(pageable);
    }

    @Override
    public void add(DongSanPham dongSanPham) {
        dongSanPhamRepository.save(dongSanPham);
    }

    @Override
    public DongSanPham detail(UUID id) {
        return dongSanPhamRepository.findById(id).orElse(null);
    }

    @Override
    public void update(DongSanPham dongSanPham) {
        dongSanPhamRepository.save(dongSanPham);
    }

    @Override
    public void remove(UUID id) {
        dongSanPhamRepository.deleteById(id);
    }

    @Override
    public DongSanPham findByMa(String ma) {
        return dongSanPhamRepository.findByMa(ma);
    }


}
