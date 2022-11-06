<!-- pageディレクティブ -->
<!-- 言語の指定、データ型・文字コードの指定、文字コードの指定 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- CSSファイルを読み込むコード -->
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/style.css">
<title>Insert title here</title>
<!-- includeディレクティブ -->
<!-- 他のJSPファイルを読み込む -->
<%@ include file = "header.jsp" %>

</head>
<body>

<!-- name、idの入力エリアを作成しなさい -->
<div class = "form">
  <!-- labelタグ：入力フォームやチェックボックスを関連付けるためのタグ -->
  <label class = "name">name</label>
  <!-- inputタグ：入力欄やボタンなどの部品を作成するタグ -->
  <!-- 入力された情報は、データとしてサーバに送信される -->
  <input type = "text"><br>
  <label class = "id">id</label>
  <input type = "text" class = "id-form">
</div>
<%@ include file = "footer.jsp" %>
</body>
</html>