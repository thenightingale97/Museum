<%@ taglib prefix="spring" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Администратор
  Date: 02.03.18
  Time: 1:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<h1 align="center">Автор</h1>
<div class="container">

  <div class="row">

    <article class="col-md-6">
      <header class="page-header">
        <h1 class="">${author.firstName} ${author.lastName}</h1>
       </header>
      </article>

    <aside class="col-md-6 sidebar sidebar-left">

      <div class="row">
        <div class="col-xs-12">
          <p><img src="/resources/images/author.jpg" alt="" style="width: 100%"></p>
        </div>
      </div>
    </aside>
    <div class="col-sm-9 showpiece-container">
      <h4>Роботи  даного  автора що  є експонатами нашого музею</h4>
      <c:forEach var="showpiece" items="${showpieces}">
        <a href="/showpiece?showpieceId=${showpiece.id}">
          <div class="col-sm-1 showpiece-item">
            <div class="row">
              <img class="showpiece-image" src="/resources/images/showpieces/${showpiece.imageUrl}">
            </div>
            <div class="row"><span class="showpiece-item-name">${showpiece.name}</span></div>
            <div class="row"><span class="showpiece-item-value">${showpiece.creationDate}</span></div>
          </div>
        </a>
      </c:forEach>
    </div>
     </div>
  </div>
</body>
</html>
