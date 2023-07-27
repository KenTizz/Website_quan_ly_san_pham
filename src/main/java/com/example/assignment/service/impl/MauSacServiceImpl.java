package com.example.assignment.service.impl;

import com.example.assignment.entity.MauSac;
import com.example.assignment.repository.MauSacRepository;
import com.example.assignment.service.MauSacService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class MauSacServiceImpl implements MauSacService {
    @Autowired
    private MauSacRepository mauSacRepository;

    @Override
    public List<MauSac> getAll() {
        return mauSacRepository.findAll();
    }

    @Override
    public Page<MauSac> getAll(Pageable pageable) {
        return mauSacRepository.findAll(pageable);
    }

    @Override
    public void add(MauSac MauSac) {
        mauSacRepository.save(MauSac);
    }

    @Override
    public MauSac detail(UUID id) {
        return mauSacRepository.findById(id).orElse(null);
    }

    @Override
    public void update(MauSac MauSac) {
        mauSacRepository.save(MauSac);
    }

    @Override
    public void remove(UUID id) {
        mauSacRepository.deleteById(id);
    }

    @Override
    public MauSac findByMa(String ma) {
        return mauSacRepository.findByMa(ma);
    }


}
