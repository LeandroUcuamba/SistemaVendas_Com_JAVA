/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projeto.jdbc;

import java.sql.DriverManager;
import java.sql.Connection;
import javax.swing.JOptionPane;



public class ConexaoBanco {
    
    public Connection pegarConexao(){
        
        try{
          return DriverManager.getConnection("jdbc:mysql://localhost/sistemavendasdb","root","");
        }catch(Exception e){
          JOptionPane.showMessageDialog(null,"erro"+e);
        }
        return null;
    }
    
}
