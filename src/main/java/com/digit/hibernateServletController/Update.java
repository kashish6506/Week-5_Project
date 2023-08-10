package com.digit.hibernateServletController;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.digit.hibernateServlet.bean.AadharDetails;
import com.digt.hibernateServlet.model.HibernateManager;
@WebServlet("/update")
public class Update extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id=Integer.parseInt(req.getParameter("id"));
		String name=req.getParameter("name");
		
		AadharDetails ad=new AadharDetails();
		ad.setId(id);
		ad.setName(name);
		
		HibernateManager hbm= new HibernateManager();
		if(hbm.update(id,name)==true) {
			
			resp.sendRedirect("/ServletHibernate/UpdateSuccess.html");
		}
		else {
			resp.sendRedirect("/ServletHibernate/UpdateFailed.html");
			
		}
		//hbm.readAll();
		
		
	}

}
