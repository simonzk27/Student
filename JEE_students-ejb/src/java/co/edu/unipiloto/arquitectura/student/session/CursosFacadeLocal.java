/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unipiloto.arquitectura.student.session;

import co.edu.unipiloto.arquitectura.student.entity.Cursos;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author User
 */
@Local
public interface CursosFacadeLocal {

    void create(Cursos cursos);

    void edit(Cursos cursos);

    void remove(Cursos cursos);

    Cursos find(Object id);

    List<Cursos> findAll();

    List<Cursos> findRange(int[] range);

    int count();
    
}
