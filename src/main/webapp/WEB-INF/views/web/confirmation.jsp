<%--
  Created by IntelliJ IDEA.
  User: manhthanh
  Date: 01/11/2022
  Time: 10:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!-- Start Banner Area -->
<section class="banner-area organic-breadcrumb">
    <div class="container">
        <div class="breadcrumb-banner d-flex flex-wrap align-items-center justify-content-end">
            <div class="col-first"><%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
                <h1>Confirmation</h1>
                <nav class="d-flex align-items-center">
                    <a href="index.html">Home<span class="lnr lnr-arrow-right"></span></a>
                    <a href="category.html">Confirmation</a>
                </nav>
            </div>
        </div>
    </div>
</section>
<!-- End Banner Area -->

<!--================Order Details Area =================-->
<section class="order_details section_gap">
	<c:forEach var="order" items="${ orders }">
    <div class="container">
        <h3 class="title_confirmation">Thank you. Your order has been received.</h3>
        <div class="row order_d_inner" style="position: relative;">
            <div class="col-lg-4">
                <div class="details_item">
                    <h4>Order Info</h4>
                    <ul class="list">
                        <li><a href="#"><span>Order number</span> : ${ order.id }</a></li>
                        <li><a href="#"><span>Date</span> : Los Angeles</a></li>
                        <li><a href="#"><span>Total</span> : USD 2210</a></li>
                        <li><a href="#"><span>Payment method</span> : ${ order.paymentMethod }</a></li>
                    </ul>
                </div>
            </div>
            <div class="col-lg-4">
                <div class="details_item">
                    <h4>Billing Address</h4>
                    <ul class="list">
                        <li><a href="#"><span>Street</span> : 56/8</a></li>
                        <li><a href="#"><span>City</span> : Los Angeles</a></li>
                        <li><a href="#"><span>Country</span> : United States</a></li>
                        <li><a href="#"><span>Postcode </span> : 36952</a></li>
                    </ul>
                </div>
            </div>
            <div class="col-lg-4">
                <div class="details_item">
                    <h4>Shipping Address</h4>
                    <ul class="list">
                        <li><a href="#"><span>Street</span> : 56/8</a></li>
                        <li><a href="#"><span>City</span> : Los Angeles</a></li>
                        <li><a href="#"><span>Country</span> : United States</a></li>
                        <li><a href="#"><span>Postcode </span> : 36952</a></li>
                    </ul>
                </div>
            </div>
            <span style=" width: 20px;
						  display: block;
						  position: absolute;
						  right: 0;
						  cursor: pointer;" onclick="openOrderDetail(${order.id});"><img src="/FourT-Shop-E-commerce/asset/web/img/features/down-arrow.png">
			</span>
        </div>
        <div class="order_details_table" id="order_detail_${ order.id }" style="display:none;">
            <h2>Order Details</h2>
            <div class="table-responsive">
                <table class="table">
                    <thead>
                    <tr>
                        <th scope="col">Product</th>
                        <th scope="col">Quantity</th>
                        <th scope="col">Total</th>
                    </tr>
                    </thead>
                    <tbody>
	                    <c:forEach var="orderDetail" items="${ order.orderDetailDTOs }">
							<tr>
		                        <td>
		                            <p>${ orderDetail.productName }</p>
		                        </td>
		                        <td>
		                            <h5>x ${ orderDetail.quantity }</h5>
		                        </td>
		                        <td>
		                            <p><fmt:formatNumber type="currency" value="${orderDetail.price}"/></p>
		                        </td>
		                    </tr>        
	                    </c:forEach>
                    <tr>
                        <td>
                            <h4>Subtotal</h4>
                        </td>
                        <td>
                            <h5></h5>
                        </td>
                        <td>
                            <p>$2160.00</p>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <h4>Shipping</h4>
                        </td>
                        <td>
                            <h5></h5>
                        </td>
                        <td>
                            <p>Flat rate: $50.00</p>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <h4>Total</h4>
                        </td>
                        <td>
                            <h5></h5>
                        </td>
                        <td>
                            <p>$2210.00</p>
                        </td>
                    </tr>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
    
	</c:forEach>
</section>
<!--================End Order Details Area =================-->
