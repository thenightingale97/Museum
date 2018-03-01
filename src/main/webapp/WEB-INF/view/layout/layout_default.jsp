<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
    <head>
        <meta charset="UTF-8"/>
        <title>Title</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <link href="https://fonts.googleapis.com/css?family=Lato" rel="stylesheet" type="text/css">
        <link href="https://fonts.googleapis.com/css?family=Montserrat" rel="stylesheet" type="text/css">

        <link rel="stylesheet" href="/resources/css/bootstrap.min.css"/>
        <link rel="stylesheet" href="/resources/css/bootstrap-datetimepicker.min.css"/>

        <script src="/resources/js/jquery-3.2.1.min.js"></script>
        <script src="/resources/js/moment-with-locales.min.js"></script>
        <script src="/resources/js/bootstrap.min.js"></script>
        <script src="/resources/js/bootstrap-datetimepicker.min.js"></script>

        <link rel="stylesheet" href="/resources/css/style.css"/>
        <%--<link rel="stylesheet" href="/resources/css/main.css"/>--%>
    </head>

    <body>
        <tiles:insertAttribute name="header"/>
        <tiles:insertAttribute name="body"/>
        <tiles:insertAttribute name="footer"/>
    </body>
</html>