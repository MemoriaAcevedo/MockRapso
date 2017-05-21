/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionbeans;

import entities.Cuenta;
import entities.Operacion;
import entities.Usuario;
import facade.CuentaFacadeLocal;
import facade.OperacionFacadeLocal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Sebastian
 */
@Stateless
public class ModuloDEJB implements ModuloDEJBLocal {

    @EJB
    private CuentaFacadeLocal cuentaFacade;

    @EJB
    private OperacionFacadeLocal operacionFacade;

    @Override
    public String loginD(String rut, String pass) {
        Cuenta c = getByRutD(rut);
        if (c != null) {
            Usuario usuario = c.getIdU();
            if (usuario.getContrasenaU().equals(pass) && c.getEstadoC() == true) {
                return "/moduloD/home";
            }
        }
        return "false";
    }

    @Override
    public Cuenta getByRutD(String rut) {
        Cuenta cuenta = null;
        List<Cuenta> allU = cuentaFacade.findByTipoC("cb");

        if (allU == null) {
            return null;
        }

        for (Cuenta c : allU) {
            if (c.getIdU().getRutU().equals(rut)) {
                cuenta = c;
                break;
            }
        }
        return cuenta;
    }

    @Override
    public String depositarD(String rut, int monto) {

        Cuenta c = getByRutD(rut);

        if (c == null) {
            return "err";
        }
        int montoF = c.getSaldoC() + monto;

        c.setSaldoC(montoF);
        String response = cuentaFacade.drt(c);

        if (response.equals("true")) {
            Cuenta f = getByRutD(rut);
            Operacion o = new Operacion();
            o.setOperacion("Deposito");
            o.setMontoOp(monto);
            o.setFechaOp(new Date());
            o.setRealizador(f);
            o.setRutR(rut);
            o.setRutR(rut);
            o.setSaldoFinal(f.getSaldoC());
            o.setTipoO("cb");
            String resp = operacionFacade.registrarOperacion(o);
            if (resp.equals("true")) {
                return "true";
            } else {
                return "err";
            }
        } else {
            return "err";
        }
    }

    @Override
    public String retirarD(String rut, int monto) {
        Cuenta c = getByRutD(rut);

        if (c == null) {
            return "err";
        }

        int montoF = c.getSaldoC() - monto;
        c.setSaldoC(montoF);

        String response = cuentaFacade.drt(c);

        if (response.equals("true")) {
            Cuenta f = getByRutD(rut);
            Operacion o = new Operacion();
            o.setOperacion("Retiro");
            o.setMontoOp(monto);
            o.setFechaOp(new Date());
            o.setRealizador(f);
            o.setRutR(rut);
            o.setRutRE(rut);
            o.setSaldoFinal(f.getSaldoC());
            o.setTipoO("cb");
            String resp = operacionFacade.registrarOperacion(o);
            if (resp.equals("true")) {
                return "true";
            } else {

                return "err";
            }
        } else {
            return "err";
        }
    }

    @Override
    public String transferirD(String rutR, String rutRE, int monto) {

        Cuenta r = getByRutD(rutR);
        Cuenta re = getByRutD(rutRE);

        if (r == null || re == null) {
            return "err";
        }

        int saldoFRE = re.getSaldoC() + monto;
        re.setSaldoC(saldoFRE);
        String realizadorRE = cuentaFacade.drt(re);

        if (realizadorRE.equals("true")) {
            Cuenta realizadorF = getByRutD(rutR);
            Operacion o = new Operacion();
            o.setOperacion("Transferencia");
            o.setMontoOp(monto);
            o.setFechaOp(new Date());
            o.setRealizador(realizadorF);
            o.setRutR(rutR);
            o.setRutRE(rutR);
            o.setSaldoFinal(realizadorF.getSaldoC());
            o.setTipoO("cb");
            String resp = operacionFacade.registrarOperacion(o);
            if (resp.equals("true")) {
                return "true";
            } else {
                return "err";
            }
        } else {
            return "err";
        }
    }

    @Override
    public List<Operacion> getOperacionD(String rut) {

        List<Operacion> all = operacionFacade.findAll();
        if (all == null) {
            return null;
        }
        List<Operacion> response = new ArrayList();

        for (Operacion op : all) {
            if (op.getRealizador().getIdU().getRutU().equals("18486956-k") && op.getTipoO().equals("cb")) {
                response.add(op);
            }
        }

        return response;
    }

    @Override
    public String cerrarC(String rut) {
        Cuenta c = getByRutD(rut);

        if (c == null) {
            return "e";
        }

        c.setEstadoC(true);

        String r = cuentaFacade.updateEstado(c);

        return r;
    }

}
