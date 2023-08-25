package com.practical1;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class RegisterUser
 */
public class RegisterUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterUser() {
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
		String user_name = request.getParameter("user_name");
		String user_mob = request.getParameter("user_mob");
		String user_email = request.getParameter("user_email");
		String user_password = request.getParameter("user_password");
		try{
		Connection con = Connect_DB.connect();
		PreparedStatement ps2 = con.prepareStatement("insert into users_tbl values(?,?,?,?,?)");
		ps2.setInt(1,0);
		ps2.setString(2,user_name);
		ps2.setString(3,user_mob);
		ps2.setString(4,user_email);
		ps2.setString(5,user_password);
		int i = ps2.executeUpdate();
		if(i==1){
			response.sendRedirect("index.html");
		}
	}
		catch(Exception e)
		{
			response.sendRedirect("register.html");
		}

}
}
