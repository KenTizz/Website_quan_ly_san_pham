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
<h1 style="text-align: center">ADD Chi Tiết Sản Phẩm</h1>
<%--@elvariable id="chiTietSanPham" type=""--%>
<form:form action="/chi-tiet-san-pham/add" method="post" modelAttribute="chiTietSanPham">
    Sản phẩm:
    <form:select path="idSP" class="form-select">
        <c:forEach items="${sanPhamList}" var="cv">
            <form:option value="${cv.id}">${cv.ten}</form:option>
        </c:forEach>
    </form:select>
    <br>
    Màu sắc:
    <form:select path="idMauSac" class="form-select">
        <c:forEach items="${mauSacList}" var="cv">
            <form:option value="${cv.id}">${cv.ten}</form:option>
        </c:forEach>
    </form:select>
    <br>
    Dòng sản phẩm:
    <form:select path="idDongSP" class="form-select">
        <c:forEach items="${dongSanPhamList}" var="cv">
            <form:option value="${cv.id}">${cv.ten}</form:option>
        </c:forEach>
    </form:select>
    <br>
    Nhà sản xuất:
    <form:select path="idNsx" class="form-select">
        <c:forEach items="${nhaSanXuatList}" var="cv">
            <form:option value="${cv.id}">${cv.ten}</form:option>
        </c:forEach>
    </form:select>
    <br>
    Năm Bảo Hành: <form:input type="number" path="namBH" class="form-control"/>
    <form:errors path="namBH" cssStyle="font-size: 12px;color: red"/>
    <br>
    Năm Số Lượng Tồn: <form:input type="number" path="soLuongTon" class="form-control"/>
    <form:errors path="soLuongTon" cssStyle="font-size: 12px;color: red"/>
    <br>
    Giá Nhập: <form:input type="number" path="giaNhap" class="form-control"/>
    <form:errors path="giaNhap" cssStyle="font-size: 12px;color: red"/>
    <br>
    Giá Bán: <form:input type="number" path="giaBan" class="form-control"/>
    <form:errors path="giaBan" cssStyle="font-size: 12px;color: red"/>
    <br>
    Mô tả: <form:input path="moTa" class="form-control"/>
    <form:errors path="moTa" cssStyle="font-size: 12px;color: red"/>
    <br>
    <form:button type="submit" class="btn btn-success">Add</form:button>
</form:form>
<%@ include file="/WEB-INF/view/layout/footer.jsp" %>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz"
        crossorigin="anonymous"></script>
</body>
</html>