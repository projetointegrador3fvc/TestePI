/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ba.poo2.dao;


import br.ba.poo2.mapeamento.Passagem;
import java.util.Date;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Camila
 */
public class PassagemDAO implements PassagemListenerDAO {
    private Session sessao;
    @Override
    public void setSessao(Session sessao) {
        this.sessao = sessao;
    }
    @Override
    public void salvar(Passagem pas) {
    this.sessao.save(pas);
    }
    @Override
    public void alterar(Passagem pas) {
    this.sessao.update(pas);
    }
    @Override
    public void excluir(Passagem pas) {
    this.sessao.delete(pas);
    }
    
    @Override
    public Passagem consultarId(int idpassagem) {
        return (Passagem) this.sessao.get(Passagem.class,idpassagem);
    }
    @Override 
       public Passagem consultarPoltrona(int poltrona) {
    return (Passagem) this.sessao.get(Passagem.class,poltrona);
    }
       @Override
       public Passagem consultarPassagemId (String idPassagem) {
    String cpi = "Select idPassagem from Passagem;";
    Query cons = this.sessao.createQuery(cpi);
    cons.setString("idPassagem", idPassagem);
    return (Passagem) cons.uniqueResult();
    }
       @Override
       public Passagem consultarPassagemPoltrona (int poltrona) {
    String cpi = "Select poltrona from Passagem;";
    Query cons = this.sessao.createQuery(cpi);
    cons.setInteger("poltrona", poltrona);
    return (Passagem) cons.uniqueResult();
    }
       @Override
    public List<Passagem> listarSemFiltro(){
        return this.sessao.createCriteria(Passagem.class).list();
    }

    @Override
    public Passagem faturamento(Date inicio, Date fim) {
        String cpi = "Select SUM(valorPassagem) from passagem where dataSaida > '"+inicio+"' "
                + "and dataSaida < '"+fim+"' ";        
        Query cons = this.sessao.createQuery(cpi);
        
        return (Passagem) cons.uniqueResult();        
    }
    }

