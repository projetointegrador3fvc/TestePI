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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Ramon
 */
@Entity
@Table(name = "veiculo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Veiculo.findAll", query = "SELECT v FROM Veiculo v")
    , @NamedQuery(name = "Veiculo.findByIdVeiculo", query = "SELECT v FROM Veiculo v WHERE v.idVeiculo = :idVeiculo")
    , @NamedQuery(name = "Veiculo.findByNumero", query = "SELECT v FROM Veiculo v WHERE v.numero = :numero")
    , @NamedQuery(name = "Veiculo.findByPlaca", query = "SELECT v FROM Veiculo v WHERE v.placa = :placa")
    , @NamedQuery(name = "Veiculo.findByMotorista", query = "SELECT v FROM Veiculo v WHERE v.motorista = :motorista")
    , @NamedQuery(name = "Veiculo.findByModelo", query = "SELECT v FROM Veiculo v WHERE v.modelo = :modelo")
    , @NamedQuery(name = "Veiculo.findByDataCompra", query = "SELECT v FROM Veiculo v WHERE v.dataCompra = :dataCompra")
    , @NamedQuery(name = "Veiculo.findByQtdPoltronas", query = "SELECT v FROM Veiculo v WHERE v.qtdPoltronas = :qtdPoltronas")})
public class Veiculo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idVeiculo")
    private Integer idVeiculo;
    @Size(max = 10)
    @Column(name = "numero")
    private String numero;
    @Size(max = 10)
    @Column(name = "placa")
    private String placa;
    @Size(max = 25)
    @Column(name = "motorista")
    private String motorista;
    @Size(max = 20)
    @Column(name = "modelo")
    private String modelo;
    @Column(name = "dataCompra")
    @Temporal(TemporalType.DATE)
    private Date dataCompra;
    @Column(name = "qtdPoltronas")
    private Integer qtdPoltronas;

    public Veiculo() {
    }

    public Veiculo(Integer idVeiculo) {
        this.idVeiculo = idVeiculo;
    }

    public Integer getIdVeiculo() {
        return idVeiculo;
    }

    public void setIdVeiculo(Integer idVeiculo) {
        this.idVeiculo = idVeiculo;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getMotorista() {
        return motorista;
    }

    public void setMotorista(String motorista) {
        this.motorista = motorista;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Date getDataCompra() {
        return dataCompra;
    }

    public void setDataCompra(Date dataCompra) {
        this.dataCompra = dataCompra;
    }

    public Integer getQtdPoltronas() {
        return qtdPoltronas;
    }

    public void setQtdPoltronas(Integer qtdPoltronas) {
        this.qtdPoltronas = qtdPoltronas;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idVeiculo != null ? idVeiculo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Veiculo)) {
            return false;
        }
        Veiculo other = (Veiculo) object;
        if ((this.idVeiculo == null && other.idVeiculo != null) || (this.idVeiculo != null && !this.idVeiculo.equals(other.idVeiculo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.ba.poo2.mapeamento.Veiculo[ idVeiculo=" + idVeiculo + " ]";
    }
    
}
