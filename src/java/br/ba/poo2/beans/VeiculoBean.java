/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ba.poo2.beans;

import br.ba.poo2.mapeamento.Veiculo;
import br.ba.poo2.modelo.VeiculoModelo;
import br.ba.poo2.rn.VeiculoRN;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import org.primefaces.context.RequestContext;
import org.primefaces.model.StreamedContent;

@ManagedBean(name = "veiculoBean")
@SessionScoped
public class VeiculoBean implements Serializable {
  VeiculoRN veiculoRN;
    
    
    private Veiculo veiculoSelecionado;
    private List<Veiculo> veiculos;
    private Veiculo veiculo;
    private VeiculoModelo modelo;
    
    private StreamedContent arquivoRetorno;
    private int tipoRelatorio;
    
    public void popularDataTable(){
        veiculoRN = new VeiculoRN();
        this.veiculos = veiculoRN.listarSemFiltro();
        modelo = new VeiculoModelo(veiculos);
    }
    
    public List<SelectItem> idVeiculoList(){       
    final List<SelectItem> listaComboBoxFunc2 = new ArrayList<SelectItem>(0);
        for (int i = 1; i <= veiculos.size(); i++) {
            SelectItem item = new SelectItem();
            item.setLabel(veiculos.get(i-1).getModelo());
            item.setValue(veiculos.get(i-1).getIdVeiculo());
            listaComboBoxFunc2.add(item);
        }
      return listaComboBoxFunc2;
}
    public VeiculoBean() {
        veiculo = new Veiculo();
        popularDataTable();
    }

    public Veiculo getVeiculoSelecionado() {
        return veiculoSelecionado;
    }

    public void setAlunoSelecionado(Veiculo veiculoSelecionado) {
        this.veiculoSelecionado = veiculoSelecionado;
    }

    public List<Veiculo> getVeiculos() {
        return veiculos;
    }

    public void setVeiculos(List<Veiculo> veiculos) {
        this.veiculos = veiculos;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setAluno(Veiculo veiculo) {
        this.veiculo = veiculo;
    }
    
    public VeiculoModelo getModelo() {
        return modelo;
    }

    public void setModelo(VeiculoModelo modelo) {
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
    
    
    public void salvar(){
        try {
              if (veiculos.contains(veiculo)){
              this.veiculoSelecionado = veiculo;
              alterar();
              veiculo = new Veiculo();
            } else{
            veiculoRN = new VeiculoRN();
            veiculoRN.salvar(veiculo);
            this.veiculos = veiculoRN.listarSemFiltro();
            veiculo = new Veiculo();
            FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_INFO, "Inclusão", "Veiculo incluído com Sucesso!");
            FacesContext.getCurrentInstance().addMessage(null, facesMessage);   
              }
          
        } catch (Exception e) {
            FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Falha", "Ocorreu um erro na inclusão!");
            FacesContext.getCurrentInstance().addMessage(null, facesMessage);
        }
    }
    public void alterar(){
        veiculoRN = new VeiculoRN();
        veiculoRN.alterar(veiculoSelecionado);
        this.veiculos = veiculoRN.listarSemFiltro();
        FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_INFO, "Alteração", "Veiculo alterado com Sucesso!");
        FacesContext.getCurrentInstance().addMessage(null, facesMessage);
    }
    public void excluir(){
        veiculoRN = new VeiculoRN();
        veiculoRN.excluir(veiculoSelecionado);
        this.veiculos = veiculoRN.listarSemFiltro();
        FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_INFO, "Exclusão", "Veiculo excluído com Sucesso!");
        FacesContext.getCurrentInstance().addMessage(null, facesMessage);
    }
    


    public int getTipoRelatorio() {
        return tipoRelatorio;
    }

    public void setTipoRelatorio(int tipoRelatorio) {
        this.tipoRelatorio = tipoRelatorio;
    }
    
    public String editarVeiculo(Veiculo veiculo){
        this.veiculo = veiculo;
        return "CadastroVeiculo";
    }
    public void excluirVeiculo (Veiculo veiculo) {
    this.veiculoSelecionado = veiculo;
    excluir();
    }
}
