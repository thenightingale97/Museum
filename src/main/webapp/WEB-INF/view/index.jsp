<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<body id="myPage" data-spy="scroll" data-target=".navbar" data-offset="50">

<div id="myCarousel" class="carousel slide" data-ride="carousel">
    <!-- Indicators -->
    <ol class="carousel-indicators">
        <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
        <li data-target="#myCarousel" data-slide-to="1"></li>
        <li data-target="#myCarousel" data-slide-to="2"></li>
    </ol>

    <!-- Wrapper for slides -->
    <div class="carousel-inner" role="listbox">
        <div class="item active">
            <img src="/resources/images/showpieces/${showpieces[0].imageUrl}" alt="New York" width="1200" height="700">
            <div class="carousel-caption">
                <h3>${showpieces[0].name}</h3>
                <p>${showpiece[0].author.firstName} ${showpieces[0].author.lastName}</p>
            </div>
        </div>

        <div class="item">
            <img src="/resources/images/showpieces/${showpieces[1].imageUrl}" alt="Chicago" width="1200" height="700">
            <div class="carousel-caption">
                <h3>${showpieces[1].name}</h3>
                <p>${showpieces[1].author.firstName} ${showpieces[1].author.lastName}</p>
            </div>
        </div>

        <div class="item">
            <img src="/resources/images/showpieces/${showpieces[2].imageUrl}" alt="Los Angeles" width="1200"
                 height="700">
            <div class="carousel-caption">
                <h3>${showpieces[2].name}</h3>
                <p>${showpieces[2].author.firstName} ${showpieces[2].author.lastName}</p>
            </div>
        </div>
    </div>

    <!-- Left and right controls -->
    <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
        <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
        <span class="sr-only"><spring:message code="previous"/></span>
    </a>
    <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
        <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
        <span class="sr-only"><spring:message code="next"/></span>
    </a>
</div>

<!-- Container (The Band Section) -->
<div id="band" class="container text-center">
    <h3><spring:message code="museum"/></h3>
    <p><em>Ми любимо заглядувати у минуле</em></p>
    <p><em>У нашому музеї ви зможете знайти вироби виготовлені за допомогою різноманітних матеріалів,
        а також ряд виробів виготовлених найдивовижнішими техніками, ознайомитися з якими ви можете за
        <a href="/statistic">посиланням</a>
    </em></p>

    <br>
</div>

<!-- Container (TOUR Section) -->
<div id="tour" class="bg-1">
    <div class="container">
        <div class="row text-center">
            <c:forEach items="${upcomingEvents}" var="event">
                <div class="col-sm-4">
                    <div class="thumbnail  indexExcursion">
                        <img src="/resources/images/excursions/${event.excursion.imageUrl}" alt="Paris" width="400" height="500">
                        <p><strong>${event.excursion.name}</strong></p>
                        <p>${event.startTime}</p>
                        <a href="/excursion/${event.excursion.id}"><button class="btn"><spring:message code="visit"/></button></a>
                    </div>
                </div>
            </c:forEach>
        </div>
    </div>

<!-- Add Google Maps -->
<div id="googleMap"></div>
<script>
    function myMap() {
        var myCenter = new google.maps.LatLng(49.832748, 23.996945);
        var mapProp = {
            center: myCenter,
            zoom: 12,
            scrollwheel: false,
            draggable: false,
            mapTypeId: google.maps.MapTypeId.ROADMAP
        };
        var map = new google.maps.Map(document.getElementById("googleMap"), mapProp);
        var marker = new google.maps.Marker({position: myCenter});
        marker.setMap(map);
    }
</script>
    <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyDn_m2llZUMCjR1xlfxE4mgN0tGFGFX2cQ&callback=myMap"></script>
<!--
To use this code on your website, get a free API key from Google.
Read more at: https://www.w3schools.com/graphics/google_maps_basic.asp
-->

<script>
    $(document).ready(function () {
        // Initialize Tooltip
        $('[data-toggle="tooltip"]').tooltip();

        // Add smooth scrolling to all links in navbar + footer link
        $(".navbar a, footer a[href='#myPage']").on('click', function (event) {

            // Make sure this.hash has a value before overriding default behavior
            if (this.hash !== "") {

                // Prevent default anchor click behavior
                event.preventDefault();

                // Store hash
                var hash = this.hash;

                // Using jQuery's animate() method to add smooth page scroll
                // The optional number (900) specifies the number of milliseconds it takes to scroll to the specified area
                $('html, body').animate({
                    scrollTop: $(hash).offset().top
                }, 900, function () {

                    // Add hash (#) to URL when done scrolling (default click behavior)
                    window.location.hash = hash;
                });
            } // End if
        });
    })
</script>

</body>
</html>
