package org.epicode.dao;

import org.epicode.entities.Catalogo;
import org.epicode.entities.Prestito;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.UUID;

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


    public List<Catalogo> loanForUser(UUID id){
        TypedQuery<Catalogo> list = em.createQuery("SELECT c FROM Catalogo c JOIN c.prestito p  WHERE p.utente.numeroTessera =:g  AND p.getDataRestituzioneEffettiva IS NULL", Catalogo.class);
        list.setParameter("g",id);
        return  list.getResultList();
    };
}
