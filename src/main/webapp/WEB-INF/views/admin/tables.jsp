<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!-- Begin Page Content -->
<div class="container-fluid">

    <!-- Page Heading -->
    <h1 class="h3 mb-2 text-gray-800">Tables</h1>
    <p class="mb-4">DataTables is a third party plugin that is used to generate the demo table below.
        For more information about DataTables, please visit the <a target="_blank"
                                                                   href="https://datatables.net">official DataTables
            documentation</a>.</p>

    <!-- DataTales Example -->
    <div class="card shadow mb-4">
        <div class="row">
            <div class="card-header py-3 col-sm-12 col-md-6 text-left">
                <h6 class="m-0 font-weight-bold text-primary">DataTables Example</h6>
            </div>
            <div class="col-sm-12 col-md-6 text-right  align-items-center row justify-content-end">
                <a href="<c:url value="/admin/product?action=add"/>">
                    <button class="btn-facebook rounded px-3">Add data</button>
                </a>
            </div>
        </div>
        <div class="card-body">
            <div class="table-responsive">
                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                    <thead>
                    <c:choose>
                        <c:when test="${model eq 'Account' }">
                            <tr>
                                <th>Username</th>
                                <th>Password</th>
                                <th>Enabled</th>
                                <th>Email</th>
                                <th>Phone</th>
                                <th>FullName</th>
                                <th>Address</th>
                                <th>Rank</th>
                                <th>Order</th>
                                <th>Role</th>
                                <th>Action</th>
                            </tr>
                        </c:when>
                        <c:when test="${model eq 'DiscountCode' }">
                            <tr>
                                <th>Id</th>
                                <th>Code</th>
                                <th>Sale Percent</th>
                                <th>Sale Money</th>
                                <th>Start Day</th>
                                <th>End Day</th>
                                <th>Max Discount</th>
                                <th>Description</th>
                                <th>Action</th>
                            </tr>
                        </c:when>
                        <c:when test="${model eq 'Discount' }">
                            <tr>
                                <th>Id</th>
                                <th>Sale Percent</th>
                                <th>Start Day</th>
                                <th>End Day</th>
                                <th>Product Apply</th>
                                <th>Description</th>
                                <th>Action</th>
                            </tr>
                        </c:when>
                        <c:when test="${model eq 'Role' }">
                            <tr>
                                <th>Id</th>
                                <th>Name</th>
                                <th>Permission</th>
                                <th>Action</th>
                            </tr>
                        </c:when>
                        <c:when test="${model eq 'Access' }">
                            <tr>
                                <th>Id</th>
                                <th>Code</th>
                                <th>Description</th>
                                <th>Action</th>
                            </tr>
                        </c:when>
                        <c:when test="${model eq 'Order' }">
                            <tr>
                                <th>Id</th>
                                <th>Order Status</th>
                                <th>Ammount</th>
                                <th>Payment Method</th>
                                <th>Create Time</th>
                                <th>Username</th>
                                <th>Discount Code</th>
                                <th>Order Detail</th>
                                <th>Action</th>
                            </tr>
                        </c:when>
                        <c:when test="${model eq 'Cart' }">
                            <tr>
                                <th>Id</th>
                                <th>Ammount</th>
                                <th>Username</th>
                                <th>Cart Detail</th>
                                <th>Action</th>
                            </tr>
                        </c:when>
                        <c:when test="${model eq 'Product' }">
                            <tr>
                                <th>Id</th>
                                <th>Name</th>
                                <th>Price</th>
                                <th>Description</th>
                                <th>Thumbnail</th>
                                <th>Represent</th>
                                <th>Category</th>
                                <th>Discount</th>
                                <th>Detail</th>
                                <th>Action</th>
                            </tr>
                        </c:when>
                        <c:when test="${model eq 'Category' }">
                            <tr>
                                <th>Id</th>
                                <th>Name</th>
                                <th>Code</th>
                                <th>Thumbnail</th>
                                <th>Logo</th>
                                <th>Description</th>
                                <th>Action</th>
                            </tr>
                        </c:when>
                        <c:when test="${model eq 'Size' }">
                            <tr>
                                <th>Id</th>
                                <th>Name</th>
                                <th>Code</th>
                                <th>Description</th>
                                <th>Action</th>
                            </tr>
                        </c:when>
                        <c:when test="${model eq 'Color' }">
                            <tr>
                                <th>Id</th>
                                <th>Name</th>
                                <th>Code</th>
                                <th>Description</th>
                                <th>Action</th>
                            </tr>
                        </c:when>
                    </c:choose>
                    </thead>
                    <tfoot>
                    <c:choose>
                        <c:when test="${model eq 'Account' }">
                            <tr>
                                <th>Username</th>
                                <th>Password</th>
                                <th>Enabled</th>
                                <th>Email</th>
                                <th>Phone</th>
                                <th>FullName</th>
                                <th>Address</th>
                                <th>Rank</th>
                                <th>Order</th>
                                <th>Role</th>
                                <th>Action</th>
                            </tr>
                        </c:when>
                        <c:when test="${model eq 'DiscountCode' }">
                            <tr>
                                <th>Id</th>
                                <th>Code</th>
                                <th>Sale Percent</th>
                                <th>Sale Money</th>
                                <th>Start Day</th>
                                <th>End Day</th>
                                <th>Max Discount</th>
                                <th>Description</th>
                                <th>Action</th>
                            </tr>
                        </c:when>
                        <c:when test="${model eq 'Discount' }">
                            <tr>
                                <th>Id</th>
                                <th>Sale Percent</th>
                                <th>Start Day</th>
                                <th>End Day</th>
                                <th>Product Apply</th>
                                <th>Description</th>
                                <th>Action</th>
                            </tr>
                        </c:when>
                        <c:when test="${model eq 'Role' }">
                            <tr>
                                <th>Id</th>
                                <th>Name</th>
                                <th>Permission</th>
                                <th>Action</th>
                            </tr>
                        </c:when>
                        <c:when test="${model eq 'Access' }">
                            <tr>
                                <th>Id</th>
                                <th>Code</th>
                                <th>Description</th>
                                <th>Action</th>
                            </tr>
                        </c:when>
                        <c:when test="${model eq 'Order' }">
                            <tr>
                                <th>Id</th>
                                <th>Order Status</th>
                                <th>Ammount</th>
                                <th>Payment Method</th>
                                <th>Create Time</th>
                                <th>Username</th>
                                <th>Discount Code</th>
                                <th>Order Detail</th>
                                <th>Action</th>
                            </tr>
                        </c:when>
                        <c:when test="${model eq 'Cart' }">
                            <tr>
                                <th>Id</th>
                                <th>Ammount</th>
                                <th>Username</th>
                                <th>Cart Detail</th>
                                <th>Action</th>
                            </tr>
                        </c:when>
                        <c:when test="${model eq 'Product' }">
                            <tr>
                                <th>Id</th>
                                <th>Name</th>
                                <th>Price</th>
                                <th>Description</th>
                                <th>Thumbnail</th>
                                <th>Represent</th>
                                <th>Category</th>
                                <th>Discount</th>
                                <th>Detail</th>
                                <th>Action</th>
                            </tr>
                        </c:when>
                        <c:when test="${model eq 'Category' }">
                            <tr>
                                <th>Id</th>
                                <th>Name</th>
                                <th>Code</th>
                                <th>Thumbnail</th>
                                <th>Logo</th>
                                <th>Description</th>
                                <th>Action</th>
                            </tr>
                        </c:when>
                        <c:when test="${model eq 'Size' }">
                            <tr>
                                <th>Id</th>
                                <th>Name</th>
                                <th>Code</th>
                                <th>Description</th>
                                <th>Action</th>
                            </tr>
                        </c:when>
                        <c:when test="${model eq 'Color' }">
                            <tr>
                                <th>Id</th>
                                <th>Name</th>
                                <th>Code</th>
                                <th>Description</th>
                                <th>Action</th>
                            </tr>
                        </c:when>
                    </c:choose>
                    </tfoot>
                    <tbody>
                    <c:choose>
                        <c:when test="${model eq 'Account' }">
                            <c:forEach var="account" items="${ listObject }">
                                <tr>
                                    <th>${account.username}</th>
                                    <th>${account.password}</th>
                                    <th>${account.enabled4}</th>
                                    <th>${account.email}</th>
                                    <th>${account.phone}</th>
                                    <th>${account.fullName}</th>
                                    <th>${account.address}</th>
                                    <th>${account.rankAccount}</th>
                                    <th><a href="#">Order Detail</a></th>
                                    <th>${account.roleById.authority}</th>
                                    <th><a>update</a> <a>delete</a></th>
                                </tr>
                            </c:forEach>
                        </c:when>
                        <c:when test="${model eq 'DiscountCode' }">
                            <c:forEach var="discountCode" items="${ listObject }">
                                <tr>
                                    <th>${discountCode.id}</th>
                                    <th>${discountCode.code}</th>
                                    <th>${discountCode.salePercent}</th>
                                    <th>${discountCode.saleMoney}</th>
                                    <th>${discountCode.startDay}</th>
                                    <th>${discountCode.endDay}</th>
                                    <th>${discountCode.maxDiscount}</th>
                                    <th>${discountCode.description}</th>
                                    <th><a>update</a> <a>delete</a></th>
                                </tr>
                            </c:forEach>
                        </c:when>
                        <c:when test="${model eq 'Discount' }">
                            <c:forEach var="discount" items="${ listObject }">
                                <tr>
                                    <th>${discount.id}</th>
                                    <th>${discount.salePercent}</th>
                                    <th>${discount.startDay}</th>
                                    <th>${discount.endDay}</th>
                                    <th>${discount.description}</th>
                                    <th><a>update</a> <a>delete</a></th>
                                </tr>
                            </c:forEach>
                        </c:when>
                        <c:when test="${model eq 'Role' }">
                            <c:forEach var="role" items="${ listObject }">
                                <tr>
                                    <th>${role.id}</th>
                                    <th>${role.authority}</th>
                                    <th><a>Permission</a></th>
                                    <th><a>update</a> <a>delete</a></th>
                                </tr>
                            </c:forEach>
                        </c:when>
                        <c:when test="${model eq 'Access' }">
                            <c:forEach var="access" items="${ listObject }">
                                <tr>
                                    <th>${access.id}</th>
                                    <th>${access.code}</th>
                                    <th>${access.description}</th>
                                    <th><a>update</a> <a>delete</a></th>
                                </tr>
                            </c:forEach>
                        </c:when>
                        <c:when test="${model eq 'Order' }">
                            <c:forEach var="order" items="${ listObject }">
                                <tr>
                                    <th>${order.id}</th>
                                    <th>${order.orderStatus}</th>
                                    <th>${order.ammount}</th>
                                    <th>${order.paymentMethod}</th>
                                    <th>${order.createTime}</th>
                                    <th>${order.accountByUsername.username}</th>
                                    <th>${order.discountCodeByDiscountCodeId.code}</th>
                                    <th><a>Detail</a></th>
                                    <th><a>update</a> <a>delete</a></th>
                                </tr>
                            </c:forEach>
                        </c:when>
                        <c:when test="${model eq 'Cart' }">
                            <c:forEach var="cart" items="${ listObject }">
                                <tr>
                                    <th>${cart.id}</th>
                                    <th>${cart.ammount}</th>
                                    <th>${cart.accountByUsername.username}</th>
                                    <th><a>Detail</a></th>
                                    <th><a>update</a> <a>delete</a></th>
                                </tr>
                            </c:forEach>
                        </c:when>
                        <c:when test="${model eq 'Product' }">
                            <c:forEach var="product" items="${ listObject }">
                                <tr>
                                    <th>${product.id}</th>
                                    <th>${product.name}</th>
                                    <th>${product.price}</th>
                                    <th>${product.description}</th>
                                    <th>${product.thumbnail}</th>
                                    <th>
                                        <img src="${product.represent}"/>
                                    </th>
                                    <th>${product.categoryByCategoryId.name}</th>
                                    <th>${product.discountByDiscountId.id}</th>
                                    <th>Detail</th>
                                    <th>
                                        <a href="<c:url value="/admin/product?action=update&&id=${product.id}"/>">update</a>
                                        <a href="<c:url value="/admin/product?action=delete&&id=${product.id}"/>">delete</a>
                                    </th>
                                </tr>
                            </c:forEach>
                        </c:when>
                        <c:when test="${model eq 'Category' }">
                            <c:forEach var="category" items="${ listObject }">
                                <tr>
                                    <th>${category.id}</th>
                                    <th>${category.name}</th>
                                    <th>${category.code}</th>
                                    <th>${category.thumbnail}</th>
                                    <th>${category.description}</th>
                                    <th>${category.logo}</th>
                                    <th><a>update</a> <a>delete</a></th>
                                </tr>
                            </c:forEach>
                        </c:when>
                        <c:when test="${model eq 'Size' }">
                            <c:forEach var="size" items="${ listObject }">
                                <tr>
                                    <th>${size.id}</th>
                                    <th>${size.name}</th>
                                    <th>${size.code}</th>
                                    <th>${size.description}</th>
                                    <th><a>update</a> <a>delete</a></th>
                                </tr>
                            </c:forEach>
                        </c:when>
                        <c:when test="${model eq 'Color' }">
                            <c:forEach var="color" items="${ listObject }">
                                <tr>
                                    <th>${color.id}</th>
                                    <th>${color.name}</th>
                                    <th>${color.code}</th>
                                    <th>${color.description}</th>
                                    <th><a>update</a> <a>delete</a></th>
                                </tr>
                            </c:forEach>
                        </c:when>
                    </c:choose>

                    </tbody>
                </table>
            </div>
        </div>
    </div>
    <c:if test="${param.action != null}">
        <div class="wrapper">
            <div class="overlay">
                <c:choose>
                    <c:when test="${model eq 'Product'}">
                        <c:url value="/product" var="url"/>
                        <form:form action="${url}" modelAttribute="Product">
                            <div class="form-group row">
                                <h2 class="heading col-lg-6">${model} form</h2>
                                <div class="col-lg-6 text-right">
                                    <button type="button" class="close" aria-label="Close">
                                        <a href="<c:url value="/admin/product"/>">
                                            <span aria-hidden="true">&times;</span>
                                        </a>
                                    </button>
                                </div>
                            </div>
                            <div class="form-group row">
                                <div class="controls col-lg-6">
                                    <form:input type="text" id="name" class="floatLabel" name="name" path="name"/>
                                    <label for="name" ${Product.name !=null ? "class='active'" : ""}>Name</label>
                                </div>
                                <div class="controls col-lg-6">
                                    <form:input type="number" id="price" class="floatLabel" name="price" path="price"/>
                                    <label for="price" ${Product.price !=null ? "class='active'" : ""}>Price</label>
                                </div>
                                <div class="controls col-lg-12">
                                    <form:input type="text" id="thumbnail" class="floatLabel" name="thumbnail"
                                                path="thumbnail"/>
                                    <label for="thumbnail" ${Product.thumbnail !=null ? "class='active'" : ""}>Thumbnail</label>
                                </div>
                                <div class="controls col-lg-12">
                                    <div class="row">
                                        <div class="col-lg-6">
                                            <div class="custom-file-upload">
                                                <div class="row col-lg-12">
                                                    <div class="file-upload-wrapper row col-lg-12">
                                                        <input type="file" id="file" name="myfiles[]" multiple="" class="custom-file-upload-hidden " tabindex="-1" style="position: absolute; left: -9999px;">
                                                        <input type="text" class="file-upload-input col-lg-6">
                                                        <button type="button" class="file-upload-button col-lg-6" tabindex="-1">
                                                            Select a File
                                                        </button>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="col-lg-6">
                                            <i class="fa fa-sort"></i>
                                            <form:select class="floatLabel" path="categoryByCategoryId">
                                                <c:forEach var="category" items="${Categories}">
                                                    <form:option value="${category}">${category.name}</form:option>
                                                </c:forEach>
                                            </form:select>
                                            <label ${Product.categoryByCategoryId !=null ? "class='active'" : ""}>Category</label>
                                        </div>
                                    </div>
                                </div>
                                <div class="controls col-lg-12">
                                    <form:textarea name="description" class="floatLabel" id="description"
                                                   path="description"></form:textarea>
                                    <label for="description" ${Product.description !=null ? "class='active'" : ""}>Description</label>
                                </div>
                                <div class="row col-lg-12">
                                    <div class="col-lg-5"></div>
                                    <button type="submit" value="Submit" class="col-lg-2">Submit</button>
                                    <div class="col-lg-5"></div>
                                </div>
                                <form:input type="hidden" path="id"/>
                                <form:input type="hidden" path="discountByDiscountId"/>
                                <form:input type="hidden" path="productDetailsById"/>
                            </div>
                        </form:form>
                    </c:when>
                </c:choose>
            </div>
        </div>
    </c:if>
</div>
<!-- /.container-fluid -->

<%--<form action="">--%>
<%--    <div class="form-group row">--%>
<%--        <h2 class="heading col-lg-6">Booking & contact</h2>--%>
<%--        <div class="col-lg-6 text-right">--%>
<%--            <button type="button" class="close" aria-label="Close">--%>
<%--                <span aria-hidden="true">&times;</span>--%>
<%--            </button>--%>
<%--        </div>--%>
<%--    </div>--%>
<%--    <div class="form-group row">--%>
<%--        <div class="controls col-lg-6">--%>
<%--            <input type="text" id="name" class="floatLabel" name="name">--%>
<%--            <label for="name">Name</label>--%>
<%--        </div>--%>
<%--        <div class="controls col-lg-6">--%>
<%--            <input type="text" id="email" class="floatLabel" name="email">--%>
<%--            <label for="email">Email</label>--%>
<%--        </div>--%>
<%--        <div class="controls col-lg-12">--%>
<%--            <input type="tel" id="phone" class="floatLabel" name="phone">--%>
<%--            <label for="phone">Phone</label>--%>
<%--        </div>--%>
<%--        <div class="col-lg-12">--%>
<%--            <div class="row">--%>
<%--                <div class="col-lg-12">--%>
<%--                    <div class="controls">--%>
<%--                        <input type="text" id="street" class="floatLabel" name="street">--%>
<%--                        <label for="street">Street</label>--%>
<%--                    </div>--%>
<%--                </div>--%>
<%--                <div class="col-lg-12">--%>
<%--                    <div class="controls">--%>
<%--                        <input type="number" id="street-number" class="floatLabel" name="street-number">--%>
<%--                        <label for="street-number">Number</label>--%>
<%--                    </div>--%>
<%--                </div>--%>
<%--            </div>--%>
<%--        </div>--%>
<%--        <div class="col-lg-12">--%>
<%--            <div class="row">--%>
<%--                <div class="col-lg-12">--%>
<%--                    <div class="controls">--%>
<%--                        <input type="text" id="city" class="floatLabel" name="city">--%>
<%--                        <label for="city">City</label>--%>
<%--                    </div>--%>
<%--                </div>--%>
<%--                <div class="col-lg-12">--%>
<%--                    <div class="controls">--%>
<%--                        <input type="text" id="post-code" class="floatLabel" name="post-code">--%>
<%--                        <label for="post-code">Post Code</label>--%>
<%--                    </div>--%>
<%--                </div>--%>
<%--            </div>--%>
<%--        </div>--%>
<%--        <div class="controls col-lg-12">--%>
<%--            <input type="text" id="country" class="floatLabel" name="country">--%>
<%--            <label for="country">Country</label>--%>
<%--        </div>--%>
<%--    </div>--%>
<%--    <!--  Details -->--%>
<%--    <div class="form-group row">--%>
<%--        <h2 class="heading col-lg-12">Details</h2>--%>
<%--        <div class=" col-lg-12">--%>
<%--            <div class="row">--%>
<%--                <div class="col-lg-6">--%>
<%--                    <div class="controls">--%>
<%--                        <input type="date" id="arrive" class="floatLabel" name="arrive"--%>
<%--                               value="<?php echo date('Y-m-d'); ?>">--%>
<%--                        <label for="arrive" class="label-date"><i class="fa fa-calendar"></i>&nbsp;&nbsp;Arrive</label>--%>
<%--                    </div>--%>
<%--                </div>--%>
<%--                <div class="col-lg-6">--%>
<%--                    <div class="controls">--%>
<%--                        <input type="date" id="depart" class="floatLabel" name="depart"--%>
<%--                               value="<?php echo date('Y-m-d'); ?>"/>--%>
<%--                        <label for="depart" class="label-date"><i class="fa fa-calendar"></i>&nbsp;&nbsp;Depart</label>--%>
<%--                    </div>--%>
<%--                </div>--%>
<%--            </div>--%>
<%--        </div>--%>
<%--        <div class=" col-lg-12">--%>
<%--            <div class="row">--%>
<%--                <div class="col-lg-4">--%>
<%--                    <div class="controls">--%>
<%--                        <i class="fa fa-sort"></i>--%>
<%--                        <select class="floatLabel">--%>
<%--                            <option value="blank"></option>--%>
<%--                            <option value="1">1</option>--%>
<%--                            <option value="2" selected>2</option>--%>
<%--                            <option value="3">3</option>--%>
<%--                        </select>--%>
<%--                        <label for="fruit"><i class="fa fa-male"></i>&nbsp;&nbsp;People</label>--%>
<%--                    </div>--%>
<%--                </div>--%>
<%--                <div class="col-lg-4">--%>
<%--                    <div class="controls">--%>
<%--                        <i class="fa fa-sort"></i>--%>
<%--                        <select class="floatLabel">--%>
<%--                            <option value="blank"></option>--%>
<%--                            <option value="deluxe" selected>With Bathroom</option>--%>
<%--                            <option value="Zuri-zimmer">Without Bathroom</option>--%>
<%--                        </select>--%>
<%--                        <label for="fruit">Room</label>--%>
<%--                    </div>--%>
<%--                </div>--%>
<%--                <div class="col-lg-4">--%>
<%--                    <div class="controls">--%>
<%--                        <i class="fa fa-sort"></i>--%>
<%--                        <select class="floatLabel">--%>
<%--                            <option value="blank"></option>--%>
<%--                            <option value="single-bed">Zweibett</option>--%>
<%--                            <option value="double-bed" selected>Doppelbett</option>--%>
<%--                        </select>--%>
<%--                        <label for="fruit">Bedding</label>--%>
<%--                    </div>--%>
<%--                </div>--%>
<%--            </div>--%>
<%--        </div>--%>
<%--        <div class=" col-lg-12">--%>
<%--            <div class="row">--%>
<%--                <p class="info-text col-lg-12">Please describe your needs e.g. Extra beds, children's cots</p>--%>
<%--                <br>--%>
<%--                <div class="controls col-lg-12">--%>
<%--                    <textarea name="comments" class="floatLabel" id="comments"></textarea>--%>
<%--                    <label for="comments">Comments</label>--%>
<%--                </div>--%>
<%--                <div class="row col-lg-12">--%>
<%--                    <div class="col-lg-5"></div>--%>
<%--                    <button type="submit" value="Submit" class="col-lg-2">Submit</button>--%>
<%--                    <div class="col-lg-5"></div>--%>
<%--                </div>--%>
<%--            </div>--%>
<%--        </div>--%>
<%--    </div>--%>
<%--    <!-- /.form-group -->--%>
<%--</form>--%>
