/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ba.poo2.modelo;

import br.ba.poo2.mapeamento.Passagem;
import java.util.List;
import javax.faces.model.ListDataModel;
import org.primefaces.model.SelectableDataModel;

/**
 *
 * @author Ramon
 */

  public class PassagemModelo extends ListDataModel<Passagem>
implements SelectableDataModel<Passagem>{
    public PassagemModelo() {   }
    public PassagemModelo(List<Passagem> list) {
        super(list);
    }
    @Override
    public Object getRowKey(Passagem a) {
        return a.getIdPassagem();
    }
    @Override
    public Passagem getRowData(String string) {
        List<Passagem> vls = (List<Passagem>) getWrappedData();
        for(Passagem vl : vls) {
            if(String.valueOf(vl.getIdPassagem()).equals(string)) return vl;
        }
        return null;
    }
}  

