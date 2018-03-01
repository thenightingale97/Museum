<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="row">
    <div class="col-sm-9 showpiece-container" align="center">
        <h3>Статистика нашого музею: </h3>
        <table align="center" class="table_showpiece" style="align-items: center">
            <table class="table table-striped">
            <thead>
            <tr >
                <th class="statisticTableHeader">Матеріал</th>
                <th class="statisticTableHeader">Кількість</th>
            </tr>
            </thead>
            <c:forEach var="materialStatistic" items="${statisticByMaterials}">
                    <tbody>
                    <tr>
                        <td>${materialStatistic.key}</td>
                        <td>${materialStatistic.value}</td>
                    </tr>
                    </tbody>
            </c:forEach>
            </table>
        </table>
    </div>
</div>
<br/>
<div class="row">
    <div class="col-sm-9 showpiece-container" align="center">
        <table align="center" class="table_showpiece" style="align-items: center">
            <table class="table table-striped">
                <thead>
                <tr >
                    <th class="statisticTableHeader">Техніка</th>
                    <th class="statisticTableHeader">Кількість</th>
                </tr>
                </thead>
                <c:forEach var="techniqueStatistic" items="${statisticByTechnique}">
                    <tbody>
                    <tr>
                        <td>${techniqueStatistic.key}</td>
                        <td>${techniqueStatistic.value}</td>
                    </tr>
                    </tbody>
                </c:forEach>
            </table>
        </table>
    </div>
</div>