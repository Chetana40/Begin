package com.practical1;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * Servlet implementation class AddRem
 */
public class AddRem extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddRem() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		String rem_title = request.getParameter("rem_title");
		String rem_desc = request.getParameter("rem_desc");
		String user_email = User.getUser_email();
		
		 try 
		   {
				Connection con = Connect_DB.connect();
				PreparedStatement ps2 = con.prepareStatement("insert into reminder_tbl values(?,?,?,?)");
				ps2.setInt(1,0);
				ps2.setString(2,rem_title);
				ps2.setString(3,rem_desc);
				ps2.setString(4,user_email);
				int i = ps2.executeUpdate();
				if(i==1)
				{
					response.sendRedirect("thank.html");
				}
		   }
		   catch(Exception e)
		   {
			   response.sendRedirect("add.html");
		   }
				
		}
	}


