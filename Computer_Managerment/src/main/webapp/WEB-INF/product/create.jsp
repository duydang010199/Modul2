<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!doctype html>
<html class="no-js" lang="zxx">
<head>
    <jsp:include page="/layout/header.jsp"></jsp:include>
    <style>
        .login_submit button:hover {
            background: #0d8226;
        }

        .btn {
            cursor: pointer;
        }
    </style>
</head>
<body>
<div class="pos_page">
    <div class="container">
        <div class="pos_page_inner">
            <jsp:include page="/layout/header-area.jsp"></jsp:include>
            <div class="customer_login">
                <div class="row">
                    <!--login area start-->
                    <div class="col-lg-12 col-md-12">
                        <div class="account_form">
                            <h2>Add Product</h2>
                            <c:if test="${requestScope.message != null}">
                                <div class="row bg-primary">
                                    <h4>${message}</h4>
                                </div>
                            </c:if>
                            <form method="post" enctype="multipart/form-data">
                                <div>
                                    <label class="form-label" for="vld1">Name Product</label>
                                    <input id="vld1" class="form-control" type="text" name="title" required>
                                </div>
                                <div>
                                    <label class="form-label" for="vld2">Price</label>
                                    <input class="form-control" id="vld2" type="number" name="price" required>

                                </div>

                                <div>
                                    <label class="form-label" for="vld3">Quantity</label>
                                    <input class="form-control" type="number" name="quantity" id="vld3" required>
                                </div>
                                <div>
                                    <label class="form-label" for="vld4">Description</label>
                                    <input id="vld4" type="text" name="description" class="form-control" required>
                                </div>
                                <div style="display: flex; margin: 10px">
                                    <div style="margin: 8px;"><label>Category</label></div>
                                    <div>
                                        <select name="idcategory">
                                            <c:forEach items="${requestScope.listCategory}" var="category">
                                                <option value="${category.getId()}">
                                                        ${category.getName()}
                                                </option>
                                            </c:forEach>
                                        </select>
                                    </div>
                                </div>
                                <div>
                                    <input type="file" name="file" onchange="loadFile(event)"
                                           value="${product.getImage()}">
                                </div>
                                <div class="mt-3">
                                    <button  class="btn btn-success" type="submit" style="
                                                                                width: 100%;
                                                                                height: 70px;
                                                                            ">Add</button>
                                </div>
                            </form>
                            <div class="card-body col-5">
                                <c:if test="${requestScope.errors != null}">
                                    <ul>
                                        <c:forEach items="${requestScope.errors}" var="errors">
                                            <li>
                                                <p class="text-danger">${errors}</p>
                                            </li>
                                        </c:forEach>
                                    </ul>
                                </c:if>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<jsp:include page="/layout/footer-aria.jsp"></jsp:include>
<jsp:include page="/layout/script.jsp"></jsp:include>
</body>


</script>
</html>
