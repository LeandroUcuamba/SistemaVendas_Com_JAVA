/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projeto.view;

import br.com.projeto.dao.FornecedorDAO;
import br.com.projeto.dao.ProdutoDAO;
import br.com.projeto.model.Fornecedor;
import br.com.projeto.model.Produto;
import br.com.projeto.model.Utilitarios;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Leandro
 */
public class FormProdutos extends javax.swing.JFrame {
    
    
     public void listar(){
       ProdutoDAO dao = new ProdutoDAO();
       List<Produto> lista = dao.listarProdutos();
          DefaultTableModel dados = (DefaultTableModel) tabelaProduto.getModel();
          dados.setNumRows(0);
          for(Produto c: lista){
              dados.addRow(new Object[]{
                 c.getId(),
                 c.getDescricao(),
                 c.getPreco(),
                 c.getQuantidade(),
                 c.getFornecedor().getNome()
                  
              });
              
          }
    
    }
    
    
    
    
    /**
     * Creates new form FormClientes
     */
    public FormProdutos() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        painelDeGuiasjTabbedPane1 = new javax.swing.JTabbedPane();
        ConsultaClientesjPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabelaProduto = new javax.swing.JTable();
        txtPesquisarCliente = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        btnPesquisar = new javax.swing.JButton();
        guia_dados_pessoais = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        btnPesq = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtDescricao = new javax.swing.JTextArea();
        txtPreco = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtQuantidade = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        cbFornecedor = new javax.swing.JComboBox();
        btnNovo = new javax.swing.JButton();
        btnSalvar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnVoltar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Cadastro de Produtos");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(304, 304, 304))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jLabel1)
                .addContainerGap(44, Short.MAX_VALUE))
        );

        tabelaProduto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "codigo", "descrição", "preço", "quantidade de stock", "Nome do fornecedor"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabelaProduto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaProdutoMouseClicked(evt);
            }
        });
        tabelaProduto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tabelaProdutoKeyReleased(evt);
            }
        });
        jScrollPane2.setViewportView(tabelaProduto);
        if (tabelaProduto.getColumnModel().getColumnCount() > 0) {
            tabelaProduto.getColumnModel().getColumn(0).setResizable(false);
            tabelaProduto.getColumnModel().getColumn(1).setResizable(false);
            tabelaProduto.getColumnModel().getColumn(2).setResizable(false);
            tabelaProduto.getColumnModel().getColumn(3).setResizable(false);
            tabelaProduto.getColumnModel().getColumn(4).setResizable(false);
        }

        txtPesquisarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPesquisarClienteActionPerformed(evt);
            }
        });
        txtPesquisarCliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPesquisarClienteKeyReleased(evt);
            }
        });

        jLabel10.setText("Nome:");

        btnPesquisar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/lupa.PNG"))); // NOI18N
        btnPesquisar.setText("pesquisar");
        btnPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout ConsultaClientesjPanel3Layout = new javax.swing.GroupLayout(ConsultaClientesjPanel3);
        ConsultaClientesjPanel3.setLayout(ConsultaClientesjPanel3Layout);
        ConsultaClientesjPanel3Layout.setHorizontalGroup(
            ConsultaClientesjPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ConsultaClientesjPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(ConsultaClientesjPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 769, Short.MAX_VALUE)
                    .addGroup(ConsultaClientesjPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addGap(29, 29, 29)
                        .addComponent(txtPesquisarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39)
                        .addComponent(btnPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        ConsultaClientesjPanel3Layout.setVerticalGroup(
            ConsultaClientesjPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ConsultaClientesjPanel3Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(ConsultaClientesjPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txtPesquisarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPesquisar))
                .addGap(88, 88, 88)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        painelDeGuiasjTabbedPane1.addTab("Consulta de produtos", ConsultaClientesjPanel3);

        jLabel2.setText("Código:");

        jLabel3.setText("Descrição:");

        txtCodigo.setEnabled(false);

        jLabel9.setText("Preço:");

        btnPesq.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/lupa.PNG"))); // NOI18N
        btnPesq.setText("Pesquisar");
        btnPesq.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesqActionPerformed(evt);
            }
        });

        txtDescricao.setColumns(20);
        txtDescricao.setRows(5);
        jScrollPane3.setViewportView(txtDescricao);

        jLabel4.setText("Quantidade:");

        jLabel5.setText("Fornecedor:");

        cbFornecedor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbFornecedorMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout guia_dados_pessoaisLayout = new javax.swing.GroupLayout(guia_dados_pessoais);
        guia_dados_pessoais.setLayout(guia_dados_pessoaisLayout);
        guia_dados_pessoaisLayout.setHorizontalGroup(
            guia_dados_pessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(guia_dados_pessoaisLayout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(guia_dados_pessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(guia_dados_pessoaisLayout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addComponent(cbFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(guia_dados_pessoaisLayout.createSequentialGroup()
                        .addGroup(guia_dados_pessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel9))
                        .addGap(10, 10, 10)
                        .addGroup(guia_dados_pessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, guia_dados_pessoaisLayout.createSequentialGroup()
                                .addGap(13, 13, 13)
                                .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, guia_dados_pessoaisLayout.createSequentialGroup()
                                .addComponent(txtPreco, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(101, 101, 101)
                                .addComponent(txtQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, guia_dados_pessoaisLayout.createSequentialGroup()
                                .addGap(106, 106, 106)
                                .addComponent(jLabel4))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, guia_dados_pessoaisLayout.createSequentialGroup()
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(31, 31, 31)
                                .addComponent(btnPesq, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(315, Short.MAX_VALUE))))
        );
        guia_dados_pessoaisLayout.setVerticalGroup(
            guia_dados_pessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(guia_dados_pessoaisLayout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addGroup(guia_dados_pessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(guia_dados_pessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(guia_dados_pessoaisLayout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(jLabel3))
                    .addGroup(guia_dados_pessoaisLayout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(guia_dados_pessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnPesq)
                            .addGroup(guia_dados_pessoaisLayout.createSequentialGroup()
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(34, 34, 34)
                                .addGroup(guia_dados_pessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtPreco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4)
                                    .addComponent(txtQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addGroup(guia_dados_pessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(cbFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36))
        );

        painelDeGuiasjTabbedPane1.addTab("Dados pessoais", guia_dados_pessoais);

        btnNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/novo.PNG"))); // NOI18N
        btnNovo.setText("NOVO");
        btnNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoActionPerformed(evt);
            }
        });

        btnSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/guardar.PNG"))); // NOI18N
        btnSalvar.setText("SALVAR");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        btnExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/deletar.PNG"))); // NOI18N
        btnExcluir.setText("EXCLUIR");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        btnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/editar.PNG"))); // NOI18N
        btnEditar.setText("EDITAR");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnVoltar.setText("VOLTAR");
        btnVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoltarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(painelDeGuiasjTabbedPane1)
            .addGroup(layout.createSequentialGroup()
                .addGap(112, 112, 112)
                .addComponent(btnNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnSalvar)
                .addGap(39, 39, 39)
                .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(btnExcluir)
                .addGap(26, 26, 26)
                .addComponent(btnVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(painelDeGuiasjTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 376, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnEditar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnExcluir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        // TODO add your handling code here:
        Produto obj = new Produto();
        obj.setDescricao(txtDescricao.getText());
        obj.setPreco(Double.valueOf(txtPreco.getText()));
        obj.setQuantidade(Integer.valueOf(txtPreco.getText()));
        obj.setFornecedor((Fornecedor) cbFornecedor.getSelectedItem());
        
        
        ProdutoDAO dao = new ProdutoDAO();
        dao.cadastrarProduto(obj);
        new Utilitarios().limpaTela(guia_dados_pessoais);
        txtDescricao.setText("");
        
        
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        // TODO add your handling code here: 
        listar();
    }//GEN-LAST:event_formWindowActivated

    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed
        //limparTela;
        Utilitarios ut = new Utilitarios();
        ut.limpaTela(guia_dados_pessoais);
      
    }//GEN-LAST:event_btnNovoActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        // Editar produto;
     
        Produto obj = new Produto();
        obj.setDescricao(txtDescricao.getText());
        obj.setPreco(Double.valueOf(txtPreco.getText()));
        obj.setQuantidade(Integer.valueOf(txtQuantidade.getText()));
        Fornecedor f = new Fornecedor();
        f = (Fornecedor) cbFornecedor.getSelectedItem();
        obj.setFornecedor(f);
        obj.setId(Integer.valueOf(txtCodigo.getText()));
        
        
        ProdutoDAO dao = new ProdutoDAO();
        dao.alterarProduto(obj);
        
        new Utilitarios().limpaTela(guia_dados_pessoais);
        txtDescricao.setText("");
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        // Ecluir Produtos;
        Produto obj = new Produto();
        obj.setId(Integer.valueOf(txtCodigo.getText()));
        
        ProdutoDAO dao = new ProdutoDAO();
        dao.excluirProduto(obj);

        
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void tabelaProdutoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tabelaProdutoKeyReleased
        // puxar dados da linha selecionada aos campos;
       
    }//GEN-LAST:event_tabelaProdutoKeyReleased

    private void tabelaProdutoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaProdutoMouseClicked
        // TODO add your handling code here:
         //quando clicar com o mouse na linha dp registro muda de aba e lega os dados nos campos;
        painelDeGuiasjTabbedPane1.setSelectedIndex(1);
        txtCodigo.setText(tabelaProduto.getValueAt(tabelaProduto.getSelectedRow(), 0).toString());
        txtDescricao.setText(tabelaProduto.getValueAt(tabelaProduto.getSelectedRow(), 1).toString());
        txtPreco.setText(tabelaProduto.getValueAt(tabelaProduto.getSelectedRow(), 2).toString());
        txtQuantidade.setText(tabelaProduto.getValueAt(tabelaProduto.getSelectedRow(), 3).toString());
        cbFornecedor.setSelectedItem(tabelaProduto.getValueAt(tabelaProduto.getSelectedRow(), 4).toString());
       
    }//GEN-LAST:event_tabelaProdutoMouseClicked

    private void btnPesqActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesqActionPerformed
        //Pesquisar por nome;
        
    }//GEN-LAST:event_btnPesqActionPerformed

    private void btnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarActionPerformed

        
    }//GEN-LAST:event_btnPesquisarActionPerformed

    private void txtPesquisarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPesquisarClienteActionPerformed
    
    }//GEN-LAST:event_txtPesquisarClienteActionPerformed

    private void txtPesquisarClienteKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPesquisarClienteKeyReleased
       // Pesquisar produto por nome;
       String nome = "%"+txtPesquisarCliente.getText()+"%";
       ProdutoDAO dao = new ProdutoDAO();
       List<Produto> lista = dao.PesquisarNome(nome);
          DefaultTableModel dados = (DefaultTableModel) tabelaProduto.getModel();
          dados.setNumRows(0);
          for(Produto c: lista){
              dados.addRow(new Object[]{
                 c.getId(),
                 c.getDescricao(),
                 c.getPreco(),
                 c.getQuantidade(),
                 c.getFornecedor().getNome()
              });
              
          }
       
      
    }//GEN-LAST:event_txtPesquisarClienteKeyReleased

    private void cbFornecedorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbFornecedorMouseClicked
        // Codigo para buscar os funcionarios já cadastrado no sistema;
        FornecedorDAO dao = new FornecedorDAO();
        List<Fornecedor> listaFornecedor = dao.listarFornecedores();
        cbFornecedor.removeAllItems();
        for(Fornecedor f : listaFornecedor){
          cbFornecedor.addItem(f); 
        }
        
    }//GEN-LAST:event_cbFornecedorMouseClicked

    private void btnVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarActionPerformed
        // TODO add your handling code here:
        FormMenu s = new FormMenu();
        this.dispose();
        s.setVisible(true);
    }//GEN-LAST:event_btnVoltarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FormProdutos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormProdutos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormProdutos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormProdutos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormProdutos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel ConsultaClientesjPanel3;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnNovo;
    private javax.swing.JButton btnPesq;
    private javax.swing.JButton btnPesquisar;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JButton btnVoltar;
    private javax.swing.JComboBox cbFornecedor;
    private javax.swing.JPanel guia_dados_pessoais;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    public javax.swing.JTabbedPane painelDeGuiasjTabbedPane1;
    private javax.swing.JTable tabelaProduto;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextArea txtDescricao;
    private javax.swing.JTextField txtPesquisarCliente;
    private javax.swing.JTextField txtPreco;
    private javax.swing.JTextField txtQuantidade;
    // End of variables declaration//GEN-END:variables
}