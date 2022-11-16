<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!doctype html>
<html class="no-js" lang="zxx">
<head>
    <jsp:include page="/layout/header.jsp"></jsp:include>
</head>
<body>
<div class="pos_page">
    <div class="container">
        <div class="pos_page_inner">
            <div class="customer_login">
                <div class="row">
                    <!--login area start-->
                    <div class="col-lg-12 col-md-12">
                        <div class="account_form">
                            <form action="/login?action=list" method="post">
                                <div class="d-flex align-items-center justify-content-between mb-3">
                                    <a href="index.jsp" class="">
                                        <h3 class="text-primary"><i class="fa fa-user-edit me-2"></i>Login</h3>
                                    </a>
                                    <h3>Sign In</h3>
                                </div>
                                <div class="form-floating mb-3">
                                    <label for="email">Email address</label>
                                    <input type="email" class="form-control" id="email" name="email" placeholder="name@example.com">
                                </div>
                                <div class="form-floating mb-4">
                                    <label for="password">Password</label>
                                    <input type="password" class="form-control" id="password" name="password" placeholder="Password">
                                </div>
                                <button type="submit" class="btn btn-primary">Sign In</button>
                            </form>
                            <div style="color: #0d8226" class="text-center"> <h2>${message}</h2></div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<jsp:include page="/layout/script.jsp"></jsp:include>
</body>
</html>
