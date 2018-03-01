<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="container-fluid">
    <div class="row">
        <div class="col-sm-3 filters">
            <%--@elvariable id="showpieceFilterRequest" type=""--%>
            <form:form id="filterForm" action="/showpieces" method="GET" modelAttribute="showpieceFilterRequest">
                <div class="row">
                    <div class="col-sm-12">
                        <h5 class="category-label"><spring:message code="showpiece"/>:</h5>
                    </div>
                </div>
                <div class="row">
                    <div class='col-sm-12'>
                        <div class="form-group">
                            <label><spring:message code="author"/></label>
                            <form:select class="form-control" path="authorId">
                                <form:option value="" label="Всі"/>
                                <form:options items="${authors}" itemValue="id" itemLabel="lastName"/>
                            </form:select>
                            <label><spring:message code="guardian"/></label>
                            <form:select class="form-control" path="guardianId">
                                <form:option value="" label="Всі"/>
                                <form:options items="${guardians}" itemValue="id" itemLabel="lastName"/>
                            </form:select>
                            <label><spring:message code="hall"/></label>
                            <form:select class="form-control" path="hallId">
                                <form:option value="" label="Всі"/>
                                <form:options items="${halls}" itemValue="id" itemLabel="name"/>
                            </form:select>
                        </div>
                    </div>
                </div>
                <button type="submit" class="btn btn-default filter-submit">Пошук</button>
            </form:form>
        </div>
        <div class="col-sm-9 showpiece-container">
            <c:forEach var="showpiece" items="${showpieces}">
                <a href="/showpiece?showpieceId=${showpiece.id}">
                    <div class="col-sm-1 showpiece-item">
                        <div class="row">
                            <img class="showpiece-image" src="/resources/images/showpieces/${showpiece.imageUrl}">
                        </div>
                        <div class="row"><span class="showpiece-item-name-head">Назва експонату: </span><span
                                class="showpiece-item-name">${showpiece.name}</span></div>
                        <div class="row"><span class="showpiece-item-name-head">Зал: </span><span
                                class="showpiece-item-value">${showpiece.hall.name}</span></div>
                    </div>
                </a>
            </c:forEach>
        </div>
    </div>
</div>

