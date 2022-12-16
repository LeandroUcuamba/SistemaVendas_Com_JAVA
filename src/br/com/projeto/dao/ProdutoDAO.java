 
package br.com.projeto.dao;
import br.com.projeto.dao.ProdutoDAO;
import br.com.projeto.jdbc.ConexaoBanco;
import br.com.projeto.model.Fornecedor;
import br.com.projeto.model.Produto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;



public class ProdutoDAO {
    private Connection conexao;
    
    public ProdutoDAO(){
        this.conexao = new ConexaoBanco().pegarConexao();
    }
    
    public void cadastrarProduto(Produto obj){
        try{
            String sql = "insert into tb_produtos (descricao,preco,qtd_estoque,for_id) values(?,?,?,?)";
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setString(1, obj.getDescricao());
            stmt.setDouble(2, obj.getPreco());
            stmt.setInt(3, obj.getQuantidade());
            stmt.setInt(4, obj.getFornecedor().getId());
            
            //3- executar
            stmt.execute();
            stmt.close();
            JOptionPane.showMessageDialog(null, "Produto registrado com sucesso");
            
            
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "erro"+e);
        }
        
    }
    
    
    //Editar produto
        public void alterarProduto(Produto obj){
            try{
              //1- instruçoes SQL
              String sql = "update tb_produtos set descricao=?, preco=?, qtd_estoque=?, for_id=?"
                      + " where id = ? ";
              PreparedStatement stmt = conexao.prepareStatement(sql);
              stmt.setString(1, obj.getDescricao());
              stmt.setDouble(2, obj.getPreco());
              stmt.setInt(3, obj.getQuantidade());
              stmt.setInt(4, obj.getFornecedor().getId());
              stmt.setInt(5, obj.getId());
              
              //3- executar
              stmt.execute();
              stmt.close();
              JOptionPane.showMessageDialog(null, "Produto Actualizado com sucesso");
              
            }catch(SQLException e){
                JOptionPane.showMessageDialog(null, "Erro"+e);
            }
            
            
        }
    
        
    //Deletar produto;
        public void excluirProduto(Produto obj){
            try{
              //1- instruçoes SQL
              String sql = "delete from tb_produtos where id = ?";
              PreparedStatement stmt = conexao.prepareStatement(sql);
              stmt.setInt(1, obj.getId());
              
              
              //3- executar
              stmt.execute();
              stmt.close();
              JOptionPane.showMessageDialog(null, "Produto excluido com sucesso");
              
            }catch(SQLException e){
                JOptionPane.showMessageDialog(null, "Erro"+e);
            }
        }
        
        
    
    //Listar produtos na tabela;
        public List<Produto> listarProdutos(){  
           try { 
               List<Produto> lista = new ArrayList<>();
               
               String sql = "select p.id, p.descricao, p.preco, p.qtd_estoque, f.nome from tb_produtos as p inner join tb_fornecedores as f on (p.for_id = f.id)";
               PreparedStatement stmt = conexao.prepareStatement(sql);
               ResultSet rs = stmt.executeQuery();
               
               while(rs.next()){
                   Fornecedor f = new Fornecedor();
                   Produto obj = new Produto();
                   obj.setId(rs.getInt("p.id"));
                   obj.setDescricao(rs.getString("p.descricao"));
                   obj.setPreco(rs.getDouble("p.preco"));
                   obj.setQuantidade(rs.getInt("p.qtd_estoque"));
                   f.setNome(rs.getString("f.nome"));
                   obj.setFornecedor(f); //porque vem de outra tabela;
                   
               lista.add(obj);
               }
               
               return lista;
               
           }catch (SQLException ex){
               JOptionPane.showMessageDialog(null, "erro" + ex);
           }
            
           return null;
        }
    
    
    
    //Pesquisar produtos por nome;    
        public List<Produto>PesquisarNome(String nome){  
           try { 
               List<Produto> lista = new ArrayList<>();
               
               String sql = "select p.id, p.descricao, p.preco, p.qtd_estoque, f.nome from tb_produtos as p inner join tb_fornecedores as f on (p.for_id = f.id) where p.descricao like ?";
               PreparedStatement stmt = conexao.prepareStatement(sql);
               stmt.setString(1, nome);
               ResultSet rs = stmt.executeQuery();
               
               while(rs.next()){
                   Fornecedor f = new Fornecedor();
                   Produto obj = new Produto();
                   obj.setId(rs.getInt("p.id"));
                   obj.setDescricao(rs.getString("p.descricao"));
                   obj.setPreco(rs.getDouble("p.preco"));
                   obj.setQuantidade(rs.getInt("p.qtd_estoque"));
                   f.setNome(rs.getString("f.nome"));
                   obj.setFornecedor(f); //porque vem de outra tabela;
                   
                   
                   lista.add(obj);
               }
               
               return lista;
               
           }catch (SQLException ex){
               JOptionPane.showMessageDialog(null, "erro\n\n" + ex);
           }
            
           return null;
        }
        
        
    //Buscar produto nome (que também se utiliza para settar os campos);    
        public Produto BuscarProdutoNome(String nome){  
           try { 
               
               String sql = "select p.id, p.descricao, p.preco, p.qtd_estoque, f.nome from tb_produtos as p inner join tb_fornecedores as f on (p.for_id = f.id) where p.descricao = ?";
               PreparedStatement stmt = conexao.prepareStatement(sql);
               stmt.setString(1, nome);
               ResultSet rs = stmt.executeQuery();
                Fornecedor f = new Fornecedor();
                Produto obj = new Produto();
               
               while(rs.next()){
                   obj.setId(rs.getInt("p.id"));
                   obj.setDescricao(rs.getString("p.descricao"));
                   obj.setPreco(rs.getDouble("p.preco"));
                   obj.setQuantidade(rs.getInt("p.qtd_estoque"));
                   f.setNome(rs.getString("f.nome"));
                   obj.setFornecedor(f); //porque vem de outra tabela;
                   
                   
               }
               
               return obj;
               
           }catch (SQLException ex){
               JOptionPane.showMessageDialog(null, "erro\n\n" + ex);
           }
            
           return null;
        }
    
    
    
    public void baixaEstoque(int id, int qtd_nova){
        try{
            String sql = "update tb_produtos set qtd_estoque =? where id=?";
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, qtd_nova);
            stmt.setInt(2, id);
            
            stmt.execute();
            stmt.close();
            JOptionPane.showMessageDialog(null, "Adicionado com sucesso no estoque");
            
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "erro\n\n" + ex);
        }
        
    }
    
     public void adicionarEstoque(int id, int qtd_nova){
        try{
            String sql = "update tb_produtos set qtd_estoque =? where id=?";
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, qtd_nova);
            stmt.setInt(2, id);
            
            stmt.execute();
            stmt.close();
            JOptionPane.showMessageDialog(null, "Adicionado com sucesso no estoque");
            
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "erro\n\n" + ex);
        }
        
    }
    
   // metodo que retorna a quantidade actual do estoque para quando fazer a venda efectuar a subtração;  
 public int retornaQTDatualizada(int id){
     try{
          int qtd_estoque = 0;
         
          String sql = "select qtd_estoque from tb_produtos where id=?";
          PreparedStatement stmt = conexao.prepareStatement(sql);
          stmt.setInt(1, id);
          ResultSet rs = stmt.executeQuery();
          if(rs.next()){
              qtd_estoque = (rs.getInt("qtd_estoque"));
          }
          return qtd_estoque;
          
     } catch(SQLException e){
         throw new RuntimeException(e);
     }
 }
    
    
}
