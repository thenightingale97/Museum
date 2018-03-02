<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Администратор
  Date: 01.03.18
  Time: 23:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<h1 align="center">Автори</h1>
<div class="container-fluid">
 <div class="row">
   <div class="col-sm-9 showpiece-container">
     <c:forEach var="author" items="${authors}">
       <a href="/author?authorId=${author.id}">
         <div class="col-sm-1 showpiece-item">
           <div class="row"><span class="showpiece-item-name">${author.firstName}</span></div>
           <div class="row"><span class="showpiece-item-name">${author.lastName}</span></div>
         </div>
       </a>
     </c:forEach>
   </div>


  </div>
  </div>



</body>
</html>
