/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entities.Incidenciacp;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.LockTimeoutException;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.Query;
import javax.persistence.QueryTimeoutException;
import javax.persistence.TransactionRequiredException;

/**
 *
 * @author Sebastian
 */
@Stateless
public class IncidenciacpFacade extends AbstractFacade<Incidenciacp> implements IncidenciacpFacadeLocal {

    @PersistenceContext(unitName = "MockRapso-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public IncidenciacpFacade() {
        super(Incidenciacp.class);
    }

    @Override
    public String createIncidenciacp(Incidenciacp i) {
        String retorno;
        try {
            int crea = em.createNativeQuery("INSERT INTO Incidenciacp (identificadorICP, nombreICP, descripcionICP, pasosICP, resultadoEICP, resultadoOICP, fechaCICP, fechaE, CasoPrueba_idCp, EstadoI_idEstadoI)" + " VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)")
                    .setParameter(1, i.getIdentificadorICP())
                    .setParameter(2, i.getNombreICP())
                    .setParameter(3, i.getDescripcionICP())
                    .setParameter(4, i.getPasosICP())
                    .setParameter(5, i.getResultadoEICP())
                    .setParameter(6, i.getResultadoOICP())
                    .setParameter(7, i.getFechaCICP())
                    .setParameter(8, i.getFechaE())
                    .setParameter(9, i.getCasoPruebaidCp().getIdCp())
                    .setParameter(10, i.getEstadoIidEstadoI().getIdEstadoI())
                    .executeUpdate();
            retorno = "t";
        } catch (IllegalArgumentException e) {
            retorno = "f";
        } catch (TransactionRequiredException e) {
            retorno = "f";
        } catch (QueryTimeoutException e) {
            retorno = "f";
        } catch (LockTimeoutException e) {
            retorno = "f";
        } catch (PersistenceException e) {
            retorno = "f";
        }
        return retorno;
    }

    @Override
    public String editIncidenciacp(Incidenciacp i) {
        String retorno = "false";
        try {
            Query query = em.createNativeQuery(
                    "UPDATE Incidenciacp SET nombreICP = ?, descripcionICP = ? , pasosICP = ?, resultadoEICP = ?, resultadoOICP = ?, fechaE = ?, EstadoI_idEstadoI = ?"
                    + " WHERE idIncidenciacp = ?");
            int updateCount = query.setParameter(1, i.getNombreICP())
                    .setParameter(2, i.getDescripcionICP())
                    .setParameter(3, i.getPasosICP())
                    .setParameter(4, i.getResultadoEICP())
                    .setParameter(5, i.getResultadoOICP())
                    .setParameter(6, i.getFechaE())
                    .setParameter(7, i.getEstadoIidEstadoI().getIdEstadoI())
                    .setParameter(8, i.getIdIncidenciacp())
                    .executeUpdate();

            if (updateCount > 0) {
                em.merge(i);
                return "true";
            } else {
                return "false";
            }
        } catch (IllegalArgumentException e) {
            retorno = "false";
        } catch (TransactionRequiredException e) {
            retorno = "false";
        } catch (QueryTimeoutException e) {
            retorno = "false";
        } catch (LockTimeoutException e) {
            retorno = "false";
        } catch (PersistenceException e) {
            retorno = "false";
        }

        return retorno;
    }

    @Override
    public String eliminarIncidenciacp(int idI) {
        String retorno;
        try {
            Query query = em.createNativeQuery(
                    "DELETE FROM Incidenciacp WHERE idIncidenciacp = ?");
            int crea = query.setParameter(1, idI)
                    .executeUpdate();
            retorno = "t";
        } catch (IllegalArgumentException e) {
            retorno = "f";
        } catch (TransactionRequiredException e) {
            retorno = "f";
        } catch (QueryTimeoutException e) {
            retorno = "f";
        } catch (LockTimeoutException e) {
            retorno = "f";
        } catch (PersistenceException e) {
            retorno = "f";
        }
        return retorno;
    }

}
