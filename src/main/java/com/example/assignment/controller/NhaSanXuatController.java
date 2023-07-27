package com.example.assignment.controller;

import com.example.assignment.entity.NhaSanXuat;
import com.example.assignment.service.NhaSanXuatService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.UUID;

@Controller
@RequestMapping("/nha-san-xuat/")
public class NhaSanXuatController {
    @Autowired
    private NhaSanXuatService nhaSanXuatService;

    @GetMapping("hien-thi")
    public String getHienThi(
            @RequestParam(value = "page", defaultValue = "1") Integer number,
            Model model) {
        Pageable pageable = PageRequest.of(number - 1, 2);
        Page<NhaSanXuat> NhaSanXuatPage = nhaSanXuatService.getAll(pageable);
        model.addAttribute("danhSach", NhaSanXuatPage);
        return "/nha-san-xuat/index";
    }

    @GetMapping("view-add")
    public String getAdd(Model model) {
        model.addAttribute("nhaSanXuat", new NhaSanXuat());
        return "/nha-san-xuat/view-add";
    }

    @PostMapping("add")
    public String postAdd(@Valid @ModelAttribute("nhaSanXuat") NhaSanXuat nhaSanXuat,
                          BindingResult result,
                          Model model) {
        if (result.hasErrors()) {
            return "/nha-san-xuat/view-add";
        } else if (nhaSanXuatService.findByMa(nhaSanXuat.getMa()) != null) {
            model.addAttribute("errorMa", "Đã tồn tại mã này rồi");
            return "/nha-san-xuat/view-add";
        }
        nhaSanXuatService.add(nhaSanXuat);
        return "redirect:/nha-san-xuat/hien-thi";
    }

    @GetMapping("remove/{id}")
    public String getRemove(@PathVariable("id") UUID uuid) {
        nhaSanXuatService.remove(uuid);
        return "redirect:/nha-san-xuat/hien-thi";
    }

    @GetMapping("view-update/{id}")
    public String getUpdate(@PathVariable("id") UUID uuid, Model model) {
        NhaSanXuat detail = nhaSanXuatService.detail(uuid);
        model.addAttribute("nhaSanXuat", detail);
        return "/nha-san-xuat/view-update";
    }

    @PostMapping("update/{id}")
    public String postUpdate(@Valid @ModelAttribute("nhaSanXuat") NhaSanXuat nhaSanXuat,
                             BindingResult result) {
        if (result.hasErrors()) {
            return "/nha-san-xuat/view-update";
        }
        nhaSanXuatService.update(nhaSanXuat);
        return "redirect:/nha-san-xuat/hien-thi";
    }
}
