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
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "ChiTietSP")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ChiTietSanPham {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "Id")
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "IdSP", referencedColumnName = "Id", nullable = false)
    private SanPham idSP;

    @ManyToOne
    @JoinColumn(name = "IdNsx", referencedColumnName = "Id", nullable = false)
    private NhaSanXuat idNsx;

    @ManyToOne
    @JoinColumn(name = "IdMauSac", referencedColumnName = "Id", nullable = false)
    private MauSac idMauSac;

    @ManyToOne
    @JoinColumn(name = "IdDongSP", referencedColumnName = "Id", nullable = false)
    private DongSanPham idDongSP;

    @Column(name = "NamBH")
    @NotNull(message = "Bạn chưa điền năm bảo hành")
    private Integer namBH;

    @Column(name = "MoTa")
    @NotBlank(message = "Bạn chưa điền mô tả")
    private String moTa;

    @Column(name = "SoLuongTon")
    @NotNull(message = "Bạn chưa điền số lượng tồn")
    private Integer soLuongTon;

    @Column(name = "GiaNhap")
    @NotNull(message = "Bạn chưa điền giá nhập")
    private BigDecimal giaNhap;

    @Column(name = "GiaBan")
    @NotNull(message = "Bạn chưa điền giá bán")
    private BigDecimal giaBan;

}
