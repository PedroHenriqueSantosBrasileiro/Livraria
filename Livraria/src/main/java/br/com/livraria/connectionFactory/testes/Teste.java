package br.com.livraria.connectionFactory.testes;

import br.com.livraria.connectionFactory.ConnectionFactory;
import br.com.livraria.dao.AutorDao;
import br.com.livraria.dao.GeneroDao;
import br.com.livraria.dao.LivroDao;
import br.com.livraria.model.Autor;
import br.com.livraria.model.Genero;
import br.com.livraria.model.Livro;
import java.util.ArrayList;
import javax.persistence.EntityManager;

public class Teste {
    
    
    public static void main(String[] args) {
        
        
        EntityManager em = new ConnectionFactory().getEntityManager();
        
        Autor autor = new Autor("Pedro Bandeira");
        
        AutorDao autorDao = new AutorDao(em);
        
        GeneroDao generoDao = new GeneroDao(em);
        
       
        
        Livro livro = new Livro("Droga Da Obediência","1º edição, capa comum",10,60.68,generoDao.buscarGeneroPorNome("Misterio"),autorDao.buscarAutorPorNome("Pedro Bandeira"));
        
        LivroDao livroDao = new LivroDao(em);
        
        livroDao.adicionarLivro(livro);
        }
    }

