<%@page import="in.co.rays.project3.util.ServletUtility"%>
<%@page import="in.co.rays.project3.util.DataUtility"%>
<%@page import="in.co.rays.project3.ctl.ForgetPasswordCtl"%>
<%@page import="in.co.rays.project3.ctl.ORSView"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>ForgetPassword View</title>
<link href="<%=ORSView.APP_CONTEXT%>/css/page.css" rel="stylesheet"
	id="bootstrap-css">
<link href="<%=ORSView.APP_CONTEXT%>/css/main.css" rel="stylesheet"
	id="bootstrap-css">
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<script type="text/javascript"
	src="https://cdnjs.cloudflare.com/ajax/libs/mdbootstrap/4.4.1/js/mdb.min.js"></script>
<style type="text/css">
/* .header {
	width: 103%;
} */
i.css {
	border: 2px solid #8080803b;
	padding-left: 10px;
	 padding-bottom: 11px; 
	 background-color: #ebebe0;
}
.hm-gradient {
	background-image: url('<%=ORSView.APP_CONTEXT%>/img/bg1.png');
}
</style>
</head>
<body class="hm-gradient">
	<div class="header">
		<%@include file="Header.jsp"%>
	</div>
	<div>

		<main>
		<form action="<%=ORSView.FORGET_PASSWORD_CTL%>" method="post">

			<div class="row log1">
				<!-- Grid column -->
				<div class="col-md-6 mb-4">
					<div class="card">
						<div class="card-body">

							<h3 class="text-center default-text py-3">Forget
								Password</h3>

							<H4 align="center">
									<%
										if (!ServletUtility.getSuccessMessage(request).equals("")) {
									%>
									<div class="alert alert-success alert-dismissible">
										<button type="button" class="close" data-dismiss="alert">&times;</button>
										<%=ServletUtility.getSuccessMessage(request)%>
									</div>
									<%
										}
									%>
								</H4>

								<H4 align="center">
									<%
										if (!ServletUtility.getErrorMessage(request).equals("")) {
									%>
									<div class="alert alert-danger alert-dismissible">
										<button type="button" class="close" data-dismiss="alert">&times;</button>
											<%=ServletUtility.getErrorMessage(request)%>
									</div>
									<%
										}
									%>

								</H4>
							<!--Body-->
							<div>

								<jsp:useBean id="bean" class="in.co.rays.project3.dto.UserDTO"
									scope="request"></jsp:useBean>

								<input type="hidden" name="id" value="<%=bean.getId()%>">
								<input type="hidden" name="createdBy"
									value="<%=bean.getCreatedBy()%>"> <input type="hidden"
									name="modifiedBy" value="<%=bean.getModifiedBy()%>"> <input
									type="hidden" name="createdDatetime"
									value="<%=DataUtility.getTimestamp(bean.getCreatedDatetime())%>">
								<input type="hidden" name="modifiedDatetime"
									value="<%=DataUtility.getTimestamp(bean.getModifiedDatetime())%>">
							</div>
							<div class="md-form">
							<span class="pl-sm-5"><b>Email Id</b><span style="color:red;">*</span></span>
								</br><i class="far fa-envelope prefix fa-5x grey-text css" style="font-size: 1rem;"></i> <input
									type="text" name="login" id="defaultForm-email" style="border: 2px solid #8080803b;"
									placeholder="Enter emailId" > <font
									color="red" class="pl-sm-5"><%=ServletUtility.getErrorMessage("login", request)%></font></br>
							</div>


							<div class="text-center">

								<input type="submit" name="operation"
									class="btn btn-success btn-md" style="font-size: 17px"
									value="<%=ForgetPasswordCtl.OP_GO%>">
							</div>

						</div>
					</div>
				</div>
				<div class="col-md-4 mb-4"></div>
				</div>
				
		</form>
		</main>


	</div>

</body>
<%@include file="Footer.jsp"%>

</html>
