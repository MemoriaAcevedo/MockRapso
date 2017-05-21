/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entities.Estadop;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Sebastian
 */
@Local
public interface EstadopFacadeLocal {

    void create(Estadop estadop);

    void edit(Estadop estadop);

    void remove(Estadop estadop);

    Estadop find(Object id);

    List<Estadop> findAll();

    List<Estadop> findRange(int[] range);

    int count();
    
    Estadop findByNombre(String nombre);
    
}
