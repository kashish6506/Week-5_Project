package com.digit.hibernateServletController;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.digit.hibernateServlet.bean.AadharDetails;
import com.digt.hibernateServlet.model.HibernateManager;

@WebServlet("/Register")

public class Register extends HttpServlet {
	private PreparedStatement pstmt;
	private Connection con;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int id=Integer.parseInt(req.getParameter("id"));
		String name=req.getParameter("name");
//		String father_name=req.getParameter("father_name");
		String email=req.getParameter("email");
//		int age=Integer.parseInt(req.getParameter("age"));
		int phone=Integer.parseInt(req.getParameter("phone"));
		String address=req.getParameter("address");
		String city=req.getParameter("city");

//		String state=req.getParameter("state");
		int pincode=Integer.parseInt(req.getParameter("pincode"));
//		String email=req.getParameter("email_id");
		
		
		AadharDetails ad=new AadharDetails();
		ad.setId(id);
		ad.setName(name);
		ad.setAddress(address);
//		ad.setAge(age);
		ad.setCity(city);
		ad.setEmail(email);
//		ad.setFather_name(father_name);
		ad.setPhone(phone);
		ad.setPincode(pincode);
//		ad.setState(state);
		
		
		HibernateManager hbm= new HibernateManager();
		if(hbm.saveObj(ad)==true) {
			resp.sendRedirect("/ServletHibernate/RegisterSuccess.html");
		}
		else {
			resp.sendRedirect("/ServletHibernate/RegisterFailed.html");
			
		}
		//hbm.readAll();
		
		
	}
		
	}


