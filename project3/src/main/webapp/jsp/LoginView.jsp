<%@page import="in.co.rays.project3.ctl.LoginCtl"%>
<%@page import="in.co.rays.project3.util.DataUtility"%>
<%@page import="in.co.rays.project3.util.ServletUtility"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
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
.log1 {
margin-top:0px;
padding-top: 10px;
height: 70px;
}

.hm-gradient {
	/* background-image: linear-gradient(#f3e7e9 0%, #e3eeff 99%, #e3eeff 100%); */
	 background-image: url('<%=ORSView.APP_CONTEXT%>/img/bg1.png'); 
}


i.css {
	border: 2px solid #8080803b;
	padding-left: 13px;
	padding-bottom: 11px;
	background-color: #ebebe0;
}
</style>
<title>Login View</title>
</head>

<body class="hm-gradient">
<jsp:useBean id="dto" class="in.co.rays.project3.dto.UserDTO" scope="request"></jsp:useBean>

	<div>
		<%@include file="Header.jsp"%>
	</div>
	<div class="container-fluid">

		<main>

			<form action="<%=ORSView.LOGIN_CTL%>" method="post">

				<div class="row log1">
					<!-- Grid column -->
					<div class="col-md-4 mb-4"></div>
					<div class="col-md-4 mb-4">
						<div class="card ">
						<div class="card-body">
							
								 <h2 class="card-title" align="center">LOGIN</h2>
								<!--Body--><br>
								<div>
									<H6 align="center">
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
									</H6>

									<H6 align="center">
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

									</H6>
									<%
										String uri = (String) request.getAttribute("uri");
									%>
									<input type="hidden" name="id" value="<%=dto.getId()%>">
									<input type="hidden" name="createdBy"
										value="<%=dto.getCreatedBy()%>"> <input type="hidden"
										name="modifiedBy" value="<%=dto.getModifiedBy()%>"> <input
										type="hidden" name="createdDatetime"
										value="<%=DataUtility.getTimestamp(dto.getCreatedDatetime())%>">
									<input type="hidden" name="modifiedDatetime"
										value="<%=DataUtility.getTimestamp(dto.getModifiedDatetime())%>">
								</div>
								<div class="md-form">
								<span class="pl-sm-5"><b>Email Id</b><span
									style="color: red;">*</span></span> </br> <i
									class="fa fa-envelope prefix fa-5x  grey-text css"
									style="font-size: 1.07rem;"></i> <input type="text" name="login"
									id="defaultForm-pass" placeholder="Enter email"
									style="border: 2px solid #8080803b;"
									value="<%=DataUtility.getStringData(dto.getLogin())%>">
								<font color="red" class="pl-sm-5"> <%=ServletUtility.getErrorMessage("login", request)%></font></br>
								</br> <span class="pl-sm-5"><b>Password</b><span
									style="color: red;">*</span></span> </br> <i
									class="fa fa-lock prefix fa-5x grey-text css"
									style="font-size: 1rem;"></i> <input type="password"
									name="password" placeholder="Enter password"
									id="defaultForm-pass" style="border: 2px solid #8080803b;"
									value="<%=DataUtility.getStringData(dto.getPassword())%>">
								<font color="red" class="pl-sm-5"> <%=ServletUtility.getErrorMessage("password", request)%></font></br>


							</div>
								<div class="text-center">

									<input type="submit" name="operation"
										class="btn btn-success btn-sm" style="font-size: 15px"
										value="<%=LoginCtl.OP_SIGN_IN%>"> 
								</div>
								<div class="text-center">
									<a href="<%=ORSView.FORGET_PASSWORD_CTL%>"
										style="color: black; font-size: 15px;"><b>Forget my
											password</b></a>
								</div>
								<input type="hidden" name="uri" value="<%=uri%>">
							</div>
						</div>
					</div>
					<div class="col-md-4 mb-4"></div>
				</div>
			</form>
		</main>
	</div>
		
		<div>
		<%@include file="Footer.jsp"%>
	</div>
</body>
</html>