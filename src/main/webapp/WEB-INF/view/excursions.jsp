<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<body>
<div class="container-fluid">
    <div class="row">
        <div class="col-sm-3 filters">
            <div class="row">
                <div class="col-sm-12">
                    <h5 class="category-label">Оберіть період:</h5>
                </div>
            </div>
            <form:form id="filterForm" action="/excursions" method="GET" modelAttribute="eventsFilterRequest">
                <div class="row">
                    <div class="col-sm-2"><h5 class="item-label">Від:</h5></div>
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
                    <div class="col-sm-2"><h5 class="item-label">До:</h5></div>
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
                <button type="submit" class="btn btn-default filter-submit">Пошук</button>
            </form:form>
        </div>
        <div class="col-sm-9 showpiece-container">
            <c:forEach var="event" items="${eventItemViews}">
                <div class="col-sm-1 showpiece-item">
                    <div class="row">
                        <img class="showpiece-image" src="/resources/images/excursions/test1.jpg" alt="lol">
                    </div>
                    <div class="row"><span class="showpiece-item-name">${event.name}</span></div>
                    <div class="row"><span class="showpiece-item-value">${event.startDate}</span></div>
                    <div class="row"><span class="showpiece-item-value">${event.startTime} - ${event.finishTime}</span>
                    </div>
                    <div class="row"><span class="showpiece-item-value">${event.duration}</span></div>
                </div>
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