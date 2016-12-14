<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!doctype html>
<html>
<c:import url="head-tag2.jsp" />

<body>

    <div id="logoutB">
        <form action="/logout" method="post">
            <label>Welcome, <c:out value="${user}"/>!</label>
            <input type="submit" value="Logout" />
        </form>
    </div>

    <div id="mainTable">
        <div class="container">
            <table class="table table-hover table-expandable table-striped">
                <thead>
                    <tr>
                        <th>Server Name</th>        <!--Column 1-->
                        <th>IP address</th>         <!--Column 2-->
                        <th>Server Status</th>      <!--Column 3-->
                        <th>Expand Row for More Information</th>      <!--Column 3-->
                    </tr>
                </thead>

                <tbody>
                    <tr>
                        <td>My First Server</td>
                        <td>67.205.162.127</td>
                        <td><c:out value="${status}"/></td>

                    </tr>
                    <tr>
                        <td><h4>Service List</h4>
                            <ul>
                                <li>
                                <c:forEach items="${serviceList}" var="item">
                                    ${item}<br>
                                </c:forEach>
                                </li>
                            </ul>
                        </td>
                        <td><h4>Memory Usage</h4>
                            <ul>
                                <li>
                                    <c:forEach items="${memory}" var="item">
                                        ${item}<br>
                                    </c:forEach>
                                </li>
                            </ul>
                        </td>
                        <td>
                            <h4>
                                <c:out value="${emailStatus}"/>
                            </h4>
                        </td>
                    </tr>
                    <tr>
                        <td>My Second Server</td>
                        <td>104.236.104.28</td>
                        <td><c:out value="${status2}"/></td>

                    </tr>
                    <tr>
                        <td><h4>Service List</h4>
                            <ul>
                                <li>
                                    <c:forEach items="${serviceList2}" var="item">
                                        ${item}<br>
                                    </c:forEach>
                                </li>
                            </ul>
                        </td>
                        <td><h4>Memory Usage</h4>
                            <ul>
                                <li>
                                    <c:forEach items="${memory2}" var="item">
                                        ${item}<br>
                                    </c:forEach>
                                </li>
                            </ul>
                        </td>
                        <td>
                            <h4>
                                <c:out value="${emailStatus2}"/>
                            </h4>
                        </td>
                    </tr>
                </tbody>
            </table>
        </div>
    <div>

</body>
</html>
