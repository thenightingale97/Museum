<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<header id="head" class="secondary"></header>

<!-- container -->
<div class="container">

    <div class="row">

        <!-- Sidebar -->
        <aside class="col-md-6 sidebar sidebar-left">

            <div class="row">
                <div class="col-xs-12">
                    <p><img src="/resources/images/showpieces/${showpiece.imageUrl}" alt="" style="width: 100%"></p>
                </div>
            </div>
        </aside>
        <!-- /Sidebar -->

        <!-- Article main content -->
        <article class="col-md-6">
            <header class="page-header">
                <h1 class="">${excursionView.name}</h1>
                <h5 class="page-title page-header">Автор: ${showpiece.author.firstName} ${showpiece.author.lastName}</h5>
                <h5 class="page-title">Зал: ${showpiece.hall.name}</h5>
                <h5 class="page-title">Матеріал: ${showpiece.material}</h5>
                <h5 class="page-title">Техніка вкионання: ${showpiece.technique}</h5>
                <h5 class="page-title">Дата створення: ${showpiece.creationDate}</h5>
                <h5 class="page-title">Опис: ${showpiece.description}</h5>
            </header>

           <%-- <blockquote>
                ${excursionView.description}
            </blockquote>
            <a href="/events?id=${showpiece.id}">
                <button type="button" class="btn btn-success pull-right">Показати усі екскурсії!</button>
            </a>>--%>

        </article>
        <!-- /Article -->

    </div>
</div>
