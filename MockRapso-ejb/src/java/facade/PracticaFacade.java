/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entities.Practica;
import entities.Practica1;
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
public class PracticaFacade extends AbstractFacade<Practica> implements PracticaFacadeLocal {

    @PersistenceContext(unitName = "MockRapso-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PracticaFacade() {
        super(Practica.class);
    }
    
    @Override
    public String createPractica(Practica p) {
        String retorno;
        try {
            int crea = em.createNativeQuery("INSERT INTO Practica (realizador, corrector, fechaInicio, calificacion, EstadoP_idEstadoP, identificadorPractica, Comunidad_idComunidad)" + " VALUES(?, ?, ?, ?, ?, ?, ?)")
                    .setParameter(1, p.getRealizador().getIdUsuario())
                    .setParameter(2, p.getCorrector().getIdUsuario())
                    .setParameter(3, p.getFechaInicio())
                    .setParameter(4, p.getCalificacion())
                    .setParameter(5, p.getEstadoPidEstadoP().getIdEstadoP())
                    .setParameter(6, p.getIdentificadorPractica())
                    .setParameter(7, p.getComunidadidComunidad().getIdComunidad())
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
    public String eliminarPractica(int idP) {
        String retorno;
        try {
            Query query = em.createNativeQuery(
                    "DELETE FROM Practica WHERE idPractica = ?");
            int crea = query.setParameter(1, idP)
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
    public String correccionPractica(Practica p) {
        String retorno = "f";
        try {
            Query query = em.createNativeQuery(
                    "UPDATE Practica SET EstadoP_idEstadoP = ?"
                    + " WHERE idPractica = ?");
            int updateCount = query.setParameter(1, p.getEstadoPidEstadoP().getIdEstadoP())
                    .setParameter(2, p.getIdPractica())
                    .executeUpdate();

            if (updateCount > 0) {
                em.merge(p);
                return "t";
            } else {
                return "f";
            }
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
    public String finalizarPractica(Practica p) {
        String retorno = "f";
        try {
            Query query = em.createNativeQuery(
                    "UPDATE Practica SET EstadoP_idEstadoP = ?, fechaTermino = ?, calificacion = ?, "
                    + " WHERE idPractica = ?");
            int updateCount = query.setParameter(1, p.getEstadoPidEstadoP().getIdEstadoP())
                    .setParameter(2, p.getFechaTermino())
                    .setParameter(3, p.getCalificacion())
                    .setParameter(4, p.getIdPractica())
                    .executeUpdate();

            if (updateCount > 0) {
                em.merge(p);
                return "t";
            } else {
                return "f";
            }
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
