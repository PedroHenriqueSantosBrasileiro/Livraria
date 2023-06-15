package br.com.livraria.connectionFactory;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ConnectionFactory {

    private final EntityManagerFactory ENTITYMANAGER = Persistence.createEntityManagerFactory("livraria");

    public EntityManager getEntityManager() {
        return ENTITYMANAGER.createEntityManager();
    }

}
