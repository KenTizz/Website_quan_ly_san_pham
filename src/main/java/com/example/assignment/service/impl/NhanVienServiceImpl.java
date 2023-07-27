package com.example.assignment.service.impl;

import com.example.assignment.entity.NhanVien;
import com.example.assignment.repository.NhanVienRepository;
import com.example.assignment.service.NhanVienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class NhanVienServiceImpl implements NhanVienService {

    @Autowired
    private NhanVienRepository nhanVienRepository;

    @Override
    public Page<NhanVien> getAll(Pageable pageable) {
        return nhanVienRepository.findAll(pageable);
    }

    @Override
    public void add(NhanVien nhanVien) {
        nhanVienRepository.save(nhanVien);
    }

    @Override
    public NhanVien detail(UUID id) {
        return nhanVienRepository.findById(id).orElse(null);
    }

    @Override
    public void update(NhanVien nhanVien) {
        nhanVienRepository.save(nhanVien);
    }

    @Override
    public void remove(UUID id) {
        nhanVienRepository.deleteById(id);
    }

    @Override
    public NhanVien findByMa(String ma) {
        return nhanVienRepository.findByMa(ma);
    }

}
