package fr.sigl.intg.model;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.model.naming.ImplicitNamingStrategyJpaCompliantImpl;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

/**
 * Created by Chaf on 12/27/2015.
 */
/**
 * Classe de DAO pour créer la configuration Hibernate nécessaire à la
 * connexion avec la base de données.
 *
 * @author Chaf
 */
public class DAO {
    private static final SessionFactory ourSessionFactory;
    //private static final ServiceRegistry serviceRegistry;

    static {
        try {
        	StandardServiceRegistry standardRegistry = new StandardServiceRegistryBuilder()
        			.configure("hibernate.cfg.xml")
        			.build();

        	Metadata metadata = new MetadataSources( standardRegistry )
        			.addResource("fr/sigl/intg/model/Userlogin.hbm.xml")
        			.addResource("fr/sigl/intg/model/Tag.hbm.xml")
        			.addResource("fr/sigl/intg/model/Image.hbm.xml")
        			.getMetadataBuilder()
        			.applyImplicitNamingStrategy( ImplicitNamingStrategyJpaCompliantImpl.INSTANCE )
        			.build();

        	ourSessionFactory = metadata.getSessionFactoryBuilder()
        			.build();
        	
            /*Configuration configuration = new Configuration();
            configuration.configure();

            serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
            ourSessionFactory = configuration.buildSessionFactory(serviceRegistry);*/
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() throws HibernateException {
        return ourSessionFactory;
    }
}
