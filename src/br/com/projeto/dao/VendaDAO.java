 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projeto.dao;

import br.com.projeto.jdbc.ConexaoBanco;
import br.com.projeto.model.Cliente;
import br.com.projeto.model.Vendas;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Leandro
 */



public class VendaDAO {
    private Connection conexao;
    
    public VendaDAO(){
        this.conexao = new ConexaoBanco().pegarConexao();
    }
    
    public void cadastrarVenda(Vendas obj){
        try{
            String sql = "insert into tb_vendas (cliente_id,data_venda,total_venda,observacoes) values(?,?,?,?)";
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, obj.getCliente().getId());
            stmt.setString(2, obj.getData_venda().toString());
            stmt.setDouble(3, obj.getTotal_venda());
            stmt.setString(4, obj.getObservacoes());
            
            //3- executar
            stmt.execute();
            stmt.close();
            JOptionPane.showMessageDialog(null, "Venda registrada com sucesso");
            
            
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "erro"+e);
        }
        
    }
    
   //metodo para retorna a ultima venda; 
   public int retornaUltimaVenda(){
       try{
           int idUltimaVenda = 0;
           String sql = "select max(id) id from tb_vendas";
           PreparedStatement stmt = conexao.prepareStatement(sql);
           ResultSet rs = stmt.executeQuery();
           
           while(rs.next()){
               Vendas v = new Vendas();
               v.setId(rs.getInt("id"));
               idUltimaVenda = v.getId();
           }
           return idUltimaVenda;
       } catch(SQLException e){
           throw new RuntimeException(e); 
       }
       
   }
   
   
   //Metodo para pegar total de vendas num dia;
   public double totalVendas(LocalDate data){
       try{
           double totais = 0;
           String sql = "select sum(total_venda) as total from tb_vendas where data_venda=?";
           PreparedStatement stmt = conexao.prepareStatement(sql);
           stmt.setString(1, data.toString());
           ResultSet rs = stmt.executeQuery();
           
           while(rs.next()){
              totais = rs.getDouble("total");
           }
         return totais;
           
       } catch(SQLException e){
           throw new RuntimeException(e);
       }
       
   }
   
   
  //Historico de bvendas entre duas datas;
   
   public List<Vendas>historicoVendas(LocalDate data_inicio, LocalDate data_fim){
       try{
           List<Vendas> lista = new ArrayList<>();
           String sql = "select v.id, c.nome, date_format(v.data_venda, '%d/%m/%y') as data_formatada, v.total_venda, v.observacoes from tb_vendas as v inner join tb_clientes as c "
                   + "on(v.cliente_id = c.id) where v.data_venda BETWEEN ? and ?";
           PreparedStatement stmt = conexao.prepareStatement(sql);
           stmt.setString(1, data_inicio.toString());
           stmt.setString(2, data_fim.toString());
           ResultSet rs = stmt.executeQuery();
           while(rs.next()){
               Vendas obj = new Vendas();
               Cliente c = new Cliente();
               obj.setId(rs.getInt("v.id"));
               c.setNome(rs.getString("c.nome"));
               obj.setCliente(c);
               obj.setData_venda(rs.getString("data_formatada"));
               obj.setTotal_venda(rs.getDouble("v.total_venda"));
               obj.setObservacoes(rs.getString("v.observacoes"));
               
               lista.add(obj);
               
           }
           
           return lista;
           
       } catch(SQLException e){
           throw new RuntimeException(e);
       }
       
   }
    
    
    
}
