package entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Date;
import java.util.List;

@Entity
class Utente {
    private String nome;
    private String cognome;
    private Date dataNascita;
    @Id
    private long numeroTessera;
@OneToMany(mappedBy = "utente")
private List<Prestito> prestiti;
    public Utente(String nome, String cognome, Date dataNascita, long numeroTessera) {
        this.nome = nome;
        this.cognome = cognome;
        this.dataNascita = dataNascita;
        this.numeroTessera = numeroTessera;
    }


    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }

    public Date getDataNascita() {
        return dataNascita;
    }

    public long getNumeroTessera() {
        return numeroTessera;
    }
}
