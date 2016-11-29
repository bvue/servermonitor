<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html>


<c:import url="head-tag.jsp" />



<body>
    <div id="container">

        <!-- main -->

        <!-- First Container -->
        <div class="container-fluid bg-1 text-center">
            <!-- Navbar -->
            <nav class="navbar navbar-default">
               <div class="container">
                   <div class="collapse navbar-collapse" id="myNavbar">
                   <ul class="nav navbar-nav navbar-right">
                       <li><a href="#">My Account</a></li>
                   </ul>
               </div>
               </div>
            </nav>


           <!-- Image -->
            <h2 class="margin">Server Monitor</h2>
        </div>

        <!-- Second Container -->
        <div class="container-fluid bg-2 text-center">
            <table class = "table table-striped">

                <thead>
                <tr>
                    <th>Server Name</th>
                    <th>IP address</th>
                    <th>Server on/off</th>
                    <th>Services Running</th>
                    <th>Memory Used</th>
                </tr>
                </thead>

                <tbody>
                <tr>
                    <td>Tanmay</td>
                    <td>Bangalore</td>
                    <td>560001</td>
                    <td>serf</td>
                    <td>sdcf</td>
                </tr>

                <tr>
                    <td>Sachin</td>
                    <td>Mumbai</td>
                    <td>400003</td>
                    <td>sdpkfsdk</td>
                    <td>odfhgsh</td>
                </tr>

                <tr>
                    <td>Uma</td>
                    <td>Pune</td>
                    <td>411027</td>
                    <td>ldfjnskj</td>
                    <td>flkjvsn</td>
                </tr>
                </tbody>

            </table>
        </div>



    </div>
</body>
</html>