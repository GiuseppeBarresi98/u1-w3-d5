package org.epicode.dao;

import org.epicode.entities.Prestito;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class PrestitoDAO {
    private EntityManager em;
    public PrestitoDAO(EntityManager em){
        this.em = em;
    }

    public void saveLoan(Prestito prestito){
        EntityTransaction transaction = em.getTransaction();

        try{
            transaction.begin();
            em.persist(prestito);
            transaction.commit();
            System.out.println("Elemento salvato con successo");
        } catch (Exception e){
            System.out.println(e.getMessage());;
        }
    }
}
