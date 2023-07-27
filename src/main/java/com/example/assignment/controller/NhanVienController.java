package com.example.assignment.controller;

import com.example.assignment.entity.ChucVu;
import com.example.assignment.entity.CuaHang;
import com.example.assignment.entity.NhanVien;
import com.example.assignment.service.ChucVuService;
import com.example.assignment.service.CuaHangService;
import com.example.assignment.service.NhanVienService;
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
@RequestMapping("/nhan-vien/")
public class NhanVienController {
    @Autowired
    private NhanVienService nhanVienService;
    @Autowired
    private ChucVuService chucVuService;
    @Autowired
    private CuaHangService cuaHangService;
    private Page<NhanVien> nhanVienList;
    private List<CuaHang> cuaHangList = new ArrayList<>();
    private List<ChucVu> chucVuList = new ArrayList<>();

    @GetMapping("hien-thi")
    public String getHienThi(Model model, @RequestParam(value = "page", defaultValue = "1") Integer number) {
        Pageable pageable = PageRequest.of(number - 1, 4);
        nhanVienList = nhanVienService.getAll(pageable);
        model.addAttribute("danhSach", nhanVienList);
        return "/nhan-vien/index";
    }

    @GetMapping("view-add")
    public String getAdd(Model model) {
        model.addAttribute("nhanVien", new NhanVien());
        chucVuList = chucVuService.getAll();
        model.addAttribute("chucVuList", chucVuList);
        cuaHangList = cuaHangService.getALL();
        model.addAttribute("cuaHangList", cuaHangList);
        return "/nhan-vien/view-add";
    }

    @PostMapping("add")
    public String postAdd(@Valid @ModelAttribute("nhanVien") NhanVien nhanVien,
                          BindingResult result,
                          Model model){

        if (result.hasErrors()) {
            model.addAttribute("chucVuList", chucVuList);
            model.addAttribute("cuaHangList", cuaHangList);
            return "/nhan-vien/view-add";
        } else if (nhanVienService.findByMa(nhanVien.getMa()) != null) {
            model.addAttribute("errosMa", "Trùng mã vui lòng điền mã khác");
            model.addAttribute("chucVuList", chucVuList);
            model.addAttribute("cuaHangList", cuaHangList);
            return "/nhan-vien/view-add";
        }
        nhanVienService.add(nhanVien);
        return "redirect:/nhan-vien/hien-thi";
    }

    @GetMapping("remove/{id}")
    public String remove(@PathVariable("id") UUID id) {
        nhanVienService.remove(id);
        return "redirect:/nhan-vien/hien-thi";
    }

    @GetMapping("view-update/{id}")
    public String viewUpdate(
            @PathVariable("id") UUID id,
            Model model
    ) {
        chucVuList = chucVuService.getAll();
        model.addAttribute("chucVuList", chucVuList);
        cuaHangList = cuaHangService.getALL();
        model.addAttribute("cuaHangList", cuaHangList);
        model.addAttribute("nhanVien", nhanVienService.detail(id));
        return "/nhan-vien/view-update";
    }

    @PostMapping("update/{id}")
    public String update(
            @Valid @ModelAttribute("nhanVien") NhanVien nhanVien,
            BindingResult result,
            Model model
    ) {
        if (result.hasErrors()) {
            model.addAttribute("chucVuList", chucVuList);
            model.addAttribute("cuaHangList", cuaHangList);
            return "/nhan-vien/view-update";
        }
        nhanVienService.update(nhanVien);
        return "redirect:/nhan-vien/hien-thi";
    }

}
