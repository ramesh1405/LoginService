package com.rest.controller;

import java.util.List;
import java.util.StringTokenizer;

import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import javax.ws.rs.core.Response.Status;

import com.rest.model.Course;
import com.rest.service.StudentService;
import com.rest.validator.AuthValidator;
import com.sun.jersey.core.spi.factory.ResponseBuilderImpl;
import com.sun.jersey.core.util.Base64;

@Path("/student")
public class StudentController {
	@GET
	@Path("/valid")
	@Produces("application/json")
	/*public Response isValidStudent(@HeaderParam("Authorization") String auth) {*/
		public Response isValidStudent(
				@QueryParam("uname") String uname,
				@QueryParam("pwd") String pwd
				) {

		ResponseBuilder rb = new ResponseBuilderImpl();

		/*// 1. is Auth header empty or null?
		if (null == auth || "".equals(auth.trim())) {
			rb.entity("Please Provide Identity Details...");
			rb.status(Status.BAD_REQUEST);
		} else {
			// remove Basic<space>
			auth = auth.replace("Basic ", "");
			// Decode Auth header
			byte[] arr = Base64.decode(auth.getBytes());
			auth = new String(arr);

			// read un, pwd as two Strings using -STR
			StringTokenizer str = new StringTokenizer(auth, ":");
			String uname = str.nextToken();
			String pwd = str.nextToken();
			System.out.println("---username:"+uname+",passwrod:"+pwd);
*/
			boolean isValidStud = AuthValidator.isValid(uname, pwd);
			List<Course> listOfCourses = null;
			if (isValidStud) {
				listOfCourses = StudentService.processRequest();
				/*for (Course course : listOfCourses) {
					rb.entity(course.getcName());
					rb.status(Status.OK);
				}*/
				rb.entity(listOfCourses);
				rb.status(Status.OK);
				
				//System.out.println("valid user");

			} else {
				rb.entity("Invalid User...Please enter valid credentials");
				rb.status(Status.UNAUTHORIZED);
				//System.out.println("status not ok");
			}
		/*}*/
		Response response = rb.build();

		return response;
	}
	
}
