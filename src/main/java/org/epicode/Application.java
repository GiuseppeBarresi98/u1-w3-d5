package org.epicode;

import org.epicode.Enum.Periodicita;
import org.epicode.dao.CatalogoDAO;
import org.epicode.dao.PrestitoDAO;
import org.epicode.dao.UtenteDAO;
import org.epicode.entities.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public class Application {

    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestionearchivio");

    public static void main(String[] args) {
        EntityManager em = emf.createEntityManager();

        CatalogoDAO catalogoDAO = new CatalogoDAO(em);
        PrestitoDAO prestitoDAO = new PrestitoDAO(em);
        UtenteDAO utenteDAO = new UtenteDAO(em);



        Catalogo libro1 = new Libri("Il signore degli Anelli",1996,700,"Folkien","fantasy");
        Catalogo libro2 = new Libri("Harry Potter",1999,1700,"J.k Rollins","fantasy");
        Catalogo rivista1 = new Riviste("CHI?",2002,40, Periodicita.SETTIMANALE);
        Catalogo rivista4 = new Riviste("Magazine",2005,240,Periodicita.SETTIMANALE);

        catalogoDAO.saveElementi(libro1);
        catalogoDAO.saveElementi(libro2);
        catalogoDAO.saveElementi(rivista1);
        catalogoDAO.saveElementi(rivista4);

        // System.out.println(catalogoDAO.findById(UUID.fromString("d16f2bc2-756f-4468-828e-ff6fcf5e8c5c")));

        // catalogoDAO.deleteById(UUID.fromString("d16f2bc2-756f-4468-828e-ff6fcf5e8c5c"));

        System.out.println("Ricerca per anno di pubblicazione: " + catalogoDAO.findByYear(1996)); ;
        System.out.println("Ricerca per nome autore: " + catalogoDAO.findbyAuthor("J.k Rollins"));
        System.out.println("Ricerca per titolo o porzione di esso: "+ catalogoDAO.findByTitle("Il"));


        Utente utente1 = new Utente("Giuseppe","Barresi", LocalDate.of(1998,7,5));
        utenteDAO.saveUser(utente1);

        Prestito prestito1 = new Prestito(utente1,rivista4,LocalDate.of(2024,1,10),LocalDate.of(2024,1,30));
        Prestito prestito2 = new Prestito(utente1,libro1,LocalDate.of(2024,1,10),LocalDate.of(2024,1,30));
        Prestito prestito3 = new Prestito(utente1,libro2,LocalDate.of(2024,1,10),LocalDate.of(2024,1,30));
        prestito3.setGetDataRestituzioneEffettiva(LocalDate.of(2024,2,10));
        Prestito prestito4 = new Prestito(utente1,rivista4,LocalDate.of(2024,1,1),LocalDate.of(2024,1,11));

        prestitoDAO.saveLoan(prestito2);
        prestitoDAO.saveLoan(prestito3);
        prestitoDAO.saveLoan(prestito1);
        prestitoDAO.saveLoan(prestito4);

        System.out.println(prestitoDAO.loanForUser(UUID.fromString("a28272fa-ec93-4b3e-b88c-eae0ab062b94")));

        List<Prestito> prestitiScaduti = prestitoDAO.prestitiScaduti();

        prestitiScaduti.forEach(System.out::println);


    }
}

