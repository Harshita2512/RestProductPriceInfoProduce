package com.database;

import java.util.ArrayList;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.springframework.stereotype.Repository;

import com.pojo.ProductPriceInfo;

@Repository
public class ProductPriceInfoDatabase {
	

	
	private static SessionFactory sf = getSessionFactory();

	private static SessionFactory  getSessionFactory() {

		if(sf==null) {

			Configuration con = new Configuration().configure();

			ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();

			sf = con.buildSessionFactory(reg);
		}

		return sf;
	}
	
	public int savePersons(ProductPriceInfo p) {
		
		Session session = sf.openSession();
		Transaction t = session.beginTransaction();
		
		int id = (Integer) session.save(p);
		
		t.commit();
		session.flush();
		session.close();
		
		return id;
	}
	
	public void deleteProduct (int id) {
		
		Session session = sf.openSession();
		Transaction t = session.beginTransaction();
		ProductPriceInfo p = new ProductPriceInfo();
		p.setId(id);
		session.delete(p);
		
		t.commit();
		session.flush();
		session.close();
	}
	
	public void updateProduct (ProductPriceInfo p) {
		
		Session session = sf.openSession();
		Transaction t = session.beginTransaction();
		
		session.update(p);
		
		t.commit();
		session.flush();
		session.close();
	}
	
	public ProductPriceInfo getProducts (int id) {

		Session session = sf.openSession();
		Transaction t = session.beginTransaction();
		
		ProductPriceInfo pro = (ProductPriceInfo) session.get(ProductPriceInfo.class, id);
		
		t.commit();
		session.flush();
		session.close();
		
		return pro;
	}
	
	public ArrayList<ProductPriceInfo> getAllProducts (){
		
		Session session = sf.openSession();
		Transaction t = session.beginTransaction();
		

		Criteria c = session.createCriteria(ProductPriceInfo.class);
		ArrayList<ProductPriceInfo> products= (ArrayList<ProductPriceInfo>) c.list();

		session.flush();
		session.close();
		
		return products;
	}


}
