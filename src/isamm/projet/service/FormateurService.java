package isamm.projet.service;

import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import isamm.projet.beans.Etudiant;
import isamm.projet.beans.Formateur;
import isamm.projet.beans.Matiere;
import isamm.projet.inter.IDao;

public class FormateurService implements IDao<Formateur> {

	@Override
	public boolean create(Formateur obj) {
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
	public List<Formateur> getAll() {
		Configuration cfg = new Configuration().configure();
		SessionFactory sessionFactory = cfg.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Query q = session.createQuery("from Formateur f");
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
			Query q = session.createQuery("delete from Formateur f where f.id=:id");
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
	public boolean update(int id, Formateur obj) {
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
	public Formateur getById(int id) {
		Configuration cfg = new Configuration().configure();
		SessionFactory sessionFactory = cfg.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Query q = session.createQuery("From Formateur f where f.id=:id");
			q.setParameter("id",id);
			session.close();
			return (Formateur) q.uniqueResult() ;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
	
	public Formateur getFormateursByMatieres(Matiere M){
		return  M.getFormateur();
	}

}
