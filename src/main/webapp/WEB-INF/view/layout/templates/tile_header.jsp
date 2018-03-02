<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<header>
    <nav class="navbar navbar-default navbar-fixed-top">
        <div class="container-fluid">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="#myPage"><img class="navbar-brand-logo"
                                                            src="/resources/images/logo-2.png"></a>
            </div>
            <ul class="nav navbar-nav navbar-right" style="padding-left: 60px">
                <li><a href="?language=en"><spring:message code="eng"/></a></li>
                <li><a href="?language=uk"><spring:message code="ukr"/></a></li>
            </ul>
            <div class="collapse navbar-collapse" id="myNavbar">
                <ul class="nav navbar-nav navbar-right">
                    <li><a href="/"><spring:message code="main"/></a></li>
                    <li><a href="/events"><spring:message code="excursions"/></a></li>
                    <li><a href="/guides"><spring:message code="guides"/></a></li>
                    <li><a href="/showpieces"><spring:message code="showpieces"/></a></li>
                    <li><a href="/authors">Authors</a></li>
                    <li class="dropdown">
                        <a class="dropdown-toggle" data-toggle="dropdown" href="#"><spring:message code="more"/>
                            <span class="caret"></span></a>
                        <ul class="dropdown-menu">
                            <li><a href="#"><spring:message code="registration"/></a></li>
                            <li><a href="#"><spring:message code="login"/></a></li>
                        </ul>
                    </li>
                    <li><a href="#"><span class="glyphicon glyphicon-search"></span></a></li>
                </ul>
            </div>
        </div>
    </nav>
</header>
