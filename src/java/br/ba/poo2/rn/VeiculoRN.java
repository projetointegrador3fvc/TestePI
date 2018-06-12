/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ba.poo2.rn;

import br.ba.poo2.dao.VeiculoListenerDAO;
import br.ba.poo2.mapeamento.Veiculo;
import br.ba.poo2.util.FabricaDAO;
import java.util.List;

/**
 *
 * @author Ramon
 */
public class VeiculoRN {
        private VeiculoListenerDAO veiculoDao;
    public VeiculoRN() {
        this.veiculoDao = FabricaDAO.VeiculoAlunoDAO();
    }
    public void alterar(Veiculo vei){
        this.veiculoDao.alterar(vei);
    }

    public Veiculo consultarVei(String placa){
        return this.veiculoDao.consultarVei(placa);
    }
    public void excluir(Veiculo vei){
        this.veiculoDao.excluir(vei);
    }


    public void salvar(Veiculo vei){
        this.veiculoDao.salvar(vei);
    }

    public List<Veiculo> listarSemFiltro() {
        return this.veiculoDao.listarSemFiltro();
    }

}
