package com.example.assignment.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.UUID;


@Entity
@Table(name = "CuaHang")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CuaHang {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "Id")
    private UUID id;

    @Column(name = "Ma")
    @NotBlank(message = "Bạn chưa điền mã")
    private String ma;

    @Column(name = "Ten")
    @NotBlank(message = "Bạn chưa điền tên")
    private String ten;

    @Column(name = "DiaChi")
    @NotBlank(message = "Bạn chưa điền địa chỉ")
    private String diaChi;

    @Column(name = "ThanhPho")
    @NotBlank(message = "Bạn chưa điền thành phố")
    private String thanhPho;

    @Column(name = "QuocGia")
    @NotBlank(message = "Bạn chưa điền quốc gia")
    private String quocGia;

    @OneToMany(mappedBy = "cuaHang", fetch = FetchType.LAZY)
    List<NhanVien> listNhanVien;
}
