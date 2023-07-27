package com.example.assignment.controller;

import com.example.assignment.entity.ChiTietSanPham;
import com.example.assignment.entity.DongSanPham;
import com.example.assignment.entity.MauSac;
import com.example.assignment.entity.NhaSanXuat;
import com.example.assignment.entity.SanPham;
import com.example.assignment.service.ChiTietSanPhamService;
import com.example.assignment.service.DongSanPhamService;
import com.example.assignment.service.MauSacService;
import com.example.assignment.service.NhaSanXuatService;
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

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/chi-tiet-san-pham/")
public class ChiTietSanPhamController {
    @Autowired
    private ChiTietSanPhamService chiTietSanPhamService;
    @Autowired
    private SanPhamService sanPhamService;
    @Autowired
    private MauSacService mauSacService;
    @Autowired
    private DongSanPhamService dongSanPhamService;
    @Autowired
    private NhaSanXuatService nhaSanXuatService;
    private List<SanPham> sanPhamList = new ArrayList<>();
    private List<MauSac> mauSacList = new ArrayList<>();
    private List<DongSanPham> dongSanPhamList = new ArrayList<>();
    private List<NhaSanXuat> nhaSanXuatList = new ArrayList<>();

    @GetMapping("hien-thi")
    public String getHienThi(
            @RequestParam(value = "page", defaultValue = "1") Integer number,
            Model model) {
        Pageable pageable = PageRequest.of(number - 1, 2);
        Page<ChiTietSanPham> ChiTietSanPhamPage = chiTietSanPhamService.getAll(pageable);
        model.addAttribute("danhSach", ChiTietSanPhamPage);
        return "/chi-tiet-san-pham/index";
    }

    @GetMapping("view-add")
    public String getAdd(Model model) {
        model.addAttribute("chiTietSanPham", new ChiTietSanPham());
        sanPhamList = sanPhamService.getAll();
        model.addAttribute("sanPhamList", sanPhamList);
        mauSacList = mauSacService.getAll();
        model.addAttribute("mauSacList", mauSacList);
        dongSanPhamList = dongSanPhamService.getAll();
        model.addAttribute("dongSanPhamList", dongSanPhamList);
        nhaSanXuatList = nhaSanXuatService.getAll();
        model.addAttribute("nhaSanXuatList", nhaSanXuatList);
        return "/chi-tiet-san-pham/view-add";
    }

    @PostMapping("add")
    public String postAdd(@Valid @ModelAttribute("chiTietSanPham") ChiTietSanPham chiTietSanPham,
                          BindingResult result,
                          Model model) {
        if (result.hasErrors()) {
            model.addAttribute("chiTietSanPham", new ChiTietSanPham());
            sanPhamList = sanPhamService.getAll();
            model.addAttribute("sanPhamList", sanPhamList);
            mauSacList = mauSacService.getAll();
            model.addAttribute("mauSacList", mauSacList);
            dongSanPhamList = dongSanPhamService.getAll();
            model.addAttribute("dongSanPhamList", dongSanPhamList);
            nhaSanXuatList = nhaSanXuatService.getAll();
            model.addAttribute("nhaSanXuatList", nhaSanXuatList);
            return "/chi-tiet-san-pham/view-add";
        }
        chiTietSanPhamService.add(chiTietSanPham);
        return "redirect:/chi-tiet-san-pham/hien-thi";
    }

    @GetMapping("remove/{id}")
    public String getRemove(@PathVariable("id") UUID uuid) {
        chiTietSanPhamService.remove(uuid);
        return "redirect:/chi-tiet-san-pham/hien-thi";
    }

    @GetMapping("view-update/{id}")
    public String getUpdate(@PathVariable("id") UUID uuid, Model model) {
        sanPhamList = sanPhamService.getAll();
        model.addAttribute("sanPhamList", sanPhamList);
        mauSacList = mauSacService.getAll();
        model.addAttribute("mauSacList", mauSacList);
        dongSanPhamList = dongSanPhamService.getAll();
        model.addAttribute("dongSanPhamList", dongSanPhamList);
        nhaSanXuatList = nhaSanXuatService.getAll();
        model.addAttribute("nhaSanXuatList", nhaSanXuatList);
        ChiTietSanPham detail = chiTietSanPhamService.detail(uuid);
        model.addAttribute("chiTietSanPham", detail);
        return "/chi-tiet-san-pham/view-update";
    }

    @PostMapping("update/{id}")
    public String postUpdate(@Valid @ModelAttribute("chiTietSanPham") ChiTietSanPham chiTietSanPham,
                             BindingResult result,Model model) {
        if (result.hasErrors()) {
            model.addAttribute("chiTietSanPham", new ChiTietSanPham());
            sanPhamList = sanPhamService.getAll();
            model.addAttribute("sanPhamList", sanPhamList);
            mauSacList = mauSacService.getAll();
            model.addAttribute("mauSacList", mauSacList);
            dongSanPhamList = dongSanPhamService.getAll();
            model.addAttribute("dongSanPhamList", dongSanPhamList);
            nhaSanXuatList = nhaSanXuatService.getAll();
            model.addAttribute("nhaSanXuatList", nhaSanXuatList);
            return "/chi-tiet-san-pham/view-update";
        }
        chiTietSanPhamService.update(chiTietSanPham);
        return "redirect:/chi-tiet-san-pham/hien-thi";
    }
}
