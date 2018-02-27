<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<body>
<div class="container-fluid">
    <div class="row">
        <div class="col-sm-4 filters">
            <div class="row"><h3>Оберіть дату цікавої для вас події!</h3></div>
            <form:form action="/excursions" method="GET" >
                <div class='col-sm-6'>
                    <div class="form-group">
                        <div class='input-group date' id='datetimepicker6'>
                            <input name="fromDate" type='text' class="form-control" />
                            <span class="input-group-addon">
                                <span class="glyphicon glyphicon-calendar"></span>
                            </span>
                        </div>
                    </div>
                </div>
                <div class='col-sm-6'>
                    <div class="form-group">
                        <div class='input-group date' id='datetimepicker7'>
                            <input name="toDate" type='text' class="form-control" />
                            <span class="input-group-addon">
                                <span class="glyphicon glyphicon-calendar"></span>
                            </span>
                        </div>
                    </div>
                </div>
                <button type="submit" class="btn btn-default">Пошук</button>
            </form:form>
        </div>
        <div class="col-sm-8 showpieceContext">
            <c:forEach items="${events}" var="event">
                <div class="col-sm-5 showpieceColumn">
                    <img class="showpieceImg" src="" height="60px" width="60px" alt="lol">
                    <div class="row"><span class="showpieceColumnText">${event.excursion.name}</span></div>
                    <div class="row"><span class="showpieceColumnText">${event.startTime} - ${event.finishTime}</span></div>
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