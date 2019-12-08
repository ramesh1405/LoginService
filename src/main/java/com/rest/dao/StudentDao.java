package com.rest.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.mysql.jdbc.Connection;

public class StudentDao implements IStudentDao {

	@Override
	public boolean isStudentExsits(String sid) {
		String sqlQuerryOne="select count(rid) from registbl where rid=?";
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		boolean flag=false;
		try {
			conn=ConnUtil.getConn();
			pstmt=conn.prepareStatement(sqlQuerryOne);
			
			pstmt.setString(1,sid);
			rs=pstmt.executeQuery();
			if(rs.next()){
				String s=rs.getString(1);
				System.out.println("string count="+s);
				int c=Integer.parseInt(s);
				System.out.println("int count:"+c);
				if(c>=1) flag=true;
			}
			
		} catch (Exception e) {
			System.out.println("----student dao ex:"+e.getMessage());
			e.printStackTrace();
		}finally{
			if(conn!=null) conn=null;
		}
		return flag;
	}
	}


