package AdminServlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import JDBC.CategoryDAO;
import JDBC.ProductDAO;
import model.Category;
import model.Product;

/**
 * Servlet implementation class EditProduct
 */
@WebServlet("/EditProduct")
public class EditProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EditProduct() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Product product = new ProductDAO().findById(id);
		request.setAttribute("PRODUCT", product);
		List<Category> list = new CategoryDAO().getCategory();
		request.setAttribute("LIST_CATE", list);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/view/admin/EditProduct.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ProductDAO pdao = new ProductDAO();
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		String author = request.getParameter("author");
		String cate = request.getParameter("category");
		int category = Integer.parseInt(cate);
		String publisher = request.getParameter("publisher");
		String quan = request.getParameter("quantity");
		int quantity = Integer.parseInt(quan);
		String pri = request.getParameter("price");
		Float price = Float.parseFloat(pri);
		String sa = request.getParameter("sale");
		Float sale = Float.parseFloat(sa);
		String image = request.getParameter("image");
		String status = request.getParameter("status");
		Product product = new Product(name, author, publisher, category, quantity, price, sale, image, status);
		product.setId(id);
		pdao.update(product);
		request.setAttribute("LIST", pdao.getAll());
		request.getRequestDispatcher("/view/admin/ListProduct.jsp").forward(request, response);

	}

}
