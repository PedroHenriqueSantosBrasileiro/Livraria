package br.com.livraria.dao;

import br.com.livraria.model.Genero;
import javax.persistence.EntityManager;

public class GeneroDao {

    EntityManager entityManager;

    public GeneroDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void adicionarGenero(Genero genero) {
        entityManager.getTransaction().begin();
        entityManager.persist(genero);
        entityManager.getTransaction().commit();
    }
}
