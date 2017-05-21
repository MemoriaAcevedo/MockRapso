/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entities.Areapregunta;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Sebastian
 */
@Local
public interface AreapreguntaFacadeLocal {

    void create(Areapregunta areapregunta);

    void edit(Areapregunta areapregunta);

    void remove(Areapregunta areapregunta);

    Areapregunta find(Object id);

    List<Areapregunta> findAll();

    List<Areapregunta> findRange(int[] range);

    int count();
    
}
