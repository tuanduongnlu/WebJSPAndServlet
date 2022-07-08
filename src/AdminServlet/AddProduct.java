package AdminServlet;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import JDBC.CategoryDAO;
import JDBC.ProductDAO;
import model.Category;
import model.Product;

/**
 * Servlet implementation class AddProduct
 */
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 10, maxFileSize = 1024 * 1024 * 50, maxRequestSize = 1024 * 1024
		* 100)
@WebServlet("/AddProduct")

public class AddProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String SAVE_DIR = "imageProduct";

	public AddProduct() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Category> list = new CategoryDAO().getCategory();
		request.setAttribute("LIST_CATE", list);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/view/admin/AddProduct.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		ProductDAO pdao = new ProductDAO();
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
		String status = request.getParameter("status");

		// up load image
		String appPath = request.getServletContext().getRealPath("");
		String savePath = appPath + SAVE_DIR;
		File fileSaveDir = new File(savePath);
		if (!fileSaveDir.exists()) {
			fileSaveDir.mkdir();
		}
		Part filePart = request.getPart("image");
		String fileName = extractFileName(filePart);
		filePart.write(savePath + File.separator + fileName);
		String image = fileName;
		
		// end
		if (pdao.findByName(name)) {
			List<Category> list = new CategoryDAO().getCategory();
			request.setAttribute("LIST_CATE", list);
			request.setAttribute("PRODUCT",
					new Product(name, author, publisher, category, quantity, price, sale, image, status));
			request.setAttribute("MESSAGE", "Sản phẩm này đã tồn tại ,vui lòng đặt tên khác");
			RequestDispatcher dispatcher = request.getRequestDispatcher("/view/admin/AddProduct.jsp");
			dispatcher.forward(request, response);
		} else {
			pdao.insert(new Product(name, author, publisher, category, quantity, price, sale, image, status));
			request.setAttribute("LIST", pdao.getAll());
			request.getRequestDispatcher("/view/admin/ListProduct.jsp").forward(request, response);
		}
	}

	private String extractFileName(Part part) {
		String contentDisp = part.getHeader("content-disposition");
		String[] items = contentDisp.split(";");
		for (String s : items) {
			if (s.trim().startsWith("filename")) {
				return s.substring(s.indexOf("=") + 2, s.length() - 1);
			}
		}
		return "";
	}

}
