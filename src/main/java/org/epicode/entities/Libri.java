package org.epicode.entities;


import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("libri")
public class Libri extends Catalogo {
    private String autore;
    private String Genere;

    public Libri() {
    }

    public Libri(String titolo, int annoDipubblicazione, int numeroDiPagine, String autore,String genere) {
        super(titolo, annoDipubblicazione, numeroDiPagine);
        this.autore = autore;
        this.Genere = genere;
    }

    public String getAutore() {
        return autore;
    }

    public void setAutore(String autore) {
        this.autore = autore;
    }

    public String getGenere() {
        return Genere;
    }

    public void setGenere(String genere) {
        Genere = genere;
    }
}
