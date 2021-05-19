package com.ayan.collegeDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ayan.model.College;

public class CollegeDAOImpl implements CollegeDAO {

	Connection con;

	public CollegeDAOImpl(Connection con) throws SQLException {
		this.con = con;
	}

	@Override
	public int insertCollege(College C) {
		// TODO Auto-generated method stub
		int result = 0;
		try {
			PreparedStatement ps = con.prepareStatement("insert into college_details values(?,?,?,?,?,?,?,?)"); // Create a
																											// Query or
			// Statement
			ps.setString(1, C.getCollege_name());
			ps.setString(2, C.getBio());
			ps.setString(3, C.getContact_email());
			ps.setString(4, C.getaddress());
			ps.setString(5, C.getFac_to_stu_ratio());
			ps.setInt(6, C.getPlacement_percent());
			ps.setInt(7, C.getMin_percent());
			ps.setString(8, C.getBest_branch());
			result = ps.executeUpdate();
		} catch (Exception e) {
			System.out.println("Error in Insert College : " + e);			
		}
		return result;
	}
		
		

	@Override
	public List<College> getAllCollege() {
		// TODO Auto-generated method stub
		List<College> cList = new ArrayList<>();
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from college_details");
			while (rs.next()) {
				cList.add(new College(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getInt(6), rs.getInt(7), rs.getString(8)));
			}
			System.out.println("Connected....");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error in Get all Colleges :" + e);
		}
		return cList;

	}

	@Override
	public College getCollegeById(String contact_email) {
		// TODO Auto-generated method stub
		
		College C = null;
		try {			
			PreparedStatement ps = con.prepareStatement("select * from college_details where college_id=?");
			ps.setString(1, contact_email);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				C= new College(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getInt(6), rs.getInt(7), rs.getString(8));
			}		
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error :"+e);
		}
		return C;
	}

	@Override
	public int updateCollege(College C) {
		// TODO Auto-generated method stub
		int result=0;
		
		try {
			PreparedStatement ps = con.prepareStatement("update college_details set college_name=?,bio=?,contact_email=?,address=?,fac_to_stu_ratio=?,placement_percent=?,min_percent=?,best_branch=? where contact_email=?"); // Create a Query or																									// Statement
			
			ps.setString(1, C.getCollege_name());
			ps.setString(2, C.getBio());
			ps.setString(3, C.getContact_email());
			ps.setString(4, C.getaddress());
			ps.setString(5, C.getFac_to_stu_ratio());
			ps.setInt(6, C.getPlacement_percent());
			ps.setInt(7, C.getMin_percent());
			ps.setString(8, C.getBest_branch());
			result = ps.executeUpdate();
			
		} catch (Exception e) {
			System.out.println("Error in Update College : " + e);			
		}
		return result;
		
	}

	@Override
	public int deleteCollege(String contact_email) {
		// TODO Auto-generated method stub
		int result =0;
		try {
			PreparedStatement ps = con.prepareStatement("delete from college_details where contact_email=?"); // Create a Query or																									// Statement
			ps.setString(1,contact_email);			
			result = ps.executeUpdate();
		} catch (Exception e) {
			System.out.println("Error in Delete College : " + e);			
		}
		return result;
	}	

}
