<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!--================Register Box Area =================-->
	<c:url value="/register" var="url"/>
	<section class="login_box_area section_gap">
		<div class="container">
			<div class="row">
				<div class="col-xs-12 m-auto">
					<div class="login_form_inner p-lg-5">
						<h3>Register account FourT</h3>
						<form:form class="row login_form" action="${ url }" method="post" id="contactForm" novalidate="novalidate" style="max-width: 600px;" modelAttribute="userRegister">
							<div class="col-md-12 form-group">
								<form:input type="text" class="form-control" id="fullName" name="fullName" placeholder="Fullname" onfocus="this.placeholder = ''" onblur="this.placeholder = 'Fullname'" path="fullName"/>
							</div>
							<div class="col-md-6 form-group">
								<form:input type="text" class="form-control" id="username" name="username" placeholder="Username" onfocus="this.placeholder = ''" onblur="this.placeholder = 'Username'" path="username"/>
							</div>
							<div class="col-md-6 form-group">
								<form:input type="email" class="form-control" id="email" name="email" placeholder="Email" onfocus="this.placeholder = ''" onblur="this.placeholder = 'Email'" path="email"/>
							</div>
							<div class="col-md-6 form-group">
								<form:input type="password" class="form-control" id="password" name="password" placeholder="Password" onfocus="this.placeholder = ''" onblur="this.placeholder = 'Password'" path="password"/>
							</div>
							<div class="col-md-6 form-group">
								<form:input type="password" class="form-control" id="passwordConfirm" name="passwordConfirm" placeholder="Password Confirm" onfocus="this.placeholder = ''" onblur="this.placeholder = 'Password Confirm'" path="passwordConfirm"/>
							</div>
							<div class="col-md-12 form-group">
								<button type="submit" value="submit" class="primary-btn rounded">Register Account</button>
								<a href="#">Go to log in -></a>
							</div>
						</form:form>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!--================End Register Box Area =================-->