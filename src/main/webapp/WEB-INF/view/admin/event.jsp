<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" %>

<div class="row">
    <div class="col-md-10 col-xs-12">
        <div class="row">
            <div class="col-md-12 col-xs-12">
                <form:form class="form-horizontal" action="/admin/event/update" method="POST" modelAttribute="event">
                    <form:input type="hidden" path="id"/>
                    <div class="form-group">
                        <label for="guide" class="col-sm-2 control-label"><spring:message code="guides"/></label>
                        <div class="col-sm-10">
                            <form:select class="form-control" path="guide" items="${guides}" itemValue="id"
                                         itemLabel="lastName"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="excursion" class="col-sm-2 control-label"><spring:message code="excursion"/></label>
                        <div class="col-sm-10">
                            <form:select class="form-control" path="excursion" items="${excursions}" itemValue="id"
                                         itemLabel="name"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-2"><h5 class="item-label"><spring:message code="from"/></h5></div>
                        <div class='col-sm-10'>
                            <div class="form-group">
                                <div class='input-group date' id='datetimepicker6'>
                                    <form:input path="startTime" type='text' class="form-control"/>
                                    <span class="input-group-addon">
                                <span class="glyphicon glyphicon-calendar"></span>
                            </span>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-2"><h5 class="item-label"><spring:message code="to"/></h5></div>
                        <div class='col-sm-10'>
                            <div class="form-group">
                                <div class='input-group date' id='datetimepicker7'>
                                    <form:input path="finishTime" type='text' class="form-control"/>
                                    <span class="input-group-addon">
                                <span class="glyphicon glyphicon-calendar"></span>
                            </span>
                                </div>
                            </div>
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
            <div class="col-md-2"><h3><spring:message code="name"/></h3></div>
            <div class="col-md-3"><h3><spring:message code="time"/></h3></div>
            <div class="col-md-3"><h3><spring:message code="guide"/></h3></div>
            <div class="col-md-1"><h3><spring:message code="update"/></h3></div>
            <div class="col-md-1"><h3><spring:message code="delete"/></h3></div>
        </div>
        <c:forEach items="${events}" var="event">
            <div class="row">
                <div class="col-md-2">${event.excursion.name}</div>
                <div class="col-md-3">${event.startTime} - ${event.finishTime}</div>
                <div class="col-md-3">${event.guide.firstName} ${event.guide.lastName}</div>
                <div class="col-md-1"><a class="btn btn-warning" href="event/updating/${event.id}"><spring:message
                        code="update"/></a></div>
                <div class="col-md-1"><a class="btn btn-danger" href="event/delete/${event.id}"><spring:message
                        code="delete"/></a></div>
            </div>
        </c:forEach>

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