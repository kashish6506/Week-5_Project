package com.digit.hibernateServletController;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.digit.hibernateServlet.bean.AadharDetails;
import com.digt.hibernateServlet.model.HibernateManager;

@WebServlet("/delete")
public class Delete extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id=Integer.parseInt(req.getParameter("id"));
		AadharDetails ad=new AadharDetails();
		ad.setId(id);
		
		
		HibernateManager hbm= new HibernateManager();
		if(hbm.delete(id)==true) {
			
			resp.sendRedirect("/ServletHibernate/DeleteSuccess.html");
		}
		else {
			resp.sendRedirect("/ServletHibernate/DeleteFailed.html");
			
		}
		//hbm.readAll();
	}

}
