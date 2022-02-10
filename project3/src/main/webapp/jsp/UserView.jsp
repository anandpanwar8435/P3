<%@page import="java.util.HashMap"%>
<%@page import="in.co.rays.project3.util.HTMLUtility"%>
<%@page import="java.util.List"%>
<%@page import="in.co.rays.project3.ctl.UserCtl"%>
<%@page import="in.co.rays.project3.util.ServletUtility"%>
<%@page import="in.co.rays.project3.ctl.ORSView"%>
<%@page import="in.co.rays.project3.util.DataUtility"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User View</title>
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
	padding-top: 10px;
	/* padding-left: 30%; */
}

.md-form {
	margin-left: 1rem !important;
	width: 90%;
}

.fas {
	padding-left: 0rem !important
}

.hm-gradient {
	background-image: url('<%=ORSView.APP_CONTEXT%>/img/bg1.png');
}

 i.css {
	border: 2px solid #8080803b;
	padding-left: 15px;
	padding-bottom: 11px;
	background-color: #ebebe0;
} 
</style>

</head>
<body class="hm-gradient">
	<div class="header">
		<%@include file="Header.jsp"%>
	</div>
	<div>

		<main>
			<form action="<%=ORSView.USER_CTL%>" method="post">
				<jsp:useBean id="dto" class="in.co.rays.project3.dto.UserDTO" scope="request"></jsp:useBean>
				<div class="row log1">
					<div class="col-md-4 mb-4"></div>
					<!-- Grid column -->
					<div class="col-md-4 mb-4">
						<div class="card">
							<div class="card-body">
								<%
									long id = DataUtility.getLong(request.getParameter("id"));

								if (id > 0) {
								%>
								<h3 class="text-center default-text py-3">UPDATE USER</h3>
								<%
									} else {
								%>
								<h3 class="text-center default-text py-3">ADD USER</h3>
								<%
									}
								%>
								<!--Body-->
								<div>
									<%
										List list = (List) request.getAttribute("rolelist");
									%>

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

									<span class="pl-sm-5"><b>First Name</b><span
										style="color: red;">*</span></span> </br> <i
										class="fa fa-user-circle prefix grey-text css"
										style="font-size: 1.07rem;"></i> <input type="text"
										name="firstName" id="defaultForm-email "
										style="border: 2px solid #8080803b;"
										placeholder="Enter First Name"
										value="<%=DataUtility.getStringData(dto.getFirstName())%>">
									<font color="red" class="pl-sm-5"> <%=ServletUtility.getErrorMessage("firstName", request)%></font></br>

									<span class="pl-sm-5"><b>Last Name</b><span
										style="color: red;">*</span></span> </br> <i
										class="fa fa-user-circle prefix grey-text css"
										style="font-size: 1.07rem;"></i> <input type="text"
										name="lastName" id="defaultForm-email"
										style="border: 2px solid #8080803b;"
										placeholder="Enter Last Name"
										value="<%=DataUtility.getStringData(dto.getLastName())%>">
									<font color="red" class="pl-sm-5"> <%=ServletUtility.getErrorMessage("lastName", request)%></font></br>
									
									
									
									<span class="pl-sm-5"><b>Email Id</b><span
										style="color: red;">*</span></span> </br> <i
										class="fa fa-envelope prefix grey-text css"
										style="font-size: 1.07rem;"></i> <input type="text"
										name="emailId" id="defaultForm-email"
										style="border: 2px solid #8080803b;"
										placeholder=" Enter email Id"
										value="<%=DataUtility.getStringData(dto.getLogin())%>">
									<font color="red" class="pl-sm-5"> <%=ServletUtility.getErrorMessage("emailId", request)%></font></br>

									

									<span class="pl-sm-5"><b>Password</b><span
										style="color: red;">*</span></span> </br> <i
										class="fa fa-unlock-alt prefix grey-text css"
										style="font-size: 1rem;"></i> <input type="password"
										name="password" id="defaultForm-email"
										style="border: 2px solid #8080803b;"
										placeholder="Enter password"
										value="<%=DataUtility.getStringData(dto.getPassword())%>">
									<font color="red" class="pl-sm-5"> <%=ServletUtility.getErrorMessage("password", request)%></font></br>


									<span class="pl-sm-5"><b>Confirm Password</b><span
										style="color: red;">*</span></span> </br> <i
										class="fa fa-key prefix grey-text css"
										style="font-size: 1rem;"></i> <input type="password"
										name="confirmPassword" id="defaultForm-email"
										style="border: 2px solid #8080803b;"
										placeholder="Enter confirm Password"
										value="<%=DataUtility.getStringData(dto.getConfirmPassword())%>">
									<font color="red" class="pl-sm-5"> <%=ServletUtility.getErrorMessage("confirmPassword", request)%></font></br>
									
									

									<span class="pl-sm-5"><b>Mobile No</b><span
										style="color: red;">*</span></span> </br> <i
										class="fa fa-mobile prefix grey-text css"
										style="font-size: 1rem;"></i> <input type="text"
										name="mobileNo" id="defaultForm-email"
										style="border: 2px solid #8080803b;"
										placeholder=" Enter mobile No" maxlength="10"
										value="<%=DataUtility.getStringData(dto.getMobileNo())%>">
									<font color="red" class="pl-sm-5"> <%=ServletUtility.getErrorMessage("mobileNo", request)%></font></br>

									<span class="pl-sm-5"><b>Role</b><span
										style="color: red;">*</span></span> </br> <i
										class="fa fa-user prefix grey-text css"
										style="font-size: 0.9rem;"></i>
									<div style="padding-left:47px; margin-right:-8px; margin-top: -4px;">
										<%=HTMLUtility.getList("role", String.valueOf(dto.getRoleId()), list)%>
									</div>
									<font color="red" class="pl-sm-5"><div style="margin-top: -40px;"><%=ServletUtility.getErrorMessage("role", request)%></font></br>
                                    </div>
									<span class="pl-sm-5"><b>Gender</b><span
										style="color: red;">*</span></span> </br> <i
										class="fa fa-venus-mars prefix grey-text css"
										style="font-size: 0.9rem;"></i>
									<div style="margin-left: 47px; margin-right:-8px; margin-top: -4px;">
										<%
											HashMap map = new HashMap();
										map.put("Male", "Male");
										map.put("Female", "Female");

										String htmlList = HTMLUtility.getList("gender", dto.getGender(), map);
										%>
										<%=htmlList%></div>
									<font color="red" class="pl-sm-5"><div style="margin-top: -40px;"> <%=ServletUtility.getErrorMessage("gender", request)%></font></br>
                                    </div>
									<span class="pl-sm-5"><b>Date of Birth</b><span
										style="color: red;">*</span></span> </br> <i
										class="fa fa-calendar  prefix grey-text css"
										style="font-size: 0.9rem;"></i> <input type="date" name="dob"
										onkeydown="return false" style="border: 2px solid #8080803b;"
										id="datepicker"
										value="<%=DataUtility.getDateString(dto.getDob())%>">
									<font color="red" class="pl-sm-5"> <%=ServletUtility.getErrorMessage("dob", request)%></font>
								</div>
								<%
									if (id > 0) {
								%>

								<div class="text-center">

									<input type="submit" name="operation"
										class="btn btn-success btn-md" style="font-size: 17px"
										value="<%=UserCtl.OP_UPDATE%>"> <input type="submit"
										name="operation" class="btn btn-success btn-md"
										style="font-size: 15px" value="<%=UserCtl.OP_CANCEL%>">

								</div>
								<%
									} else {
								%>
								<div class="text-center">

									<input type="submit" name="operation"
										class="btn btn-success btn-md" style="font-size: 17px"
										value="<%=UserCtl.OP_SAVE%>"> <input type="submit"
										name="operation" class="btn btn-warning btn-md"
										style="font-size: 15px" value="<%=UserCtl.OP_RESET%>">
								</div>

							</div>
							<%
								}
							%>
						</div>
					</div>
			</form>
		</main>
		<div class="col-md-4 mb-4"></div>

	</div>

</body>
<%@include file="Footer.jsp"%>
</html>