package dao;

import entities.Pubblicazione;
import entities.Rivista;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class PubblicazioneDAO {
    private final EntityManager em;

    public PubblicazioneDAO(EntityManager em) {this.em=em;}
    public void save(Pubblicazione p) {
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            em.persist(p);
            transaction.commit();
            System.out.println("Event salvatao correttamente: " + p);
        } catch (Exception ex) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            System.err.println("Errore durante il salvataggio dell'Evento."+ ex);
            throw ex;
        }
    }

    public Pubblicazione getById(long id) {
        return em.find(Pubblicazione.class, id);
    }

    public void delete(long id ) {
        Pubblicazione p = em.find(Pubblicazione.class, id);
        if (p != null) {
            EntityTransaction transaction = em.getTransaction();
            try {
                transaction.begin();
                em.remove(p);
                transaction.commit();
                System.out.println("Evento eliminato correttamente: " + p);
            } catch (Exception e) {
                if (transaction.isActive()) {
                    transaction.rollback();
                }
                System.err.println("Errore durante l'eliminazione dell'Evento." + e);
                throw e;
            }
        }
    }
}
