/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ba.poo2.rn;

import br.ba.poo2.mapeamento.Cidade;
import br.ba.poo2.util.FabricaDAO;
import java.util.List;
import br.ba.poo2.dao.CidadeListenerDAO;
      

public class CidadeRN {    
    private CidadeListenerDAO cidadeDao;
    public CidadeRN() {
        this.cidadeDao = FabricaDAO.criarCidadeDAO();
    }
    public void alterar(Cidade ci){
        this.cidadeDao.alterar(ci);
    }

   // public Cidade consultar(String idCidade){
    //    return this.cidadeDao.consultar(idCidade);
   // }
    public void excluir(Cidade ci){
        this.cidadeDao.excluir(ci);
    }
      public List<Cidade> listarSemFiltro(){
        return this.cidadeDao.listarSemFiltro();
    }

    public void salvar(Cidade ci){
        this.cidadeDao.salvar(ci);
    }

}
