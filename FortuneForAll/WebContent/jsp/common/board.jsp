<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	
	<!-- 합쳐지고 최소화된 최신 CSS -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
	
	<!-- 부가적인 테마 -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
	
	<!-- 합쳐지고 최소화된 최신 자바스크립트 -->
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
	
</head>
<body>
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="main.html">ForfuneForAll</a>
    </div>
    <ul class="nav navbar-nav">
      <li class="active"><a href="main.html">Home</a></li>
      <li><a href="#">자유 게시판</a></li>
      <li><a href="../Drink/drink.html">술 후기 게시판</a></li>
      <li><a href="#">술 안주 게시판</a></li>
      <li><a href="../Pub/pub.html">술집 후기 게시판</a></li>
      <li><a href="#">운세 후기 게시판</a></li>
    </ul>
    <ul class="nav navbar-nav navbar-right">
      <li><a href="../Member/join.html"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
      <li><a href="../Member/login.html"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
    </ul>
  </div>
</nav>

<div class="panel panel-default">
  <div class="panel-heading" align="center">술 후기 게시판-게시글</div>
  <div class="panel-body">
  	<div class="container">
  제목<br>
  룰루랄라룰루리 엥에에에에에에에에
  <br>
<br>
<div class="w3-container"> 
  <p>The w3-container class is one of the most important of the w3.CSS classes. It provides correct margins, padding, alignments, and more to common HTML elements.</p>
  <p>The w3-container class is one of the most important of the w3.CSS classes. It provides correct margins, padding, alignments, and more to common HTML elements.</p>
  <p>The w3-container class is one of the most important of the w3.CSS classes. It provides correct margins, padding, alignments, and more to common HTML elements.</p>
</div>
  <br>
  	 <table class="table table-striped">
  	 <thead>
      <tr>
        <th>내용</th>
        <th>작성자</th>
      </tr>
    </thead>
    <tbody>
      <tr>
        <td>여기에 댓글이 나올 듯</td>
        <td>나</td>
      </tr>
      <tr>
        <td>여기에 댓글이 나올 듯</td>
        <td>나</td>
      </tr>
    </tbody>
  </table>
  <textarea rows="1" cols="130"></textarea>
  <button type="button" onclick="location.href='drink.jsp'">수정</button>
  <button type="button" onclick="location.href='drink.jsp'">삭제</button>
  <br><br>
  <p align="left">
  <button type="button"  onclick="location.href='../Drink/drink.jsp'">목록으로</button>
  </p>
  <p align="right">
  <button type="button"  onclick="location.href='../Drink/drink.jsp'">수정</button>
  <button type="button" onclick="location.href='../Drink/drink.jsp'">삭제</button>
  </p></div>
  </div>
  </div>  
</body>
</html>