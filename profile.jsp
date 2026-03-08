<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>HOME</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/7.0.1/css/all.min.css" integrity="sha512-2SwdPD6INVrV/lHTZbO2nodKhrnDdJK9/kg2XD1r9uGqPo1cUbujc+IYdlYdEErWNu69gVcYgdxlmVmzTWnetw==" crossorigin="anonymous" referrerpolicy="no-referrer" />

</head>
<body>
<div class="header">
  <div class="navbar">
    <div class="logo">SOCIABLE</div>
  <div class="navitems">
  <h3 style="color:white;">User_name: @ ${username}</h3>
        <a href="/user"> <i class="fa-solid fa-house"></i>Home</a>
        <a href="/post"> <i class="fa-solid fa-plus"></i>Post</a>
                <a href="/delete"> <i class="fa-solid fa-delete-left"></i>Delete Account</a>
        
        <a href="/logout"> <i class="fa-solid fa-right-from-bracket"></i>LOGOUT</a>
      </div>
  </div>
</div>

</div>

<div class="profilecontiner">
<img src="${primage}" 
     alt="Profile Picture" 
     class="profile-pic">
         <div class="profilecontent">
    <ul>
        <li>
            posts:${postcount }
        </li>
        <li>Name : ${name}</li>
        <li>
          Dob : ${dob}
        </li>
    </ul>
    </div>
</div>
<h1 style="text-align:center;padding:10px;color:blue;">----POSTS----</h1>

<div class="postgrid">
  <c:forEach var="img" items="${uploads}">
    <div class="post" >
         <div class="profile"><img src="${ img.user.primage}" alt="image">@${img .user.username} |
     <p>  ${   img.created_at}</p></div>
    <p style="text-align:left;padding:10px;background-color:#9ecfed;display:block;width:100%;height:40px; margin-bottom:15px;">CAPTION: ${img.caption}</p>
    <img src="${img.filepath}" alt="User Post" >
    
        <!-- LIKE + COMMENT BUTTONS -->
<div class="action-buttons">

<form action="/likepostpr" method="post" class="like-form">
    <input type="hidden" name="postid" value="${img.id}">
    <button type="submit" class="like-submit">
        👍 Like
       ${img.total_likes}
    </button>
    
</form>


    <!-- COMMENT TOGGLE BUTTON -->
    <input type="checkbox" class="comment-toggle" id="commentToggle_${img.id}">
    <label class="comment-btn" for="commentToggle_${img.id}">
        💬 Comments: ${img.total_comments}
    </label>

    <!-- COMMENT BOX -->
    <div class="comment-box">

     <div class="comment-list">
  <c:forEach var="c" items="${img.comments}">
    <p><b>${c.username}:</b> ${c.comment}</p>
  </c:forEach>
</div>
     
        <!-- Add New Comment -->
        <form action="/addcommentpr" method="post" class="comment-form">
            <input type="hidden" name="postid" value="${img.id}">
            <input type="text" name="commenttext" placeholder="Write a comment..." required>
            <button type="submit">Post</button>
        </form>

    </div>

</div>
    </div>
  </c:forEach>
</div>

</body>
</html>