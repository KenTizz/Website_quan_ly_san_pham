<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Cao Văn Doanh - PH22977</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet"
          crossorigin="anonymous">
</head>
<body>
<h1 style="text-align: center">UPDATE NHÂN VIÊN</h1>
<%--@elvariable id="nhanVien" type=""--%>
<form:form action="/nhan-vien/update/${nhanVien.id}" method="post" modelAttribute="nhanVien">
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
    Giới tính:
    <form:radiobutton path="gioiTinh" value="Nam" checked="flase"/>Nam
    <form:radiobutton path="gioiTinh" value="Nữ"/>Nữ
    <form:errors path="gioiTinh" cssStyle="font-size: 12px;color: red"/>
    <br>
    <br>
    Chức vụ:
    <form:select path="chucVu" class="form-select">
        <c:forEach items="${chucVuList}" var="cv">
            <form:option value="${cv.id}">${cv.ten}</form:option>
        </c:forEach>
    </form:select>
    <form:errors path="chucVu" cssStyle="font-size: 12px;color: red"/>
    <br>
    Cửa hàng:
    <form:select path="cuaHang" class="form-select">
        <c:forEach items="${cuaHangList}" var="cv">
            <form:option value="${cv.id}">${cv.ten}</form:option>
        </c:forEach>
    </form:select>
    <form:errors path="cuaHang" cssStyle="font-size: 12px;color: red"/>
    <br>
    Năm sinh: <form:input type="date" path="ngaySinh" class="form-control"/>
    <form:errors path="ngaySinh" cssStyle="font-size: 12px;color: red"/>
    <br>
    Địa chỉ: <form:input path="diaChi" class="form-control"/>
    <form:errors path="diaChi" cssStyle="font-size: 12px;color: red"/>
    <br>
    Số điện thoại: <form:input path="sdt" class="form-control"/>
    <form:errors path="sdt" cssStyle="font-size: 12px;color: red"/>
    <br>
    Mật khẩu: <form:input path="matKhau" class="form-control"/>
    <form:errors path="matKhau" cssStyle="font-size: 12px;color: red"/>
    <br>
    <form:button type="submit" class="btn btn-success">Update</form:button>
</form:form>
</body>
</html>