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
  <div class="panel-heading" align="center">술 후기 게시판-게시글 작성</div>
  <div class="panel-body">
  	<div class="container">
  <p>게시글을 작성하는 곳입니다</p>
  <form action="/FortuneForAll/com.fortuneforall.drink.controller/DrinkInsertController">
  제목<br>
  <input type="text" name="title" />
  <br>
<br>
 <input type="file" name="file" />
 <br><br>
  <textarea rows="16" cols="200" name="content"></textarea>
  <button>저장</button>
  <button type="button" onclick="location.href='../Drink/drink.jsp'">취소</button>
  </form>
  </div>
  </div>
  </div>    
</body>
</html>