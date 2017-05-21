/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionbeans;

import entities.Cuenta;
import entities.Operacion;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Sebastian
 */
@Local
public interface ModuloDEJBLocal {

    String loginD(String rut, String pass);

    String depositarD(String rut, int monto);

    String retirarD(String rut, int monto);

    String transferirD(String rutR, String rutRE, int monto);

    List<Operacion> getOperacionD(String rut);

    String cerrarC(String rut);

    Cuenta getByRutD(String rut);

}
