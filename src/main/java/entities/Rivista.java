package entities;

import entities.Enum.TipoPeriodicita;

import javax.persistence.*;
import java.util.List;

@Entity
public class Rivista extends Pubblicazione {

    @Column(nullable = false)
@Enumerated(EnumType.STRING)
    private TipoPeriodicita tipoPeriodicita;
    @OneToMany(mappedBy = "elemento_prestato")
private List<Prestito>prestiti;
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

