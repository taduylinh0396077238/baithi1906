<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../common/taglib.jsp"%>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css">
<html>
<head>
    <title>Title</title>
    <%@include file="../common/resource.jsp"%>
</head>
<body>
<%@include file="../common/sidebar.jsp"%>
<div class="container-fluid" style="margin-top: 40px;">
    <div>
        <button class="btn btn-primary">
            <a style="text-decoration: none; color: white" href="${pageContext.request.contextPath}/create">Create </a>
        </button>
    </div>
    <table class="table">
        <thead class="thead-dark">
        <tr>
            <th scope="col">Name</th>
            <th scope="col">Price</th>
            <th scope="col">Length</th>
            <th scope="col">Width</th>
            <th scope="col">Height</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="item" items="${employees}">
            <tr>
                <td>${item.fullname}</td>
                <td>${item.birthday}</td>
                <td>${item.address}</td>
                <td>${item.position}</td>
                <td>${item.department}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
