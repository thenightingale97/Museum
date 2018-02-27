<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

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
                    <li><a href="#">Users</a></li>
                    <li><a href="#">Events</a></li>
                    <li><a href="#">Books</a></li>
                    <li class="active"><a href="#">Authors</a></li>
                    <li><a href="#">Publishers</a></li>
                    <li><a href="#">Countries</a></li>
                </ul>
            </div>
        </div>
    </nav>
</div>
<div class="row">
    <div class="col-md-7 col-xs-12">
        <div class="row">
            <div class="col-md-12 col-xs-12">
                <form:form class="form-horizontal" action="/admin" method="POST" modelAttribute="authorView">
                    <%--<div class="form-group">
                        <label for="name" style="color:red;text-align:left;" class="col-sm-10 col-sm-offset-2 control-label"><form:errors path="name"/></label>
                    </div>--%>
                    <div class="form-group">
                        <label for="name" class="col-sm-2 control-label">FristName</label>
                        <div class="col-sm-10">
                            <form:input class="form-control" path="firstName" id="name"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="name" class="col-sm-2 control-label">LastName</label>
                        <div class="col-sm-10">
                            <form:input class="form-control" path="lastName" id="name"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-offset-2 col-sm-10">
                            <button type="submit" class="btn btn-default">Add</button>
                        </div>
                    </div>
                </form:form>
            </div>
        </div>
        <div class="row">
            <div class="col-md-4 col-xs-4"><h3>Author name</h3></div>
            <div class="col-md-4 col-xs-4"><h3>Update</h3></div>
            <div class="col-md-4 col-xs-4"><h3>Delete</h3></div>
        </div>
        <c:forEach items="${authors}" var="author">
            <div class="row">
                <div class="col-md-4 col-xs-4">${author.firstName}</div>
                <div class="col-md-4 col-xs-4"><a class="btn btn-warning" href="admin/update/${author.id}">update</a></div>
                <div class="col-md-4 col-xs-4"><a class="btn btn-danger" href="admin/delete/${author.id}">delete</a></div>
            </div>
        </c:forEach>

    </div>
</div>