package fr.sigl.intg.model;
// Generated Jan 3, 2016 2:05:43 PM by Hibernate Tools 3.4.0.CR1

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.hibernate.LockMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Example;

/**
 * Home object for domain model class Userlogin.
 * @author Hibernate Tools
 */
public class UserloginDAO extends DAO {

	private static final Logger log = Logger.getLogger(UserloginDAO.class.getName());

	private final SessionFactory sessionFactory = getSessionFactory();

	public void persist(Userlogin transientInstance) {
		log.log(Level.INFO, "persisting Userlogin instance");
		Transaction transaction = null;
		try {
			Session session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.persist(transientInstance);
            transaction.commit();
			log.log(Level.INFO, "persist successful");
		} catch (RuntimeException re) {
			log.log(Level.SEVERE, "persist failed", re);
			throw re;
		}
	}

	public void attachDirty(Userlogin instance) {
		log.log(Level.INFO, "attaching dirty Userlogin instance");
		Transaction transaction = null;
		try {
			Session session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			session.saveOrUpdate(instance);
			transaction.commit();
			log.log(Level.INFO, "attach successful");
		} catch (RuntimeException re) {
			log.log(Level.SEVERE, "attach failed", re);
			throw re;
		}
	}

	public void attachClean(Userlogin instance) {
		log.log(Level.INFO, "attaching clean Userlogin instance");
		Transaction transaction = null;
        try {
            Session session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.lock(instance, LockMode.NONE);
            transaction.commit();
			log.log(Level.INFO, "attach successful");
		} catch (RuntimeException re) {
			log.log(Level.SEVERE, "attach failed", re);
			throw re;
		}
	}

	public void delete(Userlogin persistentInstance) {
		log.log(Level.INFO, "deleting Userlogin instance");
		Transaction transaction = null;
        try {
            Session session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.delete(persistentInstance);
            transaction.commit();
			log.log(Level.INFO, "delete successful");
		} catch (RuntimeException re) {
			log.log(Level.SEVERE, "delete failed", re);
			throw re;
		}
	}

	public Userlogin merge(Userlogin detachedInstance) {
		log.log(Level.INFO, "merging Userlogin instance");
		Transaction transaction = null;
        try {
            Session session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            Userlogin result = (Userlogin) session.merge(detachedInstance);
            transaction.commit();
			log.log(Level.INFO, "merge successful");
			return result;
		} catch (RuntimeException re) {
			log.log(Level.SEVERE, "merge failed", re);
			throw re;
		}
	}

	public Userlogin findById(int id) {
		log.log(Level.INFO, "getting Userlogin instance with id: " + id);
		try {
			Userlogin instance = (Userlogin) sessionFactory.openSession().get(Userlogin.class, id);
			if (instance == null) {
				log.log(Level.INFO, "get successful, no instance found");
			} else {
				log.log(Level.INFO, "get successful, instance found");
			}
			return instance;
		} catch (RuntimeException re) {
			log.log(Level.SEVERE, "get failed", re);
			throw re;
		}
	}

	public List findByExample(Userlogin instance) {
		log.log(Level.INFO, "finding Userlogin instance by example");
		try {
			List results = sessionFactory.openSession().createCriteria(Userlogin.class)
					.add(Example.create(instance))
					.list();
			log.log(Level.INFO, "find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.log(Level.SEVERE, "find by example failed", re);
			throw re;
		}
	}
}
