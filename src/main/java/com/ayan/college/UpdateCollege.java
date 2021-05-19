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
import com.ayan.model.College;

/**
 * Servlet implementation class UpdateCollege
 */
@WebServlet("/UpdateCollege")
public class UpdateCollege extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateCollege() {
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

		PrintWriter pw = response.getWriter();
		CollegeDAO cDAO;
		try {
			cDAO = new CollegeDAOImpl(UserDetailsConnection.connMet());
			String college_name = request.getParameter("college_name");
			String bio = request.getParameter("bio");
			String contact_email = request.getParameter("contact_email");
			String address = request.getParameter("address");
			String fac_to_stu_ratio = request.getParameter("fac_to_stu_ratio");
			int placement_percent = Integer.parseInt(request.getParameter("placement_percent"));
			int min_percent = Integer.parseInt(request.getParameter("min_percent"));
			String best_branch = request.getParameter("best_branch");
			int result = cDAO.insertCollege(
					new College(college_name, bio, contact_email, address, fac_to_stu_ratio, placement_percent, min_percent,best_branch));
			RequestDispatcher rd = request.getRequestDispatcher("Home/Admin/UpdateCollege.html");
			rd.include(request, response);
			if (result > 0) {
				pw.println("<center>College Updated Successfully...</center>");
			} else {
				pw.println("<center>College not Updated due to some Problem</center>");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}