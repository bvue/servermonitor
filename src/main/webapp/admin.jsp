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
            <table class="table table-hover table-expandable table-striped">
                <thead>
                <tr>
                    <th>Country</th>
                    <th>Population</th>
                    <th>Area</th>
                    <th>Official languages</th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <td>United States of America</td>
                    <td>306,939,000</td>
                    <td>9,826,630 km2</td>
                    <td>English</td>
                </tr>
                <tr>
                    <td colspan="5"><h4>Additional information</h4>
                        <ul>
                            <li><a href="http://en.wikipedia.org/wiki/Usa">USA on Wikipedia</a></li>
                            <li><a href="http://nationalatlas.gov/">National Atlas of the United States</a></li>
                            <li><a href="http://www.nationalcenter.org/HistoricalDocuments.html">Historical Documents</a></li>
                        </ul></td>
                </tr>
                <tr>
                    <td>United Kingdom </td>
                    <td>61,612,300</td>
                    <td>244,820 km2</td>
                    <td>English</td>
                </tr>
                <tr>
                    <td colspan="5"><h4>Additional information</h4>
                        <ul>
                            <li><a href="http://en.wikipedia.org/wiki/United_kingdom">UK on Wikipedia</a></li>
                            <li><a href="http://www.visitbritain.com/">Official tourist guide to Britain</a></li>
                            <li><a href="http://www.statistics.gov.uk/StatBase/Product.asp?vlnk=5703">Official Yearbook of the United Kingdom</a></li>
                        </ul></td>
                </tr>

                </tbody>
            </table>












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
                    <td colspan="5"> Service List:
                        <ul><c:out value="${serviceList}"/></ul>
                    </td>               <!--Column 4-->
                    <td colspan="5">
                        <c:if test="${empty myvariable}">
                            myvariable is empty.
                        </c:if>
                        <c:if test="${not empty myvariable}">
                            myvariable is NOT empty.
                        </c:if>
                    </td>                                   <!--Column 5-->
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