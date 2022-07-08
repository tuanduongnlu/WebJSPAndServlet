package JDBC;

import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Category;
import model.Product;
import model.User;

public class ProductDAO {
	public int insert(Product pro) {
		Connection con = null;
		PreparedStatement sttm = null;
		try {
			String sql = "insert into PRODUCTS (NAME,AUTHOR,PUBLISHER,CATEGORY,QUANTITY,PRICE,SALE,IMAGE,STATUS)"
					+ "values (?,?,?,?,?,?,?,?,?)";
			con = DatabaseConnect.getDBConnect();
			sttm = con.prepareStatement(sql);
			sttm.setString(1, pro.getName());
			sttm.setString(2, pro.getAuthor());
			sttm.setString(3, pro.getPublisher());
			sttm.setInt(4, pro.getCategory());
			sttm.setInt(5, pro.getQuantity());
			sttm.setFloat(6, pro.getPrice());
			sttm.setFloat(7, pro.getSale());
			sttm.setString(8, pro.getImage());
			sttm.setString(9, pro.getStatus());
			if (sttm.executeUpdate() > 0) {
				return 1;
			}

		} catch (Exception e) {
			System.out.println("insert :" + e.toString());
		} finally {
			try {
				sttm.close();
				con.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		return -1;

	}

	public int delete(int id) {
		Connection con = null;
		PreparedStatement sttm = null;
		try {
			String sSQL = "delete PRODUCTS where ID=?";
			con = DatabaseConnect.getDBConnect();
			sttm = con.prepareStatement(sSQL);
			sttm.setInt(1, id);
			;
			if (sttm.executeUpdate() > 0) {
				return 1;
			}
		} catch (Exception e) {
			System.out.println("delete :" + e.toString());
		} finally {
			try {
				sttm.close();
				con.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		return -1;
	}

	public List<Product> getAll() {
		List<Product> list = new ArrayList<Product>();
		Connection con = null;
		PreparedStatement sttm = null;
		try {
			String sql = "select * from PRODUCTS";
			con = DatabaseConnect.getDBConnect();
			sttm = con.prepareStatement(sql);
			ResultSet rs = sttm.executeQuery();
			while (rs.next()) {
				Product pro = new Product();
				pro.setId(rs.getInt(1));
				pro.setName(rs.getString(2));
				pro.setAuthor(rs.getString(3));
				pro.setPublisher(rs.getString(4));
				pro.setCategory(rs.getInt(5));
				pro.setQuantity(rs.getInt(6));
				pro.setPrice(rs.getFloat(7));
				pro.setSale(rs.getFloat(8));
				pro.setImage(rs.getString(9));
				pro.setStatus(rs.getString(10));
				list.add(pro);
			}

		} catch (Exception e) {
			System.out.println("getAll :" + e.toString());
		} finally {
			try {
				sttm.close();
				con.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		return list;
	}

	public List<Product> SearchByCategory(int idCategory) {
		List<Product> list = new ArrayList<Product>();
		Connection con = null;
		PreparedStatement sttm = null;
		try {
			String sql = "select * from PRODUCTS where CATEGORY=?";
			con = DatabaseConnect.getDBConnect();
			sttm = con.prepareStatement(sql);
			sttm.setInt(1, idCategory);
			ResultSet rs = sttm.executeQuery();
			while (rs.next()) {
				Product pro = new Product();
				pro.setId(rs.getInt(1));
				pro.setName(rs.getString(2));
				pro.setAuthor(rs.getString(3));
				pro.setPublisher(rs.getString(4));
				pro.setCategory(rs.getInt(5));
				pro.setQuantity(rs.getInt(6));
				pro.setPrice(rs.getFloat(7));
				pro.setSale(rs.getFloat(8));
				pro.setImage(rs.getString(9));
				pro.setStatus(rs.getString(10));
				list.add(pro);
			}

		} catch (Exception e) {
			System.out.println("searchByCategory :" + e.toString());
		} finally {
			try {
				sttm.close();
				con.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		return list;
	}

	public int update(Product pro) {
		Connection con = null;
		PreparedStatement sttm = null;
		try {
			String sSQL = "update PRODUCTS set NAME=?,AUTHOR=?,PUBLISHER=?,CATEGORY=?,QUANTITY=?,PRICE=?"
					+ ",SALE=?,IMAGE=?,STATUS=?" + " where ID=?";
			con = DatabaseConnect.getDBConnect();
			sttm = con.prepareStatement(sSQL);
			sttm.setString(1, pro.getName());
			sttm.setString(2, pro.getAuthor());
			sttm.setString(3, pro.getPublisher());
			sttm.setInt(4, pro.getCategory());
			sttm.setInt(5, pro.getQuantity());
			sttm.setFloat(6, pro.getPrice());
			sttm.setFloat(7, pro.getSale());
			sttm.setString(8, pro.getImage());
			sttm.setString(9, pro.getStatus());
			sttm.setInt(10, pro.getId());
			if (sttm.executeUpdate() > 0) {
				return 1;
			}
		} catch (Exception e) {
			System.out.println("err0 :" + e.toString());
		} finally {
			try {
				sttm.close();
				con.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		return -1;
	}

	public Product findById(int id) {
		Connection con = null;
		PreparedStatement sttm = null;
		Product pro = new Product();
		try {
			String sql = "select * from PRODUCTS where ID=?";
			con = DatabaseConnect.getDBConnect();
			sttm = con.prepareStatement(sql);
			sttm.setInt(1, id);
			ResultSet rs = sttm.executeQuery();
			while (rs.next()) {
				pro.setId(rs.getInt(1));
				pro.setName(rs.getString(2));
				pro.setAuthor(rs.getString(3));
				pro.setPublisher(rs.getString(4));
				pro.setCategory(rs.getInt(5));
				pro.setQuantity(rs.getInt(6));
				pro.setPrice(rs.getFloat(7));
				pro.setSale(rs.getFloat(8));
				pro.setImage(rs.getString(9));
				pro.setStatus(rs.getString(10));
			}
			return pro;

		} catch (Exception e) {
			System.out.println("findById :" + e.toString());
		} finally {
			try {
				sttm.close();
				con.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		return pro;
	}

	public boolean findByName(String name) {
		boolean result = false;
		Connection con = null;
		PreparedStatement sttm = null;
		try {
			String sql = "select * from PRODUCTS where NAME=?";
			con = DatabaseConnect.getDBConnect();
			sttm = con.prepareStatement(sql);
			sttm.setString(1, name);
			ResultSet rs = sttm.executeQuery();
			if (rs.next()) {
				result = true;
			}
		} catch (Exception e) {
			System.out.println("findByName :" + e.toString());
		} finally {
			try {
				sttm.close();
				con.close();
			} catch (Exception e2) {
			}
		}
		return result;
	}

	public List<Category> getCategory() {
		Connection con = null;
		PreparedStatement sttm = null;
		List<Category> list = new ArrayList<Category>();
		try {
			String sql = "select * from CATEGORY";
			con = DatabaseConnect.getDBConnect();
			sttm = con.prepareStatement(sql);
			ResultSet rs = sttm.executeQuery();
			while (rs.next()) {
				Category c = new Category();
				c.setId(rs.getInt(1));
				c.setName(rs.getString(2));
				list.add(c);
			}
			sttm.close();
			con.close();
			return list;
		} catch (Exception e) {
			System.out.println("getCategory :" + e.toString());
		}
		return list;
	}

	// Lấy chi tiết sản phẩm
	public Product getBookDetail(int id) {
		try {
			Connection con = null;
			String selectStatement = "SELECT * FROM PRODUCTS , CATEGORY WHERE PRODUCTS.CATEGORY = CATEGORY.ID AND PRODUCTS.ID = ? ";
			con = DatabaseConnect.getDBConnect();
			PreparedStatement prepStmt = con.prepareStatement(selectStatement);
			prepStmt.setInt(1, id);
			ResultSet rs = prepStmt.executeQuery();
			Product pro = null;
			if (rs.next()) {
				Category category = new Category(rs.getInt(11), rs.getString(12));
				pro.setId(rs.getInt(1));
				pro.setName(rs.getString(2));
				pro.setAuthor(rs.getString(3));
				pro.setPublisher(rs.getString(4));
				pro.setCategory(rs.getInt(5));
				pro.setQuantity(rs.getInt(6));
				pro.setPrice(rs.getFloat(7));
				pro.setSale(rs.getFloat(8));
				pro.setImage(rs.getString(9));
				pro.setStatus(rs.getString(10));
				prepStmt.close();
				return pro;
			} else {
				prepStmt.close();
			}
		} catch (SQLException ex) {

		}

		return null;

	}

}
