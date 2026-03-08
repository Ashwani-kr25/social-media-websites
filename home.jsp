<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>HOME</title>
    <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>

<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>
<div class="logheader">
  <div class="navbar">
    <div class="logo">SOCIABLE</div>
  <div class="navitems">
        <a href="/about">ABOUT US</a>
        <a href="/contact">CONTACT US</a>
        <button class="new-account"><a href="/signup">CREATE NEW ACCOUNT</a></button>
      </div>
  </div>
</div>
<div class="main">
    <div class="login">
<form action="${pageContext.request.contextPath}/login" method="post">
  <h1>LOGIN HERE!</h1>
    <input type="text" name="username" id="username" placeholder="ENTER YOUR USER-NAME"><br>
    <input type="password" name="password" id="" placeholder="ENTER YOUR PASSWORD"><br>
   <c:if test="${not empty message}">
<script>
swal({
    title: "LOGIN FAILED!",
    text: "${message}",
    icon: "error",
    button: "Try Again"
});
</script>
</c:if>
   
     <button type="submit">LOGIN</button>
</form>
    </div>
</div>
</body>
</html>