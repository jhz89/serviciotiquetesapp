/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Harold
 */
@Entity
@Table(name = "ruta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ruta.findAll", query = "SELECT r FROM Ruta r"),
    @NamedQuery(name = "Ruta.findByIdruta", query = "SELECT r FROM Ruta r WHERE r.idruta = :idruta"),
    @NamedQuery(name = "Ruta.findByDestino", query = "SELECT r FROM Ruta r WHERE r.destino = :destino"),
    @NamedQuery(name = "Ruta.findByFechasalida", query = "SELECT r FROM Ruta r WHERE r.fechasalida = :fechasalida"),
    @NamedQuery(name = "Ruta.findByValor", query = "SELECT r FROM Ruta r WHERE r.valor = :valor"),
    @NamedQuery(name = "Ruta.findByCantidadasientos", query = "SELECT r FROM Ruta r WHERE r.cantidadasientos = :cantidadasientos"),
    @NamedQuery(name = "Ruta.findByOrigen", query = "SELECT r FROM Ruta r WHERE r.origen = :origen")})
public class Ruta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idruta")
    private Integer idruta;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "destino")
    private String destino;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechasalida")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechasalida;
    @Basic(optional = false)
    @NotNull
    @Column(name = "valor")
    private int valor;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cantidadasientos")
    private int cantidadasientos;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "origen")
    private String origen;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idruta")
    private List<Tiquete> tiqueteList;
    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario")
    @ManyToOne
    private Usuario idUsuario;
    @JoinColumn(name = "placavehiculo", referencedColumnName = "placa")
    @ManyToOne(optional = false)
    private Vehiculo placavehiculo;

    public Ruta() {
    }

    public Ruta(Integer idruta) {
        this.idruta = idruta;
    }

    public Ruta(Integer idruta, String destino, Date fechasalida, int valor, int cantidadasientos, String origen) {
        this.idruta = idruta;
        this.destino = destino;
        this.fechasalida = fechasalida;
        this.valor = valor;
        this.cantidadasientos = cantidadasientos;
        this.origen = origen;
    }

    public Integer getIdruta() {
        return idruta;
    }

    public void setIdruta(Integer idruta) {
        this.idruta = idruta;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public Date getFechasalida() {
        return fechasalida;
    }

    public void setFechasalida(Date fechasalida) {
        this.fechasalida = fechasalida;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public int getCantidadasientos() {
        return cantidadasientos;
    }

    public void setCantidadasientos(int cantidadasientos) {
        this.cantidadasientos = cantidadasientos;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    @XmlTransient
    public List<Tiquete> getTiqueteList() {
        return tiqueteList;
    }

    public void setTiqueteList(List<Tiquete> tiqueteList) {
        this.tiqueteList = tiqueteList;
    }

    public Usuario getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuario idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Vehiculo getPlacavehiculo() {
        return placavehiculo;
    }

    public void setPlacavehiculo(Vehiculo placavehiculo) {
        this.placavehiculo = placavehiculo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idruta != null ? idruta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ruta)) {
            return false;
        }
        Ruta other = (Ruta) object;
        if ((this.idruta == null && other.idruta != null) || (this.idruta != null && !this.idruta.equals(other.idruta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Ruta[ idruta=" + idruta + " ]";
    }
    
}
