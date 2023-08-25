package com.practical1;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * Servlet implementation class DeleteRem
 */
public class DeleteRem extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteRem() {
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
		String rem_id = request.getParameter("rem_id");
		int rem_id1= Integer.parseInt(rem_id);
		
		try
		{
			Connection con=Connect_DB.connect();
			PreparedStatement p1=con.prepareStatement("delete from reminder_tbl where rem_id=?");
			p1.setInt(1, rem_id1);

			int i=p1.executeUpdate();
			if(i==1)
			{
				response.sendRedirect("thank.html");
			}
			
		}
		catch(Exception e)
		{
			response.sendRedirect("delete.html");
		}
	}

}
