/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entities.Estadoi;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Sebastian
 */
@Local
public interface EstadoiFacadeLocal {

    void create(Estadoi estadoi);

    void edit(Estadoi estadoi);

    void remove(Estadoi estadoi);

    Estadoi find(Object id);

    List<Estadoi> findAll();

    List<Estadoi> findRange(int[] range);

    int count();
    
    Estadoi findByNombre(String nombre);
}
