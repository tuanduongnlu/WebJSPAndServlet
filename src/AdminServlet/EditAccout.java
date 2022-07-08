package AdminServlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import JDBC.UserDAO;
import model.User;

/**
 * Servlet implementation class EditAccout
 */
@WebServlet("/EditAccout")
public class EditAccout extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditAccout() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		User user =new UserDAO().findByID(id);
		request.setAttribute("USER", user);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/view/admin/Register.jsp"); 
		dispatcher.forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserDAO dAO = new UserDAO();
		int id = Integer.parseInt(request.getParameter("id"));
		String CreateDate = request.getParameter("createDate");
		String userName = request.getParameter("username");
		String pass = request.getParameter("password");
		String name = request.getParameter("fullname");
		String phone =request.getParameter("phone");
		String adress = request.getParameter("adress");
		String gmail = request.getParameter("email");
		User user = new User(userName, pass, phone, adress, gmail, "user",utils.DateHelper.toDate(CreateDate));
		if (dAO.findByName(userName) != null) {
			request.setAttribute("messageSigin", "tai khoang da ton tai");
			request.setAttribute("USER", user);
			request.getRequestDispatcher("/view/admin/Register.jsp").forward(request, response);
		} else {
			user.setId(id);
			dAO.update(user);
			request.getRequestDispatcher("").forward(request, response);
		}
	}

}
