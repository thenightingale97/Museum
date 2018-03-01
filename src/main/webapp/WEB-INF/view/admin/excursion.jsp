<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="row">
    <div class="col-md-7 col-xs-12">
        <div class="row">
            <div class="col-md-12 col-xs-12">
                <form:form class="form-horizontal" action="/admin/excursion/update" method="POST"
                           modelAttribute="excursion">
                    <%--<div class="form-group">
                        <label for="name" style="color:red;text-align:left;" class="col-sm-10 col-sm-offset-2 control-label"><form:errors path="name"/></label>
                    </div>--%>

                    <form:input type="hidden" class="form-control" path="id"/>
                    <div class="form-group">
                        <label for="name" class="col-sm-2 control-label">Name</label>
                        <div class="col-sm-10">
                            <form:input class="form-control" path="name" id="name"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="name" class="col-sm-2 control-label">Duration</label>
                        <div class="col-sm-10">
                            <form:input class="form-control" path="duration" id="name"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="name" class="col-sm-2 control-label">Max vistor amount</label>
                        <div class="col-sm-10">
                            <form:input class="form-control" path="maxVisitorAmount" id="name"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="name" class="col-sm-2 control-label">Description</label>
                        <div class="col-sm-10">
                            <form:input class="form-control" path="description" id="name"/>
                        </div>
                    </div><div class="form-group">
                        <label for="name" class="col-sm-2 control-label">Picture URL</label>
                        <div class="col-sm-10">
                            <form:input class="form-control" path="imageUrl" id="name"/>
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
            <div class="col-md-2 col-xs-3"><h3>Excursion name</h3></div>
            <div class="col-md-2 col-xs-3"><h3>Excursion duration</h3></div>
            <div class="col-md-2 col-xs-3"><h3>Visitor max amount</h3></div>
            <div class="col-md-1 col-xs-2"><h3>Update</h3></div>
            <div class="col-md-1 col-xs-2"><h3>Delete</h3></div>
        </div>
        <c:forEach items="${excursions}" var="excursion">
            <div class="row">
                <div class="col-md-2 col-xs-3">${excursion.name}</div>
                <div class="col-md-2 col-xs-3">${excursion.duration}</div>
                <div class="col-md-2 col-xs-3">${excursion.maxVisitorAmount}</div>
                <div class="col-md-1 col-xs-2"><a class="btn btn-warning" href="excursion/updating/${excursion.id}">update</a>
                </div>
                <div class="col-md-1 col-xs-2"><a class="btn btn-danger"
                                                  href="excursion/delete/${excursion.id}">delete</a></div>
            </div>
        </c:forEach>

    </div>
</div>