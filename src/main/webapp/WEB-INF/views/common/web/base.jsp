<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<!DOCTYPE html>
<html>
<head>
	<!-- Mobile Specific Meta -->
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<!-- Favicon-->
	<link rel="shortcut icon" href="img/fav.png">
	<!-- Author Meta -->
	<meta name="author" content="CodePixar">
	<!-- Meta Description -->
	<meta name="description" content="">
	<!-- Meta Keyword -->
	<meta name="keywords" content="">
	<!-- meta character set -->
	<meta charset="UTF-8">
	<!-- Site Title -->
	<title>
		<tiles:insertAttribute name="title" />
	</title>
	<!--
		CSS
		============================================= -->
	<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
	<link rel="stylesheet" href="<c:url value="/asset/web/css/linearicons.css"/>">
	<link rel="stylesheet" href="<c:url value="/asset/web/css/font-awesome.min.css"/>">
	<link rel="stylesheet" href="<c:url value="/asset/web/css/themify-icons.css"/>">
	<link rel="stylesheet" href="<c:url value="/asset/web/css/bootstrap.css"/>">
	<link rel="stylesheet" href="<c:url value="/asset/web/css/owl.carousel.css"/>">
	<link rel="stylesheet" href="<c:url value="/asset/web/css/nice-select.css"/>">
	<link rel="stylesheet" href="<c:url value="/asset/web/css/nouislider.min.css"/>">
	<link rel="stylesheet" href="<c:url value="/asset/web/css/ion.rangeSlider.css"/>">
	<link rel="stylesheet" href="<c:url value="/asset/web/css/ion.rangeSlider.skinFlat.css"/>">
	<link rel="stylesheet" href="<c:url value="/asset/web/css/magnific-popup.css"/>">
	<link rel="stylesheet" href="<c:url value="/asset/web/css/main.css"/>">
	<link rel="stylesheet" href="<c:url value="/asset/web/css/customthanh.css"/>">

</head>

<body>
	<tiles:insertAttribute name="header" />

	<tiles:insertAttribute name="content" />

	<tiles:insertAttribute name="deal-of-week" />

	<tiles:insertAttribute name="footer" />

	<script src="<c:url value="/asset/web/js/vendor/jquery-2.2.4.min.js"/>"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js" integrity="sha384-b/U6ypiBEHpOf/4+1nzFpr53nxSS+GLCkfwBdFNTxtclqqenISfwAzpKaMNFNmj4" crossorigin="anonymous"></script>
	<script src="<c:url value="/asset/web/js/vendor/bootstrap.min.js"/>"></script>
	<script src="<c:url value="/asset/web/js/jquery.ajaxchimp.min.js"/>"></script>
	<script src="<c:url value="/asset/web/js/jquery.nice-select.min.js"/>"></script>
	<script src="<c:url value="/asset/web/js/jquery.sticky.js"/>"></script>
	<script src="<c:url value="/asset/web/js/nouislider.min.js"/>"></script>
	<script src="<c:url value="/asset/web/js/countdown.js"/>"></script>
	<script src="<c:url value="/asset/web/js/jquery.magnific-popup.min.js"/>"></script>
	<script src="<c:url value="/asset/web/js/owl.carousel.min.js"/>"></script>
	<!--gmaps Js-->
	<script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCjCGmQ0Uq4exrzdcL6rvxywDDOvfAu6eE"></script>
	<script src="<c:url value="/asset/web/js/gmaps.min.js"/>"></script>
	<script src="<c:url value="/asset/web/js/main.js"/>"></script>
	<script src="<c:url value="/asset/web/js/custom.js"/>"></script>
	<script src="<c:url value="/asset/web/js/cart.js"/>"></script>
</body>
</html>