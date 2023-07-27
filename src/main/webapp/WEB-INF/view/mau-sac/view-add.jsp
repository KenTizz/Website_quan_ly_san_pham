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
<h1 style="text-align: center">QUẢN LÝ màu sắc</h1>
<%--@elvariable id="mauSac" type=""--%>
<form:form action="/mau-sac/add" method="post" modelAttribute="mauSac">
    <div class="row">
        <div class="col-md-4">
        </div>
        <div class="col-md-4">
            <label class="form-label">Mã màu sắc</label>
            <form:input path="ma" class="form-control"/>
            <form:errors path="ma" cssStyle="color: red"/>
            <span style="color: red">${errorMa}</span>
        </div>
    </div>
    <br>
    <div class="row">
        <div class="col-md-4">
        </div>
        <div class="col-md-4">
            <label class="form-label">Tên màu sắc</label>
            <form:input path="ten" class="form-control"/>
            <form:errors path="ten" cssStyle="color: red"/>
            <br>
            <form:button type="submit" class="btn btn-success">Add</form:button>
        </div>
    </div>
</form:form>
<%@ include file="/WEB-INF/view/layout/footer.jsp" %>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz"
        crossorigin="anonymous"></script>
</body>
</html>