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
            <jsp:include page="/layout/header-area.jsp"></jsp:include>
<%--            <c:if test="${!requestScope.errors.isEmpty() && requestScope.errors!=null }">--%>
<%--                <c:forEach items="${requestScope.errors}" var="item">--%>
<%--                    <div class="alert alert-warning" role="alert">--%>
<%--                        <div class="alert alert-danger alert-dismissible" role="alert">--%>
<%--                            <button class="close" type="button" data-dismiss="alert" aria-label="Close"><span--%>
<%--                                    class="mdi mdi-close" aria-hidden="true"></span></button>--%>
<%--                            <div class="icon"><span class="mdi mdi-close-circle-o"></span></div>--%>
<%--                            <div class="message">--%>
<%--                                <span>Error!</span>--%>
<%--                                    ${item}--%>
<%--                            </div>--%>
<%--                        </div>--%>
<%--                    </div>--%>
<%--                </c:forEach>--%>
<%--            </c:if>--%>


<%--            <c:if test="${requestScope.message!=null}">--%>
<%--                <div class="alert alert-success alert-dismissible" role="alert">--%>
<%--                    <button class="close" type="button" data-dismiss="alert" aria-label="Close"><span--%>
<%--                            class="mdi mdi-close" aria-hidden="true"></span></button>--%>
<%--                    <div class="icon"><span class="mdi mdi-check"></span></div>--%>
<%--                    <div class="message">--%>
<%--                        <strong><i class="fa-solid fa-ban"></i></strong>--%>
<%--                            ${requestScope.message}--%>
<%--                    </div>--%>
<%--                </div>--%>
<%--            </c:if>--%>
            <div class=" pos_home_section">
                <div class="customer_login">
                    <div class="row">
                        <div class="col-lg-12">
                            <div class="account_form">
                                <h2>Edit Product</h2>
                                <form method="post" enctype="multipart/form-data">
                                    <c:if test="${requestScope.message !=null}">
                                        <h1>${requestScope.message}</h1>
                                    </c:if>
                                    <p>
                                        <label for="validationServer01" class="form-label">Name Product</label>
                                        <input type="text" class="form-control is-valid" id="validationServer01" input="title" name="title" value="${requestScope.product.getTitle()}" required>
                                    </p>
                                    <p>
                                        <label for="validationServer02" class="form-label">Price</label>
                                        <input type="number" class="form-control is-valid" id="validationServer02" name="price" value="${requestScope.product.getPrice()}" required>
                                    </p>
                                    <p>
                                        <label for="validationServer03" class="form-label">Quantity</label>
                                        <input type="number" class="form-control is-valid" id="validationServer03" name="quantity" value="${requestScope.product.getQuantity()}" required>
                                    </p>
                                    <p>
                                        <label for="validationServer04" class="form-label">Description</label>
                                        <input type="text" class="form-control is-valid" id="validationServer04" name="price" value="${requestScope.product.getDescription()}" required>
                                    </p>
                                    <p>
                                    <div>
                                        <div style="display: flex"><label>Category</label></div>
                                        <div style="display: flex">
                                            <select name="idcategory">
                                                <c:forEach items="${applicationScope.listCategory}" var="category">
                                                    <option <c:if test="${category.getId() == product.getIdCategory()}">selected</c:if> value="${category.getId()}">
                                                        ${category.getName()}
                                                    </option>
                                                </c:forEach>
                                            </select>
                                        </div>
                                    </div>
                                    </p>
                                    <p>
                                          <label>Image</label>
                                          <input type="file" name="file" onchange="loadFile(event)">
                                        <span>
                                            <img src="${requestScope.product.getImage()}" id="output"/>
                                        </span>
                                    </p>
                                    <div class="login_submit">
                                        <button type="submit">Edit</button>
                                    </div>
                                    <c:if test="${requestScope.errors != null}">
                                        <ul>
                                            <c:forEach items="${requestScope.errors}" var="error">
                                                <li>
                                                    <p>${error}</p>
                                                </li>
                                            </c:forEach>
                                        </ul>
                                    </c:if>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<script>
    var loadFile = function(event) {
        var output = document.getElementById('output');
        output.src = URL.createObjectURL(event.target.files[0]);
        output.onload = function() {
            URL.revokeObjectURL(output.src)
        }
    };
</script>
<jsp:include page="/layout/footer-aria.jsp"></jsp:include>
<jsp:include page="/layout/script.jsp"></jsp:include>
</body>
</html>
