<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="in.co.rays.project3.model.ModelFactory"%>
<%@page import="in.co.rays.project3.model.RoleModelInt"%>
<%@page import="in.co.rays.project3.util.DataUtility"%>
<%@page import="in.co.rays.project3.ctl.UserListCtl"%>
<%@page import="in.co.rays.project3.util.HTMLUtility"%>
<%@page import="in.co.rays.project3.util.ServletUtility"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User List View</title>
<script src="<%=ORSView.APP_CONTEXT%>/js/jquery.min.js"></script>
<script type="text/javascript"
	src="<%=ORSView.APP_CONTEXT%>/js/CheckBox11.js"></script>
<style>
.hm-gradient {
	/* background-image: linear-gradient(to top, #f3e7e9 0%, #e3eeff 99%, #e3eeff 100%); */
	background-image: url('<%=ORSView.APP_CONTEXT%>/img/bg1.png');
}

.p1 {
	padding: 5px;
	width: 200px;
	font-size: bold;
}

.text {
	text-align: center;
}
</style>
</head>
<body class="hm-gradient">
	<!-- <div class="header"> -->
		<%@include file="Header.jsp"%>
	</div>
	</br>
	<div>
		<form action="<%=ORSView.USER_LIST_CTL%>" method="post">

			<jsp:useBean id="dto" class="in.co.rays.project3.dto.UserDTO" scope="request"></jsp:useBean>
			<%
				List list1 = (List) request.getAttribute("roleList");
			%>


			<%
				int pageNo = ServletUtility.getPageNo(request);
				int pageSize = ServletUtility.getPageSize(request);
				int index = ((pageNo - 1) * pageSize) + 1;
				int nextPageSize = DataUtility.getInt(request.getAttribute("nextListSize").toString());
				RoleDTO rbean1 = new RoleDTO();
				RoleModelInt rmodel = ModelFactory.getInstance().getRoleModel();

				List list = ServletUtility.getList(request);
				Iterator<UserDTO> it = list.iterator();
				if (list.size() != 0) {
			%>
			<center>
				<h1 style="font-size: 40px; color: #162390;">USER LIST</h1>
			</center>
			<div class="row">
				<!-- <div class="text-center col-md-offset-4"></div> -->
				<div class="col-md-4" align="center"></div>

				<%
					if (!ServletUtility.getSuccessMessage(request).equals("")) {
				%>

				<div
					class="col-md-4 alert alert-success alert-dismissible ">
					<button type="button" class="close" data-dismiss="alert">&times;</button>
					<h6 align="center">
						<font><%=ServletUtility.getSuccessMessage(request)%></font>
					</h6>
				</div>
				<%
					}
				%>

				<div class="col-md-4"></div>
			</div>
			<div class="row">
				<div class="col-md-4"></div>

				<%
					if (!ServletUtility.getErrorMessage(request).equals("")) {
				%>
				<div
					class=" col-md-4 alert alert-danger alert-dismissible ">
					<button type="button" class="close" data-dismiss="alert">&times;</button>
					<h6 align="center">
						<font> <%=ServletUtility.getErrorMessage(request)%></font>
					</h6>
				</div>
				<%
					}
				%>
				<div class="col-md-4"></div>
			</div>

			 
				<!--  <div class="col-sm-2"> -->
				<br>
            
			<div class="container-fluid text-center">
				<div class="form-inline mr-5">

					<div class="col-md-4-offset"></div>

					<div class="form-group  text-center mr-5">
						&emsp;&emsp;&emsp;&emsp;&emsp;&emsp; <label class="control-label"
							for="name">First Name : &emsp;</label>
				
					<input type="text" name="firstName" placeholder="Enter FirstName"
						class="form-control"
						value="<%=ServletUtility.getParameter("firstName", request)%>">
				</div>
				&emsp;
			<!-- 	<div class="col-sm-2"> -->
				<div class="form-group text-center">
						<label class="control-label" for="login">LoginId
							:&emsp;</label>
					<input type="text" name="login" placeholder="Enter Login Id"
						class="form-control"
						value="<%=ServletUtility.getParameter("login", request)%>">
				</div>
				&emsp;&emsp;
				<div class="form-group text-center">
						<label class="control-label" for="Role">Role
							:&emsp;</label>
				<div class="col-sm-2"><%=HTMLUtility.getList("Role", String.valueOf(dto.getRoleId()), list1)%></div>


				<div class="col-sm-3"></div>
			</div>
			
<!-- 			<div class="form-group">
 -->						&emsp;&emsp;&emsp;&emsp;
						<button type="submit" name="operation"
							class=" form-control btn btn-primary"
							value="<%=UserListCtl.OP_SEARCH%>">
							<span class="glyphicon glyphicon-search"></span> Search
						</button>
			
			&emsp;&emsp;
                            <button type="submit" name="operation"
							class=" form-control btn btn-warning"
							value="<%=UserListCtl.OP_RESET%>">
							<span class=" glyphicon glyphicon-refresh"></span> Reset
						</button>
				</div>
				<div class="col-sm-3"></div>
				</div>
				<br>
				<div style="margin-bottom: 20px;" class="table-responsive">
					<table class="table">
						<thead>
							<tr style="background-color: #f2c12dcc;">

								<th class="text-center"><input type="checkbox" id="select_all"
									name="Select" class="text"> Select All</th>
								<th  class="text-center">S.NO</th>
								<th  class="text-center">FirstName</th>
								<th  class="text-center">LastName</th>
								<th  class="text-center">LoginId</th>
								<th  class="text-center">Gender</th>
								<th  class="text-center">Role</th>
								<th  class="text-center">DOB</th>
								<th  class="text-center">Edit</th>
							</tr>
						</thead>
						<%
							while (it.hasNext()) {
									dto = it.next();

									RoleDTO rbean = rmodel.findByPk(dto.getRoleId());

									System.out.print(rbean.getName());
						%>

						<tbody>
							<tr>
								<td align="center"><input type="checkbox" class="checkbox"
									name="ids" value="<%=dto.getId()%>"
									<%if (dto.getRoleId() == RoleDTO.ADMIN) {%> <%="disabled"%>
									<%}%>></td>
								<td align="center"><%=index++%></td>
								<td align="center"><%=dto.getFirstName()%></td>
								<td align="center"><%=dto.getLastName()%></td>
								<td align="center"><%=dto.getLogin()%></td>
								<td align="center"><%=dto.getGender()%></td>
								<td align="center"><%=rbean.getName()%></td>
								<td align="center"><%=DataUtility.getDateString(dto.getDob())%></td>
								<td align="center"><a href="UserCtl?id=<%=dto.getId()%>"
									<%if (dto.getRoleId() == RoleDTO.ADMIN) {%>
									onclick="return false;" <%}%>>Edit</a></td>
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
							class="btn btn-primary btn-md" style="font-size: 15px"
							value="<%=UserListCtl.OP_PREVIOUS%>"
							<%=pageNo > 1 ? "" : "disabled"%>></td>
						<td><input type="submit" name="operation"
							class="btn btn-primary btn-md" style="font-size: 15px"
							value="<%=UserListCtl.OP_NEW%>"></td>
						<td><input type="submit" name="operation"
							class="btn btn-danger btn-md" style="font-size: 15px"
							value="<%=UserListCtl.OP_DELETE%>"></td>

						<td align="right"><input type="submit" name="operation"
							class="btn btn-info btn-md" style="font-size: 15px"
							style="padding: 5px;" value="<%=UserListCtl.OP_NEXT%>"
							<%=(nextPageSize != 0) ? "" : "disabled"%>></td>
					</tr>
					<tr></tr>
				</table>

				<%
					}
					if (list.size() == 0) {
						System.out.println("user list view list.size==0");
				%>
				<center>
					<h1 style="font-size: 40px; color: #162390;">USER LIST</h1>
				</center>
				</br>
				<div class="row">
					<div class="col-md-4"></div>

					<%
						if (!ServletUtility.getErrorMessage(request).equals("")) {
					%>
					<div class=" col-md-4 alert alert-danger alert-dismissible">
						<button type="button" class="close" data-dismiss="alert">&times;</button>
						<h4 align="center">
							<font color="red"> <%=ServletUtility.getErrorMessage(request)%></font>
						</h4>
					</div>
					<%
						}
					%>

					<%
						if (!ServletUtility.getSuccessMessage(request).equals("")) {
					%>
					<div class=" col-md-4 alert alert-primary alert-dismissible">
						<button type="button" class="close" data-dismiss="alert">&times;</button>
						<h4 align="center">
							<font color="red"> <%=ServletUtility.getSuccessMessage(request)%></font>
						</h4>
					</div>
					<%
						}
					%>
					<div class="col-md-4"></div>
				</div>
				</br>

				<div style="padding-left: 48%;">
					<input type="submit" name="operation"
						class="btn btn-primary btn-md" style="font-size: 17px"
						value="<%=UserListCtl.OP_BACK%>">
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