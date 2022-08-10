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
 * Servlet implementation class CustomerServlet
 */
@WebServlet("/CustomerServlet")
public class CustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	//顧客管理一覧画面のリンク押下時にはこちらで処理を行う
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SqlDao sql = new SqlDao();
		List<Customer> customer_data = new ArrayList<Customer>();
		// get user_id from user's session.
		var user_id = (int)request.getSession().getAttribute("userId");
		// get all customer data.
		customer_data = sql.get_customer_info(user_id);

		// set all customer's data on attribute.
		request.setAttribute("customer", customer_data);
		RequestDispatcher dispatcher =
				request.getRequestDispatcher("WEB-INF/jsp/customer_list.jsp");
		dispatcher.forward(request, response);
	}
}