package com.example.assignment.service.impl;

import com.example.assignment.entity.NhaSanXuat;
import com.example.assignment.repository.NhaSanXuatRepository;
import com.example.assignment.service.NhaSanXuatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class NhaSanXuatServiceImpl implements NhaSanXuatService {
    @Autowired
    private NhaSanXuatRepository nhaSanXuatRepository;

    @Override
    public List<NhaSanXuat> getAll() {
        return nhaSanXuatRepository.findAll();
    }

    @Override
    public Page<NhaSanXuat> getAll(Pageable pageable) {
        return nhaSanXuatRepository.findAll(pageable);
    }

    @Override
    public void add(NhaSanXuat nhaSanXuat) {
        nhaSanXuatRepository.save(nhaSanXuat);
    }

    @Override
    public NhaSanXuat detail(UUID id) {
        return nhaSanXuatRepository.findById(id).orElse(null);
    }

    @Override
    public void update(NhaSanXuat nhaSanXuat) {
        nhaSanXuatRepository.save(nhaSanXuat);
    }

    @Override
    public void remove(UUID id) {
        nhaSanXuatRepository.deleteById(id);
    }

    @Override
    public NhaSanXuat findByMa(String ma) {
        return nhaSanXuatRepository.findByMa(ma);
    }


}
