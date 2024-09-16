/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unipiloto.arquitectura.student.session;

import co.edu.unipiloto.arquitectura.student.entity.Studcur;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author User
 */
@Local
public interface StudcurFacadeLocal {

    void create(Studcur studcur);

    void edit(Studcur studcur);

    void remove(Studcur studcur);

    Studcur find(Object id);

    List<Studcur> findAll();

    List<Studcur> findRange(int[] range);

    int count();
    
}
