/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ba.poo2.mapeamento;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Ramon
 */
@Entity
@Table(name = "passagem")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Passagem.findAll", query = "SELECT p FROM Passagem p")
    , @NamedQuery(name = "Passagem.findByIdPassagem", query = "SELECT p FROM Passagem p WHERE p.idPassagem = :idPassagem")
    , @NamedQuery(name = "Passagem.findByIdVeiculo", query = "SELECT p FROM Passagem p WHERE p.idVeiculo = :idVeiculo")
    , @NamedQuery(name = "Passagem.findByPoltrona", query = "SELECT p FROM Passagem p WHERE p.poltrona = :poltrona")
    , @NamedQuery(name = "Passagem.findByDataSaida", query = "SELECT p FROM Passagem p WHERE p.dataSaida = :dataSaida")
    , @NamedQuery(name = "Passagem.findByDataVolta", query = "SELECT p FROM Passagem p WHERE p.dataVolta = :dataVolta")
    , @NamedQuery(name = "Passagem.findByHoraSaida", query = "SELECT p FROM Passagem p WHERE p.horaSaida = :horaSaida")
    , @NamedQuery(name = "Passagem.findByCidadeOrigem", query = "SELECT p FROM Passagem p WHERE p.cidadeOrigem = :cidadeOrigem")
    , @NamedQuery(name = "Passagem.findByCidadeDestino", query = "SELECT p FROM Passagem p WHERE p.cidadeDestino = :cidadeDestino")
    , @NamedQuery(name = "Passagem.findByValorPassagem", query = "SELECT p FROM Passagem p WHERE p.valorPassagem = :valorPassagem")})
public class Passagem implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idPassagem")
    private Integer idPassagem;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idVeiculo")
    private int idVeiculo;
    @Column(name = "poltrona")
    private Integer poltrona;
    @Column(name = "dataSaida")
    @Temporal(TemporalType.DATE)
    private Date dataSaida;
    @Column(name = "dataVolta")
    @Temporal(TemporalType.DATE)
    private Date dataVolta;
    @Size(max = 10)
    @Column(name = "horaSaida")
    private String horaSaida;
    @Size(max = 25)
    @Column(name = "cidadeOrigem")
    private String cidadeOrigem;
    @Size(max = 25)
    @Column(name = "cidadeDestino")
    private String cidadeDestino;
    @Column(name = "valorPassagem")
    private Long valorPassagem;

    public Passagem() {
    }

    public Passagem(Integer idPassagem) {
        this.idPassagem = idPassagem;
    }

    public Passagem(Integer idPassagem, int idVeiculo) {
        this.idPassagem = idPassagem;
        this.idVeiculo = idVeiculo;
    }

    public Integer getIdPassagem() {
        return idPassagem;
    }

    public void setIdPassagem(Integer idPassagem) {
        this.idPassagem = idPassagem;
    }

    public int getIdVeiculo() {
        return idVeiculo;
    }

    public void setIdVeiculo(int idVeiculo) {
        this.idVeiculo = idVeiculo;
    }

    public Integer getPoltrona() {
        return poltrona;
    }

    public void setPoltrona(Integer poltrona) {
        this.poltrona = poltrona;
    }

    public Date getDataSaida() {
        return dataSaida;
    }

    public void setDataSaida(Date dataSaida) {
        this.dataSaida = dataSaida;
    }

    public Date getDataVolta() {
        return dataVolta;
    }

    public void setDataVolta(Date dataVolta) {
        this.dataVolta = dataVolta;
    }

    public String getHoraSaida() {
        return horaSaida;
    }

    public void setHoraSaida(String horaSaida) {
        this.horaSaida = horaSaida;
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

    public Long getValorPassagem() {
        return valorPassagem;
    }

    public void setValorPassagem(Long valorPassagem) {
        this.valorPassagem = valorPassagem;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPassagem != null ? idPassagem.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Passagem)) {
            return false;
        }
        Passagem other = (Passagem) object;
        if ((this.idPassagem == null && other.idPassagem != null) || (this.idPassagem != null && !this.idPassagem.equals(other.idPassagem))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.ba.poo2.mapeamento.Passagem[ idPassagem=" + idPassagem + " ]";
    }
    
}
