package com.rest.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.rest.model.Course;

public class CourseDaoImpl {
	public static List<Course> getCourses(){
		String courseInfoQuery="select *from coursetbl";
		List<Course> courses=null;
		try {
			Connection conn=ConnUtil.getConn();
			PreparedStatement pstmt=(PreparedStatement) conn.prepareStatement(courseInfoQuery);
			ResultSet rs = pstmt.executeQuery();
			
			courses=new ArrayList<>();
			while(rs.next()){
				courses.add(
						
						new Course(
								rs.getString(1),
								rs.getString(2)
								)
						);
			}
		} catch (Exception e) {
			System.out.println("CourseDaoImpl ex:"+e.getMessage());
		}
		return courses;
	}

}
