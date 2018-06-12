/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ba.poo2.dao;

import br.ba.poo2.mapeamento.Passagem;
import java.util.Date;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author Camila
 */
public interface PassagemListenerDAO {

    void alterar(Passagem pas);

    Passagem consultarId(int idpassagem);

    Passagem consultarPoltrona(int poltrona);

    void excluir(Passagem pas);

    void salvar(Passagem pas);

    void setSessao(Session sessao);
   Passagem consultarPassagemId (String idPassagem);
   
   Passagem consultarPassagemPoltrona (int poltrona);
   Passagem faturamento(Date inicio, Date fim);
    public List<Passagem> listarSemFiltro();
    
}
