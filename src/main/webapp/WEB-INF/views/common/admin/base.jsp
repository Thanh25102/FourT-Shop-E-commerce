<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 4/9/2022
  Time: 4:14 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<html>
<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>SB Admin 2 - Dashboard</title>

    <!-- Custom fonts for this template-->
    <link href="<c:url value="/asset/admin/vendor/fontawesome-free/css/all.min.css"/>" rel="stylesheet" type="text/css">
    <link
            href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
            rel="stylesheet">

    <!-- Custom styles for this template-->
    <link href="<c:url value="/asset/admin/css/sb-admin-2.min.css"/>" rel="stylesheet" type="text/css">

    <!-- Custom styles for this page -->
    <link href="<c:url value="/asset/admin/vendor/datatables/dataTables.bootstrap4.min.css"/>" rel="stylesheet">

    <link rel="stylesheet" href="<c:url value="/asset/admin/css/form-custom.css"/>">
</head>

<body>


    <!-- Page Wrapper -->
    <div id="wrapper">
        <tiles:insertAttribute name="navigation"/>
        <!-- Content Wrapper -->
        <div id="content-wrapper" class="d-flex flex-column">
            <tiles:insertAttribute name="header"/>
            <tiles:insertAttribute name="content"/>
            <tiles:insertAttribute name="footer"/>
        </div>
        <!-- End of Content Wrapper -->
    </div>
    <!-- End of Page Wrapper -->


    <!-- Logout Modal-->
    <div class="modal fade" id="logoutModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
         aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">Ready to Leave?</h5>
                    <button class="close" type="button" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">×</span>
                    </button>
                </div>
                <div class="modal-body">Select "Logout" below if you are ready to end your current session.</div>
                <div class="modal-footer">
                    <button class="btn btn-secondary" type="button" data-dismiss="modal">Cancel</button>
                    <a class="btn btn-primary" href="login.html">Logout</a>
                </div>
            </div>
        </div>
    </div>

    <!-- Bootstrap core JavaScript-->
    <script src="<c:url value="/asset/admin/vendor/jquery/jquery.min.js"/>"></script>
    <script src="<c:url value="/asset/admin/vendor/bootstrap/js/bootstrap.bundle.min.js"/>"></script>

    <!-- Core plugin JavaScript-->
    <script src="<c:url value="/asset/admin/vendor/jquery-easing/jquery.easing.min.js"/>"></script>

    <!-- Custom scripts for all pages-->
    <script src="<c:url value="/asset/admin/js/sb-admin-2.min.js"/>"></script>

    <!-- Page level plugins -->
    <script src="<c:url value="/asset/admin/vendor/chart.js/Chart.min.js"/>"></script>
    <script src="<c:url value="/asset/admin/vendor/datatables/jquery.dataTables.min.js"/>"></script>
    <script src="<c:url value="/asset/admin/vendor/datatables/dataTables.bootstrap4.min.js"/>"></script>

    <!-- Page level custom scripts -->
    <script src="<c:url value="/asset/admin/js/demo/chart-area-demo.js"/>"></script>
    <script src="<c:url value="/asset/admin/js/demo/chart-pie-demo.js"/>"></script>
    <script src="<c:url value="/asset/admin/js/demo/datatables-demo.js"/>"></script>
    <script src="<c:url value="/asset/admin/js/form-custom.js"/>"></script>
</body>
</html>
