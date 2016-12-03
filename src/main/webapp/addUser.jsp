<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>

<c:import url="head-tag.jsp" />

<body>

<!-- main -->
<div class = "container">
    <form class="form-horizontal format-form" action="/registerUser" method="post">

        <div class="form-group">
            <label class="control-label col-sm-2" for="firstName">First
                Name</label>
            <div class="col-sm-4">
                <input type="text" class="form-control" id="firstName"
                       name="firstName"
                       data-error="Please enter your first name." required>
            </div>
            <div class="help-block with-errors"></div>
        </div>
        <div class="form-group">
            <label class="control-label col-sm-2" for="lastName">Last Name</label>
            <div class="col-sm-4">
                <input type="text" class="form-control" id="lastName"
                       name="lastName"
                       data-error="Please enter your last name." required>
            </div>
            <div class="help-block with-errors"></div>
        </div>
        <div class="form-group">
            <label  class="control-label col-sm-2" for="userName">User Name</label>
            <div class="col-sm-4">
                <input type="user_name" class="form-control" id="userName"
                       name="userName"
                       data-error="Please enter your user name." required>
            </div>
            <div class="help-block with-errors"></div>
        </div>
        <div class="form-group">
            <label class="control-label col-sm-2" for="password1">Password
            </label>
            <div class="col-sm-4">
                <input type="password" class="form-control" id="password1"
                       name="password1" data-error="Please provide a password."
                       required>
                <div class="help-block with-errors"></div>
            </div>

        </div>
        <div class="form-group">
            <label class="control-label col-sm-2"
                   for="confirmPassword">Retype
                Password</label>
            <div class="col-sm-4">
                <input type="password" class="form-control" id="confirmPassword"
                       name="confirmPassword" equalTo="#pwd"
                       data-match="#pwd"
                       data-match-error="Confirmation password does not match"
                       required data-error="Please retype your password.">
                <div class="help-block with-errors"></div>
            </div>
        </div>

        <button type="submit" class="btn btn-default col-sm-offset-3"
                data-disable="true">Submit
        </button>
        <button type="reset" class="btn btn-default">Clear</button>

    </form>
</div>


</body>
</html>