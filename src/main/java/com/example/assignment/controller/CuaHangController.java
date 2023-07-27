package com.example.assignment.controller;

import com.example.assignment.entity.CuaHang;
import com.example.assignment.service.CuaHangService;
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
@RequestMapping("/cua-hang/")
public class CuaHangController {
    @Autowired
    private CuaHangService cuaHangService;

    @GetMapping("hien-thi")
    public String getHienThi(@RequestParam(value = "page", defaultValue = "1") Integer number,
                             Model model) {
        Pageable pageable = PageRequest.of(number - 1, 5);
        Page<CuaHang> cuaHangPage = cuaHangService.getAll(pageable);
        model.addAttribute("danhSach", cuaHangPage);
        return "/cua-hang/index";
    }

    @GetMapping("view-add")
    public String getAdd(Model model) {
        model.addAttribute("cuaHang", new CuaHang());
        return "/cua-hang/view-add";
    }

    @PostMapping("add")
    public String postAdd(@Valid @ModelAttribute("cuaHang") CuaHang cuaHang,
                          BindingResult result,
                          Model model) {
        if (result.hasErrors()) {
            return "/cua-hang/view-add";
        } else if (cuaHangService.findByMa(cuaHang.getMa()) != null) {
            model.addAttribute("errorMa", "Đã tồn tại mã này rồi");
            return "/cua-hang/view-add";
        }
        cuaHangService.add(cuaHang);
        return "redirect:/cua-hang/hien-thi";
    }

    @GetMapping("remove/{id}")
    public String getRemove(@PathVariable("id") UUID uuid) {
        cuaHangService.remove(uuid);
        return "redirect:/cua-hang/hien-thi";
    }

    @GetMapping("view-update/{id}")
    public String getUpdate(@PathVariable("id") UUID uuid, Model model) {
        CuaHang detail = cuaHangService.detail(uuid);
        model.addAttribute("cuaHang", detail);
        return "/cua-hang/view-update";
    }

    @PostMapping("update/{id}")
    public String postUpdate(@Valid @ModelAttribute("cuaHang") CuaHang cuaHang,
                             BindingResult result) {
        if (result.hasErrors()) {
            return "/cua-hang/view-update";
        }
        cuaHangService.update(cuaHang);
        return "redirect:/cua-hang/hien-thi";
    }

}
