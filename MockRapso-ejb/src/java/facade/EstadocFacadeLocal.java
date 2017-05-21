/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entities.Estadoc;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Sebastian
 */
@Local
public interface EstadocFacadeLocal {

    void create(Estadoc estadoc);

    void edit(Estadoc estadoc);

    void remove(Estadoc estadoc);

    Estadoc find(Object id);

    List<Estadoc> findAll();

    List<Estadoc> findRange(int[] range);

    int count();
    
    Estadoc findByNombre(String nombre);
}
