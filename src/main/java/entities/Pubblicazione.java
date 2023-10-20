package entities;




import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "Pubblicazioni")
@NamedQuery(name = "Pubblicazione.findByCodiceISBN",query = "SELECT p FROM Pubblicazione p Where p.codiceISBN = :isbn")
@NamedQuery(name = "Pubblicazione.findByAnnoPubblicazione",query = "SELECT p FROM Pubblicazione p Where p.annoPubblicazione= :annoPubblicazione")
@NamedQuery(name = "Pubblicazione.findByAutore", query = "SELECT p FROM Pubblicazione p WHERE p.autore = :autore")
@NamedQuery(name = "Pubblicazione.findByTitolo", query = "SELECT p FROM Pubblicazione p WHERE p.titolo LIKE :titolo")
@NamedQuery(name = "Pubblicazione.removeByCodiceISBN", query = "DELETE FROM Pubblicazione p WHERE p.codiceISBN = :isbn")
public abstract class Pubblicazione {
    @Id
    private long codiceISBN;
    private String titolo;
    private int annoPubblicazione;
    private int numeroPagine;

    public Pubblicazione(){};
    public Pubblicazione(long codiceISBN, String titolo, int annoPubblicazione, int numeroPagine) {
        this.codiceISBN = codiceISBN;
        this.titolo = titolo;
        this.annoPubblicazione = annoPubblicazione;
        this.numeroPagine = numeroPagine;
    }


    public long getCodiceISBN() {
        return codiceISBN;
    }

    public void setCodiceISBN(long codiceISBN) {
        this.codiceISBN = codiceISBN;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public int getAnnoPubblicazione() {
        return annoPubblicazione;
    }

    public void setAnnoPubblicazione(int annoPubblicazione) {
        this.annoPubblicazione = annoPubblicazione;
    }

    public int getNumeroPagine() {
        return numeroPagine;
    }

    public void setNumeroPagine(int numeroPagine) {
        this.numeroPagine = numeroPagine;
    }

    @Override
    public String toString() {
        return "Pubblicazione{" +
                "codiceISBN=" + codiceISBN +
                ", titolo='" + titolo + '\'' +
                ", annoPubblicazione=" + annoPubblicazione +
                ", numeroPagine=" + numeroPagine +
                '}';
    }
}