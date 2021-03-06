<%-- 
    Document   : dashboard
    Created on : Dec 2, 2016, 8:09:01 PM
    Author     : Heshan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <title>Lotto App</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="http://www.w3schools.com/lib/w3.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Raleway">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <style>
    html,body,h1,h2,h3,h4,h5 {font-family: "Raleway", sans-serif}
    </style>
    <body class="w3-light-grey">

        <!-- Top container -->
        <div class="w3-container w3-top w3-black w3-large w3-padding" style="z-index:4">
          <button class="w3-btn w3-hide-large w3-padding-0 w3-hover-text-grey" onclick="w3_open();"><i class="fa fa-bars"></i>  Menu</button>
          <span class="w3-right">Logo</span>
        </div>

    <!-- Sidenav/menu -->
    <nav class="w3-sidenav w3-collapse w3-white w3-animate-left" style="z-index:3;width:300px;" id="mySidenav"><br>
      <div class="w3-container w3-row">
        <div class="w3-col s8">
          <span>Welcome, <strong>Heshan</strong></span><br>
          <a href="#" class="w3-hover-none w3-hover-text-red w3-show-inline-block"><i class="fa fa-envelope"></i></a>
          <a href="#" class="w3-hover-none w3-hover-text-green w3-show-inline-block"><i class="fa fa-user"></i></a>
          <a href="#" class="w3-hover-none w3-hover-text-blue w3-show-inline-block"><i class="fa fa-cog"></i></a>
        </div>
      </div>
      <hr>
      <div class="w3-container">
        <h5>Dashboard</h5>
      </div>
      <a href="#" class="w3-padding-16 w3-hide-large w3-dark-grey w3-hover-black" onclick="w3_close()" title="close menu"><i class="fa fa-remove fa-fw"></i>  Close Menu</a>
      <a href="#" class="w3-padding w3-blue"><i class="fa fa-users fa-fw"></i>  Overview</a>
      <a onclick="load_page('history')" class="w3-padding"><i class="fa fa-history fa-fw"></i>  View History</a>
      <a onclick="load_page('lottery')"  class="w3-padding"><i class="fa fa-bank fa-fw"></i>  Lottery</a>
      <a onclick="load_page('subscribers')"  class="w3-padding"><i class="fa fa-users fa-fw"></i>  Subscribers</a>
      <a onclick="load_page('settings')"  class="w3-padding"><i class="fa fa-cog fa-fw"></i>  Settings</a><br><br>
    </nav>


    <!-- Overlay effect when opening sidenav on small screens -->
    <div class="w3-overlay w3-hide-large w3-animate-opacity" onclick="w3_close()" style="cursor:pointer" title="close side menu" id="myOverlay"></div>

    <!-- !PAGE CONTENT! -->
    <div id="content"  style="margin-left:300px;margin-top:43px;">

      <!-- Header -->
      <header class="w3-container" style="padding-top:22px">
        <h5><b><i class="fa fa-dashboard"></i> My Dashboard</b></h5>
      </header>

      <div class="w3-row-padding w3-margin-bottom">
          
        <div class="w3-quarter">
          <div class="w3-container w3-red w3-padding-16">
            <div class="w3-left"><i class="fa fa-comment w3-xxxlarge"></i></div>
            <div class="w3-right">
              <h3>52</h3>
            </div>
            <div class="w3-clear"></div>
            <h4>Messages</h4>
          </div>
        </div>
          
        <div class="w3-quarter">
          <div class="w3-container w3-orange w3-text-white w3-padding-16">
            <div class="w3-left"><i class="fa fa-users w3-xxxlarge"></i></div>
            <div class="w3-right">
              <h3>50</h3>
            </div>
            <div class="w3-clear"></div>
            <h4>Subscribers</h4>
          </div>
        </div>
          

        <div class="w3-quarter">
          <div class="w3-container w3-teal w3-padding-16">
            <div class="w3-left"><i class="fa fa-share-alt w3-xxxlarge"></i></div>
            <div class="w3-right">
              <h3>23</h3>
            </div>
            <div class="w3-clear"></div>
            <h4>Revenue</h4>
          </div>
        </div>
        
      </div>

      <div class="w3-container w3-section">
        <div class="w3-row-padding" style="margin:0 -16px">
          <div class="w3-twothird">
            <h5>Today Lottery Results</h5>
            <table class="w3-table w3-striped w3-white">
              <tr>
                <td><i class="fa fa-user w3-blue w3-padding-tiny"></i></td>
                <td>New record, over 90 views.</td>
                <td><i>10 mins</i></td>
              </tr>
              <tr>
                <td><i class="fa fa-bell w3-red w3-padding-tiny"></i></td>
                <td>Database error.</td>
                <td><i>15 mins</i></td>
              </tr>
              <tr>
                <td><i class="fa fa-users w3-orange w3-text-white w3-padding-tiny"></i></td>
                <td>New record, over 40 users.</td>
                <td><i>17 mins</i></td>
              </tr>
              <tr>
                <td><i class="fa fa-comment w3-red w3-padding-tiny"></i></td>
                <td>New comments.</td>
                <td><i>25 mins</i></td>
              </tr>
              <tr>
                <td><i class="fa fa-bookmark w3-light-blue w3-padding-tiny"></i></td>
                <td>Check transactions.</td>
                <td><i>28 mins</i></td>
              </tr>
              <tr>
                <td><i class="fa fa-laptop w3-red w3-padding-tiny"></i></td>
                <td>CPU overload.</td>
                <td><i>35 mins</i></td>
              </tr>
              <tr>
                <td><i class="fa fa-share-alt w3-green w3-padding-tiny"></i></td>
                <td>New shares.</td>
                <td><i>39 mins</i></td>
              </tr>
            </table>
          </div>
        </div>
      </div>
     

      <!-- Footer -->
      <footer class="w3-container w3-padding-16 w3-light-grey">
        <h4>FOOTER</h4>
        <p>Powered by <a href="" target="_blank">Weerawarna Technologies</a></p>
      </footer>

      <!-- End page content -->
    </div>

    <script>
    // Get the Sidenav
    var mySidenav = document.getElementById("mySidenav");

    // Get the DIV with overlay effect
    var overlayBg = document.getElementById("myOverlay");

    // Toggle between showing and hiding the sidenav, and add overlay effect
    function w3_open() {
        if (mySidenav.style.display === 'block') {
            mySidenav.style.display = 'none';
            overlayBg.style.display = "none";
        } else {
            mySidenav.style.display = 'block';
            overlayBg.style.display = "block";
        }
    }

    // Close the sidenav with the close button
    function w3_close() {
        mySidenav.style.display = "none";
        overlayBg.style.display = "none";
    }
    
    function load_page(selected) {
        if(selected == 'history'){
            document.getElementById("content").innerHTML="<iframe src=history.jsp width='100%' height='100%'></iframe>";
            
        }else if(selected == 'lottery'){
            document.getElementById("content").innerHTML="<iframe src=addlotteryhistory.jsp width='100%' height='100%'></iframe>";
        }else if(selected == 'subscribers'){
            document.getElementById("content").innerHTML="<iframe src=subscribers.jsp width='100%' height='100%'></iframe>";
        }else if(selected == 'settings'){
            document.getElementById("content").innerHTML="<iframe src=settings.jsp width='100%' height='100%'></iframe>";
        }
    }
    </script>

    </body>
</html>
