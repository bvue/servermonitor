<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html>

<c:set var="pageTitle" value="HomePage" scope="request" />

<c:import url="head-tag.jsp" />



<body>
<div id="container">
    <!-- header -->

    <c:import url="header.jsp" />

    <!-- main -->
    <div id="main">
        <c:import url="content-home.jsp" />
    </div><!-- end main -->

    <c:import url="footer.jsp" />

</div>
</body>
</html>
