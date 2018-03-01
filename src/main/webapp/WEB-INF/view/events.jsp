<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<body>
<div class="container-fluid">
    <div class="row">
        <div class="col-sm-3 filters">
            <form:form excurtionId="filterForm" action="/events" method="GET" modelAttribute="eventFilterRequest">
                <div class="row">
                    <div class="col-sm-12">
                        <h5 class="category-label"><spring:message code="excursion"/>:</h5>
                    </div>
                </div>
                <div class="row">
                    <div class='col-sm-12'>
                        <div class="form-group">
                            <form:select class="form-control" path="excursionId">
                                <form:option value="" label="Всі"/>
                                <form:options items="${excursions}" itemValue="id" itemLabel="name"/>
                            </form:select>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-sm-12">
                        <h5 class="category-label"><spring:message code="period"/>:</h5>
                    </div>
                </div>
                <div class="row">
                    <div class="col-sm-2"><h5 class="item-label"><spring:message code="from"/>:</h5></div>
                    <div class='col-sm-10'>
                        <div class="form-group">
                            <div class='input-group date' id='datetimepicker6'>
                                <form:input path="fromDateTime" type='text' class="form-control"/>
                                <span class="input-group-addon">
                                <span class="glyphicon glyphicon-calendar"></span>
                            </span>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-sm-2"><h5 class="item-label"><spring:message code="to"/>:</h5></div>
                    <div class='col-sm-10'>
                        <div class="form-group">
                            <div class='input-group date' id='datetimepicker7'>
                                <form:input path="toDateTime" type='text' class="form-control"/>
                                <span class="input-group-addon">
                                <span class="glyphicon glyphicon-calendar"></span>
                            </span>
                            </div>
                        </div>
                    </div>
                </div>
                <button type="submit" class="btn btn-default filter-submit"><spring:message code="search"/></button>
            </form:form>
            <br/>
            <h3><p><spring:message code="found"/> <c:out value="${number}"/> <spring:message code="events"/></p></h3>
        </div>
        <div class="col-sm-9 showpiece-container">
            <c:forEach var="eventView" items="${eventViews}">
                <a href="/excursion/${eventView.excursionId}">
                    <div class="col-sm-1 showpiece-item">
                        <div class="row">
                            <img class="showpiece-image" src="/resources/images/excursions/${eventView.imageUrl}">
                        </div>
                        <div class="row"><span class="showpiece-item-name">${eventView.name}</span></div>
                        <div class="row"><span class="showpiece-item-value">${eventView.startDate}</span></div>
                        <div class="row"><span
                                class="showpiece-item-value">${eventView.startTime} - ${eventView.finishTime}</span>
                        </div>
                        <div class="row"><span class="showpiece-item-value">${eventView.duration}</span></div>
                    </div>
                </a>
            </c:forEach>
        </div>


    </div>
</div>

<script type="text/javascript">
    $(function () {
        $('#datetimepicker6').datetimepicker({
            format: "YYYY-MM-DD HH:mm"
        });
        $('#datetimepicker7').datetimepicker({
            format: "YYYY-MM-DD HH:mm",
            useCurrent: false//Important! See issue #1075
        });
        $("#datetimepicker6").on("dp.change", function (e) {
            $('#datetimepicker7').data("DateTimePicker").minDate(e.date);
        });
        $("#datetimepicker7").on("dp.change", function (e) {
            $('#datetimepicker6').data("DateTimePicker").maxDate(e.date);
        });
    });
</script>
</body>