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
@Table(name = "ChucVu")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ChucVu {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "Id")
    private UUID id;

    @NotBlank(message = "Bạn chưa điền mã")
    @Column(name = "Ma")
    private String ma;

    @NotBlank(message = "Bạn chưa điền tên")
    @Column(name = "Ten")
    private String ten;

    @OneToMany(mappedBy = "chucVu", fetch = FetchType.LAZY)
    List<NhanVien> listNhanVien;

}
