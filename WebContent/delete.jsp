<%@page import="com.practical1.*" %>
<%@page import="java.sql.*" %>


<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
   try{
	
     String rem_id = request.getParameter("rem_id") ;
     Connection con = Connect_DB.connect();
	 PreparedStatement ps1=con.prepareStatement("delete from reminder_tbl where rem_id=?");
	 ps1.setString(1,rem_id);
	 int i = ps1.executeUpdate();
	 if(i>0)
	 {
		response.sendRedirect("view.jsp");   
	 }
   }
  catch(Exception e)
{
	  e.printStackTrace();
}


%>
</body>
</html>