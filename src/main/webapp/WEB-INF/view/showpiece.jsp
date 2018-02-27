<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<head>
    <link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
    <title></title>
</head>

<body>
<div id="table_showpiece">
    <table align="center" text-cellpadding="15" text-cellspacing="0" >
        <tr align="right">
            <td colspan ="3" ><h1 align="center"><b>${showpiece.name}</b></h1>

                <form action="obrabotka.php" method="POST" name="form1"  align="right">

                    <p>
                        <input type="submit" name="button" value="Редагувати">
                    </p>

                </form>

            </td>
        </tr>

        <tr align="center">
            <td rowspan="5"width="65%" >
                <img src="/resources/images/showpieces/${showpiece.imageUrl}" alt="Mona Liza" width="500" height="700">
                 </td>
            <tr class="showpiece_font">
            <td >
           <p>Автор</p>
            </td>
            <td >
             <p> <b>${showpiece.getAuthor().getFirstName()}</b> <b>${showpiece.getAuthor().getLastName()}</b></p>
            </td>
            </tr>
             <tr class="showpiece_font">
                 <td >
                     <p>Дата</p>
                 </td>
                 <td >
                     <p>????</p>
                 </td>
            </tr>
        <tr class="showpiece_font">
            <td >
                <p>Опис</p>
            </td>
            <td >
                ${showpiece.description}
            </td>
        </tr>
        <tr class="showpiece_font">
            <td >

                <p>Відвідувань</p>
            </td>
            <td >
                <p>????</p>

            </td>
        </tr>

        </tr>
        <tr >
            <td colspan="3" >
                <form action="obrabotka.php" method="POST" name="form1" align="right">

                    <p>
                        <input type="submit" name="button" value="Відвідати">
                    </p>

                </form>

            </td>
        </tr>


    </table>
</div>

</body>