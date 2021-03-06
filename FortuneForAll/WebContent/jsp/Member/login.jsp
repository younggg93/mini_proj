<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewpoint" content="width=device-width", initial-sacle="1">
<link rel="stylesheet" href="../../css/bootstrap.css">
<title>운세 프로젝트</title>
</head>
<body>
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="../common/main.html">ForfuneForAll</a>
    </div>
    <ul class="nav navbar-nav">
      <li class="active"><a href="../common/main.html">Home</a></li>
      <li><a href="#">자유 게시판</a></li>
      <li><a href="#">술 후기 게시판</a></li>
      <li><a href="#">술 안주 게시판</a></li>
      <li><a href="#">술집 후기 게시판</a></li>
      <li><a href="#">운세 후기 게시판</a></li>
    </ul>
    <ul class="nav navbar-nav navbar-right">
      <li><a href="join.html"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
      <li><a href="login.html"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
    </ul>
  </div>
</nav>
   <div class="container">
      <div class="col-lg-4"></div>
      <div class="col-lg-4">
         <div class="jumbotron" style="padding-top: 20px;">
            <form method="post" action="loginAction.jsp">
               <h3 style="text-align: center;">로그인 화면</h3>
               <div class="form-group">
                 <input type="text" class="form-control" placeholder="아이디"  name="userID" maxlength="20">
               </div>
               
               <div class="form-group">
                 <input type="password" class="form-control" placeholder="비밀번호"  name="userPassword" maxlength="20">
               </div>
               <input type="submit" class="btn btn-primary form-control" value="로그인">
            </form>
         </div>
      </div>
   </div>
   <script src="http://code.jquery.com/jquery-3.1.1.min.js"></script>
   <script src="../../js/bootstrap.js"></script>
</body>
</html>