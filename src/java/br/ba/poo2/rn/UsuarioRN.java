/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ba.poo2.rn;

import br.ba.poo2.dao.UsuarioListenerDAO;
import br.ba.poo2.mapeamento.Usuario;
import br.ba.poo2.util.FabricaDAO;
import java.util.List;

/**
 *
 * @author Ramon
 */
public class UsuarioRN {
        private UsuarioListenerDAO usuarioDao;
    public UsuarioRN() {
        this.usuarioDao = FabricaDAO.criarUsuarioDAO();
    }
    public void alterar(Usuario usu){
        this.usuarioDao.alterar(usu);
    }

    public Usuario consultar(String idCidade){
        return this.usuarioDao.consultar(idCidade);
    }
    public void excluir(Usuario usu){
        this.usuarioDao.excluir(usu);
    }
   public List<Usuario> listarSemFiltro(){
        return this.usuarioDao.listarSemFiltro();
    }
    public void salvar(Usuario usu){
        this.usuarioDao.salvar(usu);
    }

}

