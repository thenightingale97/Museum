<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="container-fluid">
    <div class="row">
        <form:form action="/guides" method="GET" modelAttribute="guideFilterRequest">
            <div class="col-sm-3 filters">
                <div class="row">
                    <div class="col-sm-12">
                        <h5 class="category-label">Введіть ім'я екскурсовода:</h5>
                    </div>
                </div>
                <div class="row">
                    <div class="col-sm-3"><h5 class="item-label">Ім'я:</h5></div>
                    <div class="col-sm-9">
                        <form:input class="form-control" path="firstName"/>
                    </div>
                </div>
                <div class="row">
                    <div class="col-sm-3"><h5 class="item-label">Прізвище:</h5></div>
                    <div class="col-sm-9">
                        <form:input class="form-control" path="lastName"/>
                    </div>
                </div>
                <div class="row">
                    <div class="col-sm-12">
                        <h5 class="category-label"><spring:message code="position"/></h5>
                    </div>
                </div>
                <div class="row">
                    <div class='col-sm-12'>
                        <div class="form-group">
                            <form:select class="form-control" path="position">
                                <form:option value="" label="Всі"/>
                                <form:options items="${guidePositions}"/>
                            </form:select>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-sm-12">
                        <h5 class="category-label"><spring:message code="period"/>:</h5>
                    </div>
                </div>
                <div class="row" style="padding-bottom: 15px">
                    <div class="col-sm-12">
                        <spring:message code="busy" var="busy"/>
                        <spring:message code="free" var="free"/>

                        <form:checkbox id="toggle" path="busy" class="form-control" value="true" data-toggle="toggle"
                                       data-width="100%" data-height="35"
                                       data-on="${busy}" data-off="${free}"/>
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
                <button type="submit" class="btn btn-default filter-submit">Пошук</button>
            </div>
        </form:form>
        <div class="col-sm-9 showpiece-container">
            <c:forEach var="guideView" items="${guideViews}">
                <div class="col-sm-1 showpiece-item">
                    <div class="row"><span
                            class="showpiece-item-name">${guideView.firstName} ${guideView.lastName}</span></div>
                    <div class="row" style="height: 10px"></div>
                    <div class="row"><span class="showpiece-item-value"><spring:message code="phoneNumber"/>: ${guideView.phoneNumber}</span></div>
                    <div class="row"><span class="showpiece-item-value"><spring:message code="position"/>: ${guideView.position}</span></div>
                    <div class="row"><span class="showpiece-item-value"><spring:message
                            code="eventCount"/>: ${guideView.eventCount}</span></div>
                    <div class="row"><span class="showpiece-item-value"><spring:message
                            code="workDuration"/>: ${guideView.workDuration}</span></div>
                </div>
            </c:forEach>
        </div>
    </div>
</div>
<script type="text/javascript">
    $(function () {
        $('#toggle').bootstrapToggle();
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
