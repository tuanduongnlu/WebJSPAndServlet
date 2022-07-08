package AdminServlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import JDBC.UserDAO;
import model.Account;
import model.User;
import utils.MD5Library;

/**
 * Servlet implementation class AddAccout
 */
@WebServlet("/AddAccout")
public class AddAccout extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddAccout() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/view/admin/Register.jsp"); 
		dispatcher.forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserDAO dAO = new UserDAO();
		String userName = request.getParameter("username");
		String pass = request.getParameter("password");
		String name = request.getParameter("fullname");
		String phone =request.getParameter("phone");
		String adress = request.getParameter("adress");
		String gmail = request.getParameter("email");
		String action = request.getParameter("action");
		String passMd5 = MD5Library.md5(pass);
		User user = new User(userName, passMd5, phone, adress, gmail, "user",utils.DateHelper.now());
		if (dAO.findByName(userName) != null) {
			request.setAttribute("messageSigin", "tai khoang da ton tai");
			request.setAttribute("USER", user);
			request.getRequestDispatcher("/view/admin/Register.jsp").forward(request, response);
		} else {
			dAO.insert(user);
			request.getRequestDispatcher("").forward(request, response);
		}
	}

}
