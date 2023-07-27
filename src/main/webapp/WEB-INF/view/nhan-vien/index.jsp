<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Menu</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css"/>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
</head>
<body>
<%@ include file="/WEB-INF/view/layout/header.jsp" %>
<h1 style="text-align: center">QUẢN LÝ NHÂN VIÊN</h1>
<a style="margin: 20px" href="/nhan-vien/view-add" type="button"
   class="btn btn-primary"><i class="fa-solid fa-user-plus"></i> Add</a>

<table class="table table-hover">
    <thead>
    <tr class="table-warning">
        <th>#</th>
        <th>Mã</th>
        <th>Họ và tên</th>
        <th>Giới tính</th>
        <th>Ngày sinh</th>
        <th>Chức vụ</th>
        <th>Cửa Hàng</th>
        <th>Địa chỉ</th>
        <th>SĐT</th>
        <th>Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${danhSach.content}" var="nv" varStatus="stt">
        <tr>
            <td scope="row">${stt.index + 1}</td>
            <td>${nv.ma}</td>
            <td>${nv.ho} ${nv.tenDem} ${nv.ten}</td>
            <td>${nv.gioiTinh}</td>
            <td>${nv.ngaySinh}</td>
            <td>${nv.chucVu.ten}</td>
            <td>${nv.cuaHang.ten}</td>
            <td>${nv.diaChi}</td>
            <td>${nv.sdt}</td>
            <td>
                <a href="/nhan-vien/view-update/${nv.id}"
                   class="btn btn-warning btn-sm"><i class="fa-solid fa-pen-to-square"></i></a>
                <a href="/nhan-vien/remove/${nv.id}"
                   class="btn btn-danger btn-sm"><i class="fa-solid fa-trash-can" style="color: black"></i></a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<nav aria-label="Page navigation example">
    <ul class="pagination justify-content-center">
        <li class="page-item">
            <a class="page-link" href="/nhan-vien/hien-thi?page=1">Trước</a>
        </li>
        <c:forEach begin="0" end="${danhSach.totalPages -1}" varStatus="loop">
            <li class="page-item">
                <a class="page-link"
                   href="/nhan-vien/hien-thi?page=${loop.index + 1}">${loop.index + 1}</a>
            </li>
        </c:forEach>
        <li class="page-item">
            <a class="page-link" href="/nhan-vien/hien-thi?page=${danhSach.totalPages}">Sau</a>
        </li>
    </ul>
</nav>
<%@ include file="/WEB-INF/view/layout/footer.jsp" %>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz"
        crossorigin="anonymous"></script>
</body>
</html>