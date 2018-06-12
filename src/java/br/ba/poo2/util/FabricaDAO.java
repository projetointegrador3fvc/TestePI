/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ba.poo2.util;

//import br.ba.poo2.dao.AlunoDAO;
//import br.ba.poo2.dao.AlunoDAOListener;
import br.ba.poo2.dao.CidadeDAO;
import br.ba.poo2.dao.CidadeListenerDAO;
import br.ba.poo2.dao.PassagemDAO;
import br.ba.poo2.dao.PassagemListenerDAO;
import br.ba.poo2.dao.UsuarioDAO;
import br.ba.poo2.dao.UsuarioListenerDAO;
import br.ba.poo2.dao.VeiculoDAO;
import br.ba.poo2.dao.VeiculoListenerDAO;

/**
 *
 * @author Camila 
 */
public class FabricaDAO {
/*
    public static AlunoDAOListener criarAlunoDAO(){
        AlunoDAO alunoDAO = new AlunoDAO();
        alunoDAO.setSessao(HibernateUtil.getSessionFactory().getCurrentSession());
        return alunoDAO;
    }
*/
     public static CidadeListenerDAO criarCidadeDAO(){
        CidadeDAO cidadeDAO = new CidadeDAO();
        cidadeDAO.setSessao(HibernateUtil.getSessionFactory().getCurrentSession());
        return cidadeDAO;
    }
      public static PassagemListenerDAO criarPassagemDAO(){
        PassagemDAO passagemDAO = new PassagemDAO();
        passagemDAO.setSessao(HibernateUtil.getSessionFactory().getCurrentSession());
        return passagemDAO;
    }
      public static UsuarioListenerDAO criarUsuarioDAO(){
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        usuarioDAO.setSessao(HibernateUtil.getSessionFactory().getCurrentSession());
        return usuarioDAO;
    }
      public static VeiculoListenerDAO VeiculoAlunoDAO(){
        VeiculoDAO veiculoDAO = new VeiculoDAO();
        veiculoDAO.setSessao(HibernateUtil.getSessionFactory().getCurrentSession());
        return veiculoDAO;
    }
}
