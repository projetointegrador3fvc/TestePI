/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ba.poo2.dao;

import br.ba.poo2.mapeamento.Cidade;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author Camila
 */
public interface CidadeListenerDAO {

    void alterar(Cidade ci);

    Cidade consultar(String nomeCidade);

    void excluir(Cidade ci);

    void salvar(Cidade ci);

    void setSessao(Session sessao);
    List<Cidade> listarSemFiltro();
    
}
