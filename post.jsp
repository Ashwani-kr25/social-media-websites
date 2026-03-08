<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>HOME</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">

</head>
<body>
<div class="main" style="height: 750px;">
    <div class="login" style="margin-top: 60px;">
<form action="${pageContext.request.contextPath}/post" method="post" enctype="multipart/form-data">
  <h1> UPLOAD!  </h1>

        <input type="file" name="file" placeholder="UPLOAD YOUR POST HERE!"> 
          <input type="text" name="caption" placeholder="ADD CAPTION "> 
        
      <button type="submit" style="  margin-bottom: 30px; ">SUBMIT</button>
    <a href="/profile" style="color: white; font-size: 20px; font-weight: bold;color:black;">GO BACK</a>
</form>
    </div>
</div>

</body>
</html>