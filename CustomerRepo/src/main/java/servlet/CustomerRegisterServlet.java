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

import dao.SqlDao;
import dto.Customer;

/**
 * Servlet implementation class CustomerRegisterServlet
 */
@WebServlet("/CustomerRegisterServlet")
public class CustomerRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		RequestDispatcher dispatcher_list =
			request.getRequestDispatcher("WEB-INF/jsp/register.jsp");
		dispatcher_list.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//文字コードの設定
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");

		//顧客登録画面で入力された値をパラメーターで取得
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		String tel = request.getParameter("tel");

		SqlDao sql = new SqlDao();

		//顧客情報を登録するメソッドの呼び出し
		sql.insert_customer_info(name,address,tel);

		//全ての顧客情報を取得し、顧客管理一覧画面に遷移する
		List<Customer> customer_data = new ArrayList<Customer>();
		customer_data = sql.get_customer_info();
		request.setAttribute("customer", customer_data);

		//顧客画面に遷移
		RequestDispatcher dispatcher =
				request.getRequestDispatcher("WEB-INF/jsp/customer_list.jsp");
		dispatcher.forward(request, response);
	}
}