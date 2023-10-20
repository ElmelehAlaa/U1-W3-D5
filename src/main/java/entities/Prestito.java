package entities;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.Calendar;
import java.util.Date;

public class Prestito {

    @Id
    @GeneratedValue
    private long id;

    private Date dataInizioPrestito;
    private Date dataRestituizionePrevista;
    private Date dataRestituizioneEffettiva;

    @ManyToOne
    @JoinColumn(name="utente_id")
    private Utente utente;

    @ManyToOne
    @JoinColumn(name = "elemento_prestato_id")
    private Pubblicazione elementoPrestato;

    public Prestito(Utente utente, Pubblicazione elementoPrestato, Date dataInizioPrestito) {
        this.utente = utente;
        this.elementoPrestato = elementoPrestato;
        this.dataInizioPrestito = dataInizioPrestito;

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(dataInizioPrestito);
        calendar.add(Calendar.DAY_OF_MONTH, 30);
        this.dataRestituizionePrevista = calendar.getTime();
    }

    public Utente getUtente() {
        return utente;
    }

    public Pubblicazione getElementoPrestato() {
        return elementoPrestato;
    }

    public Date getDataInizioPrestito() {
        return dataInizioPrestito;
    }

    public Date getDataRestituizionePrevista() {
        return dataRestituizionePrevista;
    }

    public Date getDataRestituizioneEffettiva() {
        return dataRestituizioneEffettiva;
    }

    public void setDataRestituizioneEffettiva(Date dataRestituizioneEffettiva) {
        this.dataRestituizioneEffettiva = dataRestituizioneEffettiva;
    }
}
