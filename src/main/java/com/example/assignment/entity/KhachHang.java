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
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import java.sql.Date;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "KhachHang")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class KhachHang {
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

    @Column(name = "TenDem")
    @NotBlank(message = "Bạn chưa điền tên đệm")
    private String tenDem;

    @Column(name = "Ho")
    @NotBlank(message = "Bạn chưa điền họ")
    private String ho;

    @Column(name = "NgaySinh")
    @NotNull(message = "Bạn chưa điền ngày sinh")
    private Date ngaySinh;

    @Column(name = "Sdt")
    @NotBlank(message = "Bạn chưa điền số điện thoại")
    private String sdt;

    @Column(name = "DiaChi")
    @NotBlank(message = "Bạn chưa điền địa chỉ")
    private String diaChi;

    @Column(name = "ThanhPho")
    @NotBlank(message = "Bạn chưa điền thành phố")
    private String thanhPho;

    @Column(name = "QuocGia")
    @NotBlank(message = "Bạn chưa điền quốc gia")
    private String quocGia;

    @Column(name = "MatKhau")
    @NotBlank(message = "Bạn chưa điền mật khẩu")
    private String matKhau;

}
