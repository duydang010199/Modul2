<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!doctype html>
<html class="no-js" lang="en">
<head>
    <jsp:include page="/layout/header.jsp"></jsp:include>

    <style>
        .btn {
            cursor: pointer;
        }

        .handleDeleted:hover {
            background-color: white;
            color: red;
        }

        .handleEdit:hover {
            background-color: white;
            color: #1d5987;
        }

        .table td, .table th {
            vertical-align: middle;
            border-top: 1px solid #e9ecef;
        }
        #buttonAdd:hover{
            background-color: rgba(255, 255, 255, 0.66);
            color: #1d5987;
            font-weight: bold;
        }
        .zoom{
            cursor: pointer;
        }
        .zoom:hover {
            -ms-transform: scale(1.5); /* IE 9 */
            -webkit-transform: scale(1.5); /* Safari 3-8 */
            transform: scale(1.5);
        }
    </style>
</head>
<body>
<div class="pos_page">
    <div class="container">
        <div class="pos_page_inner">
            <jsp:include page="/layout/header-area.jsp"></jsp:include>
            <div class="row" style="margin: 20px">
                <a href="/product?action=create">
                    <button type="button" id="buttonAdd" class="btn btn-primary btn-lg rounded" style="
                                                        height: 50px;
                                                        width: 200px;
                                                    ">
                        <i class="fa-solid fa-plus"></i>  Add New Product
                    </button>
                </a>
                <table class="table m-1">
                    <thead>
                    <tr class="text-center">
                        <th>Name</th>
                        <th>Image</th>
                        <th>Price</th>
                        <th>Quantity</th>
                        <th>Description</th>
                        <th>Category</th>
                        <th>Action</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="product" items="${requestScope.listProduct}">
                        <tr class="text-center">
                            <td class="vAlignC"><c:out value="${product.getTitle()}"/></td>
                            <td style=" height: 100px; width: 150px;">
                                <img class="zoom" src="${(product.getImage() != null) ? product.getImage():"https://climate.onep.go.th/wp-content/uploads/2020/01/default-image.jpg"}">
                            </td>
                            <td class="text-right">
                                <fmt:setLocale value="en_US"/>
                                <fmt:formatNumber value="${product.getPrice()}" type="currency"/>
<%--                                <fmt:formatNumber pattern="#,##0" value="${product.getPrice()}" />--%>
                            </td>
                            <td class="text-right"><c:out value="${product.getQuantity()}"/></td>
                            <td><c:out value="${product.getDescription()}"/></td>
                            <c:forEach items="${requestScope.listCategory}" var="category">
                                <c:if test="${product.getIdCategory() == category.getId()}">
                                    <td>${category.getName()}</td>
                                </c:if>
                            </c:forEach>
                            <td>

                                <a href="/product?action=edit&id=${product.getIdProduct()}">
                                    <button class="btn btn-primary rounded handleEdit">
                                        <i class="mdi mdi-account-edit-outline">Edit</i>
                                    </button>
                                </a>

                                <a>
                                    <button class="btn btn-danger rounded handleDeleted" onclick="handleDeleted(${product.idProduct})">
                                        <i class="mdi mdi-delete">Delete</i>
                                    </button>
                                </a>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
            <nav aria-label="Page navigation example">
                <ul class="pagination">
                    <c:if test="${requestScope.currentPage != 1}">
                        <li class="page-item"><a class="page-link" href="product?page=${requestScope.currentPage - 1}">Previous</a>
                        </li>
                    </c:if>
                    <c:forEach begin="1" end="${noOfPages}" var="i">
                        <c:choose>
                            <c:when test="${requestScope.currentPage eq i}">
                                <li class="page-item"><a class="page-link" href="product?page=${i}">${i}</a></li>
                            </c:when>
                            <c:otherwise>
                                <li class="page-item"><a class="page-link" href="product?page=${i}">${i}</a></li>
                            </c:otherwise>
                        </c:choose>
                    </c:forEach>
                    <c:if test="${requestScope.currentPage lt requestScope.noOfPages}">
                        <li class="page-item"><a class="page-link" href="product?page=${requestScope.currentPage + 1}">Next</a>
                        </li>
                    </c:if>
                </ul>
            </nav>
        </div>
    </div>
</div>
<jsp:include page="/layout/footer-aria.jsp"></jsp:include>
<jsp:include page="/layout/script.jsp"></jsp:include>
</body>

<script>
    function handleDeleted(id){
        Swal.fire({
            title: 'Are you sure?',
            text: "You won't be able to revert this!",
            icon: 'warning',
            showCancelButton: true,
            confirmButtonColor: '#3085d6',
            cancelButtonColor: '#d33',
            confirmButtonText: 'Yes, delete it!'
        }).then((result) => {
            if (result.isConfirmed) {
                  setTimeout(()=>{
                      window.location.href ="/product?action=delete&id=" + id
                  },1000)
            }
        })
    }
</script>
</html>
