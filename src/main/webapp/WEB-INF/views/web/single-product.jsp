
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- Start Banner Area -->
<section class="banner-area organic-breadcrumb">
    <div class="container">
        <div class="breadcrumb-banner d-flex flex-wrap align-items-center justify-content-end">
            <div class="col-first">
                <h1>Shopping Product Detail</h1>
                <nav class="d-flex align-items-center">
                    <a href="index.html">Home<span class="lnr lnr-arrow-right"></span></a>
                    <a href="category.html">Product Detail</a>
                </nav>
            </div>
        </div>
    </div>
</section>
<!-- End Banner Area -->

	<c:if test="${ isExist == true }">
		<div class="container">
			<div class="card mt-5 mb-5">
				<div class="container-fliud">
					<div class="wrapper row">
						<div class="preview col-md-6">
							<div class="preview-pic tab-content">
								<c:forEach var="productDetail" items="${ productDetails }">
										<div class="tab-pane ${ productDetail.id == 1 ? "active show" : "" }"  id="pic-${productDetail.id }"><img src="${ productDetail.image }" /></div>
								</c:forEach>
							</div>
							<ul class="preview-thumbnail nav nav-tabs">
								<c:forEach var="productDetail" items="${ productDetails }">
							  		<li ${ productDetail.id == 1 ? "class='active'" : "" }><a data-target="#pic-${productDetail.id}" data-toggle="tab"><img src="${ productDetail.image }" /></a></li>
								</c:forEach>
							</ul>
							
						</div>
						<div class="details col-md-6">
							<h3 class="product-title">${ product.name }</h3>
							<div class="rating">
								<div class="stars">
									<span class="fa fa-star checked"></span>
									<span class="fa fa-star checked"></span>
									<span class="fa fa-star checked"></span>
									<span class="fa fa-star"></span>
									<span class="fa fa-star"></span>
								</div>
								<span class="review-no">41 reviews</span>
							</div>
							<p class="product-description">${ product.description }</p>
							<h4 class="price">current price: <span>${ product.price }</span></h4>
							<p class="vote"><strong>91%</strong> of buyers enjoyed this product! <strong>(87 votes)</strong></p>
							<h5 class="sizes">sizes:
								<c:forEach var="size" items="${ sizes }">
									<span class="size" data-toggle="tooltip" title="${ size.name }">${ size.code }</span>
								</c:forEach>
							</h5>
							<h5 class="colors">colors:
								<span class="color orange not-available" data-toggle="tooltip" title="Not In store"></span>
								<c:forEach var="colorvar" items="${ colors }">
									<span class="color ${ colorvar.name }"></span>
								</c:forEach>
							</h5>
							<div class="action">
								<button class="add-to-cart btn btn-default" type="button">add to cart</button>
								<button class="like btn btn-default" type="button"><span class="fa fa-heart"></span></button>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</c:if>
	
	<c:if test="${ isExist == false }">
		<div class="container mt-5 mb-5">
			<h1>Product is not exist</h1>
		</div>
	</c:if>