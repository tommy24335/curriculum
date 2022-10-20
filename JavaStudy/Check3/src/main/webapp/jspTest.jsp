<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/style.css">
<title>Insert title here</title>
<%@ include file = "header.jsp" %>

</head>
<body>

<!-- name、idの入力エリアを作成しなさい -->
<div class = "name">
  <label for = "name">name</label>
  <input type = "text"><br>
  <label class = "id">id</label>
  <input type = "text" class = "id-form">
</div>
<%@ include file = "footer.jsp" %>
</body>
</html>