<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="row">
    <div class="col-md-7 col-xs-12">
        <div class="row">
            <div class="col-md-12 col-xs-12">
                <form:form class="form-horizontal" action="/admin/guardian/update" method="POST" modelAttribute="guardian">
                    <%--<div class="form-group">
                        <label for="name" style="color:red;text-align:left;" class="col-sm-10 col-sm-offset-2 control-label"><form:errors path="name"/></label>
                    </div>--%>
                    <form:input type="hidden" path="id"/>
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
            <div class="col-md-2 col-xs-4"><h3>Guardian name</h3></div>
            <div class="col-md-2 col-xs-4"><h3></h3></div>
            <div class="col-md-4 col-xs-4"><h3>Update</h3></div>
            <div class="col-md-4 col-xs-4"><h3>Delete</h3></div>
        </div>
        <c:forEach items="${guardians}" var="guardian">
            <div class="row">
                <div class="col-md-2 col-xs-4">${guardian.firstName}</div>
                <div class="col-md-2 col-xs-2">${guardian.lastName}</div>
                <div class="col-md-4 col-xs-4"><a class="btn btn-warning" href="guardian/updating/${guardian.id}">update</a></div>
                <div class="col-md-4 col-xs-4"><a class="btn btn-danger" href="guardian/delete/${guardian.id}">delete</a></div>
            </div>
        </c:forEach>

    </div>
</div>