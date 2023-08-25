<%@page import="com.practical1.*" %>
<%@page import="java.sql.*" %>


<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login page in HTML</title>
<style>
body 
{
  font-family:sans-serif; 
  background: -webkit-linear-gradient(to right, #155799, #159957);  
  background: linear-gradient(to right, #155799, #159957); 
  color:whitesmoke;
}


h1{
    text-align: center;
}


form{
    width:35rem;
    margin: auto;
    color:whitesmoke;
    backdrop-filter: blur(16px) saturate(180%);
    -webkit-backdrop-filter: blur(16px) saturate(180%);
    background-color: rgba(11, 15, 13, 0.582);
    border-radius: 12px;
    border: 1px solid rgba(255, 255, 255, 0.125);
    padding: 20px 25px;
}

input[type=text], input[type=password]{
    width: 100%;
    margin: 10px 0;
    border-radius: 5px;
    padding: 15px 18px;
    box-sizing: border-box;
  }
table
{
background-color:white;
margin-top:20px;

}
th{
text-decoration:none;
}
table,th,td{
   border:1px solid black;
   padding:10px;
}
button {
    background-color: #030804;
    color: white;
    padding: 14px 20px;
    border-radius: 5px;
    margin: 7px 0;
    width: 100%;
    font-size: 18px;
  }

button:hover {
    opacity: 0.6;
    cursor: pointer;
}

.headingsContainer{
    text-align: center;
}

.headingsContainer p{
    color: gray;
}
.mainContainer{
    padding: 16px;
}

.center{
  margin-left:auto;
  margin-right:auto;
}

  /* Media queries for the responsiveness of the page */
  @media screen and (max-width: 600px) {
    form{
      width: 25rem;
    }
  }
  
  @media screen and (max-width: 400px) {
    form{
      width: 20rem;
    }
  }
</style>
</head>
  <body>
  <h1></h1>
    
    <form>
        <div class="headingsContainer">
            <h3></h3>
           
        </div>
        <div class="mainContainer">
            <button type="submit"><a href="add.html">Add Reminder</button>
            <button type="submit"><a href="delete.html">Delete Reminder</button>
            <button type="submit"><a href="view.jsp">View Reminder</button>
            
        </div>
      
      <table class="center" >
      <tr>
      <th>ID</th>
      <th>Title</th>  
      <th>Description</th>
      <th>Email</th>
      <th>Action</th>
      </tr>
        
        <%
        
        String user_email = User.getUser_email();
        Connection con = Connect_DB.connect();
        try{
        	PreparedStatement ps1=con.prepareStatement("select * from reminder_tbl where user_email=?");
    		ps1.setString(1,user_email);
    		ResultSet rs=ps1.executeQuery();
    		while(rs.next())
    		{
        %>
  
             <tr>
             <td><%=rs.getString("rem_id")%></td>
             <td><%=rs.getString("rem_title")%></td>
             <td><%=rs.getString("rem_desc")%></td>
             <td><%=rs.getString("user_email")%></td>
             <td><a href="delete.jsp?rem_id=<%=rs.getString("rem_id")%>">Delete</a></td>
             </tr>
       <%
    		}
        }
        catch(Exception e)
        {
        	e.printStackTrace();
        }
       %>
  
  
  </table>
         
         
 
        
</body>
</html>
