<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../common/taglib.jsp"%>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css">
<html>
<head>
    <title>Create new employee</title>
    <%@include file="../common/resource.jsp"%>
</head>
<body>
<%@include file="../common/sidebar.jsp"%>
<form  method="post" action="${pageContext.request.contextPath}/create">
    <div class="form-group">
        <label for="exampleInputEmail1">Employee name</label>
        <input type="text" name="fullname" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter fullname">
    </div>
    <div class="form-group">
        <label for="exampleInputPassword1">Birthday</label>
        <input type="date" name="birthday" class="form-control" id="exampleInputPassword1" placeholder="Enter birthday">
    </div>
    <div class="form-group">
        <label for="exampleInputAddress1">Address</label>
        <input type="text" name="address" class="form-control" id="exampleInputAddress1"  placeholder="Enter address">
    </div>
    <div class="form-group">
        <label for="exampleInputposition1">Position</label>
        <input type="text" name="position" class="form-control" id="exampleInputposition1" placeholder="Enter position">
    </div>
    <div class="form-group">
        <label for="exampleInputdepartment1">Department</label>
        <input type="text" name="department" class="form-control" id="exampleInputdepartment1" placeholder="Enter department">
    </div>
    <button type="submit" class="btn btn-primary">Submit</button>
    <button type="reset" class="btn btn-danger">Reset</button>
</form>

</body>
</html>
