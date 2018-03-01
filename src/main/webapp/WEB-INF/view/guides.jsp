<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="container-fluid">
    <div class="row">
        <form:form action="/guides" method="GET"  modelAttribute="guide">
            <div class="col-sm-3 filters">
                    <%-- <form:form id="filterForm" action="/showpieces" method="GET" >--%>
                <div class="row">
                    <div class="col-sm-12">
                        <h5 class="category-label">Оберіть екскурсовода:</h5>
                    </div>
                </div>
                <div class="row">
                    <div class='col-sm-12'>
                        <div class="form-group">
                            <form:select class="form-control" path="position">
                                <form:option value="" label="Всі"/>
                                <form:options items="${guides}" itemValue="position" itemLabel="position"/>
                            </form:select>
                        </div>
                    </div>
                </div>
                <button type="submit" class="btn btn-default filter-submit">Пошук</button>
            </div>
        </form:form>
        <div class="col-sm-9 showpiece-container">
            <c:forEach var="guide" items="${guidesByPosition}">
                <div class="col-sm-1 showpiece-item">
                    <div class="row"><span class="showpiece-item-name"> Імя: ${guide.firstName}</span></div>
                    <div class="row"><span class="showpiece-item-name"> Прізвище: ${guide.lastName}</span></div>
                    <div class="row"><span class="showpiece-item-value">Телефон: ${guide.phoneNumber}</span></div>
                    <div class="row"><span class="showpiece-item-value">Посада: ${guide.position}</span></div>
                </div>
            </c:forEach>
        </div>
    </div>
</div>

<%--
<div class="container-fluid">
    <div class="row">
        <div class="col-sm-8 showpieceContext">


            <c:forEach items="${guides}" var="guide">
                <div class="col-sm-5 showpieceColumn">
                    <div class="row"> Імя:  ${guide.firstName}</div>
                    <div class="row"> Прізвище:  ${guide.lastName}</div>
                    <div class="row"> Телефон: ${guide.phoneNumber}</div>
                    <div class="row"> Посада: ${guide.position}</div>
                </div>

            </c:forEach>

        </div>
    </div>
</div>






</body>
</html>--%>
