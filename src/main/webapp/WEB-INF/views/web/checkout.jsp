<%--
  Created by IntelliJ IDEA.
  User: manhthanh
  Date: 01/11/2022
  Time: 09:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- Start Banner Area -->
<section class="banner-area organic-breadcrumb">
    <div class="container">
        <div class="breadcrumb-banner d-flex flex-wrap align-items-center justify-content-end">
            <div class="col-first">
                <h1>Checkout</h1>
                <nav class="d-flex align-items-center">
                    <a href="index.html">Home<span class="lnr lnr-arrow-right"></span></a>
                    <a href="single-product.html">Checkout</a>
                </nav>
            </div>
        </div>
    </div>
</section>
<!-- End Banner Area -->

<!--================Checkout Area =================-->
<section class="checkout_area section_gap">
    <div class="container">
        <div class="returning_customer">
            <div class="check_title">
                <h2>Returning Customer? <a href="#">Click here to login</a></h2>
            </div>
            <p>If you have shopped with us before, please enter your details in the boxes below. If you are a new
                customer, please proceed to the Billing & Shipping section.</p>
            <form class="row contact_form" action="#" method="post" novalidate="novalidate">
                <div class="col-md-6 form-group p_star">
                    <input type="text" class="form-control" id="name" name="name">
                    <span class="placeholder" data-placeholder="Username or Email"></span>
                </div>
                <div class="col-md-6 form-group p_star">
                    <input type="password" class="form-control" id="password" name="password">
                    <span class="placeholder" data-placeholder="Password"></span>
                </div>
                <div class="col-md-12 form-group">
                    <button type="submit" value="submit" class="primary-btn">login</button>
                    <div class="creat_account">
                        <input type="checkbox" id="f-option" name="selector">
                        <label for="f-option">Remember me</label>
                    </div>
                    <a class="lost_pass" href="#">Lost your password?</a>
                </div>
            </form>
        </div>
        <div class="billing_details">
            <div class="row">
                <div class="col-lg-8">
                    <h3>Update Order Information</h3>
                    <c:url value='/checkout/process' var="url"/>
                    <form:form class="row contact_form" action="${url}" method="POST" modelAttribute="order" >
                         <div class="col-md-6 form-group p_star">
                            <form:input type="text" class="form-control" id="phone" name="phone" path="phone"/>
                            <span class="placeholder" data-placeholder="Phone number"></span>
                        </div>
                        <div class="col-md-6 form-group">
                            <form:input type="text" class="form-control" id="discountCode" name="discountCode" placeholder="DiscountCode/ZIP" path="discountCode"/>
                        </div>
                        <div class="col-md-12 form-group p_star">
                            <form:select class="country_select" path="city">
                                <form:option value="null">-- Select City --</form:option>
                                <form:option value="HoChiMinh">Ho Chi Minh City</form:option>
                                <form:option value="HaNoi">Ha Noi City</form:option>
                                <form:option value="DaNang">Da Nang City</form:option>
                            </form:select>
                        </div>
                        <div class="col-md-12 form-group p_star">
                            <form:select class="country_select" path="paymentMethod">
                                <form:option value="null">-- Select Payment Method --</form:option>
                                <form:option value="Momo">Momo</form:option>
                                <form:option value="CreditCards">Credit Cards</form:option>
                                <form:option value="MobilePayments">Mobile Payments</form:option>
                                <form:option value="Cash">Cash</form:option>
                            </form:select>
                        </div>
                        <div class="col-md-12 form-group p_star">
                            <form:input type="text" class="form-control" id="shipingAddress" name="shipingAddress" path="shipingAddress"/>
                            <span class="placeholder" data-placeholder="Address line 01"></span>
                        </div>
                        <div>
                        	<form:input type="hidden" path="id"/>
                        	<form:input type="hidden" path="username"/>
                        	<form:input type="hidden" path="orderStatus"/>
                        	<form:input type="hidden" path="ammount"/>
                        	<form:input type="hidden" path="discountCodeId"/>
                        </div>
                        <div class="col-md-12 form-group">
                       		<input class="genric-btn primary-border circle arrow" type="submit" value="Submit"/>
                        </div>
                    </form:form>
                </div>
                <div class="col-lg-4">
                    <div class="order_box">
                        <h2>Your Order</h2>
                        <ul class="list">
                            <li><a href="#">Product <span>Total</span></a></li>
                            <c:set var="sumPrice" value="0"/>
                            <c:forEach var="cartDetail" items="${ cartDetails }">
		                    	<input type="hidden" value="${ sumPrice = sumPrice + cartDetail.price }"/> 
	                            <li>
		                            <a href="#">${ cartDetail.productName }
		                            	<span class="middle">x ${ cartDetail.quantity }</span> 
		                            	<span class="last">
                                			<fmt:formatNumber type="currency" value="${cartDetail.price}"/>
		                            	</span>
		                            </a>
	                            </li>
                            </c:forEach>
                        </ul>
                        <ul class="list list_2">
                            <li><a href="#">Subtotal 
	                            	<span>
	                                	<fmt:formatNumber type="currency" value="${sumPrice}"/>
	                                </span>
                                </a>
                            </li>
                            <li><a href="#">Shipping <span>Flat rate: $0.00</span></a></li>
                            <li><a href="#">Total <span><fmt:formatNumber type="currency" value="${sumPrice}"/></span></a></li>
                        </ul>
                        <div class="payment_item">
                            <div class="radion_btn">
                                <input type="radio" id="f-option5" name="selector">
                                <label for="f-option5">Check payments</label>
                                <div class="check"></div>
                            </div>
                            <p>Please send a check to Store Name, Store Street, Store Town, Store State / County,
                                Store Postcode.</p>
                        </div>
                        <div class="payment_item active">
                            <div class="radion_btn">
                                <input type="radio" id="f-option6" name="selector">
                                <label for="f-option6">Paypal </label>
                                <img src="<c:url value="/asset/web/img/product/card.jpg"/>" alt="">
                                <div class="check"></div>
                            </div>
                            <p>Pay via PayPal; you can pay with your credit card if you don’t have a PayPal
                                account.</p>
                        </div>
                        <div class="creat_account">
                            <input type="checkbox" id="f-option4" name="selector">
                            <label for="f-option4">I’ve read and accept the </label>
                            <a href="#">terms & conditions*</a>
                        </div>
                        <a class="primary-btn" href="#">Proceed to Paypal</a>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
<!--================End Checkout Area =================-->
