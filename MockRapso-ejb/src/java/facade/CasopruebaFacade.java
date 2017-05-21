/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entities.Casoprueba;
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
public class CasopruebaFacade extends AbstractFacade<Casoprueba> implements CasopruebaFacadeLocal {

    @PersistenceContext(unitName = "MockRapso-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CasopruebaFacade() {
        super(Casoprueba.class);
    }
    
    @Override
    public String createCP(Casoprueba cp) {
        String retorno = "f";
        try {
            int crea = em.createNativeQuery("INSERT INTO Casoprueba (identificadorCaso, nombre, descripcion, precondicion, pasos, resultadosE, fechaC, fechaE, EstadoC_idEstadoC, Practica_idPractica, HU_idHU, resultadosO)" + " VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)")
                    .setParameter(1, cp.getIdentificadorCaso())
                    .setParameter(2, cp.getNombre())
                    .setParameter(3, cp.getDescripcion())
                    .setParameter(4, cp.getPrecondicion())
                    .setParameter(5, cp.getPasos())
                    .setParameter(6, cp.getResultadosE())
                    .setParameter(7, cp.getFechaC())
                    .setParameter(8, cp.getFechaE())
                    .setParameter(9, cp.getEstadoCidEstadoC().getIdEstadoC())
                    .setParameter(10, cp.getPracticaidPractica().getIdPractica())
                    .setParameter(11, cp.getHUidHU().getIdHU())
                    .setParameter(12, cp.getResultadosO())
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
    public String editCP(Casoprueba cp) {
        String retorno = "false";
        try {
            Query query = em.createNativeQuery(
                    "UPDATE Casoprueba SET nombre = ?, descripcion = ?, precondicion = ?, pasos = ?, resultadosE = ?, resultadosO = ?, fechaE = ?, EstadoC_idEstadoC = ?"
                    + " WHERE idCp = ?");
            int updateCount = query.setParameter(1, cp.getNombre())
                    .setParameter(2, cp.getDescripcion())
                    .setParameter(3, cp.getPrecondicion())
                    .setParameter(4, cp.getPasos())
                    .setParameter(5, cp.getResultadosE())
                    .setParameter(6, cp.getResultadosO())
                    .setParameter(7, cp.getFechaE())
                    .setParameter(8, cp.getEstadoCidEstadoC().getIdEstadoC())
                    .setParameter(9, cp.getIdCp())
                    .executeUpdate();

            if (updateCount > 0) {
                em.merge(cp);
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
    public String deleteCP(int idC) {
        String retorno;
        try {
            Query query = em.createNativeQuery(
                    "DELETE FROM Casoprueba WHERE idCp = ?");
            int crea = query.setParameter(1, idC)
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
