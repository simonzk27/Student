/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unipiloto.arquitectura.student.entity;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author UUSARIO
 */
@Entity
@Table(name = "STUDCUR")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Studcur.findAll", query = "SELECT s FROM Studcur s"),
    @NamedQuery(name = "Studcur.findByCodCurso", query = "SELECT s FROM Studcur s WHERE s.studcurPK.codCurso = :codCurso"),
    @NamedQuery(name = "Studcur.findByStudentid", query = "SELECT s FROM Studcur s WHERE s.studcurPK.studentid = :studentid")})
public class Studcur implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected StudcurPK studcurPK;

    public Studcur() {
    }

    public Studcur(StudcurPK studcurPK) {
        this.studcurPK = studcurPK;
    }

    public Studcur(int codCurso, int studentid) {
        this.studcurPK = new StudcurPK(codCurso, studentid);
    }

    public StudcurPK getStudcurPK() {
        return studcurPK;
    }

    public void setStudcurPK(StudcurPK studcurPK) {
        this.studcurPK = studcurPK;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (studcurPK != null ? studcurPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Studcur)) {
            return false;
        }
        Studcur other = (Studcur) object;
        if ((this.studcurPK == null && other.studcurPK != null) || (this.studcurPK != null && !this.studcurPK.equals(other.studcurPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.unipiloto.arquitectura.student.entity.Studcur[ studcurPK=" + studcurPK + " ]";
    }
    
}
