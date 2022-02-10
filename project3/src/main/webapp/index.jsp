<%@page import="in.co.rays.project3.ctl.ORSView"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<style>
.p1 {
	padding-top: 125px;
}

	 /*  background-image: linear-gradient(to top, #f3e7e9 0%, #e3eeff 99%, #e3eeff 100%); */  
	 /* background-image: url('img/bg.png'); */
	.hm-gradient {
	background-image: url('<%=ORSView.APP_CONTEXT%>/img/bg1.png');
}
	



</style>
<body class="hm-gradient" >
	<div class="p1">
		<h1 align="Center" >
			<img src="img/custom.png" width="318" height="127" border="0">
		</h1 >
		<h1 align="Center">
         <a href="<%=ORSView.WELCOME_CTL%>" style="color: black;"  > <font size="8px">Online Result System</font></a>
		</h1>
	</div>
</body>
</html>