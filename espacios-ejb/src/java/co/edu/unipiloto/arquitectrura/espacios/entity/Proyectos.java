/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unipiloto.arquitectrura.espacios.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author barr2
 */
@Entity
@Table(name = "PROYECTOS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Proyectos.findAll", query = "SELECT p FROM Proyectos p"),
    @NamedQuery(name = "Proyectos.findByProyectoid", query = "SELECT p FROM Proyectos p WHERE p.proyectoid = :proyectoid"),
    @NamedQuery(name = "Proyectos.findByNombre", query = "SELECT p FROM Proyectos p WHERE p.nombre = :nombre"),
    @NamedQuery(name = "Proyectos.findByDescripcion", query = "SELECT p FROM Proyectos p WHERE p.descripcion = :descripcion"),
    @NamedQuery(name = "Proyectos.findByLocalidad", query = "SELECT p FROM Proyectos p WHERE p.localidad = :localidad"),
    @NamedQuery(name = "Proyectos.findByPresupuesto", query = "SELECT p FROM Proyectos p WHERE p.presupuesto = :presupuesto"),
    @NamedQuery(name = "Proyectos.findByNumeroHabitantes", query = "SELECT p FROM Proyectos p WHERE p.numeroHabitantes = :numeroHabitantes")})
public class Proyectos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "PROYECTOID")
    private Integer proyectoid;
    @Size(max = 50)
    @Column(name = "NOMBRE")
    private String nombre;
    @Size(max = 50)
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @Size(max = 50)
    @Column(name = "LOCALIDAD")
    private String localidad;
    @Column(name = "PRESUPUESTO")
    private Integer presupuesto;
    @Column(name = "NUMERO_HABITANTES")
    private Integer numeroHabitantes;

    public Proyectos() {
    }

    public Proyectos(Integer proyectoid, String nombre, String descripcion, String localidad, Integer presupuesto, Integer numeroHabitantes) {
        this.proyectoid = proyectoid;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.localidad = localidad;
        this.presupuesto = presupuesto;
        this.numeroHabitantes = numeroHabitantes;
    }
    
    

    public Proyectos(Integer proyectoid) {
        this.proyectoid = proyectoid;
    }

    public Integer getProyectoid() {
        return proyectoid;
    }

    public void setProyectoid(Integer proyectoid) {
        this.proyectoid = proyectoid;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public Integer getPresupuesto() {
        return presupuesto;
    }

    public void setPresupuesto(Integer presupuesto) {
        this.presupuesto = presupuesto;
    }

    public Integer getNumeroHabitantes() {
        return numeroHabitantes;
    }

    public void setNumeroHabitantes(Integer numeroHabitantes) {
        this.numeroHabitantes = numeroHabitantes;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (proyectoid != null ? proyectoid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Proyectos)) {
            return false;
        }
        Proyectos other = (Proyectos) object;
        if ((this.proyectoid == null && other.proyectoid != null) || (this.proyectoid != null && !this.proyectoid.equals(other.proyectoid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.unipiloto.arquitectrura.espacios.entity.Proyectos[ proyectoid=" + proyectoid + " ]";
    }
    
}
