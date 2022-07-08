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
import model.Category;

/**
 * Servlet implementation class EditCategory
 */
@WebServlet("/EditCategory")
public class EditCategory extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditCategory() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Category cate = new CategoryDAO().findById(id);
		request.setAttribute("CATEGORY", cate);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/view/admin/EditCategory.jsp"); 
		dispatcher.forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		new CategoryDAO().update(new Category(id, name));
		CategoryDAO dAO = new CategoryDAO();
		List<Category> list =  dAO .getCategory();
		request.setAttribute("LISTCATE", list);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/view/admin/listCategory.jsp"); 
		dispatcher.forward(request,response);
//		response.sendRedirect(request.getContextPath()+"/ListCate");
		
	}

}
