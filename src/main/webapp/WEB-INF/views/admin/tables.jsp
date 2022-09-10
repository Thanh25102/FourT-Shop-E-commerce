<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  				<!-- Begin Page Content -->
                <div class="container-fluid">

                    <!-- Page Heading -->
                    <h1 class="h3 mb-2 text-gray-800">Tables</h1>
                    <p class="mb-4">DataTables is a third party plugin that is used to generate the demo table below.
                        For more information about DataTables, please visit the <a target="_blank"
                             href="https://datatables.net">official DataTables documentation</a>.</p>

                    <!-- DataTales Example -->
                    <div class="card shadow mb-4">
                        <div class="card-header py-3">
                            <h6 class="m-0 font-weight-bold text-primary">DataTables Example</h6>
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
                                                        <th><a>update</a> <a>delete</a></th>
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

                </div>
                <!-- /.container-fluid -->
