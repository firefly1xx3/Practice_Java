package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.SqlDao;
import dto.Customer;
import dto.LoginUser;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		RequestDispatcher dispatcher =
				request.getRequestDispatcher("WEB-INF/jsp/login.jsp");
		dispatcher.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		// set character code
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		//
		String user = request.getParameter("user_name");
		String password = request.getParameter("password");
//		System.out.printf("name: %s & pass: %s%n", user, password);
		
		SqlDao sql = new SqlDao();
		List<LoginUser> login = sql.check(user, password);
		
		//
		String login_user = login.get(0).getName();
		String login_pass = login.get(0).getPassword();
		int login_user_id = login.get(0).getId();
		
		/**
		 *  If login method does not work correctly, 
		 * 	the program get "no user" at user's value.
		 */
		if(user.equals(login_user) && password.equals(login_pass)) {
			// Login Successful
			// set user info at session
			HttpSession session = request.getSession();
	        session.setAttribute("username", login_user);
	        session.setAttribute("userId", login_user_id);
	        System.out.println("userId: " + request.getSession().getAttribute("userId"));
			// Send to new page with customer list.
			RequestDispatcher dispatcher =
					request.getRequestDispatcher("/AccountServlet");
			dispatcher.forward(request, response);
		} else {
			// failure => go back present screen.
			RequestDispatcher dispatcher =
					request.getRequestDispatcher("WEB-INF/jsp/login.jsp");
			dispatcher.forward(request, response);
		}
	}
}