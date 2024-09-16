/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unipiloto.arquitectura.student.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author UUSARIO
 */
@Embeddable
public class StudcurPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "COD_CURSO")
    private int codCurso;
    @Basic(optional = false)
    @NotNull
    @Column(name = "STUDENTID")
    private int studentid;

    public StudcurPK() {
    }

    public StudcurPK(int codCurso, int studentid) {
        this.codCurso = codCurso;
        this.studentid = studentid;
    }

    public int getCodCurso() {
        return codCurso;
    }

    public void setCodCurso(int codCurso) {
        this.codCurso = codCurso;
    }

    public int getStudentid() {
        return studentid;
    }

    public void setStudentid(int studentid) {
        this.studentid = studentid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) codCurso;
        hash += (int) studentid;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof StudcurPK)) {
            return false;
        }
        StudcurPK other = (StudcurPK) object;
        if (this.codCurso != other.codCurso) {
            return false;
        }
        if (this.studentid != other.studentid) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.unipiloto.arquitectura.student.entity.StudcurPK[ codCurso=" + codCurso + ", studentid=" + studentid + " ]";
    }
    
}
