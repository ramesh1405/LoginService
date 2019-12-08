package com.rest.service;

import java.util.List;

import com.rest.dao.CourseDaoImpl;
import com.rest.model.Course;

public class StudentService {
	public static List<Course> processRequest(){
		List<Course> list=CourseDaoImpl.getCourses();
		
		return list;
		
	}

}
