package br.com.livraria.dao;

import br.com.livraria.model.Autor;
import java.util.ArrayList;
import javax.persistence.EntityManager;

public class AutorDao {

    private EntityManager em;

    public AutorDao(EntityManager em) {
        this.em = em;
    }

    public void adicionarAutor(Autor autor) {
        em.getTransaction().begin();
        em.persist(autor);
        em.getTransaction().commit();
    }

    public ArrayList<Autor> listarAutores() {
        String sql = "select * from autor";

        return (ArrayList<Autor>) em.createNativeQuery(sql, Autor.class).getResultList();
    }

    public Autor buscarAutorPorNome(String nome) {

        String sql = "Select * from autor where nome = ?";
        return (Autor) em.createNativeQuery(sql, Autor.class).setParameter(1, nome).getSingleResult();

    }
    
    public void deletarAutor(int id){
        em.getTransaction().begin();
        Autor autor = em.find(Autor.class,id);
        em.remove(autor);
        em.getTransaction().commit();
    }
}
