<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
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
            <img src="ny.jpg" alt="New York" width="1200" height="700">
            <div class="carousel-caption">
                <h3>New York</h3>
                <p>The atmosphere in New York is lorem ipsum.</p>
            </div>
        </div>

        <div class="item">
            <img src="chicago.jpg" alt="Chicago" width="1200" height="700">
            <div class="carousel-caption">
                <h3>Chicago</h3>
                <p>Thank you, Chicago - A night we won't forget.</p>
            </div>
        </div>

        <div class="item">
            <img src="la.jpg" alt="Los Angeles" width="1200" height="700">
            <div class="carousel-caption">
                <h3>LA</h3>
                <p>Even though the traffic was a mess, we had the best time playing at Venice Beach!</p>
            </div>
        </div>
    </div>

    <!-- Left and right controls -->
    <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
        <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
        <span class="sr-only">Previous</span>
    </a>
    <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
        <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
        <span class="sr-only">Next</span>
    </a>
</div>

<!-- Container (The Band Section) -->
<div id="band" class="container text-center">
    <h3>THE BAND</h3>
    <p><em>We love music!</em></p>
    <p>We have created a fictional band website. Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod
        tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco
        laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse
        cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui
        officia deserunt mollit anim id est laborum consectetur adipiscing elit, sed do eiusmod tempor incididunt ut
        labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut
        aliquip ex ea commodo consequat.</p>
    <br>
    <div class="row">
        <div class="col-sm-4">
            <p class="text-center"><strong>Name</strong></p><br>
            <a href="#demo" data-toggle="collapse">
                <img src="bandmember.jpg" class="img-circle person" alt="Random Name" width="255" height="255">
            </a>
            <div id="demo" class="collapse">
                <p>Guitarist and Lead Vocalist</p>
                <p>Loves long walks on the beach</p>
                <p>Member since 1988</p>
            </div>
        </div>
        <div class="col-sm-4">
            <p class="text-center"><strong>Name</strong></p><br>
            <a href="#demo2" data-toggle="collapse">
                <img src="bandmember.jpg" class="img-circle person" alt="Random Name" width="255" height="255">
            </a>
            <div id="demo2" class="collapse">
                <p>Drummer</p>
                <p>Loves drummin'</p>
                <p>Member since 1988</p>
            </div>
        </div>
        <div class="col-sm-4">
            <p class="text-center"><strong>Name</strong></p><br>
            <a href="#demo3" data-toggle="collapse">
                <img src="bandmember.jpg" class="img-circle person" alt="Random Name" width="255" height="255">
            </a>
            <div id="demo3" class="collapse">
                <p>Bass player</p>
                <p>Loves math</p>
                <p>Member since 2005</p>
            </div>
        </div>
    </div>
</div>

<!-- Container (TOUR Section) -->
<div id="tour" class="bg-1">
    <div class="container">
        <h3 class="text-center">TOUR DATES</h3>
        <p class="text-center">Lorem ipsum we'll play you some music.<br> Remember to book your tickets!</p>
        <ul class="list-group">
            <li class="list-group-item">September <span class="label label-danger">Sold Out!</span></li>
            <li class="list-group-item">October <span class="label label-danger">Sold Out!</span></li>
            <li class="list-group-item">November <span class="badge">3</span></li>
        </ul>

        <div class="row text-center">
            <div class="col-sm-4">
                <div class="thumbnail">
                    <img src="paris.jpg" alt="Paris" width="400" height="300">
                    <p><strong>Paris</strong></p>
                    <p>Friday 27 November 2015</p>
                    <button class="btn" data-toggle="modal" data-target="#myModal">Buy Tickets</button>
                </div>
            </div>
            <div class="col-sm-4">
                <div class="thumbnail">
                    <img src="newyork.jpg" alt="New York" width="400" height="300">
                    <p><strong>New York</strong></p>
                    <p>Saturday 28 November 2015</p>
                    <button class="btn" data-toggle="modal" data-target="#myModal">Buy Tickets</button>
                </div>
            </div>
            <div class="col-sm-4">
                <div class="thumbnail">
                    <img src="sanfran.jpg" alt="San Francisco" width="400" height="300">
                    <p><strong>San Francisco</strong></p>
                    <p>Sunday 29 November 2015</p>
                    <button class="btn" data-toggle="modal" data-target="#myModal">Buy Tickets</button>
                </div>
            </div>
        </div>
    </div>

    <!-- Modal -->
    <div class="modal fade" id="myModal" role="dialog">
        <div class="modal-dialog">

            <!-- Modal content-->
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal">×</button>
                    <h4><span class="glyphicon glyphicon-lock"></span> Tickets</h4>
                </div>
                <div class="modal-body">
                    <form role="form">
                        <div class="form-group">
                            <label for="psw"><span class="glyphicon glyphicon-shopping-cart"></span> Tickets, $23 per
                                person</label>
                            <input type="number" class="form-control" id="psw" placeholder="How many?">
                        </div>
                        <div class="form-group">
                            <label for="usrname"><span class="glyphicon glyphicon-user"></span> Send To</label>
                            <input type="text" class="form-control" id="usrname" placeholder="Enter email">
                        </div>
                        <button type="submit" class="btn btn-block">Pay
                            <span class="glyphicon glyphicon-ok"></span>
                        </button>
                    </form>
                </div>
                <div class="modal-footer">
                    <button type="submit" class="btn btn-danger btn-default pull-left" data-dismiss="modal">
                        <span class="glyphicon glyphicon-remove"></span> Cancel
                    </button>
                    <p>Need <a href="#">help?</a></p>
                </div>
            </div>
        </div>
    </div>
</div>

<!-- Add Google Maps -->
<div id="googleMap"></div>
<script>
    function myMap() {
        var myCenter = new google.maps.LatLng(41.878114, -87.629798);
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
<script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBu-916DdpKAjTmJNIgngS6HL_kDIKU0aU&callback=myMap"></script>
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
