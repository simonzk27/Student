/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unipiloto.arquitectura.student.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author User
 */
@Entity
@Table(name = "CURSOS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cursos.findAll", query = "SELECT c FROM Cursos c"),
    @NamedQuery(name = "Cursos.findByCodCurso", query = "SELECT c FROM Cursos c WHERE c.codCurso = :codCurso"),
    @NamedQuery(name = "Cursos.findByNombreCurso", query = "SELECT c FROM Cursos c WHERE c.nombreCurso = :nombreCurso"),
    @NamedQuery(name = "Cursos.findByNumCreditos", query = "SELECT c FROM Cursos c WHERE c.numCreditos = :numCreditos"),
    @NamedQuery(name = "Cursos.findBySemestre", query = "SELECT c FROM Cursos c WHERE c.semestre = :semestre"),
    @NamedQuery(name = "Cursos.findByNumEstudAdmitidos", query = "SELECT c FROM Cursos c WHERE c.numEstudAdmitidos = :numEstudAdmitidos")})
public class Cursos implements Serializable {

    @JoinTable(name = "STUDCUR", joinColumns = {
        @JoinColumn(name = "COD_CURSO", referencedColumnName = "COD_CURSO")}, inverseJoinColumns = {
        @JoinColumn(name = "STUDENTID", referencedColumnName = "STUDENTID")})
    @ManyToMany
    private Collection<Student> studentCollection;

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "COD_CURSO")
    private Integer codCurso;
    @Size(max = 100)
    @Column(name = "NOMBRE_CURSO")
    private String nombreCurso;
    @Column(name = "NUM_CREDITOS")
    private Integer numCreditos;
    @Column(name = "SEMESTRE")
    private Integer semestre;
    @Column(name = "NUM_ESTUD_ADMITIDOS")
    private Integer numEstudAdmitidos;

    public Cursos() {
    }

    public Cursos(Integer codCurso, String nombreCurso, Integer numCreditos, Integer semestre, Integer numEstudAdmitidos) {
        this.codCurso = codCurso;
        this.nombreCurso = nombreCurso;
        this.numCreditos = numCreditos;
        this.semestre = semestre;
        this.numEstudAdmitidos = numEstudAdmitidos;
    }

    
    public Cursos(Integer codCurso) {
        this.codCurso = codCurso;
    }

    public Integer getCodCurso() {
        return codCurso;
    }

    public void setCodCurso(Integer codCurso) {
        this.codCurso = codCurso;
    }

    public String getNombreCurso() {
        return nombreCurso;
    }

    public void setNombreCurso(String nombreCurso) {
        this.nombreCurso = nombreCurso;
    }

    public Integer getNumCreditos() {
        return numCreditos;
    }

    public void setNumCreditos(Integer numCreditos) {
        this.numCreditos = numCreditos;
    }

    public Integer getSemestre() {
        return semestre;
    }

    public void setSemestre(Integer semestre) {
        this.semestre = semestre;
    }

    public Integer getNumEstudAdmitidos() {
        return numEstudAdmitidos;
    }

    public void setNumEstudAdmitidos(Integer numEstudAdmitidos) {
        this.numEstudAdmitidos = numEstudAdmitidos;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codCurso != null ? codCurso.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cursos)) {
            return false;
        }
        Cursos other = (Cursos) object;
        if ((this.codCurso == null && other.codCurso != null) || (this.codCurso != null && !this.codCurso.equals(other.codCurso))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.unipiloto.arquitectura.student.entity.Cursos[ codCurso=" + codCurso + " ]";
    }

    @XmlTransient
    public Collection<Student> getStudentCollection() {
        return studentCollection;
    }

    public void setStudentCollection(Collection<Student> studentCollection) {
        this.studentCollection = studentCollection;
    }
    
}
