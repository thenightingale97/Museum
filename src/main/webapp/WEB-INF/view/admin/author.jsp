<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="row">
    <div class="col-md-7 col-xs-12">
        <div class="row">
            <div class="col-md-12 col-xs-12">
                <form:form class="form-horizontal" action="/admin/author/update" method="POST" modelAttribute="author">
                    <%--<div class="form-group">
                        <label for="name" style="color:red;text-align:left;" class="col-sm-10 col-sm-offset-2 control-label"><form:errors path="name"/></label>
                    </div>--%>

                    <form:input type="hidden" class="form-control" path="id"/>
                    <div class="form-group">
                        <label for="name" class="col-sm-2 control-label"><spring:message code="firstName"/></label>
                        <div class="col-sm-10">
                            <form:input class="form-control" path="firstName" id="name"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="name" class="col-sm-2 control-label"><spring:message code="lastName"/></label>
                        <div class="col-sm-10">
                            <form:input class="form-control" path="lastName" id="name"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-offset-2 col-sm-10">
                            <button type="submit" class="btn btn-default"><spring:message code="add"/></button>
                        </div>
                    </div>
                </form:form>
            </div>
        </div>
        <div class="row">
            <div class="col-md-3 col-xs-4"><h3><spring:message code="authorName"/></h3></div>
            <div class="col-md-1 col-xs-4"><h3><spring:message code="update"/></h3></div>
            <div class="col-md-1 col-xs-4"><h3><spring:message code="delete"/></h3></div>
        </div>
        <c:forEach items="${authors}" var="author">
            <div class="row">
                <div class="col-md-3 col-xs-4">${author.firstName} ${author.lastName}</div>
                <div class="col-md-1 col-xs-4"><a class="btn btn-warning" href="author/updating/${author.id}"><spring:message code="update"/></a></div>
                <div class="col-md-1 col-xs-4"><a class="btn btn-danger" href="author/delete/${author.id}"><spring:message code="delete"/></a></div>
            </div>
        </c:forEach>

    </div>
</div>