package com.example.assignment.controller;

import com.example.assignment.entity.DongSanPham;
import com.example.assignment.service.DongSanPhamService;
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
@RequestMapping("/dong-san-pham/")
public class DongSanPhamController {
    @Autowired
    private DongSanPhamService dongSanPhamService;

    @GetMapping("hien-thi")
    public String getHienThi(
            @RequestParam(value = "page", defaultValue = "1") Integer number,
            Model model) {
        Pageable pageable = PageRequest.of(number - 1, 2);
        Page<DongSanPham> dongSanPhams = dongSanPhamService.getAll(pageable);
        model.addAttribute("danhSach", dongSanPhams);
        return "/dong-san-pham/index";
    }

    @GetMapping("view-add")
    public String getAdd(Model model) {
        model.addAttribute("dongSanPham", new DongSanPham());
        return "/dong-san-pham/view-add";
    }

    @PostMapping("add")
    public String postAdd(@Valid @ModelAttribute("dongSanPham") DongSanPham dongSanPham,
                          BindingResult result,
                          Model model) {
        if (result.hasErrors()) {
            return "/dong-san-pham/view-add";
        } else if (dongSanPhamService.findByMa(dongSanPham.getMa()) != null) {
            model.addAttribute("errorMa", "Đã tồn tại mã này rồi");
            return "/dong-san-pham/view-add";
        }
        dongSanPhamService.add(dongSanPham);
        return "redirect:/dong-san-pham/hien-thi";
    }

    @GetMapping("remove/{id}")
    public String getRemove(@PathVariable("id") UUID uuid) {
        dongSanPhamService.remove(uuid);
        return "redirect:/dong-san-pham/hien-thi";
    }

    @GetMapping("view-update/{id}")
    public String getUpdate(@PathVariable("id") UUID uuid, Model model) {
        DongSanPham detail = dongSanPhamService.detail(uuid);
        model.addAttribute("dongSanPham", detail);
        return "/dong-san-pham/view-update";
    }

    @PostMapping("update/{id}")
    public String postUpdate(@Valid @ModelAttribute("dongSanPham") DongSanPham dongSanPham,
                             BindingResult result) {
        if (result.hasErrors()) {
            return "/dong-san-pham/view-update";
        }
        dongSanPhamService.update(dongSanPham);
        return "redirect:/dong-san-pham/hien-thi";
    }
}
