package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UpdateAccountInfo;
import dto.UserInfo;

/**
 * Servlet implementation class AddAccountInfoServlet
 */
@WebServlet("/UpdateAccountInfoServlet")
public class UpdateAccountInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 *  open the page for entering additional account information; phone number, email, and date of birth
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		int userId = (int)session.getAttribute("userId");
		
		UpdateAccountInfo userInfo = new UpdateAccountInfo();
		UserInfo info = userInfo.getUserInfo(userId);
		request.setAttribute("user_info", info);
		RequestDispatcher dispatcher =
				request.getRequestDispatcher("WEB-INF/jsp/update_account_info.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		int userId = (int)session.getAttribute("userId");
		
		UpdateAccountInfo updateInfo = new UpdateAccountInfo();
		UserInfo fixAndAddInfo = new UserInfo();
		fixAndAddInfo.setId(userId);
		fixAndAddInfo.setName(request.getParameter("name"));
		fixAndAddInfo.setDateOfBirth(request.getParameter("dateOfBirth"));
		fixAndAddInfo.setPhoneNumber(request.getParameter("phoneNumber"));
		fixAndAddInfo.setEmail(request.getParameter("email"));
		updateInfo.add(fixAndAddInfo);
	}

}
