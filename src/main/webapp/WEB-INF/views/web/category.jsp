<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!-- Start Banner Area -->
<section class="banner-area organic-breadcrumb">
	<div class="container">
		<div
			class="breadcrumb-banner d-flex flex-wrap align-items-center justify-content-end">
			<div class="col-first">
				<h1>Shop Category page</h1>
				<nav class="d-flex align-items-center">
					<a href="index.html">Home<span class="lnr lnr-arrow-right"></span></a>
					<a href="#">Shop<span class="lnr lnr-arrow-right"></span></a> <a
						href="category.html">Fashon Category</a>
				</nav>
			</div>
		</div>
	</div>
</section>
<!-- End Banner Area -->

<div class="container-fluid" style="padding:80px">
	<div class="row">
		<div class="col-xl-3 col-lg-4 col-md-5">
			<div class="sidebar-filter mt-50">
				<div class="top-filter-head">Product Filters</div>
				<div class="common-filter">
					<div class="head">Brands</div>
					<form action="#">
						<ul>
							<li class="filter-list"><input class="pixel-radio"
								onclick="window.location.href = '<c:url value="${productUrlBuilder.buildRootURL()}"/>'"
								type="radio" id="0" name="brand"
								<c:if test="${productUrlBuilder.categoryId == 0}">checked</c:if>><label
								for="all">All Product<span>(${allCategoryRanges})</span>
							</label></li>
							<c:forEach var="category" items="${categories}">
								<li class="filter-list"><input class="pixel-radio"
									onclick="window.location.href = '<c:url value="${productUrlBuilder.buildCategoryURL(category.id)}"/>'"
									type="radio" id="${ category.id }" name="brand"
									<c:if test="${productUrlBuilder.categoryId == category.id}">checked</c:if>>
									<label for="${category.code}">${category.name}<span>(<c:forEach
												var="categoryRange" items="${ categoryRanges }">
												<c:if test="${categoryRange.categoryId == category.id}">${ categoryRange.range }</c:if>
											</c:forEach>)
									</span>
								</label></li>
							</c:forEach>
						</ul>
					</form>
				</div>
				<div class="common-filter">
					<div class="head">Color</div>
					<form action="#">
						<ul>
							<li class="filter-list"><input class="pixel-radio"
								type="radio" id="black" name="color"><label for="black">Black<span>(29)</span></label></li>
							<li class="filter-list"><input class="pixel-radio"
								type="radio" id="balckleather" name="color"><label
								for="balckleather">Black Leather<span>(29)</span></label></li>
							<li class="filter-list"><input class="pixel-radio"
								type="radio" id="blackred" name="color"><label
								for="blackred">Black with red<span>(19)</span></label></li>
							<li class="filter-list"><input class="pixel-radio"
								type="radio" id="gold" name="color"><label for="gold">Gold<span>(19)</span></label></li>
							<li class="filter-list"><input class="pixel-radio"
								type="radio" id="spacegrey" name="color"><label
								for="spacegrey">Spacegrey<span>(19)</span></label></li>
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

						<div class="d-flex justify-content-around">
							<button type="button" class="btn btn-outline-secondary"
								onclick="window.location.href = '<c:url value="${productUrlBuilder.buildRootURL()}"/>'"
								style="width: 80px;">RESET</button>
							<button type="button" class="btn btn-outline-warning"
								onclick="filterWithPrice('<c:url value="${productUrlBuilder.buildURLWithoutPriceRange()}"/>');"
								style="width: 80px;">GO</button>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="col-xl-9 col-lg-8 col-md-7">
			<!-- Start Filter Bar -->
			<div class="filter-bar d-flex flex-wrap align-items-center">
				<div class="sorting">
					<div class="nice-select" tabindex="0">
						<span class="current">Default sorting</span>
						<ul class="list">
							<li data-value="1"
								onclick="window.location.href = '<c:url value="${productUrlBuilder.buildURL('name','DESC',productUrlBuilder.limit,1)}"/>'"
								class="option <c:if test="${ productUrlBuilder.orderBy == 'name' && productUrlBuilder.sortType =='DESC' }">focus selected</c:if> ">Sort
								by name down</li>
							<li data-value="1"
								onclick="window.location.href = '<c:url value="${productUrlBuilder.buildURL('name','ASC',productUrlBuilder.limit,1)}"/>'"
								class="option <c:if test="${ productUrlBuilder.orderBy == 'name' && productUrlBuilder.sortType =='ASC' }">focus selected</c:if> ">Sort
								by name up</li>
							<li data-value="1"
								onclick="window.location.href = '<c:url value="${productUrlBuilder.buildURL('price','DESC',productUrlBuilder.limit,1)}"/>'"
								class="option <c:if test="${ productUrlBuilder.orderBy == 'price' && productUrlBuilder.sortType =='DESC' }">focus selected</c:if> ">Sort
								by price down</li>
							<li data-value="1"
								onclick="window.location.href = '<c:url value="${productUrlBuilder.buildURL('price','ASC',productUrlBuilder.limit,1)}"/>'"
								class="option <c:if test="${ productUrlBuilder.orderBy == 'price' && productUrlBuilder.sortType =='ASC' }">focus selected</c:if> ">Sort
								by price up</li>
						</ul>
					</div>
				</div>
				<div class="sorting mr-auto">
					<div class="nice-select" tabindex="0">
						<span class="current">Show ${productUrlBuilder.limit}</span>
						<ul class="list">
							<li data-value="1"
								onclick="window.location.href = '<c:url value="${productUrlBuilder.buildURLWithLimit(8,1)}"/>'"
								class="option ${ productUrlBuilder.limit == 8 || productUrlBuilder.page ==null ? 'focus selected' : '' } ">Show
								8</li>
							<li data-value="1"
								onclick="window.location.href = '<c:url value="${productUrlBuilder.buildURLWithLimit(12,1)}"/>'"
								class="option ${ productUrlBuilder.limit == 12 ? 'focus selected' : '' }">Show
								12</li>
							<li data-value="1"
								onclick="window.location.href = '<c:url value="${productUrlBuilder.buildURLWithLimit(16,1)}"/>'"
								class="option ${ productUrlBuilder.limit == 16 ? 'focus selected' : '' }">Show
								16</li>
							<li data-value="1"
								onclick="window.location.href = '<c:url value="${productUrlBuilder.buildURLWithLimit(20,1)}"/>'"
								class="option ${ productUrlBuilder.limit == 20 ? 'focus selected' : '' }">Show
								20</li>
						</ul>
					</div>
				</div>
				<div class="pagination">
					<c:if test="${pages>4}">
						<a
							href="<c:url value="${  productUrlBuilder.buildURL(productUrlBuilder.page - 1 <= 0  ? 1 : productUrlBuilder.page - 1) }"/>"
							class="prev-arrow"><i class="fa fa-long-arrow-left"
							aria-hidden="true"></i></a>
						<c:set var="begin" value="${ productUrlBuilder.page }" />
						<c:set var="end"
							value="${ productUrlBuilder.page + 2 >= pages  ? pages : productUrlBuilder.page + 2 }" />

						<c:forEach var="i" begin="${begin}" end="${end}">
							<a href="<c:url value="${productUrlBuilder.buildURL(i)}"/>"
								class="<c:if test="${i==productUrlBuilder.page }">active</c:if>">${i}</a>
						</c:forEach>
						<c:if test="${pages - productUrlBuilder.page >= 4}">
							<a href="#" class="dot-dot"><i class="fa fa-ellipsis-h"
								aria-hidden="true"></i></a>
						</c:if>
						<c:if test="${pages > end}">
							<a href="<c:url value="${productUrlBuilder.buildURL(pages)}"/>">${pages}</a>
						</c:if>
						<a
							href="<c:url value="${ productUrlBuilder.buildURL(productUrlBuilder.page + 1 >= pages  ? pages : productUrlBuilder.page + 1) }"/>"
							class="next-arrow"><i class="fa fa-long-arrow-right"
							aria-hidden="true"></i></a>
					</c:if>
					<c:if test="${ pages<=4 }">
						<a
							href="<c:url value="${  productUrlBuilder.buildURL(productUrlBuilder.page - 1 >= 0  ? 1 : productUrlBuilder.page - 1) }"/>"
							class="prev-arrow"><i class="fa fa-long-arrow-left"
							aria-hidden="true"></i></a>
						<c:forEach var="i" begin="1" end="${pages}">
							<a href="<c:url value="${productUrlBuilder.buildURL(i)}"/>"
								class="<c:if test="${i==productUrlBuilder.page }">active</c:if>">${i}</a>
						</c:forEach>
						<a
							href="<c:url value="${ productUrlBuilder.buildURL(productUrlBuilder.page + 1 >= pages  ? pages : productUrlBuilder.page + 1) }"/>"
							class="next-arrow"><i class="fa fa-long-arrow-right"
							aria-hidden="true"></i></a>
					</c:if>
				</div>
			</div>
			<!-- End Filter Bar -->
			<!-- Start Best Seller -->
			<section class="lattest-product-area pb-40 category-list">
				<div class="row">
					<c:forEach var="product" items="${ products }">
						<!-- single product -->
						<div class="col-lg-3 col-md-6">
							<div class="single-product">
								<a href="<c:url value='/product-detail/${ product.id }'/>">
									<img class="img-fluid" src="${product.represent}" alt="">
								</a>
								<div class="product-details">
									<h6>${product.name }</h6>
									<div class="price">
										<c:if test="${ product.salePercent !=null }">
											<h6>$${product.priceNew}</h6>
											<h6 class="l-through">$${product.price}</h6>
										</c:if>
										<c:if test="${ product.salePercent ==null }">
											<h6>$${product.price}</h6>
										</c:if>
									</div>
									<div class="prd-bottom">

										<span class="social-info"
											onclick="addToBag(${product.id},${ currentUser != null ? true : false });">
											<span class="ti-bag"></span>
											<p class="hover-text">add to bag</p>
										</span> <a href="" class="social-info"> <span
											class="lnr lnr-heart"></span>
											<p class="hover-text">Wishlist</p>
										</a> <a href="" class="social-info"> <span
											class="lnr lnr-sync"></span>
											<p class="hover-text">compare</p>
										</a> <a href="" class="social-info"> <span
											class="lnr lnr-move"></span>
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
						<span class="current">Show ${productUrlBuilder.limit}</span>
						<ul class="list">
							<li data-value="1"
								onclick="window.location.href = '<c:url value="${productUrlBuilder.buildURLWithLimit(8,1)}"/>'"
								class="option ${ productUrlBuilder.limit == 8 || productUrlBuilder.page ==null ? 'focus selected' : '' } ">Show
								8</li>
							<li data-value="1"
								onclick="window.location.href = '<c:url value="${productUrlBuilder.buildURLWithLimit(12,1)}"/>'"
								class="option ${ productUrlBuilder.limit == 12 ? 'focus selected' : '' }">Show
								12</li>
							<li data-value="1"
								onclick="window.location.href = '<c:url value="${productUrlBuilder.buildURLWithLimit(16,1)}"/>'"
								class="option ${ productUrlBuilder.limit == 16 ? 'focus selected' : '' }">Show
								16</li>
							<li data-value="1"
								onclick="window.location.href = '<c:url value="${productUrlBuilder.buildURLWithLimit(20,1)}"/>'"
								class="option ${ productUrlBuilder.limit == 20 ? 'focus selected' : '' }">Show
								20</li>
						</ul>
					</div>
				</div>
				<div class="pagination">
					<c:if test="${pages>4}">
						<a
							href="<c:url value="${  productUrlBuilder.buildURL(productUrlBuilder.page - 1 <= 0  ? 1 : productUrlBuilder.page - 1) }"/>"
							class="prev-arrow"><i class="fa fa-long-arrow-left"
							aria-hidden="true"></i></a>
						<c:set var="begin" value="${ productUrlBuilder.page }" />
						<c:set var="end"
							value="${ productUrlBuilder.page + 2 >= pages  ? pages : productUrlBuilder.page + 2 }" />

						<c:forEach var="i" begin="${begin}" end="${end}">
							<a href="<c:url value="${productUrlBuilder.buildURL(i)}"/>"
								class="<c:if test="${i==productUrlBuilder.page }">active</c:if>">${i}</a>
						</c:forEach>
						<c:if test="${pages - productUrlBuilder.page >= 4}">
							<a href="#" class="dot-dot"><i class="fa fa-ellipsis-h"
								aria-hidden="true"></i></a>
						</c:if>
						<c:if test="${pages > end}">
							<a href="<c:url value="${productUrlBuilder.buildURL(pages)}"/>">${pages}</a>
						</c:if>
						<a
							href="<c:url value="${ productUrlBuilder.buildURL(productUrlBuilder.page + 1 >= pages  ? pages : productUrlBuilder.page + 1) }"/>"
							class="next-arrow"><i class="fa fa-long-arrow-right"
							aria-hidden="true"></i></a>
					</c:if>
					<c:if test="${ pages<=4 }">
						<a
							href="<c:url value="${  productUrlBuilder.buildURL(productUrlBuilder.page - 1 >= 0  ? 1 : productUrlBuilder.page - 1) }"/>"
							class="prev-arrow"><i class="fa fa-long-arrow-left"
							aria-hidden="true"></i></a>
						<c:forEach var="i" begin="1" end="${pages}">
							<a href="<c:url value="${productUrlBuilder.buildURL(i)}"/>"
								class="<c:if test="${i==productUrlBuilder.page }">active</c:if>">${i}</a>
						</c:forEach>
						<a
							href="<c:url value="${ productUrlBuilder.buildURL(productUrlBuilder.page + 1 >= pages  ? pages : productUrlBuilder.page + 1) }"/>"
							class="next-arrow"><i class="fa fa-long-arrow-right"
							aria-hidden="true"></i></a>
					</c:if>
				</div>
			</div>
			<!-- End Filter Bar -->
		</div>
	</div>
</div>

<!-- Modal Quick Product View -->
<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog"
	aria-hidden="true">
	<div class="modal-dialog" role="document">
		<div class="container relative">
			<button type="button" class="close" data-dismiss="modal"
				aria-label="Close">
				<span aria-hidden="true">&times;</span>
			</button>
			<div class="product-quick-view">
				<div class="row align-items-center">
					<div class="col-lg-6">
						<div class="quick-view-carousel">
							<div class="item"
								style="background: url(<c:url value="/asset/web/img/organic-food/q1.jpg"/>);">

							</div>
							<div class="item"
								style="background: url(<c:url value="/asset/web/img/organic-food/q1.jpg"/>);">

							</div>
							<div class="item"
								style="background: url(<c:url value="/asset/web/img/organic-food/q1.jpg"/>);">

							</div>
						</div>
					</div>
					<div class="col-lg-6">
						<div class="quick-view-content">
							<div class="top">
								<h3 class="head">Mill Oil 1000W Heater, White</h3>
								<div class="price d-flex align-items-center">
									<span class="lnr lnr-tag"></span> <span class="ml-10">$149.99</span>
								</div>
								<div class="category">
									Category: <span>Household</span>
								</div>
								<div class="available">
									Availibility: <span>In Stock</span>
								</div>
							</div>
							<div class="middle">
								<p class="content">Mill Oil is an innovative oil filled
									radiator with the most modern technology. If you are looking
									for something that can make your interior look awesome, and at
									the same time give you the pleasant warm feeling during the
									winter.</p>
								<a href="#" class="view-full">View full Details <span
									class="lnr lnr-arrow-right"></span></a>
							</div>
							<div class="bottom">
								<div class="color-picker d-flex align-items-center">
									Color: <span class="single-pick"></span> <span
										class="single-pick"></span> <span class="single-pick"></span>
									<span class="single-pick"></span> <span class="single-pick"></span>
								</div>
								<div class="quantity-container d-flex align-items-center mt-15">
									Quantity: <input type="text" class="quantity-amount ml-15"
										value="1" />
									<div class="arrow-btn d-inline-flex flex-column">
										<button class="increase arrow" type="button"
											title="Increase Quantity">
											<span class="lnr lnr-chevron-up"></span>
										</button>
										<button class="decrease arrow" type="button"
											title="Decrease Quantity">
											<span class="lnr lnr-chevron-down"></span>
										</button>
									</div>

								</div>
								<div class="d-flex mt-20">
									<a href="#" class="view-btn color-2"><span>Add to
											Cart</span></a> <a href="#" class="like-btn"><span
										class="lnr lnr-layers"></span></a> <a href="#" class="like-btn"><span
										class="lnr lnr-heart"></span></a>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>

