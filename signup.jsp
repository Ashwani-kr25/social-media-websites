<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>HOME</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
    <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>

    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/7.0.1/css/all.min.css" integrity="sha512-2SwdPD6INVrV/lHTZbO2nodKhrnDdJK9/kg2XD1r9uGqPo1cUbujc+IYdlYdEErWNu69gVcYgdxlmVmzTWnetw==" crossorigin="anonymous" referrerpolicy="no-referrer" />
 <style>
        .login input{
            margin: 10px;
        }
        .login{
            height: 650px;
        }
        
    </style>
</head>
<body>
<div class="main" style="height: 750px;">
    <div class="login" style="margin-top: 60px;">
<form action="${pageContext.request.contextPath}/signup" method="post" enctype="multipart/form-data">
  <h1> SIGNUP HERE!  </h1>
        <input type="text" name="name" id="name" placeholder="ENTER YOUR NAME"><br>
        <input type="tel" name="mobile" id="mobile" placeholder="ENTER YOUR MOBILE NUMBER"> <br>
           <input type="text" name="email" id="email" placeholder="ENTER YOUR EMAIL ID"><br>
    <input type="text" name="username" id="username" placeholder="MAKE A USER NAME"><br>
    <input type="date" name="dob" id="dob" placeholder="ENTER YOUR DATE OF BIRTH">
      <input type="file" name="file"  placeholder="ENTER PROFILE IMMAGE" ><br>
    <input type="password" name="password" id="" placeholder="ENTER PASSWORD"><br>
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
      <button type="submit">SIGNUP</button>
    <a href="/" style="color: white; font-size: 20px; font-weight: bold;margin: 10px;">GO BACK</a>
</form>
    </div>
</div>

</body>
</html>