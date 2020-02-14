package com.pnp.api.Pointage;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.pnp.api.hibernateSinglton.Connection;

@Repository
public class PointageDAOImp implements PointageDAO {
	Session session = null;

	public PointageDAOImp() {
		session = Connection.getSession();

	}

	@Override
	public List<Pointage> getTous() {
		List<Pointage> list = (List<Pointage>) session.createQuery("from Pointage").list();
		if (list != null) {
			return list;
		} else
			return null;
	}

	@Override
	public void ajouterPointage(Pointage Pointage) throws InterruptedException {
Thread.sleep(300);
		Transaction tx = session.beginTransaction();
		try {
			session.save(Pointage);
			tx.commit();
		} catch (Throwable t) {
			tx.rollback();
			throw t;
		}
	}

	@Override
	public void supprimerPointage(int id1, int id2, String date) {
		Transaction transaction = session.beginTransaction();
		try { 
			// your code
			String hql = "delete from Pointage where id_taxi= :uid AND id_permis= :pid AND date= :date";
			Query query = session.createQuery(hql);
			query.setInteger("uid", id1);
			query.setInteger("pid", id2);
			query.setString("date", date);

			System.out.println(query.executeUpdate());
			// your code end

			transaction.commit();
		} catch (Throwable t) {
			transaction.rollback();
			throw t;
		}

	}

	@Override
	public Pointage getPointageid(int id) {
		Pointage Pointage = (Pointage) session.createQuery("from Pointage where id=" + id ).getSingleResult();
		if (Pointage != null) {
			return Pointage;
		} else
			return null;
	}

}
