<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<header id="head" class="secondary"></header>

<!-- container -->
<div class="container">

    <div class="row">
        <aside class="col-md-6 sidebar sidebar-left">

            <div class="row">
                <div class="col-xs-12">
                    <p><img src="/resources/images/showpieces/${showpiece.imageUrl}" alt="" style="width: 100%"></p>
                </div>
            </div>
        </aside>
        <article class="col-md-6">
            <header class="page-header">
                <h1 class="">${excursionView.name}</h1>
                <h5 class="page-title page-header"><span class="showpiece-item-name-head"><spring:message
                        code="author"/></span>: ${showpiece.author.firstName} ${showpiece.author.lastName}</h5>
                <h5 class="page-title"><span class="showpiece-item-name-head"><spring:message
                        code="hall"/></span>: ${showpiece.hall.name}</h5>
                <h5 class="page-title"><span class="showpiece-item-name-head"><spring:message
                        code="material"/></span>: ${showpiece.material}</h5>
                <h5 class="page-title"><span class="showpiece-item-name-head"><spring:message
                        code="technique"/></span>: ${showpiece.technique}</h5>
                <h5 class="page-title"><span class="showpiece-item-name-head"><spring:message
                        code="creationData"/></span>: ${showpiece.creationDate}</h5>
                <h5 class="page-title"><span class="showpiece-item-name-head"><spring:message
                        code="description"/></span>: ${showpiece.description}</h5>
            </header>
        </article>
    </div>
</div>
