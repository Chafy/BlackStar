package fr.sigl.intg.model;
// Generated Jan 3, 2016 2:05:43 PM by Hibernate Tools 3.4.0.CR1

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.naming.InitialContext;
import org.hibernate.LockMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Example;

/**
 * Home object for domain model class Tag.
 * @author Hibernate Tools
 */
public class TagDAO extends DAO {

	private static final Logger log = Logger.getLogger(TagDAO.class.getName());

	private final SessionFactory sessionFactory = getSessionFactory();

	public void persist(Tag transientInstance) {
		log.log(Level.INFO, "persisting Tag instance");
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

	public void attachDirty(Tag instance) {
		log.log(Level.INFO, "attaching dirty Tag instance");
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

	public void attachClean(Tag instance) {
		log.log(Level.INFO, "attaching clean Tag instance");
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

	public void delete(Tag persistentInstance) {
		log.log(Level.INFO, "deleting Tag instance");
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

	public Tag merge(Tag detachedInstance) {
		log.log(Level.INFO, "merging Tag instance");
		Transaction transaction = null;
        try {
            Session session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            Tag result = (Tag) session.merge(detachedInstance);
            transaction.commit();
			log.log(Level.INFO, "merge successful");
			return result;
		} catch (RuntimeException re) {
			log.log(Level.SEVERE, "merge failed", re);
			throw re;
		}
	}

	public Tag findById(int id) {
		log.log(Level.INFO, "getting Tag instance with id: " + id);
		try {
			Tag instance = (Tag) sessionFactory.openSession().get(Tag.class, id);
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

	public List findByExample(Tag instance) {
		log.log(Level.INFO, "finding Tag instance by example");
		try {
			List results = sessionFactory.openSession().createCriteria(Tag.class)
					.add(Example.create(instance)).list();
			log.log(Level.INFO, "find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.log(Level.SEVERE, "find by example failed", re);
			throw re;
		}
	}
}
