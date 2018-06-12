/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ba.poo2.modelo;


import br.ba.poo2.mapeamento.Cidade;
import java.util.List;
import javax.faces.model.ListDataModel;
import org.primefaces.model.SelectableDataModel;

public class CidadeModelo extends ListDataModel<Cidade>
implements SelectableDataModel<Cidade>{
    public CidadeModelo() {   }
    public CidadeModelo(List<Cidade> list) {
        super(list);
    }
    @Override
    public Object getRowKey(Cidade a) {
        return a.getIdCidade();
    }
    @Override
    public Cidade getRowData(String string) {
        List<Cidade> vls = (List<Cidade>) getWrappedData();
        for(Cidade vl : vls) {
            if(String.valueOf(vl.getIdCidade()).equals(string)) return vl;
        }
        return null;
    }
}
