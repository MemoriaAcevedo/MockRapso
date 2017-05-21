/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entities.Pruebateorica;
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
public class PruebateoricaFacade extends AbstractFacade<Pruebateorica> implements PruebateoricaFacadeLocal {

    @PersistenceContext(unitName = "MockRapso-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PruebateoricaFacade() {
        super(Pruebateorica.class);
    }
    
    @Override
    public String crearPruebaTeorica(Pruebateorica p) {
        String retorno;
        try {
            int crea = em.createNativeQuery("INSERT INTO Pruebateorica (nota, fechaRealizado, comunidad, usuarioRealizador)" + " VALUES(?, ?, ?, ?)")
                    .setParameter(1, p.getNota())
                    .setParameter(2, p.getFechaRealizado())
                    .setParameter(3, p.getComunidad().getIdComunidad())
                    .setParameter(4, p.getUsuarioRealizador().getIdUsuario())
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
    public String editarPruebaTeorica(Pruebateorica p) {
        String retorno = "false";
        try {
            Query query = em.createNativeQuery(
                    "UPDATE Pruebateorica SET nota = ?, fechaRealizado = ?"
                    + " WHERE comunidad = ? AND usuarioRealizador = ?");
            int updateCount = query.setParameter(1, p.getNota())
                    .setParameter(2, p.getFechaRealizado())
                    .setParameter(3, p.getComunidad().getIdComunidad())
                    .setParameter(4, p.getUsuarioRealizador().getIdUsuario())
                    .executeUpdate();

            if (updateCount > 0) {
                em.merge(p);
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
