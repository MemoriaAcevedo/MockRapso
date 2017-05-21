/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entities.Incidencia;
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
public class IncidenciaFacade extends AbstractFacade<Incidencia> implements IncidenciaFacadeLocal {

    @PersistenceContext(unitName = "MockRapso-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public IncidenciaFacade() {
        super(Incidencia.class);
    }
    
    @Override
    public String createIncidencia(Incidencia i) {
        String retorno = "f";
        try {
            int crea = em.createNativeQuery("INSERT INTO Incidencia (identificadorI, nombreI, descripcionI, pasosI, resultadoEI, resultadoOI, fechaCI, fechaEI, EstadoI_idEstadoI, Practica_idPractica)" + " VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)")
                    .setParameter(1, i.getIdentificadorI())
                    .setParameter(2, i.getNombreI())
                    .setParameter(3, i.getDescripcionI())
                    .setParameter(4, i.getPasosI())
                    .setParameter(5, i.getResultadoEI())
                    .setParameter(6, i.getResultadoOI())
                    .setParameter(7, i.getFechaCI())
                    .setParameter(8, i.getFechaEI())
                    .setParameter(9, i.getEstadoIidEstadoI().getIdEstadoI())
                    .setParameter(10, i.getPracticaidPractica().getIdPractica())
                    .executeUpdate();
            retorno = "t";
        } catch (IllegalArgumentException e) {
            retorno = "f";
        } catch (QueryTimeoutException e) {
            retorno = "f";
        } catch (TransactionRequiredException e) {
            retorno = "f";
        } catch (LockTimeoutException e) {
            retorno = "f";
        } catch (PersistenceException e) {
            retorno = "f";
        }
        return retorno;
    }

    @Override
    public String editIncidencia(Incidencia i) {
        String retorno = "false";
        try {
            Query query = em.createNativeQuery(
                    "UPDATE Incidencia SET nombreI = ?, descripcionI = ? , pasosI = ?, resultadoEI = ?, resultadoOI = ?, fechaEI = ?, EstadoI_idEstadoI = ?"
                    + " WHERE idIncidencia = ?");
            int updateCount = query.setParameter(1, i.getNombreI())
                    .setParameter(2, i.getDescripcionI())
                    .setParameter(3, i.getPasosI())
                    .setParameter(4, i.getResultadoEI())
                    .setParameter(5, i.getResultadoOI())
                    .setParameter(6, i.getFechaEI())
                    .setParameter(7, i.getEstadoIidEstadoI().getIdEstadoI())
                    .setParameter(8, i.getIdIncidencia())
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
    public String eliminarIncidencia(int idI) {
        String retorno;
        try {
            Query query = em.createNativeQuery(
                    "DELETE FROM Incidencia WHERE idIncidencia = ?");
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
