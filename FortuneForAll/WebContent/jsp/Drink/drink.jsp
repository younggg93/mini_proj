<%@page import="java.util.ArrayList"%>
<%@page import="com.fortuneforall.drink.domain.Drink"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	List<Drink> d = (List<Drink>)request.getAttribute("board");
 %>
   <%--List<Drink> list = (List<Drink>)request.getAttribute("board"); --%>
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
	
	<style>

	</style>
</head>
<body>
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="../common/main.jsp">ForfuneForAll</a>
    </div>
    <ul class="nav navbar-nav">
      <li class="active"><a href="../common/main.jsp">Home</a></li>
      <li><a href="#">자유 게시판</a></li>
      <li><a href="../Drink/drink.jsp">술 후기 게시판</a></li>
      <li><a href="#">술 안주 게시판</a></li>
      <li><a href="../Pub/pub.jsp">술집 후기 게시판</a></li>
      <li><a href="#">운세 후기 게시판</a></li>
    </ul>
    <ul class="nav navbar-nav navbar-right">
      <li><a href="../Member/join.html"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
      <li><a href="../Member/login.html"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
    </ul>
  </div>
</nav>

  <div class="panel panel-default">
  <div class="panel-heading" align="center">술 후기 게시판</div>
  <div class="panel-body">
  	<div class="container">
  <p>술에 대한 후기를 작성하는 게시판입니다
  <%=d.get(0).getBoard_no() %>
  </p>            
  <table class="table table-hover">
    <thead>
      <tr>
        <th>글 번호</th>
        <th>제목</th>
        <th>작성자</th>
        <th>등록일</th>
      </tr>
    </thead>
    <tbody>
    
    <%
    	for(int i=0;i<d.size();i++) {
    		%>
    		<tr>
    		<td><%=d.get(i).getBoard_no() %></td>
    		<td><%=d.get(i).getTitle() %></td>
    		<td><%=d.get(i).getWriter() %></td>
    		<td><%=d.get(i).getRegDate() %></td>
    		</tr>
    		<%
    	}
    %>
    </tbody>
  </table>
   <form>
   <p align="right">
   <button type="button" onclick="location.href='../jsp/common/write.jsp'">글쓰기</button>
   </p>
   <p align="center">
  <select>
	 		<option value = "a">제목+작성자</option>
	 		<option value = "b">제목</option>
	 		<option value = "c">작성자</option>
  </select>
  <input type="text" placeholder="검색할 항목을 입력해">
  <button type="submit">검색</button>
  </p>
  
  </form>
</div>
  </div>
</div>
</body>
</html>