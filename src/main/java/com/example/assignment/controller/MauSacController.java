package com.example.assignment.controller;

import com.example.assignment.entity.MauSac;
import com.example.assignment.service.MauSacService;
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
@RequestMapping("/mau-sac/")
public class MauSacController {
    @Autowired
    private MauSacService mauSacService;

    @GetMapping("hien-thi")
    public String getHienThi(
            @RequestParam(value = "page", defaultValue = "1") Integer number,
            Model model) {
        Pageable pageable = PageRequest.of(number - 1, 2);
        Page<MauSac> mauSacPage = mauSacService.getAll(pageable);
        model.addAttribute("danhSach", mauSacPage);
        return "/mau-sac/index";
    }

    @GetMapping("view-add")
    public String getAdd(Model model) {
        model.addAttribute("mauSac", new MauSac());
        return "/mau-sac/view-add";
    }

    @PostMapping("add")
    public String postAdd(@Valid @ModelAttribute("mauSac") MauSac mauSac,
                          BindingResult result,
                          Model model) {
        if (result.hasErrors()) {
            return "/mau-sac/view-add";
        } else if (mauSacService.findByMa(mauSac.getMa()) != null) {
            model.addAttribute("errorMa", "Đã tồn tại mã này rồi");
            return "/mau-sac/view-add";
        }
        mauSacService.add(mauSac);
        return "redirect:/mau-sac/hien-thi";
    }

    @GetMapping("remove/{id}")
    public String getRemove(@PathVariable("id") UUID uuid) {
        mauSacService.remove(uuid);
        return "redirect:/mau-sac/hien-thi";
    }

    @GetMapping("view-update/{id}")
    public String getUpdate(@PathVariable("id") UUID uuid, Model model) {
        MauSac detail = mauSacService.detail(uuid);
        model.addAttribute("mauSac", detail);
        return "/mau-sac/view-update";
    }

    @PostMapping("update/{id}")
    public String postUpdate(@Valid @ModelAttribute("mauSac") MauSac mauSac,
                             BindingResult result) {
        if (result.hasErrors()) {
            return "/mau-sac/view-update";
        }
        mauSacService.update(mauSac);
        return "redirect:/mau-sac/hien-thi";
    }
}
