/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entities.Area;
import entities.Areareforzar;
import entities.Pruebateorica;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Sebastian
 */
@Local
public interface AreareforzarFacadeLocal {

    void create(Areareforzar areareforzar);

    void edit(Areareforzar areareforzar);

    void remove(Areareforzar areareforzar);

    Areareforzar find(Object id);

    List<Areareforzar> findAll();

    List<Areareforzar> findRange(int[] range);

    int count();
    
    String crearAreaReforzar(Area a, Pruebateorica p);
    
    String deleteAreaReforzar(int pt);
    
}
