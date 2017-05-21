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
public interface ModuloEJBLocal {

    String login(String rut, String pass);

    Cuenta getByRut(String rut);

    String depositar(String rut, int monto);

    String retirar(String rut, int monto);

    String transferir(String rutR, String rutRE, int monto);

    List<Operacion> getOperacion(String rut);

    String updateEstadoC(String rut, String tipo);
}
