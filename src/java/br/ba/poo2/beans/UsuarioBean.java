/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ba.poo2.beans;


import br.ba.poo2.mapeamento.Usuario;
//import br.ba.poo2.modelo.AlunoModelo;
import br.ba.poo2.modelo.UsuarioModelo;
import br.ba.poo2.rn.UsuarioRN;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletResponse;
import org.primefaces.context.RequestContext;


@ManagedBean(name ="usuarioBean")
@SessionScoped

public class UsuarioBean implements Serializable {
   private String nome; 
   private String cargo;
   private String login;
   private String senha;
   private String email;

    public void Autenticar() throws IOException{         
        for (int i = 0; i < this.usuarios.size(); i++) {
            Usuario aux = new Usuario();
          aux = usuarios.listIterator().next();
          if(usuario.getLogin().equalsIgnoreCase(aux.getLogin())){
              if(usuario.getSenha().equalsIgnoreCase(aux.getSenha())){
                   FacesContext.getCurrentInstance().addMessage("", new FacesMessage("Logado com Sucesso!", "Logado com Sucesso!"));
                   FacesContext.getCurrentInstance().getExternalContext().redirect("index.POOII");
              }else{
                 FacesContext.getCurrentInstance().addMessage("", new FacesMessage(FacesMessage.SEVERITY_ERROR,"Login ou Senha Errada!", "Login ou Senha Errada!")); 
              }
          }else{
            FacesContext.getCurrentInstance().addMessage("", new FacesMessage(FacesMessage.SEVERITY_ERROR,"Login ou Senha Errada!", "Login ou Senha Errada!"));  
          }
          
        }
}
      UsuarioRN usuarioRN;
    
    
    private Usuario usuarioSelecionado;
    private List<Usuario> usuarios;
    private Usuario usuario;
    private UsuarioModelo modelo;
    
   
    private int tipoRelatorio;
    
    public void popularDataTable(){
        usuarioRN = new UsuarioRN();
        this.usuarios = usuarioRN.listarSemFiltro();
        modelo = new UsuarioModelo(usuarios);
    }
    
    public UsuarioBean() {
        usuario = new Usuario();
        popularDataTable();
    }

    public Usuario getUsuarioSelecionado() {
        return usuarioSelecionado;
    }

    public void setUsuarioSelecionado(Usuario usuarioSelecionado) {
        this.usuarioSelecionado = usuarioSelecionado;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    public UsuarioModelo getModelo() {
        return modelo;
    }

    public void setModelo(UsuarioModelo modelo) {
        this.modelo = modelo;
    }
    
    public void abrirDialog(){
        RequestContext requestContext = RequestContext.getCurrentInstance();
        requestContext.execute("PF('wdgdlgAl').show()");
        //requestContext.execute("PF('wdgdlgAl').show()"); no prime 5
    }
    public void abrirDialogAlt(){
        RequestContext requestContext = RequestContext.getCurrentInstance();
        requestContext.execute("PF('wdgdlgAlalt').show()");
    }
    
    public String editarUsuario(Usuario usuario){
        this.usuario = usuario;
        return "Cadastro";
    }
    public void excluirUsuario (Usuario usuario) {
    this.usuario = usuario;
    excluir();
    }
    public void salvar(){
        try {
            usuarioRN = new UsuarioRN();
            usuarioRN.salvar(usuario);
            this.usuarios = usuarioRN.listarSemFiltro();
            usuario = new Usuario();
            FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_INFO, "Inclusão", "Usuario incluído com Sucesso!");
            FacesContext.getCurrentInstance().addMessage(null, facesMessage);
        } catch (Exception e) {
            FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Falha", "Ocorreu um erro na inclusão!");
            FacesContext.getCurrentInstance().addMessage(null, facesMessage);
        }
    }
    public void alterar(){
        usuarioRN = new UsuarioRN();
        usuarioRN.alterar(usuarioSelecionado);
        this.usuarios = usuarioRN.listarSemFiltro();
        FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_INFO, "Alteração", "Usuario alterado com Sucesso!");
        FacesContext.getCurrentInstance().addMessage(null, facesMessage);
    }
    public void excluir(){
        usuarioRN = new UsuarioRN();
        usuarioRN.excluir(usuarioSelecionado);
        this.usuarios = usuarioRN.listarSemFiltro();
        FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_INFO, "Exclusão", "Usuario excluído com Sucesso!");
        FacesContext.getCurrentInstance().addMessage(null, facesMessage);
    }
    


    public int getTipoRelatorio() {
        return tipoRelatorio;
    }

    public void setTipoRelatorio(int tipoRelatorio) {
        this.tipoRelatorio = tipoRelatorio;
    }
    

}
    

