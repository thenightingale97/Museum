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
<h1 >Наші екскурсоводи</h1>

<div class="container-fluid">
    <div class="row">
        <div class="col-sm-8 showpieceContext">


            <c:forEach items="${guides}" var="guide">
                <div class="col-sm-5 showpieceColumn">
                    <div class="row"> Імя:  ${guide.firstName}</div>
                    <div class="row"> Прізвище:  ${guide.lastName}</div>
                    <div class="row"> Телефон: ${guide.phoneNumber}</div>
                    <div class="row"> Посада: ${guide.position}</div>
                </div>

            </c:forEach>

        </div>
    </div>
</div>






</body>
</html>