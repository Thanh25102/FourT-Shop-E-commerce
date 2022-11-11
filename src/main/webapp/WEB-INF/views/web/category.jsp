<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
		 pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
	<!-- Start Banner Area -->
	<section class="banner-area organic-breadcrumb">
		<div class="container">
			<div class="breadcrumb-banner d-flex flex-wrap align-items-center justify-content-end">
				<div class="col-first">
					<h1>Shop Category page</h1>
					<nav class="d-flex align-items-center">
						<a href="index.html">Home<span class="lnr lnr-arrow-right"></span></a>
						<a href="#">Shop<span class="lnr lnr-arrow-right"></span></a>
						<a href="category.html">Fashon Category</a>
					</nav>
				</div>
			</div>
		</div>
	</section>
	<!-- End Banner Area -->
	<div class="container mt-5 mb-5">
		<div class="row">
			<div class="col-xl-3 col-lg-4 col-md-5">
				<div class="sidebar-filter mt-50">
					<div class="top-filter-head">Product Filters</div>
					<div class="common-filter">
						<div class="head">Brands</div>
						<form action="#">
							<ul>
								<li class="filter-list"><input class="pixel-radio" type="radio" id="all" name="categoryId" onclick="window.location.href = '<c:url value="/category?page=${curPage}&&limit=${url.limit }&&categoryId=0&&orderBy=name&&sortType=ASC&&priceStart=${ url.priceStart }&&priceEnd=${ url.priceEnd }"/>';"><label for="all">All<span>( ${allProducts} )</span></label></li>
								<c:forEach var="category" items="${categories }">
									<li class="filter-list">
										<input class="pixel-radio" type="radio" id="${ category.id }" name="categoryId" >
										<label for="${ category.id }">${category.name}<span>(
											<c:forEach var="categoryRange" items="${ categoryRanges }">
												<c:if test="${categoryRange.categoryId == category.id}">${ categoryRange.range }</c:if>
											</c:forEach>
										)</span></label>
									</li>
								</c:forEach>
							</ul>
						</form>
					</div>
					<div class="common-filter">
						<div class="head">Price</div>
						<div class="price-range-area">
							<div id="price-range"></div>
							<div class="value-wrapper d-flex">
								<div class="price">Price:</div>
								<span>$</span>
								<div id="lower-value"></div>
								<div class="to">to</div>
								<span>$</span>
								<div id="upper-value"></div>
							</div>
						</div>
						<div style="display: flex;
									margin-top: 20px;">
							<button onclick="filterByPrice('<c:url value="/category?page=${curPage}&&limit=${url.limit }&&categoryId=${ url.categoryId }&&orderBy=price&&sortType=${url.sortType}"/>')" class="genric-btn success-border circle m-auto">Filter -></button>
						</div>
					</div>
					
					<div class="common-filter">
						<div style="display: flex; margin-top: 20px;">
							<a href="<c:url value='/category'/>" class="genric-btn success-border circle m-auto">Reset</a>
						</div>
					</div>
				</div>
			</div>
			<div class="col-xl-9 col-lg-8 col-md-7">
				<!-- Start Filter Bar -->
				<div class="filter-bar d-flex flex-wrap align-items-center">
					<div class="sorting">
						<div class="nice-select" tabindex="0">
							<span class="current">Sort by ${url.orderBy} and ${url.sortType}</span>
							<ul class="list">
								<a href="<c:url value="/category?page=${curPage}&&limit=${url.limit }&&categoryId=${ url.categoryId }&&orderBy=name&&sortType=ASC&&priceStart=${ url.priceStart }&&priceEnd=${ url.priceEnd }"/>">
									<li data-value="1" class="option ${ (url.orderBy == 'name' && url.sortType =='ASC') ? 'focus selected' : '' } ">Sort by name asc</li>
								</a>
								<a href="<c:url value="/category?page=${curPage}&&limit=${url.limit }&&categoryId=${ url.categoryId }&&orderBy=name&&sortType=DESC&&priceStart=${ url.priceStart }&&priceEnd=${ url.priceEnd }"/>">
									<li data-value="1" class="option ${ (url.orderBy == 'name' && url.sortType =='DESC') ? 'focus selected' : '' } ">Sort by name desc</li>
								</a>
								<a href="<c:url value="/category?page=${curPage}&&limit=${url.limit }&&categoryId=${ url.categoryId }&&orderBy=price&&sortType=ASC&&priceStart=${ url.priceStart }&&priceEnd=${ url.priceEnd }"/>">
									<li data-value="1" class="option ${ (url.orderBy == 'price' && url.sortType =='ASC') ? 'focus selected' : '' } ">Sort by price asc</li>
								</a>
								<a href="<c:url value="/category?page=${curPage}&&limit=${url.limit }&&categoryId=${ url.categoryId }&&orderBy=price&&sortType=DESC&&priceStart=${ url.priceStart }&&priceEnd=${ url.priceEnd }"/>">
									<li data-value="1" class="option ${ (url.orderBy == 'price' && url.sortType =='DESC') ? 'focus selected' : '' } ">Sort by price desc</li>
								</a>
							</ul>
						</div>
					</div>
					<div class="sorting mr-auto">
						<div class="nice-select" tabindex="0">
							<span class="current">Show ${url.limit}</span>
							<ul class="list">
								<a href="<c:url value="/category?page=${curPage}&&limit=6&&categoryId=${ url.categoryId }&&orderBy=${ url.orderBy }&&sortType=${ url.sortType }&&priceStart=${ url.priceStart }&&priceEnd=${ url.priceEnd }"/>">
									<li data-value="1" class="option ${ (url.limit == 6 || url.page ==null) ? 'focus selected' : '' } ">Show 6</li>
								</a>
								<a href="<c:url value="/category?page=${curPage}&&limit=9&&categoryId=${ url.categoryId }&&orderBy=${ url.orderBy }&&sortType=${ url.sortType }&&priceStart=${ url.priceStart }&&priceEnd=${ url.priceEnd }"/>">
									<li data-value="1" class="option ${ url.limit == 9 ? 'focus selected' : '' }">Show 9</li>
								</a>
								<a href="<c:url value="/category?page=${curPage}&&limit=12&&categoryId=${ url.categoryId }&&orderBy=${ url.orderBy }&&sortType=${ url.sortType }&&priceStart=${ url.priceStart }&&priceEnd=${ url.priceEnd }"/>">
									<li data-value="1" class="option ${ url.limit == 12 ? 'focus selected' : '' }">Show 12</li>
								</a>
							</ul>
						</div>
					</div>
					<div class="pagination">
						<c:if test="${ totalPage >3 }">
							<a href="<c:url value="/category?page=${(curPage - 1) == 0 ? 1 : curPage-1 }&&limit=${url.limit}&&categoryId=${ url.categoryId }&&orderBy=${ url.orderBy }&&sortType=${ url.sortType }&&priceStart=${ url.priceStart }&&priceEnd=${ url.priceEnd }"/>" class="prev-arrow"><i class="fa fa-long-arrow-left" aria-hidden="true"></i></a>
							<c:forEach var="i" begin="${(curPage - 1) == 0 ? 1 : curPage-1 }" end="${(curPage + 2) >= totalPage ? totalPage : (curPage+2)}">
								<a href="<c:url value="/category?page=${i}&&limit=${url.limit}&&categoryId=${ url.categoryId }&&orderBy=${ url.orderBy }&&sortType=${ url.sortType }&&priceStart=${ url.priceStart }&&priceEnd=${ url.priceEnd }"/>" ${ i == curPage ? "class='active'" : "" }>${ i }</a>
							</c:forEach>
							<c:if test="${curPage+2 <totalPage }">
								<a href="#" class="dot-dot" style="padding-right:12px; padding-left:12px"><i class="fa fa-ellipsis-h" aria-hidden="true"></i></a>
								<a href="<c:url value="/category?page=${totalPage}&&limit=${url.limit}&&categoryId=${ url.categoryId }&&orderBy=${ url.orderBy }&&sortType=${ url.sortType }&&priceStart=${ url.priceStart }&&priceEnd=${ url.priceEnd }"/>" ${curPage == totalPage ? "class='active'" : "" }>${ totalPage }</a>
							</c:if>
							<a href="<c:url value="/category?page=${(curPage + 1) >= totalPage  ? totalPage : curPage+1 }&&limit=${url.limit}&&categoryId=${ url.categoryId }&&orderBy=${ url.orderBy }&&sortType=${ url.sortType }&&priceStart=${ url.priceStart }&&priceEnd=${ url.priceEnd }"/>" class="next-arrow"><i class="fa fa-long-arrow-right" aria-hidden="true"></i></a>
							
						</c:if>
						<c:if test="${ totalPage <=3 }">
							<c:forEach var="i" begin="1" end="${totalPage}">
								<a href="#" ${ i == curPage ? "class='active'" : "" } class="active">${ i }</a>
							</c:forEach>
						</c:if>
					</div>
				</div>
				<!-- End Filter Bar -->
				<!-- Start Best Seller -->
				<section class="lattest-product-area pb-40 category-list">
					<div class="row">
					<c:forEach var="product" items="${ products }">
							<!-- single product -->
							<div class="col-lg-4 col-md-6">
								<div class="single-product">
									<a href="<c:url value='/product-detail/${ product.id }'/>">
										<img class="img-fluid" src="${product.represent}" alt="">
									</a>
									<div class="product-details">
										<h6>${product.name }</h6>
										<div class="price">
											<h6>$${product.price}</h6>
											<h6 class="l-through">$${product.price}</h6>
										</div>
										<div class="prd-bottom">

											<span class="social-info" onclick="addToBag(${product.id},${ currentUser != null ? true : false });">
												<span class="ti-bag"></span>
												<p class="hover-text" >add to bag</p>
											</span>
											<a href="" class="social-info">
												<span class="lnr lnr-heart"></span>
												<p class="hover-text">Wishlist</p>
											</a>
											<a href="" class="social-info">
												<span class="lnr lnr-sync"></span>
												<p class="hover-text">compare</p>
											</a>
											<a href="" class="social-info">
												<span class="lnr lnr-move"></span>
												<p class="hover-text">view more</p>
											</a>
										</div>
									</div>
								</div>
							</div>
							<!-- single product -->
						</c:forEach>
					</div>
				</section>
				<!-- End Best Seller -->
				<!-- Start Filter Bar -->
				<div class="filter-bar d-flex flex-wrap align-items-center">
					<div class="sorting mr-auto">
						<div class="nice-select" tabindex="0">
							<span class="current">Show ${url.limit}</span>
							<ul class="list">
								<a href="<c:url value="/category?page=${curPage}&&limit=6&&categoryId=${ url.categoryId }&&orderBy=${ url.orderBy }&&sortType=${ url.sortType }&&priceStart=${ url.priceStart }&&priceEnd=${ url.priceEnd }"/>">
									<li data-value="1" class="option ${ (url.limit == 6 || url.page ==null) ? 'focus selected' : '' } ">Show 6</li>
								</a>
								<a href="<c:url value="/category?page=${curPage}&&limit=9&&categoryId=${ url.categoryId }&&orderBy=${ url.orderBy }&&sortType=${ url.sortType }&&priceStart=${ url.priceStart }&&priceEnd=${ url.priceEnd }"/>">
									<li data-value="1" class="option ${ url.limit == 9 ? 'focus selected' : '' }">Show 9</li>
								</a>
								<a href="<c:url value="/category?page=${curPage}&&limit=12&&categoryId=${ url.categoryId }&&orderBy=${ url.orderBy }&&sortType=${ url.sortType }&&priceStart=${ url.priceStart }&&priceEnd=${ url.priceEnd }"/>">
									<li data-value="1" class="option ${ url.limit == 12 ? 'focus selected' : '' }">Show 12</li>
								</a>
							</ul>
						</div>
					</div>
					<div class="pagination">
						<c:if test="${ totalPage >3 }">
							<a href="<c:url value="/category?page=${(curPage - 1) == 0 ? 1 : curPage-1 }&&limit=${url.limit}&&categoryId=${ url.categoryId }&&orderBy=${ url.orderBy }&&sortType=${ url.sortType }&&priceStart=${ url.priceStart }&&priceEnd=${ url.priceEnd }"/>" class="prev-arrow"><i class="fa fa-long-arrow-left" aria-hidden="true"></i></a>
							<c:forEach var="i" begin="${(curPage - 1) == 0 ? 1 : curPage-1 }" end="${(curPage + 2) >= totalPage ? totalPage : (curPage+2)}">
								<a href="<c:url value="/category?page=${i}&&limit=${url.limit}&&categoryId=${ url.categoryId }&&orderBy=${ url.orderBy }&&sortType=${ url.sortType }&&priceStart=${ url.priceStart }&&priceEnd=${ url.priceEnd }"/>" ${ i == curPage ? "class='active'" : "" }>${ i }</a>
							</c:forEach>
							<c:if test="${curPage+2 <totalPage }">
								<a href="#" class="dot-dot" style="padding-right:12px; padding-left:12px"><i class="fa fa-ellipsis-h" aria-hidden="true"></i></a>
								<a href="<c:url value="/category?page=${totalPage}&&limit=${url.limit}&&categoryId=${ url.categoryId }&&orderBy=${ url.orderBy }&&sortType=${ url.sortType }&&priceStart=${ url.priceStart }&&priceEnd=${ url.priceEnd }"/>" ${curPage == totalPage ? "class='active'" : "" }>${ totalPage }</a>
							</c:if>
							<a href="<c:url value="/category?page=${(curPage + 1) >= totalPage  ? totalPage : curPage+1 }&&limit=${url.limit}&&categoryId=${ url.categoryId }&&orderBy=${ url.orderBy }&&sortType=${ url.sortType }&&priceStart=${ url.priceStart }&&priceEnd=${ url.priceEnd }"/>" class="next-arrow"><i class="fa fa-long-arrow-right" aria-hidden="true"></i></a>

						</c:if>
						<c:if test="${ totalPage <=3 }">
							<c:forEach var="i" begin="1" end="${totalPage}">
								<a href="#" ${ i == curPage ? "class='active'" : "" } class="active">${ i }</a>
							</c:forEach>
						</c:if>
					</div>
				</div>
				<!-- End Filter Bar -->
			</div>
		</div>
	</div>
	<!-- Modal Quick Product View -->
	<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="container relative">
				<button type="button" class="close" data-dismiss="modal" aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				<div class="product-quick-view">
					<div class="row align-items-center">
						<div class="col-lg-6">
							<div class="quick-view-carousel">
								<div class="item" style="background: url(<c:url value="/asset/web/img/organic-food/q1.jpg"/>);">

								</div>
								<div class="item" style="background: url(<c:url value="/asset/web/img/organic-food/q1.jpg"/>);">

								</div>
								<div class="item" style="background: url(<c:url value="/asset/web/img/organic-food/q1.jpg"/>);">

								</div>
							</div>
						</div>
						<div class="col-lg-6">
							<div class="quick-view-content">
								<div class="top">
									<h3 class="head">Mill Oil 1000W Heater, White</h3>
									<div class="price d-flex align-items-center"><span class="lnr lnr-tag"></span> <span class="ml-10">$149.99</span></div>
									<div class="category">Category: <span>Household</span></div>
									<div class="available">Availibility: <span>In Stock</span></div>
								</div>
								<div class="middle">
									<p class="content">Mill Oil is an innovative oil filled radiator with the most modern technology. If you are
										looking for something that can make your interior look awesome, and at the same time give you the pleasant
										warm feeling during the winter.</p>
									<a href="#" class="view-full">View full Details <span class="lnr lnr-arrow-right"></span></a>
								</div>
								<div class="bottom">
									<div class="color-picker d-flex align-items-center">Color:
										<span class="single-pick"></span>
										<span class="single-pick"></span>
										<span class="single-pick"></span>
										<span class="single-pick"></span>
										<span class="single-pick"></span>
									</div>
									<div class="quantity-container d-flex align-items-center mt-15">
										Quantity:
										<input type="text" class="quantity-amount ml-15" value="1" />
										<div class="arrow-btn d-inline-flex flex-column">
											<button class="increase arrow" type="button" title="Increase Quantity"><span class="lnr lnr-chevron-up"></span></button>
											<button class="decrease arrow" type="button" title="Decrease Quantity"><span class="lnr lnr-chevron-down"></span></button>
										</div>

									</div>
									<div class="d-flex mt-20">
										<a href="#" class="view-btn color-2"><span>Add to Cart</span></a>
										<a href="#" class="like-btn"><span class="lnr lnr-layers"></span></a>
										<a href="#" class="like-btn"><span class="lnr lnr-heart"></span></a>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	