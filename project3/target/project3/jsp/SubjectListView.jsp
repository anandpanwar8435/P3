<%@page import="in.co.rays.project3.util.HTMLUtility"%>
<%@page import="in.co.rays.project3.dto.SubjectDTO"%>
<%@page import="java.util.Iterator"%>
<%@page import="in.co.rays.project3.util.DataUtility"%>
<%@page import="java.util.List"%>
<%@page import="in.co.rays.project3.util.ServletUtility"%>
<%@page import="in.co.rays.project3.ctl.SubjectListCtl"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Subject List View</title>
<script src="<%=ORSView.APP_CONTEXT%>/js/jquery.min.js"></script>
<script type="text/javascript"
	src="<%=ORSView.APP_CONTEXT%>/js/CheckBox11.js"></script>
<style>
.hm-gradient {
	background-image: url('<%=ORSView.APP_CONTEXT%>/img/bg1.png');
}

.p1 {
	padding: 4px;
	font-weight: bold;
}
</style>
</head>
<body class="hm-gradient">
	<div>
		<%@include file="Header.jsp"%>
	</div>
	<div>
		<form action="<%=ORSView.SUBJECT_LIST_CTL%>" method="post">




			<jsp:useBean id="dto" class="in.co.rays.project3.dto.SubjectDTO"
				scope="request"></jsp:useBean>
			<%
				List list2 = (List) request.getAttribute("courseList");
			%>
			<%
				int pageNo = ServletUtility.getPageNo(request);
				int pageSize = ServletUtility.getPageSize(request);
				int index = ((pageNo - 1) * pageSize) + 1;
				int nextPageSize = DataUtility.getInt(request.getAttribute("nextListSize").toString());
				List list = ServletUtility.getList(request);
				Iterator<SubjectDTO> it = list.iterator();
				if (list.size() != 0) {
			%>
			<center>
						<h1 style="font-size: 40px; padding-top: 24px; color: #162390;">SUBJECT LIST</h1>
					</center>
					</br>

					<div class="row">
				<div class="col-md-4" align="center"></div>
				
					<%
						if (!ServletUtility.getSuccessMessage(request).equals("")) {
					%>

					<div class="col-md-4 alert alert-success alert-dismissible" style="background-color: #80ff80">
						<button type="button" class="close" data-dismiss="alert">&times;</button>
						<h6><font color="#008000"><%=ServletUtility.getSuccessMessage(request)%></font></h6>
					</div>
					<%
						}
					%>
				
				<div class="col-md-4"></div>
			</div>
			<div class="row">
				<div class="col-md-4" align="center"></div>
				
					<%
						if (!ServletUtility.getErrorMessage(request).equals("")) {
					%>
					<div class=" col-md-4 alert alert-danger alert-dismissible">
						<button type="button" class="close" data-dismiss="alert">&times;</button>
					<h6>	<font color="red"><%=ServletUtility.getErrorMessage(request)%></font></h6>
					</div>
					<%
						}
					%>
					<div class="col-md-4"></div>
			</div>
			<!-- <div class="row">

				<div class="col-sm-2"></div>
				<div class="col-sm-2"> -->
            
			<div class="container-fluid text-center">
				<div class="form-inline mr-5">

					<div class="col-md-4-offset"></div>

					<div class="form-group  text-center mr-5">
						&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp; <label class="control-label"
							for="name">Subject Name : &emsp;</label>
					<input type="text" name="name" placeholder="Enter SubjectName" class="form-control"
							value="<%=ServletUtility.getParameter("subjectName", request)%>">
				</div>&emsp;
				
				<!-- <div class="col-sm-4" align="center"> -->
				<div class="form-group text-center">
						<label class="control-label" for="courseId">Course Name
							:&emsp;</label><%=HTMLUtility.getList("courseId", String.valueOf(dto.getCourseId()), list2)%></div>
					
					&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;	
				
					<input type="submit" class="btn btn-primary btn-md"
						style="font-size: 17px" name="operation"
						value="<%=SubjectListCtl.OP_SEARCH%>">&emsp;
						<input type="submit" class="btn btn-warning btn-md"
						style="font-size: 17px" name="operation"
						value="<%=SubjectListCtl.OP_RESET%>">
				</div>
				
			
				<div class="col-sm-2"></div>
			</div>
			
			</br>
			<div style="margin-bottom: 20px;" class="table-responsive">
				<table class="table table-hover">
					<thead>
						<tr style="background-color: #f2c12dcc;">

							<th class="text-center" width="10%"><input type="checkbox" id="select_all"
								name="Select" class="text"> Select All</th>
							<th class="text-center">S.NO</th>
							<th class="text-center">Subject Name</th>
							<th class="text-center">Course Name</th>
							<th class="text-center">Description</th>
							<th class="text-center">Edit</th>
						</tr>
					</thead>
					<%
						while (it.hasNext()) {
								dto = it.next();
					%>

					<tbody>
						<tr>
							<td align="center"><input type="checkbox" class="checkbox"
								name="ids" value="<%=dto.getId()%>"></td>
							<td align="center"><%=index++%></td>
							<td align="center"><%=dto.getSubjectName()%></td>
							<td align="center"><%=dto.getCourseName()%></td>
							<td align="center"><%=dto.getDescription()%></td>
							<td align="center"><a href="SubjectCtl?id=<%=dto.getId()%>">Edit</a></td>
						</tr>
					</tbody>
					<%
						}
					%>
				</table>
</div>
				<table width="100%">
					<tr>
						<td><input type="submit" name="operation"
							class="btn btn-info btn-md" style="font-size: 15px"
							value="<%=SubjectListCtl.OP_PREVIOUS%>"
							<%=pageNo > 1 ? "" : "disabled"%>></td>
						<td><input type="submit" name="operation"
							class="btn btn-primary btn-md" style="font-size: 15px"
							value="<%=SubjectListCtl.OP_NEW%>"></td>
						<td><input type="submit" name="operation"
							class="btn btn-danger btn-md" style="font-size: 15px"
							value="<%=SubjectListCtl.OP_DELETE%>"></td>

						<td align="right"><input type="submit" name="operation"
							class="btn btn-info btn-md" style="font-size: 15px"
							style="padding: 5px;" value="<%=SubjectListCtl.OP_NEXT%>"
							<%=(nextPageSize != 0) ? "" : "disabled"%>></td>
					</tr>
					<tr></tr>
				</table>
				</br>
			
			<%
				}
				if (list.size() == 0) {
					System.out.println("user list view list.size==0");
			%>
			<center>
						<h1 style="font-size: 40px; padding-top: 24px; color: #162390;">SUBJECT
							LIST</h1>
					</center>
					</br>
					<div class="row">
				<div class="col-md-4" align="center"></div>
				
					<%
						if (!ServletUtility.getErrorMessage(request).equals("")) {
					%>
					<div class=" col-md-4 alert alert-danger alert-dismissible">
						<button type="button" class="close" data-dismiss="alert">&times;</button>
					<h6>	<font color="red"><%=ServletUtility.getErrorMessage(request)%></font></h6>
					</div>
					<%
						}
					%>
					
					
					<%
						if (!ServletUtility.getSuccessMessage(request).equals("")) {
					%>
					<div class=" col-md-4 alert alert-primary alert-dismissible">
						<button type="button" class="close" data-dismiss="alert">&times;</button>
					<h6>	<font color="red"><%=ServletUtility.getSuccessMessage(request)%></font></h6>
					</div>
					<%
						}
					%>
					<div class="col-md-4"></div>
			</div>
					</br>
			<div style="padding-left: 48%;">
				<input type="submit" name="operation" class="btn btn-primary btn-md"
					style="font-size: 15px" value="<%=SubjectListCtl.OP_BACK%>">
			</div>
			<%
				}
			%>
			<input type="hidden" name="pageNo" value="<%=pageNo%>"> <input
				type="hidden" name="pageSize" value="<%=pageSize%>">


		</form>

	</div>
</br>
</br>
</body>
<%@include file="Footer.jsp"%>

</html>