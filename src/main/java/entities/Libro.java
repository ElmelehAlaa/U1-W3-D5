package entities;

import javax.persistence.Entity;

@Entity
public class Libro extends Pubblicazione {
    private String genere;
    private String autore;

    public Libro(long codiceISBN, String titolo, int annoPubblicazione, int numeroPagine, String genere, String autore) {
        super(codiceISBN, titolo, annoPubblicazione, numeroPagine);
        this.genere = genere;
        this.autore = autore;
    }


    public String getGenere() {
        return genere;
    }

    public String getAutore() {
        return autore;
    }
}

