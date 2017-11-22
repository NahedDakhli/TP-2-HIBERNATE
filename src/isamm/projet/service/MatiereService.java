package isamm.projet.service;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import isamm.projet.beans.Formateur;
import isamm.projet.beans.Matiere;
import isamm.projet.inter.IDao;

public class MatiereService implements IDao<Matiere> {

	@Override
	public boolean create(Matiere obj) {
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
	public List<Matiere> getAll() {
		Configuration cfg = new Configuration().configure();
		SessionFactory sessionFactory = cfg.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Query q = session.createQuery("from Matiere m");
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
			Query q = session.createQuery("delete from Matiere m where m.id=:id");
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
	public boolean update(int id, Matiere obj) {
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
	public Matiere getById(int id) {
		Configuration cfg = new Configuration().configure();
		SessionFactory sessionFactory = cfg.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Query q = session.createQuery("From Matiere m where m.id=:id");
			q.setParameter("id",id);
			session.close();
			return (Matiere) q.uniqueResult() ;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}

}
