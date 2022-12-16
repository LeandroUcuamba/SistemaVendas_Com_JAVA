/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projeto.dao;

import br.com.projeto.jdbc.ConexaoBanco;
import java.sql.Connection;
import br.com.projeto.model.Fornecedor;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Leandro
 */
public class FornecedorDAO {
    
    private Connection conexao;
    
    public FornecedorDAO(){
        this.conexao = new ConexaoBanco().pegarConexao();
    }
    
    //Cadastrar Fornecedor;
    public void cadastrarFornecedores(Fornecedor obj){
        try{
            //1- Criar instrucao SQL;
            String sql = "insert into tb_fornecedores (nome, email, telefone, endereco, numero, complemento, estado) "
                    + " values (?,?,?,?,?,?,?)";
            //2- preparar SQL
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setString(1, obj.getNome());
            stmt.setString(2, obj.getEmail());
            stmt.setString(3, obj.getTelefone());
            stmt.setString(4, obj.getEndereco());
            stmt.setString(5, obj.getNumero());
            stmt.setString(6, obj.getComplemento());
            stmt.setString(7, obj.getEstado());
            
            //3- executar
            stmt.execute();
            stmt.close();
            JOptionPane.showMessageDialog(null, "Fornecedor cadastrado com sucesso");
            
            
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "erro"+e);
        }
        
    }
    
    
    //Editar Fornecedor
        public void alterarFornecedor(Fornecedor obj){
            try{
              //1- instruçoes SQL
              String sql = "update tb_fornecedores set nome=?, email=?, telefone=?, endereco=?, numero=?, complemento=?, estado=?"
                      + " where id = ? ";
              PreparedStatement stmt = conexao.prepareStatement(sql);
              stmt.setString(1, obj.getNome());
              stmt.setString(2, obj.getEmail());
              stmt.setString(3, obj.getTelefone());
              stmt.setString(4, obj.getEndereco());
              stmt.setString(5, obj.getNumero());
              stmt.setString(6, obj.getComplemento());
              stmt.setString(7, obj.getEstado());
              stmt.setInt(8, obj.getId());
              
              //3- executar
              stmt.execute();
              stmt.close();
              JOptionPane.showMessageDialog(null, "Fornecedor Actualizado com sucesso");
              
            }catch(SQLException e){
                JOptionPane.showMessageDialog(null, "Erro"+e);
            }
            
            
        }
        
    //Deletar Fornecedor;
        public void excluirFornecedor(Fornecedor obj){
            try{
              //1- instruçoes SQL
              String sql = "delete from tb_fornecedores where id = ?";
              PreparedStatement stmt = conexao.prepareStatement(sql);
              stmt.setInt(1, obj.getId());
              
              
              //3- executar
              stmt.execute();
              stmt.close();
              JOptionPane.showMessageDialog(null, "Fornecedor excluido com sucesso");
              
            }catch(SQLException e){
                JOptionPane.showMessageDialog(null, "Erro"+e);
            }
        }
        
    
    //Listar Fornecedor na tabela;
        public List<Fornecedor> listarFornecedores(){  
           try { 
               List<Fornecedor> lista = new ArrayList<>();
               
               String sql = "select * from tb_fornecedores";
               PreparedStatement stmt = conexao.prepareStatement(sql);
               ResultSet rs = stmt.executeQuery();
               
               while(rs.next()){
                   Fornecedor obj = new Fornecedor();
                   obj.setId(rs.getInt("id"));
                   obj.setNome(rs.getString("nome"));
                   obj.setEmail(rs.getString("email"));
                   obj.setTelefone(rs.getString("telefone"));
                   obj.setEndereco(rs.getString("endereco"));
                   obj.setNumero(rs.getString("numero"));
                   obj.setComplemento(rs.getString("complemento"));
                   obj.setEstado(rs.getString("estado"));
                   
                   lista.add(obj);
               }
               
               return lista;
               
           }catch (SQLException ex){
               JOptionPane.showMessageDialog(null, "erro" + ex);
           }
            
           return null;
        }
        
        
    //buscar cliente para add nos campos;
        public Fornecedor buscarFornecedor(String nome){
            try { 
              String sql = "select * from tb_fornecedores where nome = ?";
              PreparedStatement stmt = conexao.prepareStatement(sql);
              stmt.setString(1, nome);
              ResultSet rs = stmt.executeQuery();
              
              Fornecedor obj = new Fornecedor();
               while(rs.next()){
                   obj.setId(rs.getInt("id"));
                   obj.setNome(rs.getString("nome"));
                   obj.setEmail(rs.getString("email"));
                   obj.setTelefone(rs.getString("telefone"));
                   obj.setEndereco(rs.getString("endereco"));
                   obj.setNumero(rs.getString("numero"));
                   obj.setComplemento(rs.getString("complemento"));
                   obj.setEstado(rs.getString("estado"));
               }
              return obj;
               
           }catch (SQLException ex){
               JOptionPane.showMessageDialog(null, "erro" + ex);
           }
            
          return null;
            
        }
        
    //Pesquisar cliente por nome;    
        public List<Fornecedor>PesquisarNome(String nome){  
           try { 
               List<Fornecedor> lista = new ArrayList<>();
               
               String sql = "select * from tb_fornecedores where nome like ?";
               PreparedStatement stmt = conexao.prepareStatement(sql);
               stmt.setString(1, nome);
               ResultSet rs = stmt.executeQuery();
               
               while(rs.next()){
                   Fornecedor obj = new Fornecedor();
                   obj.setId(rs.getInt("id"));
                   obj.setNome(rs.getString("nome"));
                   obj.setEmail(rs.getString("email"));
                   obj.setTelefone(rs.getString("telefone"));
                   obj.setEndereco(rs.getString("endereco"));
                   obj.setNumero(rs.getString("numero"));
                   obj.setComplemento(rs.getString("complemento"));
                   obj.setEstado(rs.getString("estado"));
                   
                   lista.add(obj);
               }
               
               return lista;
               
           }catch (SQLException ex){
               JOptionPane.showMessageDialog(null, "erro\n\n" + ex);
           }
            
           return null;
        }
        
        
        
    }
    
   
