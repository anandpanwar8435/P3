<%@page import="in.co.rays.project3.ctl.MarksheetListCtl"%>
<%@page import="in.co.rays.project3.ctl.MarksheetListCtl"%>
<%@page import="in.co.rays.project3.dto.MarksheetDTO"%>
<%@page import="java.util.Iterator"%>
<%@page import="in.co.rays.project3.util.DataUtility"%>
<%@page import="java.util.List"%>
<%@page import="in.co.rays.project3.util.ServletUtility"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Marksheet Merit List View</title>
<script src="<%=ORSView.APP_CONTEXT%>/js/jquery.min.js"></script>
<script type="text/javascript"
	src="<%=ORSView.APP_CONTEXT%>/js/CheckBox11.js"></script>
<style>
body{
padding-bottom: 3%;
}
.p1 {
	padding-top: 200px;
	font-size: 20px;
	color: #b62f2f;
}

.hm-gradient {
	background-image: url('<%=ORSView.APP_CONTEXT%>/img/bg1.png');
}

.text {
	text-align: center;
}
</style>
</head>
<body class="hm-gradient">
	<div>
		<%@include file="Header.jsp"%>
	</div>
	<div>
		<form action="<%=ORSView.MARKSHEET_MERIT_LIST_CTL%>" method="post">



			<div align="center">
				<h1 style="font-size: 40px; padding-top: 24px; color: #162390;">MARKSHEET MERIT
					LIST</h1>
			</div>

				<div class="row">
				<div class="col-md-4"></div>

				<%
					if (!ServletUtility.getSuccessMessage(request).equals("")) {
				%>

				<div class="col-md-4 alert alert-success alert-dismissible">
					<button type="button" class="close" data-dismiss="alert">&times;</button>
					<h4><font color="#008000"><%=ServletUtility.getSuccessMessage(request)%></font></h4>
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
				<div class=" col-md-4 alert alert-danger alert-dismissible">
					<button type="button" class="close" data-dismiss="alert">&times;</button>
					<h4>
						<font color="red"><%=ServletUtility.getErrorMessage(request)%></font></h4>
				</div>
				<%
					}
				%>
				<div class="col-md-4"></div>
			</div>
			<jsp:useBean id="dto" class="in.co.rays.project3.dto.MarksheetDTO"
				scope="request"></jsp:useBean>
			


			<%
				int pageNo = ServletUtility.getPageNo(request);
				int pageSize = ServletUtility.getPageSize(request);
				int index = ((pageNo - 1) * pageSize) + 1;

				List list = ServletUtility.getList(request);
				Iterator<MarksheetDTO> it = list.iterator();
				if (list.size() != 0) {
			%>

			<div style="margin-left: 82%;" >

<a style="font-size: 16px;" href="/project3/ctl/JasperCtl" class="btn btn-primary " role="button" target = "blank">
<span class="fa fa-print mr-1"></span>Print</a>
</div>

			</br>
			<div style="margin-bottom: 20px;" class="table-responsive">
				<table class="table">
					<thead>
						<tr style="background-color: #f2c12dcc;">

							<th class="text-center"><input type="checkbox" id="select_all"
								name="Select" class="text"> Select All</th>
							<th class="text">S.NO</th>

							<th class="text-center">RollNo</th>
							<th class="text-center">Name</th>
							<th class="text-center">Physics</th>
							<th class="text-center">Chemistry</th>
							<th class="text-center">Maths</th>
							<th class="text-center">Total</th>
							<th class="text-center">Percentage(%)</th>
						</tr>
					</thead>
					<%
						while (it.hasNext()) {
								dto = it.next();
					%>

					<tbody>
						<tr>
							<td align="center"><input type="checkbox" class="checkbox"
								name="ids" value="<%=dto.getId()%>"
								></td>
							<td align="center"><%=index++%></td>
							<td align="center"><%=dto.getRollNo()%></td>
							<td align="center"><%=dto.getName()%></td>
							<td align="center"><%=dto.getPhysics()%></td>
							<td align="center"><%=dto.getChemistry()%></td>
							<td align="center"><%=dto.getMaths()%></td>
							<td align="center">
						<%
							int total = (dto.getChemistry() + dto.getPhysics() + dto.getMaths());
						%><%=total%></td>
					<td align="center">
						<%
							float percentage = ((total * 100) / 300);
						%> <%=percentage%></td>
							
						</tr>
					</tbody>
					<%
						}
					%>
				</table>
				</div>
				<div style="padding-left: 48%;">
					<input type="submit" name="operation" class="btn btn-primary btn-md" style="font-size: 17px"
						value="<%=MarksheetListCtl.OP_BACK%>">
				</div>


			
			<%
				}
				
			%>
		
			<input type="hidden" name="pageNo" value="<%=pageNo%>"> <input
				type="hidden" name="pageSize" value="<%=pageSize%>">


		</form>

	</div>

</body>
<%@include file="Footer.jsp"%>


</html>