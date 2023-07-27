package com.example.assignment.controller;

import com.example.assignment.entity.ChucVu;
import com.example.assignment.service.ChucVuService;
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
@RequestMapping("/chuc-vu/")
public class ChucVuController {
    @Autowired
    private ChucVuService chucVuService;

    @GetMapping("hien-thi")
    public String getHienThi(
            @RequestParam(value = "page", defaultValue = "1") Integer number,
            Model model) {
        Pageable pageable = PageRequest.of(number - 1, 2);
        Page<ChucVu> chucVuPage = chucVuService.getAll(pageable);
        model.addAttribute("danhSach", chucVuPage);
        return "/chuc-vu/index";
    }

    @GetMapping("view-add")
    public String getAdd(Model model) {
        model.addAttribute("chucVu", new ChucVu());
        return "/chuc-vu/view-add";
    }

    @PostMapping("add")
    public String postAdd(@Valid @ModelAttribute("chucVu") ChucVu chucVu,
                          BindingResult result,
                          Model model) {
        if (result.hasErrors()) {
            return "/chuc-vu/view-add";
        } else if (chucVuService.findByMa(chucVu.getMa()) != null) {
            model.addAttribute("errorMa", "Đã tồn tại mã này rồi");
            return "/chuc-vu/view-add";
        }
        chucVuService.add(chucVu);
        return "redirect:/chuc-vu/hien-thi";
    }

    @GetMapping("remove/{id}")
    public String getRemove(@PathVariable("id") UUID uuid) {
        chucVuService.remove(uuid);
        return "redirect:/chuc-vu/hien-thi";
    }

    @GetMapping("view-update/{id}")
    public String getUpdate(@PathVariable("id") UUID uuid, Model model) {
        ChucVu detail = chucVuService.detail(uuid);
        model.addAttribute("chucVu", detail);
        return "/chuc-vu/view-update";
    }

    @PostMapping("update/{id}")
    public String postUpdate(@Valid @ModelAttribute("chucVu") ChucVu chucVu,
                             BindingResult result) {
        if (result.hasErrors()) {
            return "/chuc-vu/view-update";
        }
        chucVuService.update(chucVu);
        return "redirect:/chuc-vu/hien-thi";
    }
}
