/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ba.poo2.dao;

import br.ba.poo2.mapeamento.Usuario;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author Camila
 */
public interface UsuarioListenerDAO {

    void alterar(Usuario usu);

    Usuario consultar(String email);

    void excluir(Usuario usu);

    void salvar(Usuario usu);

    void setSessao(Session sessao);
    Usuario consultarporEmail (String email);

    public List<Usuario> listarSemFiltro();
    
}
