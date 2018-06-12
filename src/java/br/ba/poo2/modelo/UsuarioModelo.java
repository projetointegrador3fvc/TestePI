/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ba.poo2.modelo;

import br.ba.poo2.mapeamento.Usuario;
import java.util.List;
import javax.faces.model.ListDataModel;
import org.primefaces.model.SelectableDataModel;

/**
 *
 * @author Ramon
 */

public class UsuarioModelo extends ListDataModel<Usuario>
implements SelectableDataModel<Usuario>{
    public UsuarioModelo() {   }
    public UsuarioModelo(List<Usuario> list) {
        super(list);
    }
    @Override
    public Object getRowKey(Usuario a) {
        return a.getIdUsuario();
    }
    @Override
    public Usuario getRowData(String string) {
        List<Usuario> vls = (List<Usuario>) getWrappedData();
        for(Usuario vl : vls) {
            if(String.valueOf(vl.getIdUsuario()).equals(string)) return vl;
        }
        return null;
    }
}

