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
public class ModuloEJB implements ModuloEJBLocal {

    @EJB
    private CuentaFacadeLocal cuentaFacade;

    @EJB
    private OperacionFacadeLocal operacionFacade;

    @Override
    public String login(String rut, String pass) {
        Cuenta cuenta = getByRut(rut);

        if (cuenta != null) {
            Usuario usuario = cuenta.getIdU();
            if (usuario.getContrasenaU().equals(pass) && cuenta.getEstadoC() == true) {
                return "/moduloP/home";
            } else if (usuario.getContrasenaU().equals(pass) && cuenta.getEstadoC() == false) {
                return "/moduloP/activar";
            } else if (!usuario.getContrasenaU().equals(pass)) {
                return "i";
            }
        }
        return "false";
    }

    @Override
    public Cuenta getByRut(String rut) {
        Cuenta cuenta = null;
        List<Cuenta> allU = cuentaFacade.findByTipoC("sb");

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
    public String depositar(String rut, int monto) {
        String r = validarMonto(monto);
        if (!r.equals("true")) {
            return r;
        }
        Cuenta c = getByRut(rut);

        if (c == null) {
            return "err";
        }
        int montoF = c.getSaldoC() + monto;

        if (montoF > 1000000) {
            return "e";
        }
        c.setSaldoC(montoF);
        String response = cuentaFacade.drt(c);

        if (response.equals("true")) {
            Cuenta f = getByRut(rut);
            Operacion o = new Operacion();
            o.setOperacion("Deposito");
            o.setMontoOp(monto);
            o.setFechaOp(new Date());
            o.setRealizador(f);
            o.setRutR(rut);
            o.setRutRE(rut);
            o.setSaldoFinal(f.getSaldoC());
            o.setTipoO("sb");
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
    public String retirar(String rut, int monto) {
        String r = validarMonto(monto);
        if (!r.equals("true")) {
            return r;
        }
        Cuenta c = getByRut(rut);

        if (c == null) {
            return "err";
        }

        if (c.getSaldoC() < monto) {
            return "e";
        }

        int montoF = c.getSaldoC() - monto;
        c.setSaldoC(montoF);

        String response = cuentaFacade.drt(c);

        if (response.equals("true")) {
            Cuenta f = getByRut(rut);
            Operacion o = new Operacion();
            o.setOperacion("Retiro");
            o.setMontoOp(monto);
            o.setFechaOp(new Date());
            o.setRealizador(f);
            o.setRutR(rut);
            o.setRutRE(rut);
            o.setSaldoFinal(f.getSaldoC());
            o.setTipoO("sb");
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
    public String transferir(String rutR, String rutRE, int monto) {
        String res = validarMonto(monto);
        if (!res.equals("true")) {
            return res;
        }
        Cuenta r = getByRut(rutR);
        Cuenta re = getByRut(rutRE);

        if (r == null) {
            return "err";
        }
        if (re == null) {
            return "f";
        }
        if (rutR.equals(rutRE)) {
            return "r";
        }

        if (re.getEstadoC() == false) {
            return "c";
        }

        if (monto > r.getSaldoC()) {
            return "e";
        }

        int saldoFRE = re.getSaldoC() + monto;

        if (saldoFRE > 1000000) {
            return "i";
        }

        int saldoFR = r.getSaldoC() - monto;
        r.setSaldoC(saldoFR);
        re.setSaldoC(saldoFRE);

        String realizadorR = cuentaFacade.drt(r);
        String receptorR = cuentaFacade.drt(re);

        if (realizadorR.equals("true") && receptorR.equals("true")) {
            Cuenta realizadorF = getByRut(rutR);
            Cuenta receptorF = getByRut(rutRE);
            Operacion o = new Operacion();
            o.setOperacion("Transferencia");
            o.setMontoOp(monto);
            o.setFechaOp(new Date());
            o.setRealizador(realizadorF);
            o.setRutR(rutR);
            o.setRutRE(rutRE);
            o.setSaldoFinal(realizadorF.getSaldoC());
            o.setTipoO("sb");
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

    public String validarMonto(int monto) {

        if (monto > 1000000) {
            return "ex";
        } else if (monto <= 0) {
            return "n";
        }
        return "true";
    }

    @Override
    public List<Operacion> getOperacion(String rut) {

        List<Operacion> all = operacionFacade.findAll();
        if (all == null) {
            return null;
        }
        List<Operacion> response = new ArrayList();

        for (Operacion op : all) {
            if (op.getRealizador().getIdU().getRutU().equals(rut) && op.getTipoO().equals("sb")) {
                response.add(op);
            }
        }

        return response;
    }

    @Override
    public String updateEstadoC(String rut, String tipo) {
        Cuenta c = getByRut(rut);

        if (c == null) {
            return "e";
        }

        if (tipo.equals("c")) {
            c.setEstadoC(false);
        } else {
            c.setEstadoC(true);
        }

        String r = cuentaFacade.updateEstado(c);

        return r;
    }
}
