/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ba.poo2.dao;

import br.ba.poo2.mapeamento.Veiculo;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author Camila
 */
public class VeiculoDAO implements VeiculoListenerDAO {
    private Session sessao;
    @Override
    public void setSessao(Session sessao) {
        this.sessao = sessao;
    }
    @Override
    public void salvar (Veiculo vei) {
    this.sessao.save(vei);
    }
    @Override
    public void alterar (Veiculo vei) {
    this.sessao.update(vei);
    }
    @Override
    public void excluir (Veiculo vei) {
    this.sessao.delete(vei);
    }
    @Override 
    public Veiculo consultarVei(String placa) {
    return (Veiculo) this.sessao.get(Veiculo.class,placa);
    }
       @Override
    public List<Veiculo> listarSemFiltro(){
        return this.sessao.createCriteria(Veiculo.class).list();
    }
}
