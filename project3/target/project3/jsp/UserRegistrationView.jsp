<%@page import="in.co.rays.project3.ctl.UserRegistrationCtl"%>
<%@page import="in.co.rays.project3.util.HTMLUtility"%>
<%@page import="java.util.HashMap"%>
<%@page import="in.co.rays.project3.util.DataUtility"%>
<%@page import="in.co.rays.project3.util.ServletUtility"%>
<%@page import="in.co.rays.project3.ctl.ORSView"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta  name="viewport" content="width=device-width, initial-scale=1.0">
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
	 padding-top: 5px;
	padding-bottom: 5px;
}

i.css {
	border: 1px solid #8080803b;
	padding-left: 11px;
	padding-bottom: 11px;
	background-color: #ebebe0;
}

.fa_custom {
	color: #2199CC
}

.hm-gradient {
	/* background-image: linear-gradient(to top, #f3e7e9 0%, #e3eeff 99%, #e3eeff 100%); */
	background-image: url('img/bg1.png');
}
</style>

<title>User Registration</title>
</head>
<body class="hm-gradient img-responsive">

	<div class="header">
		<%@include file="Header.jsp"%>
	</div>
	
	<div>

		<main>


			<form action="<%=ORSView.USER_REGISTRATION_CTL%>" method="post">
				<div class="row log1">

					<div class="col md-4 mb-4"></div>
					
					<div class="col md-4 mb-4">

						<div class="card">

							<div class="card-body">
								<h3 class="text-center default-text py-3">User Registration
								</h3>


								<jsp:useBean id="dto" class="in.co.rays.project3.dto.UserDTO"
									scope="request"></jsp:useBean>
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

								<span class="pl-sm-5" style="margin-left: 9px;"><b>First Name</b><span
									style="color: red;">*</span></span> </br> <i
									class="fas fa-user-circle prefix  red-text css"
									style="font-size: 1rem; margin-left: 9px;"></i> <input type="text"
									name="firstName" id="defaultForm-email"
									placeholder="First Name" style="border: 1px solid #8080803b;margin-left: 57px; width:85%;"
									value="<%=DataUtility.getStringData(dto.getFirstName())%>">
								<font color="red" class="pl-sm-5" style="margin-left: 9px;"> <%=ServletUtility.getErrorMessage("firstName", request)%></font></br>

								<span class="pl-sm-5" style="margin-left: 9px;"><b>Last Name</b><span
									style="color: red;">*</span></span> </br> <i
									class="fas fa-user-circle prefix  fa-5x blue-text css"
									style="font-size: 1rem; margin-left: 9px;"></i> <input type="text"
									name="lastName" id="defaultForm-email" placeholder="Last Name"
									style="border: 1px solid #8080803b;margin-left: 57px; width:85%;"
									value="<%=DataUtility.getStringData(dto.getLastName())%>">
								<font color="red" class="pl-sm-5" style="margin-left: 9px;"> <%=ServletUtility.getErrorMessage("lastName", request)%></font></br>
								
								
								<span class="pl-md-5" style="margin-left: 9px;"><b>Email Id</b><span
										style="color: red;">*</span></span> </br> <i
										class="fa fa-envelope prefix fa-5x  grey-text css"
										style="font-size: 1rem; margin-left: 9px;"></i> <input type="text" name="login"
										id="defaultForm-pass" placeholder="Enter email"
										style="border: 1px solid #8080803b;margin-left: 57px;width:85%;"
										value="<%=DataUtility.getStringData(dto.getLogin())%>">
									<font color="red" class="pl-md-5" style="margin-left: 9px;"> <%=ServletUtility.getErrorMessage("login", request)%></font></br>

								<span class="pl-sm-5" style="margin-left: 9px;"><b>Password</b><span
									style="color: red;">*</span></span> </br> <i
									class="fa fa-key prefix  fa-5x  red-text css"
									style="font-size: 1rem; margin-left: 9px;"></i> <input type="password"
									name="password" id="defaultForm-email" placeholder="password"
									style="border: 1px solid #8080803b;margin-left: 57px;width:85%;"
									value="<%=DataUtility.getStringData(dto.getPassword())%>">
								<font color="red" class="pl-sm-5" style="margin-left: 9px;"> <%=ServletUtility.getErrorMessage("password", request)%></font></br>

								<span class="pl-sm-5" style="margin-left: 9px;"><b>Confirm Password</b><span
									style="color: red;">*</span></span> </br> <i
									class="fa fa-key prefix   fa-5x  red-text css"
									style="font-size: 1rem; margin-left: 9px;"></i> <input type="password"
									name="confirmPassword" id="defaultForm-email"
									placeholder="confirm Password"
									style="border: 1px solid #8080803b;margin-left: 57px;width:85%;"
									value="<%=DataUtility.getStringData(dto.getConfirmPassword())%>">
								<font color="red" class="pl-sm-5" style="margin-left: 9px;"> <%=ServletUtility.getErrorMessage("confirmPassword", request)%></font></br>

						
								<span class="pl-sm-5" style="margin-left: 9px;"><b>Mobile No</b><span
									style="color: red;">*</span></span> </br> <i
									class="fa  fa-phone-square prefix   fa-5x  green-text css"
									style="font-size: 1rem; margin-left: 9px;"></i> <input type="text"
									name="mobileNo" id="defaultForm-email" maxlength="10"
									placeholder="mobile No" style="border: 1px solid #8080803b;margin-left: 57px;width:85%;"
									value="<%=DataUtility.getStringData(dto.getMobileNo())%>">
								<font color="red" class="pl-sm-5" style="margin-left: 9px;"> <%=ServletUtility.getErrorMessage("mobileNo", request)%></font></br>

								<span class="pl-sm-5" style="margin-left: 9px;"><b>Gender</b><span
									style="color: red;">*</span></span> </br> <i
									class="fa fa-venus-mars prefix fa_custom  fa-5x css"
									style="font-size: 1rem; margin-left: 9px;"></i>
								<div style="margin-left: 57px; margin-right: 10px; margin-top: -4px;">
									<%
										HashMap map = new HashMap();
									map.put("Male", "Male");
									map.put("Female", "Female");

									String htmlList = HTMLUtility.getList("gender", dto.getGender(), map);
									%>
									<%=htmlList%></div>
								<font color="red" class="pl-sm-5" style="margin-left: 9px;"><div style="margin-top: -40px;"> <%=ServletUtility.getErrorMessage("gender", request)%></font></div>

								<span class="pl-sm-5" style="margin-left: 9px;"><b>DOB</b><span style="color: red;">*</span></span>
								</br> <i class="fa fa-calendar  prefix   fa-5x  blue-text css"
									style="font-size: 1rem; margin-left: 9px;" style="margin-top: -4;"></i> <input
									type="date" name="dob" onkeydown="return false"
									style="border: 1px solid #8080803b;margin-left: 57px;width:85%;"
									placeholder="Date Of Birth" id="datepicker"
									value="<%=DataUtility.getDateString(dto.getDob())%>"> <font
									color="red" class="pl-sm-5" style="margin-left: 9px;"> <%=ServletUtility.getErrorMessage("dob", request)%></font></br>



							</div>

							<div class="text-center">

								<input type="submit" name="operation"
									class="btn btn-success btn-md" style="font-size: 15px"
									value="<%=UserRegistrationCtl.OP_SIGN_UP%>"> <input
									type="submit" name="operation" class="btn btn-success btn-md"
									style="font-size: 15px"
									value="<%=UserRegistrationCtl.OP_RESET%>">
							</div>



						</div>

					</div>

					<div class="col md-4 mb-4"></div>

				</div>




			</form>

		</main>
<div>
<%@ include file="Footer.jsp" %>
</div>

	</div>

</body>
</html>