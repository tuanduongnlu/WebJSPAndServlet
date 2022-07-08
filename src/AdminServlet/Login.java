package AdminServlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import model.User;
import utils.MD5Library;
import JDBC.UserDAO;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Login() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/view/admin/Login.jsp");
    	dispatcher.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		 response.setContentType("text/html");  
		UserDAO dao = new UserDAO();
		List<User> ls = dao.getAll();
		User u = null;
		String username = request.getParameter("usernamel");
		String password = request.getParameter("passwordl");
		String passMD5 = MD5Library.md5(password);
		u = dao.login(username, passMD5);
		if (u == null) {
			request.setAttribute("usernamel", username);
			request.setAttribute("MESSAGEL", "login that bai");
			request.getRequestDispatcher("/view/admin/Login.jsp").forward(request, response);
		} else {
			HttpSession session = request.getSession();
			session.setAttribute("USER", username);
			session.setAttribute("ROLE",u.getActivity() );
			if (u.getActivity().equals("admin") || u.getActivity().equals("root")) {
				response.sendRedirect(request.getContextPath() + "/HomePage"); 
				} else {
					request.setAttribute("username", username);
					request.getRequestDispatcher("welcome.jsp").forward(request, response);
				}
		}
	}

}
