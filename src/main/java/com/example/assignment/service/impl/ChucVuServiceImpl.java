package com.example.assignment.service.impl;

import com.example.assignment.entity.ChucVu;
import com.example.assignment.repository.ChucVuRepository;
import com.example.assignment.service.ChucVuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ChucVuServiceImpl implements ChucVuService {
    @Autowired
    private ChucVuRepository chucVuRepository;

    @Override
    public List<ChucVu> getAll() {
        return chucVuRepository.findAll();
    }

    @Override
    public Page<ChucVu> getAll(Pageable pageable) {
        return chucVuRepository.findAll(pageable);
    }

    @Override
    public void add(ChucVu chucVu) {
        chucVuRepository.save(chucVu);
    }

    @Override
    public ChucVu detail(UUID id) {
        return chucVuRepository.findById(id).orElse(null);
    }

    @Override
    public void update(ChucVu chucVu) {
        chucVuRepository.save(chucVu);
    }

    @Override
    public void remove(UUID id) {
        chucVuRepository.deleteById(id);
    }

    @Override
    public ChucVu findByMa(String ma) {
        return chucVuRepository.findByMa(ma);
    }


}
