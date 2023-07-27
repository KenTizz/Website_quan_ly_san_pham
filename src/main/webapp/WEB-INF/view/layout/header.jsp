<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Cao Văn Doanh - PH22977</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css"/>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
</head>
<body>
<header>
    <nav class="navbar navbar-expand-lg bg-body-tertiary" style="padding: 0px">
        <div class="container-fluid" style="background-color: #6c95bc; padding: 0px">
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarScroll"
                    aria-controls="navbarScroll" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarScroll">
                <ul class="navbar-nav me-auto my-2 my-lg-0 navbar-nav-scroll" style="--bs-scroll-height: 100px;">
                    <li class="nav-item">
                        <a class="nav-link active" aria-current="page"
                           href="#"><i
                                class="fa-solid fa-house"></i> Trang chủ</a>
                    </li>
                    <li class="nav-item dropdown">
                        <a class="nav-link active dropdown-toggle" href="" role="button" data-bs-toggle="dropdown"
                           aria-expanded="false">
                            <i class="fa-solid fa-layer-group"></i> Quản lý
                        </a>
                        <ul class="dropdown-menu">
                            <li><a class="dropdown-item"
                                   href="/cua-hang/hien-thi"><i
                                    class="fa-solid fa-shop"></i> Cửa
                                hàng</a></li>
                            <li>
                                <hr class="dropdown-divider">
                            </li>
                            <li><a class="dropdown-item"
                                   href="/chuc-vu/hien-thi"><i
                                    class="fa-solid fa-chart-simple"></i> Chức
                                vụ</a></li>
                            <hr class="dropdown-divider">
                            </li>

                            <li><a class="dropdown-item"
                                   href="/nhan-vien/hien-thi"><i
                                    class="fa-sharp fa-solid fa-user-tie"></i> Nhân
                                viên</a></li>
                            <li>
                        </ul>
                    </li>
                    <li class="nav-item dropdown">
                        <a class="nav-link active dropdown-toggle" role="button" data-bs-toggle="dropdown"
                           aria-expanded="false">
                            <i class="fa-solid fa-box"></i> Sản phẩm
                        </a>
                        <ul class="dropdown-menu">
                            <li><a class="dropdown-item"
                                   href="/san-pham/hien-thi"><i
                                    class="fa-solid fa-box-open"></i> Sản
                                phẩm</a></li>
                            <li><a class="dropdown-item"
                                   href="/mau-sac/hien-thi"><i
                                    class="fa-solid fa-palette"></i> Màu
                                sắc</a></li>
                            <li><a class="dropdown-item"
                                   href="/nha-san-xuat/hien-thi"><i
                                    class="fa-solid fa-dice-d6"></i> Nhà
                                sản xuất</a></li>
                            <li><a class="dropdown-item"
                                   href="/dong-san-pham/hien-thi"><i
                                    class="fa-brands fa-red-river"></i> Dòng
                                sản phẩm</a></li>

                            <li>
                                <hr class="dropdown-divider">
                            </li>
                            <li><a class="dropdown-item"
                                   href="/chi-tiet-san-pham/hien-thi"><i
                                    class="fa-solid fa-cubes-stacked"></i> Chi
                                tiết sản phẩm</a></li>
                        </ul>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link active"
                           href="/khach-hang/hien-thi"><i
                                class="fa-solid fa-users"></i> Khách
                            hàng</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link active"
                           href="/hoa-don/hien-thi"><i
                                class="fa-solid fa-scroll"></i> Hóa đơn</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link active"
                           href="/ban-hang/hien-thi"><i
                                class="fa-brands fa-sellcast"></i> Bán hàng</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link active"
                           href="/login"><i
                                class="fa-solid fa-right-from-bracket"></i> Đăng xuất</a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
</header>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.min.js"
        integrity="sha384-fbbOQedDUMZZ5KreZpsbe1LCZPVmfTnH7ois6mU1QK+m14rQ1l2bGBq41eYeM/fS"
        crossorigin="anonymous"></script>
</body>
</html>
