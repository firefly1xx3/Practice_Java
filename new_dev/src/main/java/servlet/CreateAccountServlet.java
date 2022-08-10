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

import dao.CreateAccount;
import dto.CreateUser;

/**
 * Servlet implementation class CreateAccount
 */
@WebServlet("/CreateAccountServlet")
public class CreateAccountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	final String incorrect_pass = "確認用パスワードが一致しません!";
	final String smth_error_at_registration 
		= "アカウント登録時に何らかのエラーが発生しています。" 
		+ "\n" + "もう一度入力上を確認してください";
	List<String> errorMsg = new ArrayList<String>();
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher =
				request.getRequestDispatcher("WEB-INF/jsp/create_account.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse 
			response) throws ServletException, IOException {
		// set UTF-8 type
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		// get variable from request.
		String name = request.getParameter("user_name");
		String password = request.getParameter("password");
		String confirmation_password = request.getParameter("confirmation_password");
		System.out.println("request: \n" + request.getParameter("password") + " : " + request.getParameter("confirmation_password"));
		
		// define class object
		CreateAccount createAccount = new CreateAccount();
		/**
		 * check user typed correct password at confirmation of password.
		 *  if: these two are same.
		 *  else : password and confirmation password are not same.
		 */
		if (password.equals(confirmation_password)) {
			// if correct, create new user and store it at DB.
			System.out.println("before creating");
			List<CreateUser> new_account = createAccount.create(name, password);
			System.out.println(new_account);
			System.out.println("after creating");
			// save info at session.
			/**
			 *  if: something error happens. go back create screen with error message.
			 *  else : Register new account.
			 */
			if (new_account == null) {
				errorMsg.add(smth_error_at_registration);
				request.setAttribute("errorMsg", errorMsg);
				// re-send same page with error message.
				RequestDispatcher dispatcher =
						request.getRequestDispatcher("WEB-INF/jsp/create_account.jsp");
				dispatcher.forward(request, response);
			} else {
		        // send to the account page.
		        RequestDispatcher dispatcher =
						request.getRequestDispatcher("WEB-INF/jsp/login.jsp");
				dispatcher.forward(request, response);
			}
		} else {
			// set error message which will show user.
			errorMsg.add(incorrect_pass);
			request.setAttribute("errorMsg", errorMsg);
			// re-send same page with error message.
			RequestDispatcher dispatcher =
					request.getRequestDispatcher("WEB-INF/jsp/create_account.jsp");
			dispatcher.forward(request, response);
		}
		//
		
	}

}
