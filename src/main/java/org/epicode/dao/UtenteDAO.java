package org.epicode.dao;

import org.epicode.entities.Utente;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class UtenteDAO {
  private  EntityManager em;

  public UtenteDAO(EntityManager em){
      this.em = em;
  }

  public void saveUser(Utente user){
      EntityTransaction transaction = em.getTransaction();

      try {
          transaction.begin();
          em.persist(user);
          transaction.commit();
          System.out.println("Elemento Salvato con successo");
      } catch (Exception e){
          System.out.println(e.getMessage());
      }
  }
}
