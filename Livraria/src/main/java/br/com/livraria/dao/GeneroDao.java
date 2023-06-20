package br.com.livraria.dao;

import br.com.livraria.model.Genero;
import java.util.List;
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
    
    public List<Genero> listarGeneros(){
        String sql = "Select * from genero";
        
        return entityManager.createNativeQuery(sql,Genero.class).getResultList();
        
    }
    
    public Genero buscarGeneroPorNome(String nome){
        String sql = "Select * from genero where nome = ?";
        return (Genero) entityManager.createNativeQuery(sql,Genero.class).setParameter(1, nome).getSingleResult();
    }
    
    public void excluirGenero(int id){
        entityManager.getTransaction().begin();
        Genero genero = entityManager.find(Genero.class, id);
        entityManager.remove(genero);
        entityManager.getTransaction().commit();
        
    }
    
    public void editarGenero(int id ,String nome){
        entityManager.getTransaction().begin();
        Genero genero = entityManager.find(Genero.class, id);
        genero.setNome(nome);
        
        entityManager.merge(genero);
        
        entityManager.getTransaction().commit();
        
    }
}
