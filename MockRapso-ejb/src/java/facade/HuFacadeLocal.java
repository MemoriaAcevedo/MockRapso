/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entities.Hu;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Sebastian
 */
@Local
public interface HuFacadeLocal {

    void create(Hu hu);

    void edit(Hu hu);

    void remove(Hu hu);

    Hu find(Object id);

    List<Hu> findAll();

    List<Hu> findRange(int[] range);

    int count();
    
}
