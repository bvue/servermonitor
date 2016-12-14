<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>

<c:import url="head-tag.jsp" />

<body class="login">
    <!-- main -->

    <div class="container login-container">
        <form class="form-horizontal format-form loginForm" ACTION="j_security_check" METHOD="POST">
            <div class="form-group innerForm">
                <label>User Name</label>
                <div>
                    <INPUT TYPE="TEXT" NAME="j_username">
                </div>
            </div>
            <div class="form-group innerForm">
                <label>Password</label>
                <div>
                    <INPUT TYPE="PASSWORD" NAME="j_password">
                </div>
            </div>
            <div class="form-group innerForm">
                <div class="col-sm-offset-2 col-sm-10">
                    <INPUT TYPE="SUBMIT" VALUE="Log In">
                </div>
            </div>
        </form>
    </div>

    <div class="container newUserContainer">
        <p>
            Is this your first time here? Click <a href="/addUser.jsp">here</a> to register!
        </p>
    </div>


    <!-- end main -->
</body>
</html>
