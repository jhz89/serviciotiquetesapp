/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Harold
 */
@Entity
@Table(name = "vehiculo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Vehiculo.findAll", query = "SELECT v FROM Vehiculo v"),
    @NamedQuery(name = "Vehiculo.findByPlaca", query = "SELECT v FROM Vehiculo v WHERE v.placa = :placa"),
    @NamedQuery(name = "Vehiculo.findByNumeroasientos", query = "SELECT v FROM Vehiculo v WHERE v.numeroasientos = :numeroasientos"),
    @NamedQuery(name = "Vehiculo.findByNitcooperativa", query = "SELECT v FROM Vehiculo v WHERE v.nitcooperativa = :nitcooperativa")})
public class Vehiculo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "placa")
    private String placa;
    @Basic(optional = false)
    @NotNull
    @Column(name = "numeroasientos")
    private short numeroasientos;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nitcooperativa")
    private String nitcooperativa;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "placavehiculo")
    private List<Ruta> rutaList;

    public Vehiculo() {
    }

    public Vehiculo(String placa) {
        this.placa = placa;
    }

    public Vehiculo(String placa, short numeroasientos, String nitcooperativa) {
        this.placa = placa;
        this.numeroasientos = numeroasientos;
        this.nitcooperativa = nitcooperativa;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public short getNumeroasientos() {
        return numeroasientos;
    }

    public void setNumeroasientos(short numeroasientos) {
        this.numeroasientos = numeroasientos;
    }

    public String getNitcooperativa() {
        return nitcooperativa;
    }

    public void setNitcooperativa(String nitcooperativa) {
        this.nitcooperativa = nitcooperativa;
    }

    @XmlTransient
    public List<Ruta> getRutaList() {
        return rutaList;
    }

    public void setRutaList(List<Ruta> rutaList) {
        this.rutaList = rutaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (placa != null ? placa.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Vehiculo)) {
            return false;
        }
        Vehiculo other = (Vehiculo) object;
        if ((this.placa == null && other.placa != null) || (this.placa != null && !this.placa.equals(other.placa))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Vehiculo[ placa=" + placa + " ]";
    }
    
}
