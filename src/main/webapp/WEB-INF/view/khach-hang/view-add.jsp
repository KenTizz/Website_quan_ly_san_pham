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
<h1 style="text-align: center">QUẢN LÝ Khách Hàng</h1>
<%--@elvariable id="khachHang" type=""--%>
<form:form action="/khach-hang/add" method="post" modelAttribute="khachHang">
    Mã: <form:input path="ma" class="form-control"/>
    <form:errors path="ma" cssStyle="font-size: 12px;color: red"/>
    <span style="font-size: 12px;color: red">${errosMa}</span>
    <br>
    Họ: <form:input path="ho" class="form-control"/>
    <form:errors path="ho" cssStyle="font-size: 12px;color: red"/>
    <br>
    Tên Đệm: <form:input path="tenDem" class="form-control"/>
    <form:errors path="tenDem" cssStyle="font-size: 12px;color: red"/>
    <br>
    Tên: <form:input path="ten" class="form-control"/>
    <form:errors path="ten" cssStyle="font-size: 12px;color: red"/>
    <br>
    Năm sinh: <form:input type="date" path="ngaySinh" class="form-control"/>
    <form:errors path="ngaySinh" cssStyle="font-size: 12px;color: red"/>
    <br>
    Số điện thoại: <form:input path="sdt" class="form-control"/>
    <form:errors path="sdt" cssStyle="font-size: 12px;color: red"/>
    <br>
    Địa chỉ: <form:input path="diaChi" class="form-control"/>
    <form:errors path="diaChi" cssStyle="font-size: 12px;color: red"/>
    <br>
    Thành phố: <form:input path="thanhPho" class="form-control"/>
    <form:errors path="thanhPho" cssStyle="font-size: 12px;color: red"/>
    <br>
    Quốc gia: <form:input path="quocGia" class="form-control"/>
    <form:errors path="quocGia" cssStyle="font-size: 12px;color: red"/>
    <br>
    Mật khẩu: <form:input path="matKhau" class="form-control"/>
    <form:errors path="matKhau" cssStyle="font-size: 12px;color: red"/>
    <br>
    <form:button type="submit" class="btn btn-success">Add</form:button>
</form:form>
<%@ include file="/WEB-INF/view/layout/footer.jsp" %>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz"
        crossorigin="anonymous"></script>
</body>
</html>