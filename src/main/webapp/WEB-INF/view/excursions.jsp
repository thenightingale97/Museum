<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<body>
<div class="container-fluid clearfix">
    <div class="row">
        <div class="col-sm-3 filters">
            <h3>Фільтри</h3>
            <div class="row">
                <div class="col-xs-12">
                    <h2>DateTimePicker #1</h2>
                    <div class="form-group">
                        <div class="input-group date" id="datetimepicker1">
                            <input type="text" class="form-control"/>
                            <span class="input-group-addon">
                                <span class="glyphicon-calendar glyphicon"></span>
                            </span>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="col-sm-9">

        </div>
    </div>
</div>

<script type="text/javascript">
    $(function () {
        $('#datetimepicker1').datetimepicker({
            locale: 'ru',
            stepping: 10,
            format: 'DD.MM.YYYY',
            defaultDate: moment('01.11.2017').format('DD.MM.YYYY'),
            daysOfWeekDisabled: [0, 6]
        });
        $('#datetimepicker2').datetimepicker({
            locale: 'ru'
        });
    });
</script>
</body>