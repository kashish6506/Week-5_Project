package com.digt.hibernateServlet.model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistryBuilder;

import com.digit.hibernateServlet.bean.AadharDetails;

public class HibernateManager {
	public Session Session;
	
	public HibernateManager() {

		Configuration configuration= new Configuration().configure("hibernate.cfg.xml");
		ServiceRegistryBuilder builder= new ServiceRegistryBuilder().applySettings(configuration.getProperties());
		SessionFactory sessionFactory= configuration.buildSessionFactory(builder.buildServiceRegistry());
		Session=sessionFactory.openSession();
		System.out.println("Connected to pf...");
		


	}
	public boolean saveObj(AadharDetails ad) {
		Transaction tran=Session.beginTransaction();
		Session.save(ad);

		tran.commit();

		System.out.println("Object saved");
		return true;

	}
	public boolean update(int id, String name) {
		Transaction transaction= Session.beginTransaction();
		AadharDetails ad=(AadharDetails)Session.get(AadharDetails.class,id);
		ad.setName(name);
		Session.update(ad);
		System.out.println("Update Success");
		transaction.commit();
		return true;
	}
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		Transaction transaction= Session.beginTransaction();
		AadharDetails ad=(AadharDetails)Session.get(AadharDetails.class,id);
		
		Session.delete(ad);
		System.out.println("Delete Success");
		transaction.commit();
		return true;
	}
}
