<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>
</head>
<body>
<nav class="navbar navbar-default navbar-fixed-top">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#"><spring:message code="main"/></a>
        </div>
        <div class="collapse navbar-collapse" id="myNavbar">
            <ul class="nav navbar-nav navbar-right">
                <li><a href="#"><spring:message code="excursions"/></a></li>
                <li><a href="#"><spring:message code="guides"/></a></li>
                <li><a href="#"><spring:message code="showpieces"/></a></li>
            </ul>
        </div>
    </div>
</nav>

<!-- First Container -->
<div class="container-fluid bg-1 text-center">
    <h3 class="margin">Хто ми є ?</h3>
    <h3>Ми шукачі істини, що намагаються знайти її у минулому</h3>
</div>

<!-- Second Container -->
<div class="container-fluid bg-2 text-center">
    <h3 class="margin">What Am I?</h3>
    <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore
        magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo
        consequat. </p>
    <a href="#" class="btn btn-default btn-lg">
        <span class="glyphicon glyphicon-search"></span> Search
    </a>
</div>

<!-- Third Container (Grid) -->
<div class="container-fluid bg-3 text-center">
    <h3 class="margin">Where To Find Me?</h3><br>
    <div class="row">
        <div class="col-sm-4">
            <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et
                dolore magna aliqua.</p>
            <img src="birds1.jpg" class="img-responsive margin" style="width:100%" alt="Image">
        </div>
        <div class="col-sm-4">
            <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et
                dolore magna aliqua.</p>
            <img src="birds2.jpg" class="img-responsive margin" style="width:100%" alt="Image">
        </div>
        <div class="col-sm-4">
            <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et
                dolore magna aliqua.</p>
            <img src="birds3.jpg" class="img-responsive margin" style="width:100%" alt="Image">
        </div>
    </div>
</div>

<!-- Footer -->
<footer class="container-fluid bg-4 text-center">
    <p>Bootstrap Theme Made By <a href="https://www.w3schools.com">www.w3schools.com</a></p>
</footer>

</body>
</html>
