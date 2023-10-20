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

    public void setGenere(String genere) {
        this.genere = genere;
    }

    public void setAutore(String autore) {
        this.autore = autore;
    }

    @Override
    public String toString() {
        return "Libro{" +
                "genere='" + genere + '\'' +
                ", autore='" + autore + '\'' +
                '}';
    }
}




