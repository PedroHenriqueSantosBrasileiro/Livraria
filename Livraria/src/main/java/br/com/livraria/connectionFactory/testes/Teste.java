package br.com.livraria.connectionFactory.testes;

import br.com.livraria.connectionFactory.ConnectionFactory;
import br.com.livraria.dao.GeneroDao;
import br.com.livraria.model.Genero;
import java.util.ArrayList;
import javax.persistence.EntityManager;

public class Teste {
    
    
    public static void main(String[] args) {
        
        
        EntityManager em = new ConnectionFactory().getEntityManager();
        
//        Genero genero = new Genero("Ficcção");
        
        GeneroDao generoDao = new GeneroDao(em);
        
        ArrayList<Genero> generos = (ArrayList<Genero>) generoDao.listarGeneros();
        
        for(Genero genero : generos){
            System.out.println(genero.getNome());
        }
    }
}
