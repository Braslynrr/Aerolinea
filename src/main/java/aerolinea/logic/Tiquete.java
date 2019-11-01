/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aerolinea.logic;

import java.io.Serializable;
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

/**
 *
 * @author Mario
 */
@Entity
@Table(name = "tiquete")
@NamedQueries({
    @NamedQuery(name = "Tiquete.findAll", query = "SELECT t FROM Tiquete t"),
    @NamedQuery(name = "Tiquete.findByCodigo", query = "SELECT t FROM Tiquete t WHERE t.codigo = :codigo"),
    @NamedQuery(name = "Tiquete.findByPersonaNombre", query = "SELECT t FROM Tiquete t WHERE t.personaNombre = :personaNombre")})
public class Tiquete implements Serializable {

    @Column(name = "Fila")
    private String fila;
    @Column(name = "Asiento")
    private String asiento;
    @JoinColumn(name = "Reserva", referencedColumnName = "Codigo")
    @ManyToOne(optional = false)
    private Reserva reserva;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Codigo")
    private Integer codigo;
    @Column(name = "PersonaNombre")
    private String personaNombre;
    @JoinColumn(name = "Reserva_Codigo", referencedColumnName = "Codigo")
    @ManyToOne(optional = false)
    private Reserva reservaCodigo;

    public Tiquete() {
    }

    public Tiquete(Integer codigo) {
        this.codigo = codigo;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getPersonaNombre() {
        return personaNombre;
    }

    public void setPersonaNombre(String personaNombre) {
        this.personaNombre = personaNombre;
    }

    public Reserva getReservaCodigo() {
        return reservaCodigo;
    }

    public void setReservaCodigo(Reserva reservaCodigo) {
        this.reservaCodigo = reservaCodigo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigo != null ? codigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tiquete)) {
            return false;
        }
        Tiquete other = (Tiquete) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "aerolinea.Tiquete[ codigo=" + codigo + " ]";
    }

    public String getFila() {
        return fila;
    }

    public void setFila(String fila) {
        this.fila = fila;
    }

    public String getAsiento() {
        return asiento;
    }

    public void setAsiento(String asiento) {
        this.asiento = asiento;
    }

    public Reserva getReserva() {
        return reserva;
    }

    public void setReserva(Reserva reserva) {
        this.reserva = reserva;
    }
    
}
