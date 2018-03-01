<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="row">
    <div class="col-md-7 col-xs-12">
        <div class="row">
            <div class="col-md-12 col-xs-12">
                <form:form class="form-horizontal" action="/admin/excursion/update" method="POST" modelAttribute="excursion">
                    <%--<div class="form-group">
                        <label for="name" style="color:red;text-align:left;" class="col-sm-10 col-sm-offset-2 control-label"><form:errors path="name"/></label>
                    </div>--%>

                    <form:input type="hidden" class="form-control" path="id"/>
                    <div class="form-group">
                        <label for="name" class="col-sm-2 control-label"><spring:message code="name"/></label>
                        <div class="col-sm-10">
                            <form:input class="form-control" path="name" id="name"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="name" class="col-sm-2 control-label"><spring:message code="duration"/></label>
                        <div class="col-sm-10">
                            <form:input class="form-control" path="duration" id="name"/>
                        </div>
                    </div><div class="form-group">
                        <label for="name" class="col-sm-2 control-label"><spring:message code="maxVisitorAmount"/></label>
                        <div class="col-sm-10">
                            <form:input class="form-control" path="maxVisitorAmount" id="name"/>
                        </div>
                    </div><div class="form-group">
                        <label for="name" class="col-sm-2 control-label"><spring:message code="description"/></label>
                        <div class="col-sm-10">
                            <form:input class="form-control" path="description" id="name"/>
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
            <div class="col-md-2 col-xs-3"><h3><spring:message code="name"/></h3></div>
            <div class="col-md-2 col-xs-3"><h3><spring:message code="duration"/></h3></div>
            <div class="col-md-2 col-xs-3"><h3><spring:message code="maxVisitorAmount"/></h3></div>
            <div class="col-md-1 col-xs-2"><h3><spring:message code="update"/></h3></div>
            <div class="col-md-1 col-xs-2"><h3><spring:message code="delete"/></h3></div>
        </div>
        <c:forEach items="${excursions}" var="excursion">
            <div class="row">
                <div class="col-md-2 col-xs-3">${excursion.name}</div>
                <div class="col-md-2 col-xs-3">${excursion.duration}</div>
                <div class="col-md-2 col-xs-3">${excursion.maxVisitorAmount}</div>
                <div class="col-md-1 col-xs-2"><a class="btn btn-warning" href="excursion/updating/${excursion.id}"><spring:message code="update"/>e</a></div>
                <div class="col-md-1 col-xs-2"><a class="btn btn-danger" href="excursion/delete/${excursion.id}"><spring:message code="delete"/></a></div>
            </div>
        </c:forEach>

    </div>
</div>