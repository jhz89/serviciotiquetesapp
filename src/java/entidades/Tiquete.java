/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Harold
 */
@Entity
@Table(name = "tiquete")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tiquete.findAll", query = "SELECT t FROM Tiquete t"),
    @NamedQuery(name = "Tiquete.findByIdtiquete", query = "SELECT t FROM Tiquete t WHERE t.idtiquete = :idtiquete"),
    @NamedQuery(name = "Tiquete.findByFechareserva", query = "SELECT t FROM Tiquete t WHERE t.fechareserva = :fechareserva"),
    @NamedQuery(name = "Tiquete.findByFechaCompra", query = "SELECT t FROM Tiquete t WHERE t.fechaCompra = :fechaCompra")})
public class Tiquete implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idtiquete")
    private Integer idtiquete;
    @Column(name = "fechareserva")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechareserva;
    @Column(name = "fecha_compra")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCompra;
    @JoinColumn(name = "idruta", referencedColumnName = "idruta")
    @ManyToOne(optional = false)
    private Ruta idruta;
    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario")
    @ManyToOne
    private Usuario idUsuario;
    @JoinColumn(name = "idviajero", referencedColumnName = "cedula")
    @ManyToOne(optional = false)
    private Viajero idviajero;

    public Tiquete() {
    }

    public Tiquete(Integer idtiquete) {
        this.idtiquete = idtiquete;
    }

    public Integer getIdtiquete() {
        return idtiquete;
    }

    public void setIdtiquete(Integer idtiquete) {
        this.idtiquete = idtiquete;
    }

    public Date getFechareserva() {
        return fechareserva;
    }

    public void setFechareserva(Date fechareserva) {
        this.fechareserva = fechareserva;
    }

    public Date getFechaCompra() {
        return fechaCompra;
    }

    public void setFechaCompra(Date fechaCompra) {
        this.fechaCompra = fechaCompra;
    }

    public Ruta getIdruta() {
        return idruta;
    }

    public void setIdruta(Ruta idruta) {
        this.idruta = idruta;
    }

    public Usuario getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuario idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Viajero getIdviajero() {
        return idviajero;
    }

    public void setIdviajero(Viajero idviajero) {
        this.idviajero = idviajero;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idtiquete != null ? idtiquete.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tiquete)) {
            return false;
        }
        Tiquete other = (Tiquete) object;
        if ((this.idtiquete == null && other.idtiquete != null) || (this.idtiquete != null && !this.idtiquete.equals(other.idtiquete))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Tiquete[ idtiquete=" + idtiquete + " ]";
    }
    
}
