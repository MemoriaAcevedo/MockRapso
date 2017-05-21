/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entities.Pa;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Sebastian
 */
@Local
public interface PaFacadeLocal {

    void create(Pa pa);

    void edit(Pa pa);

    void remove(Pa pa);

    Pa find(Object id);

    List<Pa> findAll();

    List<Pa> findRange(int[] range);

    int count();
    
}
