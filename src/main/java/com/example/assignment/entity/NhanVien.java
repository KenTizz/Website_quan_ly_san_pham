package com.example.assignment.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;
import java.util.List;
import java.util.UUID;


@Entity
@Table(name = "NhanVien")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class NhanVien {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "Id")
    private UUID id;

    @Column(name = "Ma")
    @NotBlank(message = "Bạn chưa điền mã")
    private String ma;

    @Column(name = "Ho")
    @NotBlank(message = "Bạn chưa điền họ")
    private String ho;

    @Column(name = "TenDem")
    @NotBlank(message = "Bạn chưa điền tên đệm")
    private String tenDem;

    @Column(name = "Ten")
    @NotBlank(message = "Bạn chưa điền tên")
    private String ten;

    @Column(name = "GioiTinh")
    @NotBlank(message = "Bạn chưa chọn giới tính")
    private String gioiTinh;

    @Column(name = "NgaySinh")
    @NotNull(message = "Bạn chưa điền ngày sinh")
    private Date ngaySinh;

    @Column(name = "DiaChi")
    @NotBlank(message = "Bạn chưa điền địa chỉ")
    private String diaChi;

    @Column(name = "Sdt")
    @NotBlank(message = "Bạn chưa điền số điện thoại")
    private String sdt;

    @Column(name = "MatKhau")
    @NotBlank(message = "Mật khẩu không được để trống")
    @Size(max = 50, message = "Mật khẩu không được vượt quá 50 ký tự")
    private String matKhau;

    @ManyToOne
    @JoinColumn(name = "IdCV", referencedColumnName = "Id", nullable = false)
    private ChucVu chucVu;

    @ManyToOne
    @JoinColumn(name = "IdCH", referencedColumnName = "Id", nullable = false)
    private CuaHang cuaHang;

    @OneToOne
    @JoinColumn(name = "IdGuiBC", referencedColumnName = "Id", nullable = true)
    private NhanVien idGuiBC;

    @Column(name = "TrangThai")
    @NotNull(message = "Bạn chưa chọn trạng thái")
    private Integer trangThai;

}
