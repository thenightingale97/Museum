<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<div class="row">
    <nav class="navbar navbar-default">
        <div class="container-fluid">
            <button type="button" class="navbar-toggle" data-toggle="collapse"
                    data-target="#myNavbar">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <div class="collapse navbar-collapse" id="myNavbar">
                <ul class="nav navbar-nav">
                    <li><a href="/admin/author"><spring:message code="author"/></a></li>
                    <li><a href="/admin/guide"><spring:message code="guides"/></a></li>
                    <li><a href="/admin/guardian"><spring:message code="guardians"/></a></li>
                    <li><a href="/admin/hall"><spring:message code="hall"/></a></li>
                    <li><a href="/admin/excursion"><spring:message code="excursions"/></a></li>
                    <li><a href="/admin/showpiece"><spring:message code="showpieces"/></a></li>
                    <li><a href="/admin/event"><spring:message code="events"/></a></li>
                </ul>
            </div>
        </div>
    </nav>
</div>
