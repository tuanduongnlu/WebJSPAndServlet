package JDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import utils.DateHelper;
import model.User;


public class UserDAO {
	public int insert(User u) {
		Connection con = null;
		PreparedStatement sttm = null;
		try {
			String sSQL = "insert into ACCOUNT(USERNAME,PASSWORD,PHONE,ADRESS,EMAIL,ACTIVITY,CREATEDATE) " 
		+ "values (?,?,?,?,?,?,?) ";
			con = DatabaseConnect.getDBConnect();
			sttm = con.prepareStatement(sSQL);
			sttm.setString(1, u.getUserName());
			sttm.setString(2, u.getPassword());
			sttm.setString(3, u.getPhone());
			sttm.setString(4, u.getAdress());
			sttm.setString(5, u.getEmail());
			sttm.setString(6, u.getActivity());
			sttm.setString(7, u.getCreateDate());
			if (sttm.executeUpdate() > 0) {
				return 1;
			}
		} catch (Exception e) {
			System.out.println("err :" + e.toString());
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

	public int update(User u) {
		Connection con = null;
		PreparedStatement sttm = null;
		try {
			String sSQL = "update ACCOUNT set USERNAME=?,PASSWORD=?,PHONE=?"
					+ ",ADRESS=?,EMAIL=?" + ",ACTIVITY=?,CREATEDATE=? where ID=?";
			con = DatabaseConnect.getDBConnect();
			sttm = con.prepareStatement(sSQL);
			sttm.setString(1, u.getUserName());
			sttm.setString(2, u.getPassword());
			sttm.setString(3, u.getPhone());
			sttm.setString(4,u.getAdress());
			sttm.setString(5,u.getEmail());
			sttm.setString(6,u.getActivity());
			sttm.setString(7, u.getCreateDate());
			sttm.setInt(8, u.getId());
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

	public int delete(int id) {
		Connection con = null;
		PreparedStatement sttm = null;
		try {
			String sSQL = "delete ACCOUNT where ID=?";
			con = DatabaseConnect.getDBConnect();
			sttm = con.prepareStatement(sSQL);
			sttm.setInt(1, id);
			if (sttm.executeUpdate() > 0) {
				return 1;
			}
		} catch (Exception e) {
			System.out.println("err1 :" + e.toString());
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
	public User findByID(int id) {
		
		User user =null ;
		Connection con = null;
		PreparedStatement sttm = null;
		try {
			String sSQL = "select * from ACCOUNT where ID=?";
			con = DatabaseConnect.getDBConnect();
			sttm = con.prepareStatement(sSQL);
			sttm.setInt(1, id);
			ResultSet rs = sttm.executeQuery();
			while(rs.next()) {
				user =new User() ;
				user.setId(rs.getInt(1));
				user.setUserName(rs.getString(2));
				user.setPassword(rs.getString(3));
				user.setPhone(rs.getString(4));
				user.setAdress(rs.getString(5));
				user.setEmail(rs.getString(6));
				user.setActivity(rs.getString(7));
				user.setCreateDate(DateHelper.toDate(rs.getString(8)));
			}
		} catch (Exception e) {
			System.out.println("err2 :" + e.toString());
		} finally {
			try {
				sttm.close();
				con.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		return user;
	}
public User findByName(String name) {
		
		User user =null ;
		Connection con = null;
		PreparedStatement sttm = null;
		try {
			String sSQL = "select * from ACCOUNT where USERNAME=?";
			con = DatabaseConnect.getDBConnect();
			sttm = con.prepareStatement(sSQL);
			sttm.setString(1, name);
			ResultSet rs = sttm.executeQuery();
			while(rs.next()) {
				user =new User() ;
				user.setId(rs.getInt(1));
				user.setUserName(rs.getString(2));
				user.setPassword(rs.getString(3));
				user.setPhone(rs.getString(4));
				user.setAdress(rs.getString(5));
				user.setEmail(rs.getString(6));
				user.setActivity(rs.getString(7));
				user.setCreateDate(DateHelper.toDate(rs.getString(8)));
			}
		} catch (Exception e) {
			System.out.println("err2 :" + e.toString());
		} finally {
			try {
				sttm.close();
				con.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		return user;
	}
public User login(String username,String password) {
		
		User user =null ;
		Connection con = null;
		PreparedStatement sttm = null;
		try {
			String sSQL = "select * from ACCOUNT"
					+ " where USERNAME =? and PASSWORD=?";
			con = DatabaseConnect.getDBConnect();
			sttm = con.prepareStatement(sSQL);
			sttm.setString(1, username);
			sttm.setString(2, password);
			ResultSet rs = sttm.executeQuery();
			while(rs.next()) {
				user =new User() ;
				user.setId(rs.getInt(1));
				user.setUserName(rs.getString(2));
				user.setPassword(rs.getString(3));
				user.setPhone(rs.getString(4));
				user.setAdress(rs.getString(5));
				user.setEmail(rs.getString(6));
				user.setActivity(rs.getString(7));
				user.setCreateDate(DateHelper.toDate(rs.getString(8)));
			}
		} catch (Exception e) {
			System.out.println("err2 :" + e.toString());
		} finally {
			try {
				sttm.close();
				con.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		return user;
	}
	public List<User> getAll() {
		List<User> ls = new ArrayList<User>() ;
		Connection con = null;
		PreparedStatement sttm = null;
		try {
			String sSQL = "select * from ACCOUNT ";
			con = DatabaseConnect.getDBConnect();
			sttm = con.prepareStatement(sSQL);
			ResultSet rs = sttm.executeQuery();
			while(rs.next()) {
			User user =new User() ;
				user.setId(rs.getInt(1));
				user.setUserName(rs.getString(2));
				user.setPassword(rs.getString(3));
				user.setPhone(rs.getString(4));
				user.setAdress(rs.getString(5));
				user.setEmail(rs.getString(6));
				user.setActivity(rs.getString(7));
				user.setCreateDate(DateHelper.toDate(rs.getString(8)));
			ls.add(user);
			}
		} catch (Exception e) {
			System.out.println("err3 :" + e.toString());
		} finally {
			try {
				sttm.close();
				con.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		return ls;
	}

}
