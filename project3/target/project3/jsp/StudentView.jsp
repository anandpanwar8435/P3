<%@page import="java.util.List"%>
<%@page import="in.co.rays.project3.util.HTMLUtility"%>
<%@page import="in.co.rays.project3.ctl.StudentCtl"%>
<%@page import="in.co.rays.project3.util.DataUtility"%>
<%@page import="in.co.rays.project3.util.ServletUtility"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Student View</title>
<link href="<%=ORSView.APP_CONTEXT%>/css/main.css" rel="stylesheet"
	id="bootstrap-css">
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<script type="text/javascript"
	src="https://cdnjs.cloudflare.com/ajax/libs/mdbootstrap/4.4.1/js/mdb.min.js"></script>

<style type="text/css">
.log1 {
	/* padding-top: 5px;
	padding-bottom: -5px; */
	margin-top:15px;
	margin-bottom:30px;

}

.hm-gradient {
	background-image: url('<%=ORSView.APP_CONTEXT%>/img/bg1.png');
}

i.css {
	border: 2px solid #8080803b;
	padding-left: 10px;
	padding-bottom: 11px;
	background-color: #ebebe0;
}
</style>
</head>
<body class="hm-gradient">
	<div class="header">
		<%@include file="Header.jsp"%>
	</div>
	
		<jsp:useBean id="dto" class="in.co.rays.project3.dto.StudentDTO"
			scope="request"></jsp:useBean>
		<main>
		<form action="<%=ORSView.STUDENT_CTL%>" method="post">

			<div class="row log1">
				<!-- Grid column -->
				<div class="col-md-4 mb-4"></div>
				<div class="col-md-4 mb-4">
					<div class="card">
						<div class="card-body">
							<%
								long id = DataUtility.getLong(request.getParameter("id"));

							if (id > 0) {
							%>
							<h3 class="text-center default-text py-3">UPDATE STUDENT</h3>
							<%
								} else {
							%>
							<h3 class="text-center default-text py-3">ADD STUDENT</h3>
							<%
								}
							%>
							<!--Body-->
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

								<input type="hidden" name="id" value="<%=dto.getId()%>">
								<input type="hidden" name="createdBy"
									value="<%=dto.getCreatedBy()%>"> <input type="hidden"
									name="modifiedBy" value="<%=dto.getModifiedBy()%>"> <input
									type="hidden" name="createdDatetime"
									value="<%=DataUtility.getTimestamp(dto.getCreatedDatetime())%>">
								<input type="hidden" name="modifiedDatetime"
									value="<%=DataUtility.getTimestamp(dto.getModifiedDatetime())%>">
							</div>
							<%
								List li = (List) request.getAttribute("collegeList");
							%>
							<div class="md-form">
								<span class="pl-sm-5"><b>College</b><span
									style="color: red;">*</span></span> </br> <i
									class="far fa-building prefix grey-text css"
									style="font-size: 0.9rem; margin-top: 3.5px;"></i>
								<div style="margin-left: 47px; margin-right:-8px;">
									<%=HTMLUtility.getList("collegeId", String.valueOf(dto.getCollegeId()), li)%>
								</div>
								<font color="red" class="pl-sm-5"><div style="margin-top: -40px;"> <%=ServletUtility.getErrorMessage("collegeId", request)%></font></br>
</div>
								<span class="pl-sm-5"><b>First Name</b><span
									style="color: red;">*</span></span> </br> <i
									class="far fa-user prefix grey-text css"
									style="font-size: 1rem;"></i> <input type="text"
									name="firstName" id="defaultForm-email"
									style="border: 2px solid #8080803b;" placeholder="First Name"
									value="<%=DataUtility.getStringData(dto.getFirstName())%>">
								<font color="red" class="pl-sm-5"> <%=ServletUtility.getErrorMessage("firstName", request)%></font></br>

								<span class="pl-sm-5"><b>Last Name</b><span
									style="color: red;">*</span></span> </br> <i
									class="fas fa-user prefix grey-text css"
									style="font-size: 1rem; margin-top: 0.5px;"></i> <input type="text"
									name="lastName" id="defaultForm-email"
									style="border: 2px solid #8080803b;" placeholder="Last Name"
									value="<%=DataUtility.getStringData(dto.getLastName())%>">
								<font color="red" class="pl-sm-5"> <%=ServletUtility.getErrorMessage("lastName", request)%></font></br>

								<span class="pl-sm-5"><b>Email Id</b><span
									style="color: red;">*</span></span> </br> <i
									class="far fa-envelope prefix grey-text css"
									style="font-size: 1rem;"></i> <input type="text" name="login"
									id="defaultForm-email" style="border: 2px solid #8080803b;"
									placeholder="Email Id"
									value="<%=DataUtility.getStringData(dto.getLogin())%>">
								<font color="red" class="pl-sm-5"> <%=ServletUtility.getErrorMessage("emailId", request)%></font></br>

								<span class="pl-sm-5"><b>Mobile No</b><span
									style="color: red;">*</span></span> </br> <i
									class="fa fa-phone prefix grey-text css"
									style="font-size: 1rem;"></i> <input type="text"
									name="mobileNo" id="defaultForm-email"
									style="border: 2px solid #8080803b;" placeholder="Mobile No"
									maxlength="10"
									value="<%=DataUtility.getStringData(dto.getMobileNo())%>">
								<font color="red" class="pl-sm-5"> <%=ServletUtility.getErrorMessage("mobileNo", request)%></font></br>

								<span class="pl-sm-5"><b>DOB</b><span style="color: red;">*</span></span>
								</br> <i class="fa fa-calendar prefix grey-text css"
									style="font-size: 1rem;" style="margin-top: -4px;"></i> <input
									type="date" name="dob" style="border: 2px solid #8080803b;"
									onkeydown="return false" placeholder=" enter Date Of Birth"
									value="<%=DataUtility.getDateString(dto.getDob())%>"> <font
									color="red" class="pl-sm-5"> <%=ServletUtility.getErrorMessage("dob", request)%></font><br>
						
								<%
															if (id > 0) {
														%>
														<div class="text-center">

									<input type="submit" name="operation"
										class="btn btn-success btn-md" style="font-size: 17px"
										value="<%=StudentCtl.OP_UPDATE%>"> <input type="submit"
										name="operation" class="btn btn-success btn-md"
										style="font-size: 15px" value="<%=StudentCtl.OP_CANCEL%>">

								</div>
								<%-- <div class="text-center">

									<input type="submit" name="operation"
										style="border-radius: 10px; background-color: #00cc88; padding: 10px; color: white; font-size: 20px;"
										value="<%=StudentCtl.OP_UPDATE%>"> <input
										type="submit" name="operation"
										style="border-radius: 10px; background-color: #00cc88; padding: 10px; color: white; font-size: 20px;"
										value="<%=StudentCtl.OP_CANCEL%>">

								</div> --%>
								<%
									} else {
								%>
								<div class="text-center">

									<input type="submit" name="operation"
										class="btn btn-success btn-md" style="font-size: 15px"
										value="<%=StudentCtl.OP_SAVE%>"> <input type="submit"
										name="operation" class="btn btn-warning btn-md"
										style="font-size: 15px" value="<%=StudentCtl.OP_RESET%>">

								</div>
								<%
									}
								%>
							</div>
						</div>
					</div>

				</div>
				<div class="col-md-4 mb-4"></div>
			</div>

		</form>

</main>
</body>
<%@include file="Footer.jsp"%>
</html>