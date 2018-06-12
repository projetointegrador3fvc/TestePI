/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ba.poo2.dao;

import br.ba.poo2.mapeamento.Usuario;
import java.util.List;
import org.hibernate.Query;

import org.hibernate.Session;

/**
 *
 * @author Camila
 */
public class UsuarioDAO implements UsuarioListenerDAO {
    private Session sessao;
    @Override
    public void setSessao(Session sessao) {
        this.sessao = sessao;
    }
    @Override
    public void salvar(Usuario usu){
        this.sessao.save(usu);
    }
    @Override
    public void alterar(Usuario usu){
        this.sessao.update(usu);
    }
    @Override
    public void excluir(Usuario usu){
        this.sessao.delete(usu);
    }
       @Override
    public List<Usuario> listarSemFiltro(){
        return this.sessao.createCriteria(Usuario.class).list();
    }
    @Override
    public Usuario consultar(String email){
        return (Usuario) this.sessao.get(Usuario.class,email);
    }
    @Override 
    public Usuario consultarporEmail (String email) {
    String cpe = "Select email from Usuario;";
    Query cons = this.sessao.createQuery(cpe);
    cons.setString("Email", email);
    return (Usuario) cons.uniqueResult();
    }
    
}
