<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: Oleksiy
  Date: 01.03.2018
  Time: 11:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
    <title>Title</title>
</head>
<body>
<h1><spring:message code="STATISTIC"/></h1>
<div class="container-fluid">
    <h1 align="center" ><spring:message code="material"/></h1>
<div class="row">
<div class="col-sm-9 showpiece-container" align="center">
    <table align="center" class="table_showpiece" style="align-items: center">
    <c:forEach var="materialStatistic" items="${statisticByMaterials}">
        <tr>
            <td>

                <span> ${materialStatistic.getKey()}</span>
            </td>
            <td>
                <span> ${materialStatistic.getValue()}</span>

            </td>
        </tr>
    </c:forEach>
  </table>
</div>
</div>
    <h1 align="center" ><spring:message code="technique"/></h1>
    <div class="row">
    <div class="col-sm-9 showpiece-container" align="center">
        <table align="center" class="table_showpiece" style="align-items: center">
            <c:forEach var="techniqueStatistic" items="${statisticByTechique}">
                <tr>
                    <td>

                        <span> ${techniqueStatistic.getKey()}</span>
                    </td>
                    <td>
                        <span> ${techniqueStatistic.getValue()}</span>

                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>
</div>
</body>
</html>

