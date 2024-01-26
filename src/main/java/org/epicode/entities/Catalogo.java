package org.epicode.entities;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "catalogo")
public abstract class Catalogo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO )
    private UUID ISBN;
    private String titolo;

    private int annoDipubblicazione;

    private int numeroDiPagine;

    @OneToOne(mappedBy = "elementoPrestato")
    private Prestito prestito;

    public Catalogo() {
    }

    public Catalogo(String titolo, int annoDipubblicazione, int numeroDiPagine) {
        this.titolo = titolo;
        this.annoDipubblicazione = annoDipubblicazione;
        this.numeroDiPagine = numeroDiPagine;
    }

    public String getTitolo() { return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public int getAnnoDipubblicazione() {
        return annoDipubblicazione;
    }

    public void setAnnoDipubblicazione(int annoDipubblicazione) {
        this.annoDipubblicazione = annoDipubblicazione;
    }

    public int getNumeroDiPagine() {
        return numeroDiPagine;
    }

    public void setNumeroDiPagine(int numeroDiPagine) {
        this.numeroDiPagine = numeroDiPagine;
    }

    public UUID getISBN() {
        return ISBN;

    }

    @Override
    public String toString() {
        return "Catalogo{" +
                "ISBN=" + ISBN +
                ", titolo='" + titolo + '\'' +
                ", annoDipubblicazione=" + annoDipubblicazione +
                ", numeroDiPagine=" + numeroDiPagine +
                ", prestito=" + prestito +
                '}';
    }
}
