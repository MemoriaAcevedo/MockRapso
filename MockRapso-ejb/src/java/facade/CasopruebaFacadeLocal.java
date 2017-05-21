/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entities.Casoprueba;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Sebastian
 */
@Local
public interface CasopruebaFacadeLocal {

    void create(Casoprueba casoprueba);

    void edit(Casoprueba casoprueba);

    void remove(Casoprueba casoprueba);

    Casoprueba find(Object id);

    List<Casoprueba> findAll();

    List<Casoprueba> findRange(int[] range);

    int count();
    
    String createCP(Casoprueba cp);
    
    String editCP(Casoprueba cp);
    
    String deleteCP(int idC);
}
