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
public interface VeiculoListenerDAO {

    void alterar(Veiculo vei);

    Veiculo consultarVei(String placa);

    void excluir(Veiculo vei);

    void salvar(Veiculo vei);

    void setSessao(Session sessao);

    public List<Veiculo> listarSemFiltro();
    
}
