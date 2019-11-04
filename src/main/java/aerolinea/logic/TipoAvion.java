/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aerolinea.logic;

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

/**
 *
 * @author Admin2
 */
@Entity
@Table(name = "tipo_avion")
@NamedQueries({
    @NamedQuery(name = "TipoAvion.findAll", query = "SELECT t FROM TipoAvion t"),
    @NamedQuery(name = "TipoAvion.findByIdentificador", query = "SELECT t FROM TipoAvion t WHERE t.identificador = :identificador"),
    @NamedQuery(name = "TipoAvion.findByA\u00f1o", query = "SELECT t FROM TipoAvion t WHERE t.a\u00f1o = :a\u00f1o"),
    @NamedQuery(name = "TipoAvion.findByModelo", query = "SELECT t FROM TipoAvion t WHERE t.modelo = :modelo"),
    @NamedQuery(name = "TipoAvion.findByMarca", query = "SELECT t FROM TipoAvion t WHERE t.marca = :marca"),
    @NamedQuery(name = "TipoAvion.findByAsientos", query = "SELECT t FROM TipoAvion t WHERE t.asientos = :asientos"),
    @NamedQuery(name = "TipoAvion.findByFilas", query = "SELECT t FROM TipoAvion t WHERE t.filas = :filas")})
public class TipoAvion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "Identificador")
    private String identificador;
    @Basic(optional = false)
    @Column(name = "A\u00f1o")
    private String año;
    @Basic(optional = false)
    @Column(name = "Modelo")
    private String modelo;
    @Basic(optional = false)
    @Column(name = "Marca")
    private String marca;
    @Basic(optional = false)
    @Column(name = "Asientos")
    private int asientos;
    @Basic(optional = false)
    @Column(name = "Filas")
    private int filas;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoA")
    private List<Avion> avionList;

    public TipoAvion() {
    }

    public TipoAvion(String identificador) {
        this.identificador = identificador;
    }

    public TipoAvion(String identificador, String año, String modelo, String marca, int asientos, int filas) {
        this.identificador = identificador;
        this.año = año;
        this.modelo = modelo;
        this.marca = marca;
        this.asientos = asientos;
        this.filas = filas;
    }

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public String getAño() {
        return año;
    }

    public void setAño(String año) {
        this.año = año;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getAsientos() {
        return asientos;
    }

    public void setAsientos(int asientos) {
        this.asientos = asientos;
    }

    public int getFilas() {
        return filas;
    }

    public void setFilas(int filas) {
        this.filas = filas;
    }

    public List<Avion> getAvionList() {
        return avionList;
    }

    public void setAvionList(List<Avion> avionList) {
        this.avionList = avionList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (identificador != null ? identificador.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoAvion)) {
            return false;
        }
        TipoAvion other = (TipoAvion) object;
        if ((this.identificador == null && other.identificador != null) || (this.identificador != null && !this.identificador.equals(other.identificador))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
         return identificador+"/"+marca;
    }
    
}
