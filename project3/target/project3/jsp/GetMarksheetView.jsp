<%@page import="in.co.rays.project3.ctl.GetMarksheetCtl"%>
<%@page import="in.co.rays.project3.util.DataUtility"%>
<%@page import="in.co.rays.project3.util.ServletUtility"%>
<%@page import="in.co.rays.project3.ctl.GetMarksheetCtl"%>
<%@page import="in.co.rays.project3.ctl.ORSView"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Get Marksheet View</title>
<script src="<%=ORSView.APP_CONTEXT%>/js/jquery.min.js"></script>
<script type="text/javascript"
	src="<%=ORSView.APP_CONTEXT%>/js/CheckBox11.js"></script>
<style>

.hm-gradient {
	background-image: url('<%=ORSView.APP_CONTEXT%>/img/bg1.png');
}

.text {
	text-align: center;
}
.po1 
{
	font-size: 18px;
	text-align:center;
	height: 100px;
	
}

</style>
</head>
<body class="hm-gradient">
	<div>
		<%@include file="Header.jsp"%>
	</div>
	<div>
		<form action="<%=ORSView.GET_MARKSHEET_CTL%>" method="post">



			<div align="center">
				<h1 style="font-size: 40px; padding-top: 24px; color: #162390;">GET MARKSHEET
					</h1>
			</div>

			<center>
				<font color="red" size="5px"><%=ServletUtility.getErrorMessage(request)%></font>
			</center>
			<center>
				<font color="green" size="5px"><%=ServletUtility.getSuccessMessage(request)%></font>
			</center>
			<jsp:useBean id="dto" class="in.co.rays.project3.dto.MarksheetDTO"
				scope="request"></jsp:useBean>
		

			 </br>
			  </br>
			<div class="row">
			<div class="col-md-5"></div>
			<div class="col-md-2"><input
							type="text" name="rollNo" class="p1"
							value="<%=ServletUtility.getParameter("rollNo", request)%>">&emsp;</div>
			<div class="col-md-2"> <input type="submit"
							class="btn btn-primary btn-md" style="font-size: 10px"
							name="operation" value="<%=GetMarksheetCtl.OP_GO%>"
							>&emsp;<font color="red"><%=ServletUtility.getErrorMessage("rollNo", request)%></font></div>
			<div class="col-md-3"></div>
			
			</div>
				<%-- <table class="container">
					<tr>
						<td style="padding-left: 39%;"><label class="p1">Roll No</label>&emsp;<input
							type="text" name="rollNo" class="p2"
							value="<%=ServletUtility.getParameter("rollNo", request)%>">&emsp;&emsp;
                            <input type="submit"
							class="btn btn-primary btn-md" style="font-size: 17px"
							name="operation" value="<%=GetMarksheetCtl.OP_GO%>"
							style="padding: 5px;"></td>
							<td style="position: fixed; padding: 10px;"><font color="red"><%=ServletUtility.getErrorMessage("rollNo", request)%></font>
						</td>

					
						
						
					</tr>
				</table> --%>
				<%
							if (dto.getRollNo() != null && dto.getRollNo().trim().length() > 0) {
						%>
			</div>
			<br>
			<div class="container" >
			
			<table  width="100%" style="background-color: white;" border="3px">
				<tr >
					<th id="po1" colspan="2" >RollNo</th>
					<td id="po1" align="center" colspan="3"><%=DataUtility.getStringData(dto.getRollNo())%></td>
				</tr>
				<tr>
					<th id="po1" colspan="2">Name</th>
					<td id="po1" align="center" colspan="3"><%=DataUtility.getStringData(dto.getName())%></td>
				</tr>
				<tr style="background-color: #e1b5158c;">
					<th id="po1"  >Subject</th>
					<th id="po1" >Max Marks</th>
					<th id="po1"  >Min Marks</th>
					<th  id="po1"  colspan="2">Marks Obtain</th>
				</tr>
				<tr>
					<td colspan="3"></td>
					<th id="po1" >Marks</th>
					<th style="color: blue;" id="po1"  >Grade</th>
				</tr>
				<tr>
					<th id="po1">Physics</th>
					<td align="center">100</td>
					<td align="center">35</td>
					<td id="po1" align="center"><%=DataUtility.getStringData(String.valueOf(dto.getPhysics()))%>
						<%
							float physics = dto.getPhysics();
								if (dto.getPhysics() < 35) {
						%><span style="color: red;">*</span> <%
 	}
 %></td>
					<td align="center">
						<%
							if (physics >= 90) {
						%> <b>A++</b> <%
 	} else if (physics >= 80) {
 %> <b>A</b> <%
 	} else if (physics >= 70) {
 %> <b>B++</b> <%
 	} else if (physics >= 60) {
 %> <b>B</b> <%
 	} else if (physics >= 50) {
 %> <b>C++</b> <%
 	} else if (physics >= 40) {
 %> <b>C</b> <%
 	} else if (physics >= 35) {
 %> <b>D</b> <%
 	} else if (physics >= 0) {
 %> <font color="red"><b>F</b></font> <%
 	}
 %>
					</td>
				</tr>
				<tr>
					<th id="po1">Chemistry</th>
					<td align="center">100</td>
					<td align="center">35</td>
					<td id="po1" align="center"><%=DataUtility.getStringData(String.valueOf(dto.getChemistry()))%>
						<%
							float chemistry = dto.getChemistry();
								if (dto.getChemistry() < 35) {
						%><span style="color: red;">*</span> <%
 	}
 %></td>
					<td align="center">
						<%
							if (chemistry >= 90) {
						%> <b>A++</b> <%
 	} else if (chemistry >= 80) {
 %> <b>A</b> <%
 	} else if (chemistry >= 70) {
 %> <b>B++</b> <%
 	} else if (chemistry >= 60) {
 %> <b>B</b> <%
 	} else if (chemistry >= 50) {
 %> <b>C++</b> <%
 	} else if (chemistry >= 40) {
 %> <b>C</b> <%
 	} else if (chemistry >= 35) {
 %> <b>D</b> <%
 	} else if (chemistry >= 0) {
 %> <font color="red"><b>F</b></font> <%
 	}
 %>
					</td>
				</tr>
				<tr>
					<th id="po1">Maths</th>
					<td align="center">100</td>
					<td align="center">35</td>
					<td id="po1" align="center"><%=DataUtility.getStringData(String.valueOf(dto.getMaths()))%>
						<%
							float marks = dto.getMaths();
								if (marks <= 35) {
						%><span style="color: red;">*</span> <%
 	}
 %></td>
					<td align="center">
						<%
							if (marks >= 90) {
						%> <b>A++</b> <%
 	} else if (marks >= 80) {
 %> <b>A</b> <%
 	} else if (marks >= 70) {
 %> <b>B++</b> <%
 	} else if (marks >= 60) {
 %> <b>B</b> <%
 	} else if (marks >= 50) {
 %> <b>C++</b> <%
 	} else if (marks >= 40) {
 %> <b>C</b> <%
 	} else if (marks >= 35) {
 %> <b>D</b> <%
 	} else if (marks >= 0) {
 %> <font color="red"><b>F</b></font> <%
 	}
 %>
					</td>

				</tr>
				<tr>
					<th id="po1" colspan="2">Total</th>

					<td id="po1" align="center" colspan="3">
						<%
							int total = ((dto.getMaths()) + (dto.getPhysics()) + (dto.getChemistry()));
								float percentage = (total * 100) / 300;
						%><%=total%></td>
				</tr>
				<%
					if ((dto.getMaths() > 35) && (dto.getPhysics() > 35) && (dto.getChemistry() > 35)) {
				%>
				<tr>

					<th id="po1" colspan="2">Percentage</th>

					<td id="po1" align="center" colspan="3"><%=percentage%>%</td>
				</tr>
				<tr>
					<th id="po1" align="center" colspan="2"><font color="blue">Grade:</font>
						<%
							if (percentage >= 90) {
						%> <b>A++</b> <%
 	} else if (percentage >= 80) {
 %> <b>A</b> <%
 	} else if (percentage >= 70) {
 %> <b>B++</b> <%
 	} else if (percentage >= 60) {
 %> <b>B</b> <%
 	} else if (percentage >= 50) {
 %> <b>C++</b> <%
 	} else if (percentage >= 40) {
 %> <b>C</b> <%
 	} else if (percentage >= 35) {
 %> <b>D</b> <%
 	} else if (percentage >= 0) {
 %> <font color="red"><b>F</b></font> <%
 	}
 %></th>
					<td id="po1" align="center" colspan="3">
						<%
							if (percentage >= 35) {
						%> <font color="green"><b>PASS</b></font> <%
 	}
 %>
					</td>
				</tr>
				<%
					} else {
				%>
				<tr>
					<th id="po1" align="center" colspan="2"><font color="blue">Final Grade:</font><font
						color="red"><b>F</b></font></th>
					<td id="po1" align="center" colspan="3"><font color="red"><b>FAIL</b></font></td>
				</tr>

				<%
					}
				%>
			</table>

			<%
				}
			%>
	
			</div>

</body>
<%@include file="Footer.jsp"%>
</html>