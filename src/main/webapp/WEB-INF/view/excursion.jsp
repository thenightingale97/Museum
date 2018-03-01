<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 24.02.2018
  Time: 20:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<header id="head" class="secondary"></header>

<!-- container -->
<div class="container">
    <div class="row">
        <aside class="col-md-6 sidebar sidebar-left">
            <div class="row">
                <div class="col-xs-12">
                    <p><img src="/resources/images/excursions/${excursionView.imageUrl}" alt="" style="width: 100%"></p>
                </div>
            </div>
        </aside>
        <article class="col-md-6">
            <header class="page-header">
                <h1 class="">${excursionView.name}</h1>
                <h5 class="page-title page-header">Duration: ${excursionView.duration}</h5>
                <h5 class="page-title">Visitor amount: ${excursionView.maxVisitorAmount}</h5>
            </header>
            <blockquote>
                ${excursionView.description}
            </blockquote>
            <a href="/events?excursionId=${excursionView.id}">
                <button type="button" class="btn btn-success pull-right">Show all events</button>
            </a>>
        </article>
    </div>
</div>
