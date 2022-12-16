/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projeto.model;

/**
 *
 * @author Leandro
 */
public class Fornecedor extends Cliente {

// É responsavel por converter o objecto Fornecedor devolvendo o nome;
// para apareçer no JComboBox;
   @Override
   public String toString(){
       return this.getNome();
   }
    
    
}
