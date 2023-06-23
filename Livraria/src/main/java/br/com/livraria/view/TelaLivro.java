/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package br.com.livraria.view;

import br.com.livraria.connectionFactory.ConnectionFactory;
import br.com.livraria.dao.AutorDao;
import br.com.livraria.dao.GeneroDao;
import br.com.livraria.dao.LivroDao;
import br.com.livraria.model.Autor;
import br.com.livraria.model.Genero;
import br.com.livraria.model.Livro;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;


/**
 *
 * @author pedro
 */
public class TelaLivro extends javax.swing.JInternalFrame {

    EntityManager em;
    LivroDao livroDao;
    GeneroDao generoDao;
    AutorDao autorDao;
    public TelaLivro() {
        initComponents();
        prencherTabela();
        precherComboBoxGenero();
        prencherComboBoxAutor();
    }
    
    private void precherComboBoxGenero(){
        iniciaGeneroDao();
        
        ArrayList<Genero> generos = (ArrayList<Genero>) generoDao.listarGeneros();
        
        
       
       for(Genero genero: generos){
           comboBoxGenero.addItem(genero.toString());
       }
       em.close();
    }
    
    private void prencherComboBoxAutor(){
        iniciaAutorDao();
        
        ArrayList<Autor> autores = autorDao.listarAutores();
        
        for(Autor autor: autores){
            comboBoxAutor.addItem(autor.toString());
        }
        
        em.close();
    }
           
    
    
    private void prencherTabela(){
        iniciaLivroDao();
        
        DefaultTableModel modelo = (DefaultTableModel) tblLivro.getModel();
        
        modelo.setNumRows(0);
        
        ArrayList<Livro> livros = livroDao.listarLivros();
        
        for(Livro livro: livros){
            modelo.addRow(new Object[]{livro.getId(),
                livro.getNome(),
                livro.getDescricao(),
                livro.getAutor().getNome(),
                livro.getGenero().getNome(),
                livro.getQuantidade(),
                String.format("%.2f", livro.getPreco())});
        }
    }
    
    private void iniciaLivroDao(){
        em = new ConnectionFactory().getEntityManager();
        livroDao = new LivroDao(em);
        
    }
    private void iniciaGeneroDao(){
       em = new ConnectionFactory().getEntityManager();
       generoDao = new GeneroDao(em);
       
    }
    
    private void iniciaAutorDao(){
        em = new ConnectionFactory().getEntityManager();
        autorDao = new AutorDao(em);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtNome = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtPreco = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        comboBoxGenero = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        comboBoxAutor = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblLivro = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtDescricao = new javax.swing.JTextArea();
        jLabel5 = new javax.swing.JLabel();
        btnAdicionar = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        txtQuantidade = new javax.swing.JTextField();
        btnExcluir = new javax.swing.JButton();

        jLabel1.setText("Nome");

        jLabel2.setText("Preço");

        jLabel3.setText("Genero");

        jLabel4.setText("Autor");

        tblLivro.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Nome", "Descrição", "Autor", "Genero", "Quantidade", "Preço"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblLivro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblLivroMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblLivro);
        if (tblLivro.getColumnModel().getColumnCount() > 0) {
            tblLivro.getColumnModel().getColumn(0).setMinWidth(50);
            tblLivro.getColumnModel().getColumn(0).setPreferredWidth(50);
            tblLivro.getColumnModel().getColumn(0).setMaxWidth(50);
            tblLivro.getColumnModel().getColumn(1).setResizable(false);
            tblLivro.getColumnModel().getColumn(2).setResizable(false);
            tblLivro.getColumnModel().getColumn(3).setResizable(false);
            tblLivro.getColumnModel().getColumn(4).setMinWidth(150);
            tblLivro.getColumnModel().getColumn(4).setPreferredWidth(150);
            tblLivro.getColumnModel().getColumn(4).setMaxWidth(150);
            tblLivro.getColumnModel().getColumn(5).setMinWidth(100);
            tblLivro.getColumnModel().getColumn(5).setPreferredWidth(100);
            tblLivro.getColumnModel().getColumn(5).setMaxWidth(100);
            tblLivro.getColumnModel().getColumn(6).setMinWidth(100);
            tblLivro.getColumnModel().getColumn(6).setPreferredWidth(100);
            tblLivro.getColumnModel().getColumn(6).setMaxWidth(100);
        }

        txtDescricao.setColumns(20);
        txtDescricao.setRows(5);
        jScrollPane2.setViewportView(txtDescricao);

        jLabel5.setText("Descrição");

        btnAdicionar.setText("Adicionar");
        btnAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarActionPerformed(evt);
            }
        });

        jLabel6.setText("Quantidade");

        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(layout.createSequentialGroup()
                .addGap(72, 72, 72)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(txtPreco, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(37, 37, 37)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(comboBoxGenero, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3))
                                .addGap(31, 31, 31)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(comboBoxAutor, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(txtQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(120, 120, 120))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(37, 37, 37)
                                .addComponent(btnAdicionar)
                                .addGap(18, 18, 18)
                                .addComponent(btnExcluir)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(149, 149, 149))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPreco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboBoxGenero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboBoxAutor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnAdicionar)
                            .addComponent(btnExcluir))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarActionPerformed
       iniciaLivroDao();
       iniciaGeneroDao();
       iniciaAutorDao();
       
       String nome = txtNome.getText();
       
       double preco = Double.parseDouble (txtPreco.getText().replace(",", "."));
       int quantidade = Integer.parseInt(txtQuantidade.getText());
       String descricao = txtDescricao.getText();
       Autor autor = autorDao.buscarAutorPorNome((String) comboBoxAutor.getSelectedItem());
       Genero genero = generoDao.buscarGeneroPorNome((String)comboBoxGenero.getSelectedItem());
       
       Livro livro = new Livro(nome,descricao,quantidade,preco,genero,autor);
       
       livroDao.adicionarLivro(livro);
       
       prencherTabela();
       em.close();
    }//GEN-LAST:event_btnAdicionarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        iniciaLivroDao();
        
        if(tblLivro.getSelectedRow() != -1){
            livroDao.excluirLivro(Integer.parseInt(tblLivro.getValueAt(tblLivro.getSelectedRow(), 0).toString()));
            prencherTabela();
            
        }
        em.close();
        
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void tblLivroMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblLivroMouseClicked
        if(tblLivro.getSelectedRow() != -1){
            txtNome.setText((String) tblLivro.getValueAt(tblLivro.getSelectedRow(), 1));
            txtDescricao.setText((String) tblLivro.getValueAt(tblLivro.getSelectedRow(), 2));
            comboBoxAutor.setSelectedItem(tblLivro.getValueAt(tblLivro.getSelectedRow(), 3));
            comboBoxGenero.setSelectedItem(tblLivro.getValueAt(tblLivro.getSelectedRow(), 4));
            txtQuantidade.setText(String.valueOf(tblLivro.getValueAt(tblLivro.getSelectedRow(), 5)));
            txtPreco.setText((String) tblLivro.getValueAt(tblLivro.getSelectedRow(), 6));
        }
    }//GEN-LAST:event_tblLivroMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdicionar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JComboBox<String> comboBoxAutor;
    private javax.swing.JComboBox<String> comboBoxGenero;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblLivro;
    private javax.swing.JTextArea txtDescricao;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtPreco;
    private javax.swing.JTextField txtQuantidade;
    // End of variables declaration//GEN-END:variables
}
