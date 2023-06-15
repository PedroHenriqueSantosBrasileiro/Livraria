package br.com.livraria.connectionFactory.testes;

import br.com.livraria.connectionFactory.ConnectionFactory;
import br.com.livraria.dao.AutorDao;
import br.com.livraria.dao.GeneroDao;
import br.com.livraria.model.Autor;
import br.com.livraria.model.Genero;
import java.util.ArrayList;
import javax.persistence.EntityManager;

public class Teste {
    
    
    public static void main(String[] args) {
        
        
        EntityManager em = new ConnectionFactory().getEntityManager();
        
        Autor autor = new Autor("Pedro Bandeira");
        
        AutorDao autorDao = new AutorDao(em);
        
        ArrayList<Autor> autores = autorDao.listarAutores();
        
        for(Autor autor1: autores){
            System.out.println(autor1.getNome());
        }
    }
}
