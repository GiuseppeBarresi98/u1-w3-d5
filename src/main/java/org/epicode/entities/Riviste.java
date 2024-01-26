package org.epicode.entities;

import org.epicode.Enum.Periodicita;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity
@DiscriminatorValue("riviste")
public class Riviste extends Catalogo {

    @Enumerated(EnumType.STRING)
    Periodicita periodicita;

    public Riviste() {
    }

    public Riviste(String titolo, int annoDipubblicazione, int numeroDiPagine, Periodicita periodicita) {
        super(titolo, annoDipubblicazione, numeroDiPagine);
        this.periodicita = periodicita;
    }

    public Periodicita getPeriodicita() {
        return periodicita;
    }

    public void setPeriodicita(Periodicita periodicita) {
        this.periodicita = periodicita;
    }
}
