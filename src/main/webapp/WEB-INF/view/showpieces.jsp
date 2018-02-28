<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Oleksiy
  Date: 27.02.2018
  Time: 20:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<style>
    h1 {
        font-family: 'Times New Roman', Times, serif;
        color:#000000;
        font-size: 750%;
    }
</style>
<h1 >Наші експонати</h1>


<div class="container-fluid">
    <div class="row">
        <div class="col-sm-8 showpieceContext">


               <c:forEach items="${showpieces}" var="showpiece">
                   <div class="col-sm-5 showpieceColumn">
                   <div class="row"> <a href="/showpiece?showpieceId=${showpiece.id}">Детальна інформація про експонат</a></div>
                   <div class="row"> ${showpiece.name}</div>
                   <div class="row"> <img src="/resources/images/showpieces/${showpiece.imageUrl}"alt="showpiece image" width="85"    height="70"></div>
                   <div class="row"> ${showpiece.description}</div>
                   <div class="row"> Дата створення: ${showpiece.creationDate}</div>
                   </div>

              </c:forEach>

        </div>
    </div>
</div>


</body>
</html>
