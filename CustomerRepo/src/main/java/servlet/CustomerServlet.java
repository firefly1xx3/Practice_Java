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
		customer_data = sql.get_customer_info();

		request.setAttribute("customer", customer_data);
		RequestDispatcher dispatcher =
				request.getRequestDispatcher("WEB-INF/jsp/customer_list.jsp");
		dispatcher.forward(request, response);
	}
}