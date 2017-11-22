package isamm.projet.service;

import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import isamm.projet.beans.Filiere;
import isamm.projet.beans.Lignematierefiliere;
import isamm.projet.beans.Matiere;
import isamm.projet.inter.IDao;

public class LigneMatiereFiliereService implements IDao<Lignematierefiliere> {

	@Override
	public boolean create(Lignematierefiliere obj) {
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
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(int id, Lignematierefiliere obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Lignematierefiliere getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	
	@Override
	public List<Lignematierefiliere> getAll() {
		// TODO Auto-generated method stub
		return null;
	}
}
