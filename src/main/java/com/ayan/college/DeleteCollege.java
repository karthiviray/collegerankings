package com.ayan.college;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ayan.collegeDAO.CollegeDAO;
import com.ayan.collegeDAO.CollegeDAOImpl;
import com.ayan.conn.UserDetailsConnection;



/**
 * Servlet implementation class DeleteCollege
 */
@WebServlet("/DeleteCollege")
public class DeleteCollege extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteCollege() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		PrintWriter pw = response.getWriter();
		CollegeDAO cDAO;
		try {
			cDAO = new CollegeDAOImpl(UserDetailsConnection.connMet());
			String contact_email = request.getParameter("contact_email");
			int result = cDAO.deleteCollege(contact_email);
			RequestDispatcher rd = request.getRequestDispatcher("DeleteCollege.html");
			rd.include(request, response);
			if (result > 0) {
				pw.println("<center>College Deleted Successfully...</center>");
			} else {
				pw.println("<center>College not Deleted due to some Problem</center>");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
