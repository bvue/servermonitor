<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!doctype html>
<html>


<c:import url="head-tag2.jsp" />


<body>

<div class="container">
    <table class="table table-hover table-expandable table-striped">
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
            <td>My First Server</td>
            <td>67.205.162.127</td>
            <td><c:out value="${status}"/></td>
            <td>See Service List below</td>
            <td>3.5/4.0 GB</td>
        </tr>
        <tr>
            <td colspan="5"><h4>Service List</h4>
                <ul>
                    <li><c:out value="${serviceList}"/></li>
                </ul></td>
        </tr>
        <tr>
            <td>My Second Server</td>
            <td>10.99.255.00</td>
            <td>Status</td>
            <td>See Service List Below</td>
            <td>1.7/4.0 GB</td>
        </tr>
        <tr>
            <td colspan="5"><h4>Service List</h4>
                <ul>
                    <li>Service List!</li>
                </ul></td>
        </tr>
        <tr>
            <td>My Third Server</td>
            <td>10.333.22.55</td>
            <td>Status</td>
            <td>See Service List Below</td>
            <td>2.2/4.0 GB</td>
        </tr>
        <tr>
            <td colspan="5"><h4>Service List</h4>
                <ul>
                    <li>Really cool info here.</li>
                </ul></td>
        </tr>
        </tbody>
    </table>

</div>

</body>
</html>
