package com.example.assignment.controller;

import com.example.assignment.entity.SanPham;
import com.example.assignment.service.SanPhamService;
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
@RequestMapping("/san-pham/")
public class SanPhamController {
    @Autowired
    private SanPhamService sanPhamService;

    @GetMapping("hien-thi")
    public String getHienThi(
            @RequestParam(value = "page", defaultValue = "1") Integer number,
            Model model) {
        Pageable pageable = PageRequest.of(number - 1, 2);
        Page<SanPham> sanPhamPage = sanPhamService.getAll(pageable);
        model.addAttribute("danhSach", sanPhamPage);
        return "/san-pham/index";
    }

    @GetMapping("view-add")
    public String getAdd(Model model) {
        model.addAttribute("sanPham", new SanPham());
        return "/san-pham/view-add";
    }

    @PostMapping("add")
    public String postAdd(@Valid @ModelAttribute("sanPham") SanPham sanPham,
                          BindingResult result,
                          Model model) {
        if (result.hasErrors()) {
            return "/san-pham/view-add";
        } else if (sanPhamService.findByMa(sanPham.getMa()) != null) {
            model.addAttribute("errorMa", "Đã tồn tại mã này rồi");
            return "/san-pham/view-add";
        }
        sanPhamService.add(sanPham);
        return "redirect:/san-pham/hien-thi";
    }

    @GetMapping("remove/{id}")
    public String getRemove(@PathVariable("id") UUID uuid) {
        sanPhamService.remove(uuid);
        return "redirect:/san-pham/hien-thi";
    }

    @GetMapping("view-update/{id}")
    public String getUpdate(@PathVariable("id") UUID uuid, Model model) {
        SanPham detail = sanPhamService.detail(uuid);
        model.addAttribute("sanPham", detail);
        return "/san-pham/view-update";
    }

    @PostMapping("update/{id}")
    public String postUpdate(@Valid @ModelAttribute("sanPham") SanPham sanPham,
                             BindingResult result) {
        if (result.hasErrors()) {
            return "/san-pham/view-update";
        }
        sanPhamService.update(sanPham);
        return "redirect:/san-pham/hien-thi";
    }
}
