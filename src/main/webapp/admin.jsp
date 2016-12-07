<jsp:useBean id="taskList" scope="request" class="edu.matc.entity.MapController"/>
<jsp:useBean id="test" scope="request" class="edu.matc.entity.MapController"/>
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
                    <th>Server Name</th>        <!--Column 1-->
                    <th>IP address</th>         <!--Column 2-->
                    <th>Server on/off</th>      <!--Column 3-->
                    <th>Services Running</th>   <!--Column 4-->
                    <th>Memory Used</th>        <!--Column 5-->
                </tr>
                </thead>

                <tbody>
                <tr>
                    <td>Tanmay</td>                                 <!--Column 1-->
                    <td>Bangalore</td>                              <!--Column 2-->
                    <td>560001</td>                                 <!--Column 3-->
                    <td><c:out value="${taskList}"/></td>               <!--Column 4-->
                    <td><c:out value="${test}"/></td>                                   <!--Column 5-->
                </tr>

                <tr>
                    <td>Sachin</td>             <!--Column 1-->
                    <td>Mumbai</td>             <!--Column 2-->
                    <td>400003</td>             <!--Column 3-->
                    <td>sdpkfsdk</td>           <!--Column 4-->
                    <td>odfhgsh</td>            <!--Column 5-->
                </tr>


                </tbody>

            </table>
        </div>



    </div>
</body>
</html>