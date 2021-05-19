package com.ayan.college;

import java.io.IOException;
//import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

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
 * Servlet implementation class ShowAllCollege
 */
@WebServlet("/ShowAllCollege")
public class ShowAllCollege extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowAllCollege() {
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

		//PrintWriter pw = response.getWriter();
		CollegeDAO cDAO;
		try {
			cDAO = new CollegeDAOImpl(UserDetailsConnection.connMet());

			List<College> cList = cDAO.getAllCollege();
			request.setAttribute("collegeList", cList);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//request.getRequestDispatcher("showjstl.jsp").forward(request, response);
		request.getRequestDispatcher("showall.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
