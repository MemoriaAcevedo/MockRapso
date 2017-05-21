/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entities.Comunidad;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.LockTimeoutException;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.PessimisticLockException;
import javax.persistence.Query;
import javax.persistence.QueryTimeoutException;
import javax.persistence.TransactionRequiredException;

/**
 *
 * @author Sebastian
 */
@Stateless
public class ComunidadFacade extends AbstractFacade<Comunidad> implements ComunidadFacadeLocal {

    @PersistenceContext(unitName = "MockRapso-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ComunidadFacade() {
        super(Comunidad.class);
    }
    
    @Override
    public Comunidad findByNombre(String nombre) {

        Comunidad retorno = null;
        try {
            Query q = em.createNamedQuery("Comunidad.findByNombreC", Comunidad.class).setParameter("nombreC", nombre);
            retorno = (Comunidad) q.getSingleResult();
        } catch (IllegalArgumentException e) {
            retorno = null;
        } catch (NoResultException e) {
            retorno = null;
        } catch (NonUniqueResultException e) {
            retorno = null;
        } catch (IllegalStateException e) {
            retorno = null;
        } catch (QueryTimeoutException e) {
            retorno = null;
        } catch (TransactionRequiredException e) {
            retorno = null;
        } catch (PessimisticLockException e) {
            retorno = null;
        } catch (LockTimeoutException e) {
            retorno = null;
        } catch (PersistenceException e) {
            retorno = null;
        }
        if (retorno == null) {
            return null;
        } else {
            return retorno;
        }
    }

    @Override
    public String createComunidad(Comunidad c) {
        String retorno;
        try {
            int crea = em.createNativeQuery("INSERT INTO Comunidad (nombreC, descripcionC, fechaCC, fechaEC, profesorC, notaMinima)" + " VALUES(?,?,?,?,?,?)")
                    .setParameter(1, c.getNombreC())
                    .setParameter(2, c.getDescripcionC())
                    .setParameter(3, c.getFechaCC())
                    .setParameter(4, c.getFechaEC())
                    .setParameter(5, c.getProfesorC().getIdUsuario())
                    .setParameter(6, c.getNotaMinima())
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
    public String editarComunidad(Comunidad c) {
        String retorno = "false";
        try {
            Query query = em.createNativeQuery(
                    "UPDATE Comunidad SET nombreC = ?, descripcionC = ? , fechaEC = ?, notaMinima = ?"
                    + " WHERE profesorC = ? AND idComunidad = ?");
            int updateCount = query.setParameter(1, c.getNombreC())
                    .setParameter(2, c.getDescripcionC())
                    .setParameter(3, c.getFechaEC())
                    .setParameter(4, c.getNotaMinima())
                    .setParameter(5, c.getProfesorC().getIdUsuario())
                    .setParameter(6, c.getIdComunidad())
                    .executeUpdate();

            if (updateCount > 0) {
                em.merge(c);
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
    
}
