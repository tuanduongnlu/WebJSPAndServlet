package AdminServlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import JDBC.UserDAO;
import model.User;

/**
 * Servlet implementation class authorizationAdmin
 */
@WebServlet("/authorizationAdmin")
public class authorizationAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public authorizationAdmin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String action = request.getParameter("action");
		UserDAO dao = new UserDAO();
		User user = dao.findByID(id);
		if(action.equals("up")) {
			user.setActivity("admin");
		}else {
			user.setActivity("user");
		}
			
		dao.update(user);
		List<User> list = new UserDAO().getAll();
		request.setAttribute("LISTUSER", list);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/view/admin/listUser.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
