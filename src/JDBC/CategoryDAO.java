package JDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.Category;

public class CategoryDAO {
	public List<Category> getCategory() {
		Connection con = null;
		PreparedStatement sttm = null;
		List<Category> list = new ArrayList<Category>();
		try {
			String sql ="select * from CATEGORY" ;
			con = DatabaseConnect.getDBConnect();
			sttm = con.prepareStatement(sql);
			ResultSet rs = sttm.executeQuery();
			while(rs.next()) {
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
	public Category findById(int id) {
		Connection con = null;
		PreparedStatement sttm = null;
		Category cate = null;
		try {
			String sql ="select * from CATEGORY where ID=?" ;
			con = DatabaseConnect.getDBConnect();
			sttm = con.prepareStatement(sql);
			sttm.setInt(1, id);
			ResultSet rs = sttm.executeQuery();
			while(rs.next()) {
				cate = new Category();
				cate.setId(rs.getInt(1));
				cate.setName(rs.getString(2));
			}
			sttm.close();
			con.close();
			return cate;
		} catch (Exception e) {
			System.out.println("getCategory :" + e.toString());
		}
		return cate;
	}
	public int update(Category cate) {
		Connection con = null;
		PreparedStatement sttm = null;
		try {
			String sql ="update CATEGORY set NAME=? where ID=?" ;
			con = DatabaseConnect.getDBConnect();
			sttm = con.prepareStatement(sql);
			sttm.setString(1, cate.getName());
			sttm.setInt(2, cate.getId());
			if (sttm.executeUpdate() > 0) {
				return 1;
			}
		} catch (Exception e) {
			System.out.println("updateCategory :" + e.toString());
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
	public int insert(Category cate) {
		Connection con = null;
		PreparedStatement sttm = null;
		try {
			String sql ="insert into CATEGORY(NAME) values(?)" ;
			con = DatabaseConnect.getDBConnect();
			sttm = con.prepareStatement(sql);
			sttm.setString(1, cate.getName());
			if (sttm.executeUpdate() > 0) {
				return 1;
			}
		} catch (Exception e) {
			System.out.println("insertCategory :" + e.toString());
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
			String sql ="delete CATEGORY where ID=?" ;
			con = DatabaseConnect.getDBConnect();
			sttm = con.prepareStatement(sql);
			sttm.setInt(1, id);
			if (sttm.executeUpdate() > 0) {
				return 1;
			}
		} catch (Exception e) {
			System.out.println("deleteCategory :" + e.toString());
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
}
