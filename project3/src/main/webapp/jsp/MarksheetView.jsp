<%@page import="in.co.rays.project3.ctl.MarksheetCtl"%>
<%@page import="in.co.rays.project3.ctl.MarksheetCtl"%>
<%@page import="in.co.rays.project3.util.HTMLUtility"%>
<%@page import="java.util.List"%>
<%@page import="in.co.rays.project3.util.DataUtility"%>
<%@page import="in.co.rays.project3.util.ServletUtility"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Marksheet View</title>
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
	<div>

		<main>
		<form action="<%=ORSView.MARKSHEET_CTL%>" method="post">
			<jsp:useBean id="dto" class="in.co.rays.project3.dto.MarksheetDTO"
				scope="request"></jsp:useBean>
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
							<h3 class="text-center default-text py-3">UPDATE MARKSHEET</h3>
							<%
								} else {
							%>
							<h3 class="text-center default-text py-3">ADD MARKSHEET</h3>
							<%
								}
							%>
							<!--Body-->
							<div>
								<%
									List list1 = (List) request.getAttribute("studentList");
								%>
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
								<span class="pl-sm-5"><b>Roll No</b><span
									style="color: red;">*</span></span> </br> <i
									class="fa fa-list-ol prefix grey-text css"
									style="font-size: 1.05rem;"></i> <input type="text" name="roll"
									id="defaultForm-email" style="border: 2px solid #8080803b;"
									placeholder="Enter RollNo"
									value="<%=DataUtility.getStringData(dto.getRollNo())%>">
								<font color="red" class="pl-sm-5"> <%=ServletUtility.getErrorMessage("roll", request)%></font></br>


								<span class="pl-sm-5"><b>Student Name</b><span
									style="color: red;">*</span></span> </br> <i
									class="far fa-user prefix grey-text css"
									style="font-size: 0.9rem; margin-top: 3px;"></i>
								<div style="margin-left: 47px; margin-right: -7px;">
									<%=HTMLUtility.getList("studentName", String.valueOf(dto.getStudentId()), list1)%>
								</div>

								<font color="red" class="pl-sm-5"><div style="margin-top: -40px;"> <%=ServletUtility.getErrorMessage("studentName", request)%></font></br>
</div>
								<span class="pl-sm-5"><b>Physics</b><span
									style="color: red;">*</span></span> </br> <i
									class="fa fa-equals prefix grey-text css"
									style="font-size: 1rem;"></i> <input type="text" name="physics"
									id="defaultForm-email" style="border: 2px solid #8080803b;"
									placeholder="Enter Physics"
									value="<%=DataUtility.getStringData(dto.getPhysics()).equals("0") ? ""
					: DataUtility.getStringData(dto.getPhysics())%>">
								<font color="red" class="pl-sm-5"> <%=ServletUtility.getErrorMessage("physics", request)%></font></br>

								<span class="pl-sm-5"><b>Chemistry</b><span
									style="color: red;">*</span></span> </br> <i
									class="fa fa-equals prefix grey-text css"
									style="font-size: 1rem;"></i> <input type="text"
									name="chemistry" id="defaultForm-email"
									style="border: 2px solid #8080803b;"
									placeholder="Enter chemistry"
									value="<%=DataUtility.getStringData(dto.getChemistry()).equals("0") ? ""
					: DataUtility.getStringData(dto.getChemistry())%>">
								<font color="red" class="pl-sm-5"> <%=ServletUtility.getErrorMessage("chemistry", request)%></font></br>
								<span class="pl-sm-5"><b>Maths</b><span
									style="color: red;">*</span></span> </br> <i
									class="fas fa-equals prefix grey-text css"
									style="font-size: 1rem;"></i> <input type="text" name="maths"
									id="defaultForm-email" style="border: 2px solid #8080803b;"
									placeholder="Enter Maths"
									value="<%=DataUtility.getStringData(dto.getMaths()).equals("0") ? ""
					: DataUtility.getStringData(dto.getMaths())%>">
								<font color="red" class="pl-sm-5"> <%=ServletUtility.getErrorMessage("maths", request)%></font></br>
							</div>
							</br>
							<%
									if (id > 0) {
								%>

								<div class="text-center">

									<input type="submit" name="operation"
										class="btn btn-success btn-md" style="font-size: 17px"
										value="<%=MarksheetCtl.OP_UPDATE%>"> <input type="submit"
										name="operation" class="btn btn-success btn-md"
										style="font-size: 15px" value="<%=MarksheetCtl.OP_CANCEL%>">

								</div>
								<%
									} else {
								%>
								<div class="text-center">

									<input type="submit" name="operation"
										class="btn btn-success btn-md" style="font-size: 17px"
										value="<%=MarksheetCtl.OP_SAVE%>"> <input type="submit"
										name="operation" class="btn btn-warning btn-md"
										style="font-size: 15px" value="<%=MarksheetCtl.OP_RESET%>">
								</div>

							</div>
							<%
								}
							%>


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