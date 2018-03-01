<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="row">
    <div class="col-md-10 col-xs-12">
        <div class="row">
            <div class="col-md-12 col-xs-12">
                <form:form class="form-horizontal" action="/admin/showpiece/update" method="POST"
                           modelAttribute="showpiece">
                    <%--<div class="form-group">
                        <label for="name" style="color:red;text-align:left;" class="col-sm-10 col-sm-offset-2 control-label"><form:errors path="name"/></label>
                    </div>--%>
                    <form:input type="hidden" path="id"/>
                    <div class="form-group">
                        <label for="name" class="col-sm-2 control-label">Name</label>
                        <div class="col-sm-10">
                            <form:input class="form-control" path="name" id="name"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="name" class="col-sm-2 control-label">Technique</label>
                        <div class="col-sm-10">
                            <form:select path="technique" class="form-control">
                                <option>SCULPTURE</option>
                                <option>OIL_PAINTING</option>
                                <option>WATERCOLOR</option>
                                <option>ENGRAVING</option>
                            </form:select>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="name" class="col-sm-2 control-label">Material</label>
                        <div class="col-sm-10">
                            <form:select path="material" class="form-control">
                                <option>COOPER</option>
                                <option>WOOD</option>
                                <option>CERAMIC</option>
                                <option>IRON</option>
                                <option>GLASS</option>
                                <option>CANVAS</option>
                            </form:select>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="name" class="col-sm-2 control-label">Author</label>
                        <div class="col-sm-10">
                            <form:select class="form-control" path="author" items="${authors}" itemValue="id"
                                         itemLabel="lastName"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="name" class="col-sm-2 control-label">Hall</label>
                        <div class="col-sm-10">
                            <form:select class="form-control" path="hall" items="${halls}" itemValue="id"
                                         itemLabel="name"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="name" class="col-sm-2 control-label">Description</label>
                        <div class="col-sm-10">
                            <form:input class="form-control" path="description" id="name"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="name" class="col-sm-2 control-label">Image Url</label>
                        <div class="col-sm-10">
                            <form:input class="form-control" path="imageUrl" id="name"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="name" class="col-sm-2 control-label">Creation Date</label>
                        <div class='col-sm-10'>
                            <div class="form-group">
                                <div class='input-group date' id='datetimepicker7'>
                                    <form:input path="creationDate" type='text' class="form-control"/>
                                    <span class="input-group-addon">
                                <span class="glyphicon glyphicon-calendar"></span>
                            </span>
                            </div>
                        </div>
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
            <div class="col-md-2"><h3><spring:message code="name"/></h3></div>
            <div class="col-md-2"><h3><spring:message code="author"/></h3></div>
            <div class="col-md-2"><h3><spring:message code="hall"/></h3></div>
            <div class="col-md-1"><h3><spring:message code="material"/></h3></div>
            <div class="col-md-1"><h3><spring:message code="technique"/></h3></div>
            <div class="col-md-1"><h3><spring:message code="update"/></h3></div>
            <div class="col-md-1"><h3><spring:message code="delete"/></h3></div>
        </div>
        <c:forEach items="${showpieces}" var="showpiece">
            <div class="row">
                <div class="col-md-2">${showpiece.name}</div>
                <div class="col-md-2">${showpiece.author.firstName} ${showpiece.author.lastName}</div>
                <div class="col-md-2">${showpiece.hall.name}</div>
                <div class="col-md-1">${showpiece.material}</div>
                <div class="col-md-1">${showpiece.technique}</div>
                <div class="col-md-1"><a class="btn btn-warning"
                                         href="showpiece/updating/${showpiece.id}"><spring:message code="update"/></a>
                </div>
                <div class="col-md-1"><a class="btn btn-danger" href="showpiece/delete/${showpiece.id}"><spring:message
                        code="delete"/></a></div>
            </div>
        </c:forEach>

    </div>
</div>
<script type="text/javascript">
    $(function () {
        $('#datetimepicker7').datetimepicker({
            format: "YYYY-MM-DD",
            useCurrent: false//Important! See issue #1075
        });
        $("#datetimepicker7").on("dp.change", function (e) {
            $('#datetimepicker6').data("DateTimePicker").maxDate(e.date);
        });
    });
</script>
