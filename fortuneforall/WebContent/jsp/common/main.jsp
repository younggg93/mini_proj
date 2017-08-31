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
      <a class="navbar-brand" href="main.jsp">ForfuneForAll</a>
    </div>
    <ul class="nav navbar-nav">
      <li class="active"><a href="main.jsp">Home</a></li>
      <li><a href="#">자유 게시판</a></li>
      <li><a href="/FortuneForAll/com.fortuneforall.drink.controller/DrinkSelectController">술 후기 게시판</a></li>
      <li><a href="#">술 안주 게시판</a></li>
      <li><a href="../Pub/pub.jsp">술집 후기 게시판</a></li>
      <li><a href="/FortuneForAll/com.fortuneforall.fortunereview.controller/FortuneReviewSelectController">운세 후기 게시판</a></li>
    </ul>
    <ul class="nav navbar-nav navbar-right">
      <li><a href="../Member/join.jsp"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
      <li><a href="../Member/login.jsp"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
    </ul>
  </div>
</nav>
  
  <div class="container">
  	<div class="jumbotron">
   	 <h1 style="text-align:center;">모두의 운세</h1> 
	<p align="center">date:
	<input type="date" value="1993-12-13" min="1980-01-01" max="2017-12-31">
	</p>
	<br>
	<p align="center">
	<button>결과 확인</button>
	</p>
 	</div>
  </div>
</body>
</html>