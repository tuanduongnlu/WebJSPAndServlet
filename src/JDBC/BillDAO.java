package JDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.Bill;
import model.BillDetail;
import utils.DateHelper;

public class BillDAO {
	public List<Bill> getAll() {
		List<Bill> list = new ArrayList<Bill>();
		Connection con = null;
		PreparedStatement sttm = null;
		try {
			String sql = "select * from BILL";
			con = DatabaseConnect.getDBConnect();
			sttm = con.prepareStatement(sql);
			ResultSet rs = sttm.executeQuery();
			while (rs.next()) {
				Bill b = new Bill();
				b.setId(rs.getInt(1));
				b.setUserId(rs.getInt(2));
				b.setUserName(rs.getString(3));
				b.setUserEmail(rs.getString(4));
				b.setUserPhonel(rs.getString(5));
				b.setAmount(rs.getFloat(6));
				b.setCreateDate(DateHelper.toDate(rs.getString(7)));
				list.add(b);
			}
			return list;

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
	public List<Bill> searchByUserName(String userName) {
		List<Bill> list = new ArrayList<Bill>();
		Connection con = null;
		PreparedStatement sttm = null;
		try {
			String sql = "select * from BILL where USERNAME=?";
			con = DatabaseConnect.getDBConnect();
			sttm = con.prepareStatement(sql);
			sttm.setString(1, userName);
			ResultSet rs = sttm.executeQuery();
			while (rs.next()) {
				Bill b = new Bill();
				b.setId(rs.getInt(1));
				b.setUserId(rs.getInt(2));
				b.setUserName(rs.getString(3));
				b.setUserEmail(rs.getString(4));
				b.setUserPhonel(rs.getString(5));
				b.setAmount(rs.getFloat(6));
				b.setCreateDate(DateHelper.toDate(rs.getString(7)));
				list.add(b);
			}
			return list;

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
	public Bill findById(int id) {
		Connection con = null;
		PreparedStatement sttm = null;
		Bill b = new Bill();
		try {
			String sql = "select * from BILL where ID=?";
			con = DatabaseConnect.getDBConnect();
			sttm = con.prepareStatement(sql);
			sttm.setInt(1, id);
			ResultSet rs = sttm.executeQuery();
			while (rs.next()) {
				b.setId(rs.getInt(1));
				b.setUserId(rs.getInt(2));
				b.setUserName(rs.getString(3));
				b.setUserEmail(rs.getString(4));
				b.setUserPhonel(rs.getString(5));
				b.setAmount(rs.getFloat(6));
				b.setCreateDate(DateHelper.toDate(rs.getString(7)));
			}
			return b;

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
		return b;
	}

	public int insertBill(Bill b) {
		Connection con = null;
		PreparedStatement sttm = null;
		try {
			String sql = "insert into BILL(USERID,USERNAME,USERMAIL,USERPHONE,AMOUNT,CREATEDATE)"
					+ " values(?,?,?,?,?,?)";
			con = DatabaseConnect.getDBConnect();
			sttm = con.prepareStatement(sql);
			sttm.setInt(1, b.getUserId());
			sttm.setString(2, b.getUserName());
			sttm.setString(3, b.getUserEmail());
			sttm.setString(4, b.getUserPhonel());
			sttm.setFloat(5, b.getAmount());
			sttm.setString(6, DateHelper.toString(b.getCreateDate()));
			if (sttm.executeUpdate() > 0) {
				return 1;
			}

		} catch (Exception e) {
			System.out.println("insertbill :" + e.toString());
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
	public int insertBillDetail(BillDetail bd) {
		Connection con = null;
		PreparedStatement sttm = null;
		try {
			String sql = "insert into BILLDETAIL(BILLID,PRODUCTID,QUANTITY,AMOUNT)"
					+ " values(?,?,?,?)";
			con = DatabaseConnect.getDBConnect();
			sttm = con.prepareStatement(sql);
			sttm.setInt(1, bd.getBillId());
			sttm.setInt(2, bd.getProductId());
			sttm.setInt(3, bd.getQuantity());
			sttm.setFloat(4, bd.getAmount());
			if (sttm.executeUpdate() > 0) {
				return 1;
			}

		} catch (Exception e) {
			System.out.println("insertbilldetail :" + e.toString());
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

	public List<BillDetail> getAll(int id) {
		Connection con = null;
		PreparedStatement sttm = null;
		List<BillDetail> list = new ArrayList<BillDetail>();
		try {
			String sql = "select * from DETAILBILL where BILLLID=?";
			con = DatabaseConnect.getDBConnect();
			sttm = con.prepareStatement(sql);
			sttm.setInt(1, id);
			ResultSet rs = sttm.executeQuery();
			while (rs.next()) {
				BillDetail b = new BillDetail();
				b.setId(rs.getInt("ID"));
				b.setBillId(rs.getInt("BILLLID"));
				b.setProductId(rs.getInt("PRODUCTID"));
				b.setQuantity(rs.getInt("QUANTITY"));
				b.setAmount(rs.getFloat("AMOUNT"));
				b.setNameProduct(rs.getString("NAMEPRODUCT"));
				list.add(b);
			}
			return list;

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
}
