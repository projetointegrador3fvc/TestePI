/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ba.poo2.mapeamento;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Ramon
 */
@Entity
@Table(name = "cidade")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cidade.findAll", query = "SELECT c FROM Cidade c")
    , @NamedQuery(name = "Cidade.findByIdTabelaCidade", query = "SELECT c FROM Cidade c WHERE c.idTabelaCidade = :idTabelaCidade")
    , @NamedQuery(name = "Cidade.findByNomeCidade", query = "SELECT c FROM Cidade c WHERE c.nomeCidade = :nomeCidade")
    , @NamedQuery(name = "Cidade.findByIdCidade", query = "SELECT c FROM Cidade c WHERE c.idCidade = :idCidade")
    , @NamedQuery(name = "Cidade.findByUf", query = "SELECT c FROM Cidade c WHERE c.uf = :uf")
    , @NamedQuery(name = "Cidade.findByCidadeOrigem", query = "SELECT c FROM Cidade c WHERE c.cidadeOrigem = :cidadeOrigem")
    , @NamedQuery(name = "Cidade.findByCidadeDestino", query = "SELECT c FROM Cidade c WHERE c.cidadeDestino = :cidadeDestino")})
public class Cidade implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_TabelaCidade")
    private Integer idTabelaCidade;
    @Size(max = 25)
    @Column(name = "nomeCidade")
    private String nomeCidade;
    @Size(max = 4)
    @Column(name = "idCidade")
    private String idCidade;
    @Size(max = 2)
    @Column(name = "uf")
    private String uf;
    @Size(max = 25)
    @Column(name = "cidadeOrigem")
    private String cidadeOrigem;
    @Size(max = 25)
    @Column(name = "cidadeDestino")
    private String cidadeDestino;
    @Column (name="valorAtribuido")
    private float valorAtribuido;
    public Cidade() {
    }

    public float getValorAtribuido() {
        return valorAtribuido;
    }

    public void setValorAtribuido(float valorAtribuido) {
        this.valorAtribuido = valorAtribuido;
    }
    
    public Cidade(Integer idTabelaCidade) {
        this.idTabelaCidade = idTabelaCidade;
    }

    public Integer getIdTabelaCidade() {
        return idTabelaCidade;
    }

    public void setIdTabelaCidade(Integer idTabelaCidade) {
        this.idTabelaCidade = idTabelaCidade;
    }

    public String getNomeCidade() {
        return nomeCidade;
    }

    public void setNomeCidade(String nomeCidade) {
        this.nomeCidade = nomeCidade;
    }

    public String getIdCidade() {
        return idCidade;
    }

    public void setIdCidade(String idCidade) {
        this.idCidade = idCidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getCidadeOrigem() {
        return cidadeOrigem;
    }

    public void setCidadeOrigem(String cidadeOrigem) {
        this.cidadeOrigem = cidadeOrigem;
    }

    public String getCidadeDestino() {
        return cidadeDestino;
    }

    public void setCidadeDestino(String cidadeDestino) {
        this.cidadeDestino = cidadeDestino;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTabelaCidade != null ? idTabelaCidade.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cidade)) {
            return false;
        }
        Cidade other = (Cidade) object;
        if ((this.idTabelaCidade == null && other.idTabelaCidade != null) || (this.idTabelaCidade != null && !this.idTabelaCidade.equals(other.idTabelaCidade))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.ba.poo2.mapeamento.Cidade[ idTabelaCidade=" + idTabelaCidade + " ]";
    }
    
}
