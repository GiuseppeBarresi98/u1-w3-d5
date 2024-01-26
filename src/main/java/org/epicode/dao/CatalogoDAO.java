package org.epicode.dao;

import org.epicode.entities.Catalogo;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.UUID;

public class CatalogoDAO {
    private EntityManager em;

    public CatalogoDAO(EntityManager em) {
        this.em = em;
    }

    public void saveElementi(Catalogo elemento) {
        try {
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();
            em.persist(elemento);
            transaction.commit();
            System.out.println("Elemento " + elemento.getTitolo() + " Salvato con successo");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("errore");
        }
    }

    public Catalogo findById(UUID ISBN){
      return em.find(Catalogo.class ,ISBN);
    };


    public List<Catalogo> findByYear(int annoDiPubblicazione) {
        TypedQuery<Catalogo> query = em.createQuery("SELECT c FROM Catalogo c WHERE c.annoDipubblicazione = :annoDiPubblicazione", Catalogo.class);
        query.setParameter("annoDiPubblicazione", annoDiPubblicazione);
        return query.getResultList();
    }


    public List<Catalogo> findbyAuthor(String autore){
        TypedQuery<Catalogo> list = em.createQuery("SELECT c from Catalogo c WHERE c.autore=:a", Catalogo.class);
        list.setParameter("a", autore);
        return list.getResultList();
    };

    public List<Catalogo> findByTitle(String titolo){
        TypedQuery<Catalogo> list = em.createQuery("SELECT c FROM Catalogo c WHERE c.titolo LIKE :t", Catalogo.class);
        list.setParameter("t","%" + titolo + "%");
        return list.getResultList();
    };


    public void deleteById(UUID ISBN){
        EntityTransaction transaction = em.getTransaction();
        Catalogo elementeFind = em.find(Catalogo.class,ISBN);
        if (elementeFind != null){
            transaction.begin();
            em.remove(elementeFind);
            transaction.commit();
            System.out.println("Elemento eliminato con successo");
        }
        else {
            System.out.println("Elemento non trovato");
        }
    }

}