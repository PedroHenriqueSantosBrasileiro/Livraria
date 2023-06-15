
package br.com.livraria.dao;

import br.com.livraria.model.Autor;
import java.util.ArrayList;
import javax.persistence.EntityManager;

public class AutorDao {
    
    private EntityManager em;

    public AutorDao(EntityManager em) {
        this.em = em;
    }
    
    public void adicionarAutor(Autor autor){
        em.getTransaction().begin();
        em.persist(autor);
        em.getTransaction().commit();
    }
    
    public ArrayList<Autor> listarAutores(){
        String sql = "select p from Autor p";
        
       return (ArrayList<Autor>) em.createQuery(sql,Autor.class).getResultList();
    }
}
