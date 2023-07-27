<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Cao Văn Doanh - PH22977</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css"/>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet"
          crossorigin="anonymous">
</head>
<body>
<%@ include file="/WEB-INF/view/layout/header.jsp" %>
<a style="margin: 20px" href="/cua-hang/view-add" type="button"
   class="btn btn-primary"><i class="fa-solid fa-user-plus"></i> Add</a>
<table class="table table-hover">
    <thead>
    <tr class="table-secondary">
        <th scope="col">STT</th>
        <th scope="col">Mã Cửa Hàng</th>
        <th scope="col">Tên Cửa Hàng</th>
        <th scope="col">Địa Chỉ</th>
        <th scope="col">Thành Phố</th>
        <th scope="col">Quốc Gia</th>
        <th scope="col">Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${danhSach.content}" var="cv" varStatus="stt">
        <tr>
            <th scope="row">${stt.index + 1}</th>
            <td>${cv.ma}</td>
            <td>${cv.ten}</td>
            <td>${cv.diaChi}</td>
            <td>${cv.thanhPho}</td>
            <td>${cv.quocGia}</td>
            <td>
                <a href="/cua-hang/view-update/${cv.id}"
                   class="btn btn-warning btn-sm"><i class="fa-solid fa-pen-to-square"></i></a>
                <a href="/cua-hang/remove/${cv.id}"
                   class="btn btn-danger btn-sm"><i class="fa-solid fa-trash-can" style="color: black"></i></a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<nav aria-label="Page navigation example">
    <ul class="pagination justify-content-center">
        <li class="page-item">
            <a class="page-link" href="/cua-hang/hien-thi?page=1">Trước</a>
        </li>
        <c:forEach begin="0" end="${danhSach.totalPages -1}" varStatus="loop">
            <li class="page-item">
                <a class="page-link"
                   href="/cua-hang/hien-thi?page=${loop.index + 1}">${loop.index + 1}</a>
            </li>
        </c:forEach>
        <li class="page-item">
            <a class="page-link" href="/cua-hang/hien-thi?page=${danhSach.totalPages}">Sau</a>
        </li>
    </ul>
</nav>
<%@ include file="/WEB-INF/view/layout/footer.jsp" %>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz"
        crossorigin="anonymous"></script>
</body>
</html>