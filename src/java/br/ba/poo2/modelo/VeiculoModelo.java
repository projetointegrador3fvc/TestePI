/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ba.poo2.modelo;

import br.ba.poo2.mapeamento.Veiculo;
import java.util.List;
import javax.faces.model.ListDataModel;
import org.primefaces.model.SelectableDataModel;

/**
 *
 * @author Ramon
 */
  public class VeiculoModelo extends ListDataModel<Veiculo>
implements SelectableDataModel<Veiculo>{
    public VeiculoModelo() {   }
    public VeiculoModelo(List<Veiculo> list) {
        super(list);
    }
    @Override
    public Object getRowKey(Veiculo a) {
        return a.getIdVeiculo();
    }
    @Override
    public Veiculo getRowData(String string) {
        List<Veiculo> vls = (List<Veiculo>) getWrappedData();
        for(Veiculo vl : vls) {
            if(String.valueOf(vl.getIdVeiculo()).equals(string)) return vl;
        }
        return null;
    }
} 
