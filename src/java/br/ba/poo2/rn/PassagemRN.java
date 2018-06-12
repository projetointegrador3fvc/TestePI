/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ba.poo2.rn;

import br.ba.poo2.dao.PassagemListenerDAO;
import br.ba.poo2.mapeamento.Passagem;
import br.ba.poo2.util.FabricaDAO;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Ramon
 */
public class PassagemRN {
    private PassagemListenerDAO passagemDao;
      public PassagemRN() {
        this.passagemDao = FabricaDAO.criarPassagemDAO();
    }
    public void alterar(Passagem pas){
        this.passagemDao.alterar(pas);
    }

    public Passagem consultarId(int idPassagem){
        return this.passagemDao.consultarId(idPassagem);
    }
    public Passagem consultarPoltrona(int poltrona){
        return this.passagemDao.consultarId(poltrona);
    }
    public void excluir(Passagem pas){
        this.passagemDao.excluir(pas);
    }

    public List<Passagem> listarSemFiltro() {
        return this.passagemDao.listarSemFiltro();
    }

    public void salvar(Passagem pas) {          
        this.passagemDao.salvar(pas);
    }
    public Passagem faturamento(Date inicio, Date fim){
        return this.passagemDao.faturamento(inicio, fim);
    }
}
