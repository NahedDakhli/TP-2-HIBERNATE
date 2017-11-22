package isamm.projet.service;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import isamm.projet.beans.Etudiant;
import isamm.projet.inter.IDao;

public class EtudiantService implements IDao<Etudiant> {

	@Override
	public boolean create(Etudiant obj) {
		Configuration cfg = new Configuration().configure();
		SessionFactory sessionFactory = cfg.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.save(obj);
			session.close();
			return true ;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public List<Etudiant> getAll() {
		Configuration cfg = new Configuration().configure();
		SessionFactory sessionFactory = cfg.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Query q = session.createQuery("from Etudiant e");
			session.close();
			return q.list() ;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
		
	

	@Override
	public boolean delete(int id) {
		Configuration cfg = new Configuration().configure();
		SessionFactory sessionFactory = cfg.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Query q = session.createQuery("delete from Etudiant e where e.id=:id");
			q.setParameter("id",id);
			q.executeUpdate();
			session.close();
			return true ;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}
		
	@Override
	public boolean update(int id, Etudiant obj) {
		Configuration cfg = new Configuration().configure();
		SessionFactory sessionFactory = cfg.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			//obj.setId(id);
			session.saveOrUpdate(obj);
			session.close();
			return true ;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}
	

	@Override
	public Etudiant getById(int id) {
		Configuration cfg = new Configuration().configure();
		SessionFactory sessionFactory = cfg.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Query q = session.createQuery("From Etudiant e where e.id=:id");
			q.setParameter("id",id);
			session.close();
			return (Etudiant) q.uniqueResult() ;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}

	
}

