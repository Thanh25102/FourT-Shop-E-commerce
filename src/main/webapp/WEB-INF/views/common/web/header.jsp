<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- Start Header Area -->
<header class="header_area sticky-header">
	<div class="main_menu">
		<nav class="navbar navbar-expand-lg navbar-light main_box">
			<div class="container">
				<!-- Brand and toggle get grouped for better mobile display -->
				<a class="navbar-brand logo_h" href="index.html"><img
					src="img/logo.png" alt=""></a>
				<button class="navbar-toggler" type="button" data-toggle="collapse"
					data-target="#navbarSupportedContent"
					aria-controls="navbarSupportedContent" aria-expanded="false"
					aria-label="Toggle navigation">
					<span class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<!-- Collect the nav links, forms, and other content for toggling -->
				<div class="collapse navbar-collapse offset"
					id="navbarSupportedContent">
					<ul class="nav navbar-nav menu_nav ml-auto">
						<li class="nav-item active"><a class="nav-link"
							href="<c:url value='/'/>">Home</a></li>
						<li class="nav-item submenu dropdown"><a href="#"
							class="nav-link dropdown-toggle" data-toggle="dropdown"
							role="button" aria-haspopup="true" aria-expanded="false">Shop</a>
							<ul class="dropdown-menu">
								<li class="nav-item"><a class="nav-link"
									href="<c:url value='/category'/>">Shop Category</a></li>
								<li class="nav-item"><a class="nav-link"
									href="<c:url value='/checkout'/>">Product Checkout</a></li>
								<li class="nav-item"><a class="nav-link" href="<c:url value='/cart'/>">Shopping
										Cart</a></li>
								<li class="nav-item"><a class="nav-link"
									href="<c:url value='/confirmation'/>">Order</a></li>
							</ul></li>
						<li class="nav-item submenu dropdown"><a href="#"
							class="nav-link dropdown-toggle" data-toggle="dropdown"
							role="button" aria-haspopup="true" aria-expanded="false">Blog</a>
							<ul class="dropdown-menu">
								<li class="nav-item"><a class="nav-link" href="blog.html">Blog</a></li>
								<li class="nav-item"><a class="nav-link"
									href="single-blog.html">Blog Details</a></li>
							</ul></li>
						<li class="nav-item submenu dropdown"><a href="#"
							class="nav-link dropdown-toggle" data-toggle="dropdown"
							role="button" aria-haspopup="true" aria-expanded="false">Pages</a>
							<ul class="dropdown-menu">
								<li class="nav-item"><a class="nav-link" href="<c:url value='/login'/>">Login</a></li>
								<li class="nav-item"><a class="nav-link"
									href="tracking.html">Tracking</a></li>
								<li class="nav-item"><a class="nav-link"
									href="elements.html">Elements</a></li>
							</ul></li>
						<li class="nav-item"><a class="nav-link" href="<c:url value='/contact'/>">Contact</a></li>
						<c:if test="${currentUser!=null}">
							<li class="nav-item submenu dropdown"
								style="display: flex; align-items: center;"><c:if
									test="${ currentUser.avatar ==null }">
									<a class="nav-link" href="#">${ currentUser.username }</a>
								</c:if> <c:if test="${ currentUser.avatar !=null }">
									<img src="${ currentUser.avatar }"
										class="rounded-circle shadow-4 nav-link dropdown-toggle"
										style="width: 24px;">
								</c:if>

								<ul class="dropdown-menu">
									<li class="nav-item"><a class="nav-link" href="login.html">Edit
											profile</a></li>
									<li class="nav-item"><a class="nav-link"
										href="<c:url value='/order'/>">Order</a></li>
									<li class="nav-item"><a class="nav-link"
										href="<c:url value='/cart'/>">Cart</a></li>
								</ul></li>
						</c:if>
						<c:if test="${ currentUser==null }">
							<li class="nav-item"><a class="nav-link" href="<c:url value='/login'/>">Login</a></li>
						</c:if>
					</ul>
					<ul class="nav navbar-nav navbar-right">
						<li class="nav-item"> 
							<a href="<c:url value='/cart'/>"class="cart"> 
								<span class="lnr lnr-cart" style="position: relative;">
									<p class="text-danger" style="position: absolute;top: -43px;left: 10px;" id="quantity_product">0</p>
								</span>
							</a>
						</li>
						<li class="nav-item"><a href="<c:url value='/confirmation'/>" class="cart"> <span
								class="ti-bag"></span></a></li>
						<li class="nav-item">
							<button class="search">
								<span class="lnr lnr-magnifier" id="search"></span>
							</button>
						</li>
					</ul>
				</div>
			</div>
		</nav>
	</div>
	<div class="search_input" id="search_input_box">
		<div class="container">
			<form class="d-flex justify-content-between">
				<input type="text" class="form-control" id="search_input"
					placeholder="Search Here">
				<button type="submit" class="btn"></button>
				<span class="lnr lnr-cross" id="close_search" title="Close Search"></span>
			</form>
		</div>
	</div>
</header>
<!-- End Header Area -->