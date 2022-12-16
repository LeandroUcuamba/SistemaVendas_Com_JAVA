/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projeto.dao;

import br.com.projeto.jdbc.ConexaoBanco;
import java.sql.Connection;
import br.com.projeto.model.Cliente;
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
public class ClienteDAO {
    
    private Connection conexao;
    
    public ClienteDAO(){
        this.conexao = new ConexaoBanco().pegarConexao();
    }
    
    //Cadastrar clientes;
    public void cadastrarClientes(Cliente obj){
        try{
            //1- Criar instrucao SQL;
            String sql = "insert into tb_clientes (nome, email, telefone, cep, endereco, numero, complemento, estado) "
                    + " values (?,?,?,?,?,?,?,?)";
            //2- preparar SQL
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setString(1, obj.getNome());
            stmt.setString(2, obj.getEmail());
            stmt.setString(3, obj.getTelefone());
            stmt.setString(4, obj.getCep());
            stmt.setString(5, obj.getEndereco());
            stmt.setString(6, obj.getNumero());
            stmt.setString(7, obj.getComplemento());
            stmt.setString(8, obj.getEstado());
            
            //3- executar
            stmt.execute();
            stmt.close();
            JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso");
            
            
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "erro"+e);
        }
        
    }
    
    
    //Editar cliente
        public void alterarCliente(Cliente obj){
            try{
              //1- instruçoes SQL
              String sql = "update tb_clientes set nome=?, email=?, telefone=?, cep=?, endereco=?, numero=?, complemento=?, estado=?"
                      + " where id = ? ";
              PreparedStatement stmt = conexao.prepareStatement(sql);
              stmt.setString(1, obj.getNome());
              stmt.setString(2, obj.getEmail());
              stmt.setString(3, obj.getTelefone());
              stmt.setString(4, obj.getCep());
              stmt.setString(5, obj.getEndereco());
              stmt.setString(6, obj.getNumero());
              stmt.setString(7, obj.getComplemento());
              stmt.setString(8, obj.getEstado());
              stmt.setInt(9, obj.getId());
              
              //3- executar
              stmt.execute();
              stmt.close();
              JOptionPane.showMessageDialog(null, "Cliente Actualizado com sucesso");
              
            }catch(SQLException e){
                JOptionPane.showMessageDialog(null, "Erro"+e);
            }
            
            
        }
        
    //Deletar cliente;
        public void excluirCliente(Cliente obj){
            try{
              //1- instruçoes SQL
              String sql = "delete from tb_clientes where id = ?";
              PreparedStatement stmt = conexao.prepareStatement(sql);
              stmt.setInt(1, obj.getId());
              
              
              //3- executar
              stmt.execute();
              stmt.close();
              JOptionPane.showMessageDialog(null, "Cliente excluido com sucesso");
              
            }catch(SQLException e){
                JOptionPane.showMessageDialog(null, "Erro"+e);
            }
        }
        
    
    //Listar clientes na tabela;
        public List<Cliente> listarClientes(){  
           try { 
               List<Cliente> lista = new ArrayList<>();
               
               String sql = "select * from tb_clientes";
               PreparedStatement stmt = conexao.prepareStatement(sql);
               ResultSet rs = stmt.executeQuery();
               
               while(rs.next()){
                   Cliente obj = new Cliente();
                   obj.setId(rs.getInt("id"));
                   obj.setNome(rs.getString("nome"));
                   obj.setEmail(rs.getString("email"));
                   obj.setTelefone(rs.getString("telefone"));
                   obj.setCep(rs.getString("cep"));
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
        public Cliente buscarCliente(String nome){
            try { 
              String sql = "select * from tb_clientes where nome = ?";
              PreparedStatement stmt = conexao.prepareStatement(sql);
              stmt.setString(1, nome);
              ResultSet rs = stmt.executeQuery();
              
              Cliente obj = new Cliente();
               while(rs.next()){
                   obj.setId(rs.getInt("id"));
                   obj.setNome(rs.getString("nome"));
                   obj.setEmail(rs.getString("email"));
                   obj.setTelefone(rs.getString("telefone"));
                   obj.setCep(rs.getString("cep"));
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
        public List<Cliente>PesquisarNome(String nome){  
           try { 
               List<Cliente> lista = new ArrayList<>();
               
               String sql = "select * from tb_clientes where nome like ?";
               PreparedStatement stmt = conexao.prepareStatement(sql);
               stmt.setString(1, nome);
               ResultSet rs = stmt.executeQuery();
               
               while(rs.next()){
                   Cliente obj = new Cliente();
                   obj.setId(rs.getInt("id"));
                   obj.setNome(rs.getString("nome"));
                   obj.setEmail(rs.getString("email"));
                   obj.setTelefone(rs.getString("telefone"));
                   obj.setCep(rs.getString("cep"));
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
        
        //---------------------------------------------------------------------
        
        //para ser usado no form de vendas
        
        public Cliente buscarClienteCEP(String cep){
            try { 
              String sql = "select * from tb_clientes where cep = ?";
              PreparedStatement stmt = conexao.prepareStatement(sql);
              stmt.setString(1, cep);
              ResultSet rs = stmt.executeQuery();
              
              Cliente obj = new Cliente();
               while(rs.next()){
                   obj.setId(rs.getInt("id"));
                   obj.setNome(rs.getString("nome"));
                   obj.setEmail(rs.getString("email"));
                   obj.setTelefone(rs.getString("telefone"));
                   obj.setCep(rs.getString("cep"));
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
        
    }
    
   
