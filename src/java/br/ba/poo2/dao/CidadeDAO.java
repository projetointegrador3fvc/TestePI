/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ba.poo2.dao;

import br.ba.poo2.mapeamento.Cidade;
import java.util.List;
import org.hibernate.Query;

import org.hibernate.Session;

/**
 *
 * @author Camila
 */
public class CidadeDAO implements CidadeListenerDAO {
    private Session sessao;
    @Override
    public void setSessao(Session sessao) {
        this.sessao = sessao;
    }
     @Override
    public void salvar(Cidade ci){
        this.sessao.save(ci);
    }
     @Override
    public void alterar(Cidade ci){
        this.sessao.update(ci);
    }
     @Override
    public void excluir(Cidade ci){
        this.sessao.delete(ci);
    }
     @Override
    public Cidade consultar(String nomeCidade){
        return (Cidade) this.sessao.get(Cidade.class,nomeCidade);
    }
    
    public Cidade consultarCidadeNome (String nomeCidade) {
    String ccn = "Select nomeCidade from Cidade;";
    Query cons = this.sessao.createQuery(ccn);
    cons.setString("nomeC", nomeCidade);
    return (Cidade) cons.uniqueResult();
    }
    
    @Override
    public List<Cidade> listarSemFiltro(){
        return this.sessao.createCriteria(Cidade.class).list();
    }
     
}
