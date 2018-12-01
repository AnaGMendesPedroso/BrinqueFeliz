/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package brinquefeliz.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
/**
 * Hibernate Utility class with a convenient method to get Session Factory
 * object.
 *
 * @author anapedroso
*/
public class HibernateUtil {

    private static SessionFactory sf;

    public static Session getSession() {

        return getSessionFactory().openSession();
        
    }

    private static SessionFactory getSessionFactory() {
        if (sf == null) {
            // carrega mapeamentos e propriedades especificadas no hibernate.cfg.xml
            Configuration configuration = new Configuration().configure();
            
            // define um Standard Service Registry, aplica as configurações do hibernate.cfg.xml
            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                .applySettings(configuration.getProperties()).build();
             
            // constrói uma session factory
            sf = configuration.buildSessionFactory(serviceRegistry);           
        }
        
        return sf;
    }

}
