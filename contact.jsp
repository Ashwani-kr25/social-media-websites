<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>CONTAC</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/all.min.css" integrity="sha512-SnH5WK+bZxgPHs44uWIX+LLJAJ9/2PkPKZ5QiAj6Ta86w+fsb2TkcmfRyVX3pBnMFcV7oQPJkl9QevSCWr3W6A==" crossorigin="anonymous" referrerpolicy="no-referrer" />

</head>
<body>
<div class="logheader">
  <div class="navbar">
    <div class="logo">SOCIABLE</div>
  <div class="navitems">
        <a href="/">HOME</a>
        <a href="/about">ABOUT US</a>
        <button class="new-account"><a href="/signup">CREATE NEW ACCOUNT</a></button>
      </div>
  </div>
</div>
<div class="main">
    <div class="contact">
     <div class="conbox">
     <i class="fa-solid fa-map-location-dot"></i>
     <h3>ADDRESS</h3>
     <P>Sociable Pvt. Ltd.</P>
     <p>3rd floor ,chirkunda,Dhanbad,Jharkhand,82800
     </p>
     <p></p>
     </div>
     <div class="conbox">
     <i class="fa-solid fa-phone-volume"></i>
     <h3>24/7 Helpline</h3>
     <p>011-229339</p>
     <p>011-234565</p>
        </div>
        <div class="conbox">
        <i class="fa-solid fa-envelope"></i>
        <h3>Email Us</h3>
        <p>enquiry@gmail.com</p>
        </div>

        
    </div>


</div>
 <footer class="footer">
                <p>Follow us on:</p>
                <div class="fa-brands">
                <i class="fa-brands1 fa-x-twitter"></i>
                <i class="fa-brands2 fa-facebook-f"></i>
                <i class="fa-brands3 fa-instagram"></i>
                <i class="fa-brands4 fa-youtube"></i>
                <i class="fa-brands5 fa-linkedin-in"></i></div>
               <div class="condition">
                <hr>
                <span ><a href="">privacy Policy</a></span>
                <span><a href="">Cookies Policy</a></span>
                <span><a href="">Copyright Nortification</a></span>
               </div>
                  <div class="Copyright">
                    <p>Copyright &copy; 2024 all rights reserved by Sociable</p>
                  </div>
              </footer>
</body>
</html>