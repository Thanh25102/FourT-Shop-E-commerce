<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- Begin Page Content -->
<div class="container-fluid">

	<!-- Page Heading -->
	<h1 class="h3 mb-2 text-gray-800">Tables</h1>
	<p class="mb-4">
		DataTables is a third party plugin that is used to generate the demo
		table below. For more information about DataTables, please visit the <a
			target="_blank" href="https://datatables.net">official DataTables
			documentation</a>.
	</p>

	<!-- DataTales Example -->
	<div class="card shadow mb-4">
		<div class="row">
			<div class="py-3 col-sm-12 col-md-6 text-left">
				<c:if test="${ model eq 'ProductDetail' }">
					<a href="<c:url value="/admin/product"/>">
						<button class="btn-facebook rounded px-3">Back</button>
					</a>
				</c:if>
				<c:if test="${ model != 'ProductDetail' }">
					<h6 class="m-0 font-weight-bold text-primary">DataTables</h6>
				</c:if>
			</div>
			<div
				class="col-sm-12 col-md-6 text-right  align-items-center row justify-content-end">

				<c:choose>
					<c:when test="${ model eq 'Product' }">
						<a href="<c:url value="/admin/product?action=add"/>">
							<button class="btn-facebook rounded px-3">Add data</button>
						</a>
					</c:when>
					<c:when test="${ model eq 'ProductDetail' }">
						<a
							href="<c:url value="/admin/product-detail/${ pathVariable }?action=add"/>">
							<button class="btn-facebook rounded px-3">Add data</button>
						</a>
					</c:when>
				</c:choose>
			</div>
		</div>
		<div class="card-body">
			<div class="table-responsive">
				<table class="table table-bordered" id="dataTable" width="100%"
					cellspacing="0">
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
							<c:when test="${model eq 'ProductDetail' }">
								<tr>
									<th>Id</th>
									<th>Image</th>
									<th>Description</th>
									<th>Quantity</th>
									<th>Size</th>
									<th>Color</th>
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
							<c:when test="${model eq 'ProductDetail' }">
								<tr>
									<th>Id</th>
									<th>Image</th>
									<th>Description</th>
									<th>Quantity</th>
									<th>Size</th>
									<th>Color</th>
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
										<th><img src="${product.represent}"
											class="custom-img-o img-thumbnail" /></th>
										<th>${product.categoryByCategoryId.name}</th>
										<th>${product.discountByDiscountId.id}</th>
										<th><a
											href="<c:url value='/admin/product-detail/${product.id}'/>">
												Detail</a></th>
										<th><a
											href="<c:url value="/admin/product?action=update&&id=${product.id}"/>">update</a>
											<a href="#"
											onclick="sendPostRequest(`<c:url value="/admin/product/delete/${ product.id }"/>`);">delete</a>
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
							<c:when test="${model eq 'ProductDetail' }">
								<c:forEach var="productDetailI" items="${ ProductDetails }">
									<tr>
										<th>${productDetailI.id}</th>
										<th><img src="${productDetailI.image}"
											class="custom-img-o img-thumbnail" /></th>
										<th>${productDetailI.description}</th>
										<th>${productDetailI.quantity}</th>
										<th>${productDetailI.sizeBySizeId.name}</th>
										<th>${productDetailI.colorByColorId.name}</th>
										<th><a
											href="<c:url value="/admin/product-detail/${ pathVariable }?action=update&&detailId=${productDetailI.id}"/>">update</a>
											<a href="#" onclick="sendPostRequest(`<c:url value="/admin/product-detail/delete/${ productDetailI.id }"/>`);">delete</a>
										</th>
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
						<c:url value="/admin/product/edit/${ param.detailId }" var="url" />
						<form:form action="${url}" modelAttribute="Product" method="post">
							<div class="form-group row">
								<form:errors path="*" cssClass="col-lg-12 text-danger"
									element="p" />
							</div>
							<div class="form-group row">
								<h2 class="heading col-lg-6">${model}form</h2>
								<div class="col-lg-6 text-right">
									<button type="button" class="close" aria-label="Close">
										<a href="<c:url value="/admin/product"/>"> <span
											aria-hidden="true">&times;</span>
										</a>
									</button>
								</div>
							</div>
							<div class="form-group row">
								<div class="controls col-lg-6">
									<form:input type="text" id="name" class="floatLabel"
										name="name" path="name" />
									<label for="name"
										${Product.name !=null ? "class='active'" : ""}>Name</label>
								</div>
								<div class="controls col-lg-6">
									<form:input type="number" id="price" class="floatLabel"
										name="price" path="price" />
									<label for="price"
										${Product.price !=null ? "class='active'" : ""}>Price</label>
								</div>
								<div class="controls col-lg-12">
									<form:input type="text" id="thumbnail" class="floatLabel"
										name="thumbnail" path="thumbnail" />
									<label for="thumbnail"
										${Product.thumbnail !=null ? "class='active'" : ""}>Thumbnail</label>
								</div>
								<div class="controls col-lg-12">
									<div class="row">
										<div class="col-lg-6">
											<input type="file" class="floatLabel" id="customFile" />
										</div>
										<div class="col-lg-6">
											<i class="fa fa-sort"></i>
											<form:select class="floatLabel" name="categoryByCategoryId"
												path="categoryByCategoryId">
												<c:forEach var="category" items="${Categories}">
													<form:option value="${category.id}">${category.name}</form:option>
												</c:forEach>
											</form:select>
											<label
												${Product.categoryByCategoryId !=null ? "class='active'" : ""}>Category</label>
										</div>
									</div>
								</div>
								<div class="controls col-lg-12">
									<form:textarea name="description" class="floatLabel"
										id="description" path="description"></form:textarea>
									<label for="description"
										${Product.description !=null ? "class='active'" : ""}>Description</label>
								</div>
								<div class="row col-lg-12">
									<div class="col-lg-5"></div>
									<button type="submit" value="Submit" class="col-lg-2">Submit</button>
									<div class="col-lg-5"></div>
								</div>
								<form:input type="hidden" path="id" />
								<form:input type="hidden" path="discountByDiscountId" value="${ Product.discountByDiscountId.id}" />
								<%-- <form:input type="hidden" path="productDetailsById"  value="${ Product.productDetailsById.id}"/> --%>
							</div>
						</form:form>
					</c:when>
					<c:when test="${model eq 'ProductDetail'}">
						<c:url value="/admin/product-detail/${pathVariable }" var="url" />
						<form:form action="${url}" modelAttribute="productDetailForm" method="post">
							<div class="form-group row">
								<form:errors path="*" cssClass="col-lg-12 text-danger" element="p" />
							</div>
							<div class="form-group row">
								<h2 class="heading col-lg-6">${model}form</h2>
								<div class="col-lg-6 text-right">
									<button type="button" class="close" aria-label="Close">
										<a href="<c:url value="/admin/product-detail/${pathVariable }"/>">
											<span aria-hidden="true">&times;</span>
										</a>
									</button>
								</div>
							</div>
							<div class="form-group row">
								<div class="controls col-lg-6">
									<form:input type="number" id="quantity" class="floatLabel" name="quantity" path="quantity" />
									<label for="quantity" ${productDetailForm.quantity !=null ? "class='active'" : ""}>quantity</label>
								</div>
								<div class="controls col-lg-6">
									<input type="file" class="floatLabel" id="customFile" />
								</div>
								<div class="controls col-lg-6">
									<i class="fa fa-sort"></i>
									<form:select class="floatLabel" name="colorByColorId" path="colorByColorId">
										<c:forEach var="color" items="${Colors}">
											<form:option value="${color.id}">${color.name}</form:option>
										</c:forEach>
									</form:select>
									<label ${productDetailForm.colorByColorId !=null ? "class='active'" : ""}>Color</label>
								</div>
								<div class="controls col-lg-6">
									<i class="fa fa-sort"></i>
									<form:select class="floatLabel" name="sizeBySizeId" path="sizeBySizeId">
										<c:forEach var="size" items="${Sizes}">
											<form:option value="${size.id}">${size.name}</form:option>
										</c:forEach>
									</form:select>
									<label ${productDetailForm.sizeBySizeId !=null ? "class='active'" : ""}>Size</label>
								</div>
								<div class="controls col-lg-12">
									<form:textarea name="description" class="floatLabel"
										id="description" path="description"></form:textarea>
									<label for="description" ${productDetailForm.description !=null ? "class='active'" : ""}>Description</label>
								</div>
								<div class="row col-lg-12">
									<div class="col-lg-5"></div>
									<button type="submit" value="Submit" class="col-lg-2">Submit</button>
									<div class="col-lg-5"></div>
								</div>
								<div class="row col-lg-12">
									<form:input path="id" type="hidden"/>
									<form:input path="productByProductId" value="${pathVariable}" type="hidden"/>
								</div>
								
							</div>
						</form:form>
					</c:when>
				</c:choose>
			</div>
		</div>
	</c:if>
</div>

