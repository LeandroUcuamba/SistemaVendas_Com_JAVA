/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projeto.dao;

import br.com.projeto.jdbc.ConexaoBanco;
import java.sql.Connection;
import br.com.projeto.model.Funcionario;
import br.com.projeto.view.FormMenu;
import br.com.projeto.view.Login;
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
public class FuncionarioDAO {
    
    private Connection conexao;
    
    public FuncionarioDAO(){
        this.conexao = new ConexaoBanco().pegarConexao();
    }
    
    //Cadastrar clientes;
    public void cadastrarFuncionario(Funcionario obj){
        try{
            //1- Criar instrucao SQL;
            String sql = "insert into tb_funcionarios (nome, email, senha, cargo, nivel_acesso, telefone, cep, endereco, numero, complemento, estado) "
                    + " values (?,?,?,?,?,?,?,?,?,?,?)";
            //2- preparar SQL
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setString(1, obj.getNome());
            stmt.setString(2, obj.getEmail());
            stmt.setString(3, obj.getSenha());
            stmt.setString(4, obj.getCargo());
            stmt.setString(5, obj.getNivelAcesso());
            stmt.setString(6, obj.getTelefone());
            stmt.setString(7, obj.getCep());
            stmt.setString(8, obj.getEndereco());
            stmt.setString(9, obj.getNumero());
            stmt.setString(10, obj.getComplemento());
            stmt.setString(11, obj.getEstado());
            
            //3- executar
            stmt.execute();
            stmt.close();
            JOptionPane.showMessageDialog(null, "Funcionario cadastrado com sucesso");
            
            
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "erro"+e);
        }
        
    }
    
    
    //Editar cliente
        public void alterarFuncionario(Funcionario obj){
            try{
              //1- instruçoes SQL
              String sql = "update tb_funcionarios set nome=?, email=?, senha=?, cargo=?, nivel_acesso=?, telefone=?, cep=?, endereco=?, numero=?, complemento=?, estado=?"
                      + " where id = ? ";
              PreparedStatement stmt = conexao.prepareStatement(sql);
              stmt.setString(1, obj.getNome());
              stmt.setString(2, obj.getEmail());
              stmt.setString(3, obj.getSenha());
              stmt.setString(4, obj.getCargo());
              stmt.setString(5, obj.getNivelAcesso());
              stmt.setString(6, obj.getTelefone());
              stmt.setString(7, obj.getCep());
              stmt.setString(8, obj.getEndereco());
              stmt.setString(9, obj.getNumero());
              stmt.setString(10, obj.getComplemento());
              stmt.setString(11, obj.getEstado());
              stmt.setInt(12, obj.getId());
              
              //3- executar
              stmt.execute();
              stmt.close();
              JOptionPane.showMessageDialog(null, "Funcionario Actualizado com sucesso");
              
            }catch(SQLException e){
                JOptionPane.showMessageDialog(null, "Erro"+e);
            }
            
            
        }
        
    //Deletar cliente;
        public void excluirFuncionario(Funcionario obj){
            try{
              //1- instruçoes SQL
              String sql = "delete from tb_funcionarios where id = ?";
              PreparedStatement stmt = conexao.prepareStatement(sql);
              stmt.setInt(1, obj.getId());
              
              
              //3- executar
              stmt.execute();
              stmt.close();
              JOptionPane.showMessageDialog(null, "Funcionario excluido com sucesso");
              
            }catch(SQLException e){
                JOptionPane.showMessageDialog(null, "Erro"+e);
            }
        }
        
    
    //Listar clientes na tabela;
        public List<Funcionario> listarFuncionarios(){  
           try { 
               List<Funcionario> lista = new ArrayList<>();
               
               String sql = "select * from tb_Funcionarios";
               PreparedStatement stmt = conexao.prepareStatement(sql);
               ResultSet rs = stmt.executeQuery();
               
               while(rs.next()){
                   Funcionario obj = new Funcionario();
                   obj.setId(rs.getInt("id"));
                   obj.setNome(rs.getString("nome"));
                   obj.setEmail(rs.getString("email"));
                   obj.setSenha(rs.getString("senha"));
                   obj.setCargo(rs.getString("cargo"));
                   obj.setNivelAcesso(rs.getString("nivel_acesso"));
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
        public Funcionario buscarFuncionario(String nome){
            try { 
              String sql = "select * from tb_funcionarios where nome = ?";
              PreparedStatement stmt = conexao.prepareStatement(sql);
              stmt.setString(1, nome);
              ResultSet rs = stmt.executeQuery();
              
              Funcionario obj = new Funcionario();
               while(rs.next()){
                   obj.setId(rs.getInt("id"));
                   obj.setNome(rs.getString("nome"));
                   obj.setEmail(rs.getString("email"));
                   obj.setSenha(rs.getString("senha"));
                   obj.setCargo(rs.getString("cargo"));
                   obj.setNivelAcesso(rs.getString("nivel_acesso"));
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
        public List<Funcionario>PesquisarNome(String nome){  
           try { 
               List<Funcionario> lista = new ArrayList<>();
               
               String sql = "select * from tb_funcionarios where nome like ?";
               PreparedStatement stmt = conexao.prepareStatement(sql);
               stmt.setString(1, nome);
               ResultSet rs = stmt.executeQuery();
               
               while(rs.next()){
                   Funcionario obj = new Funcionario();
                   obj.setId(rs.getInt("id"));
                   obj.setNome(rs.getString("nome"));
                   obj.setEmail(rs.getString("email"));
                   obj.setSenha(rs.getString("senha"));
                   obj.setCargo(rs.getString("cargo"));
                   obj.setNivelAcesso(rs.getString("nivel_acesso"));
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
        
        
        public void efectuarLogin(String email, String senha){
            try{
                String sql = "select * from tb_funcionarios where email=? and senha=?";
                PreparedStatement stmt = conexao.prepareStatement(sql);
                stmt.setString(1, email);
                stmt.setString(2, senha);
                ResultSet rs = stmt.executeQuery();
                if(rs.next())
                {
                  if(rs.getString("nivel_acesso").equals("Administrador"))
                  {
                      FormMenu f = new FormMenu();
                      f.usuarioLogado = rs.getString("nome");
                      JOptionPane.showMessageDialog(null, "Administrador - "+ " Seja bem vindo ao sistema: \n"+ f.usuarioLogado);
                      f.setVisible(true);
                  }
                  else if(rs.getString("nivel_acesso").equals("Usuario"))
                  {
                      FormMenu f = new FormMenu();
                      f.usuarioLogado = rs.getString("nome");
                      JOptionPane.showMessageDialog(null, "Usuário - "+ " Seja bem vindo ao sistema: \n"+ f.usuarioLogado);
                      f.setVisible(true);
                  }
                }
                else{
                    Login login = new Login();
                    JOptionPane.showMessageDialog(null, "Dados invalidos...");
                    login.setVisible(true);
                }
                
            }catch(SQLException e){
                throw new RuntimeException(e);
            }
            
        }
        
        
    }
    
   
