
package br.com.livraria.dao;

import br.com.livraria.model.Livro;
import java.util.ArrayList;
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
    
    public ArrayList<Livro> listarLivros(){
        String sql = "Select * from livro";
        
        return (ArrayList<Livro>) em.createNativeQuery(sql,Livro.class).getResultList();
    }
    
}
