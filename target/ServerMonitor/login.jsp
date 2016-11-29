<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>

<c:import url="head-tag.jsp" />

<body class="login">
    <!-- main -->

    <div class="container login-container">
        <form class="form-horizontal format-form" ACTION="j_security_check" METHOD="POST">
            <div class="form-group innerForm">
                <label class="col-sm-2 control-label">User Name</label>
                <div class="col-sm-10">
                    <INPUT TYPE="TEXT" NAME="j_username">
                </div>
            </div>
            <div class="form-group innerForm">
                <label class="col-sm-2 control-label">Password</label>
                <div class="col-sm-10">
                    <INPUT TYPE="PASSWORD" NAME="j_password">
                </div>
            </div>
            <div class="form-group innerForm">
                <div class="col-sm-offset-2 col-sm-10">
                    <INPUT TYPE="SUBMIT" VALUE="Log In">
                </div>
            </div>
        </form>

        <!--
        <FORM ACTION="j_security_check" METHOD="POST">
            <TABLE>
                <TR><TD>User name: <INPUT TYPE="TEXT" NAME="j_username">
                <TR><TD>Password: <INPUT TYPE="PASSWORD" NAME="j_password">
                <TR><TH><INPUT TYPE="SUBMIT" VALUE="Log In">
            </TABLE>
        </FORM>
        -->

    <!-- end main -->
    </div>
</body>
</html>
