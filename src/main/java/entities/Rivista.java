package entities;

import entities.Enum.TipoPeriodicita;

import javax.persistence.*;
import java.util.List;

@Entity
@NamedQuery(name = "Rivista.findByCodiceISBN", query = "SELECT r FROM Rivista r WHERE r.codiceISBN = :isbn")
public class Rivista extends Pubblicazione {

    @Column(nullable = false)
@Enumerated(EnumType.STRING)
    private TipoPeriodicita tipoPeriodicita;
    @OneToMany(mappedBy = "elementoPrestato")
private List<Prestito>prestiti;

    public Rivista(){};
    public Rivista(long codiceISBN, String titolo, int annoPubblicazione, int numeroPagine, TipoPeriodicita tipoPeriodicita) {
        super(codiceISBN, titolo, annoPubblicazione, numeroPagine);
        this.tipoPeriodicita = tipoPeriodicita;
    }

    public void setTipoPeriodicita(TipoPeriodicita tipoPeriodicita) {
        this.tipoPeriodicita = tipoPeriodicita;
    }

    @Override
    public String toString() {
        return "Rivista{" +
                "tipoPeriodicita=" + tipoPeriodicita +
                '}';
    }

    public TipoPeriodicita getTipoPeriodicita() {
        return tipoPeriodicita;
    }
}

