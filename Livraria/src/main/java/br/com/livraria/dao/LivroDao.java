
package br.com.livraria.dao;

import br.com.livraria.model.Livro;
import javax.persistence.EntityManager;

public class LivroDao {
   
    EntityManager em;

    public LivroDao(EntityManager em) {
        this.em = em;
    }
    
    public void adicionarLivro(Livro livro){
        em.getTransaction().begin();
        em.persist(livro);
        em.getTransaction().commit();
    }
    
}
