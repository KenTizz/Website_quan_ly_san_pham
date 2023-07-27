package com.example.assignment.controller;

import com.example.assignment.entity.KhachHang;
import com.example.assignment.service.KhachHangService;
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
@RequestMapping("/khach-hang/")
public class KhachHangController {
    @Autowired
    private KhachHangService khachHangService;

    @GetMapping("hien-thi")
    public String getHienThi(
            @RequestParam(value = "page", defaultValue = "1") Integer number,
            Model model) {
        Pageable pageable = PageRequest.of(number - 1, 2);
        Page<KhachHang> khachHangPage = khachHangService.getAll(pageable);
        model.addAttribute("danhSach", khachHangPage);
        return "/khach-hang/index";
    }

    @GetMapping("view-add")
    public String getAdd(Model model) {
        model.addAttribute("khachHang", new KhachHang());
        return "/khach-hang/view-add";
    }

    @PostMapping("add")
    public String postAdd(@Valid @ModelAttribute("khachHang") KhachHang khachHang,
                          BindingResult result,
                          Model model) {
        if (result.hasErrors()) {
            return "/khach-hang/view-add";
        } else if (khachHangService.findByMa(khachHang.getMa()) != null) {
            model.addAttribute("errorMa", "Đã tồn tại mã này rồi");
            return "/khach-hang/view-add";
        }
        khachHangService.add(khachHang);
        return "redirect:/khach-hang/hien-thi";
    }

    @GetMapping("remove/{id}")
    public String getRemove(@PathVariable("id") UUID uuid) {
        khachHangService.remove(uuid);
        return "redirect:/khach-hang/hien-thi";
    }

    @GetMapping("view-update/{id}")
    public String getUpdate(@PathVariable("id") UUID uuid, Model model) {
        KhachHang detail = khachHangService.detail(uuid);
        model.addAttribute("khachHang", detail);
        return "/khach-hang/view-update";
    }

    @PostMapping("update/{id}")
    public String postUpdate(@Valid @ModelAttribute("khachHang") KhachHang khachHang,
                             BindingResult result) {
        if (result.hasErrors()) {
            return "/khach-hang/view-update";
        }
        khachHangService.update(khachHang);
        return "redirect:/khach-hang/hien-thi";
    }
}
