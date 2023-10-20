package dao;

import entities.Libro;
import entities.Rivista;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class RivistaDAO {
    private final EntityManager em;

    public RivistaDAO(EntityManager em) {this.em=em;}
    public void save(Rivista p) {
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            em.persist(p);
            transaction.commit();
            System.out.println("Event salvatao correttamente: " + p);
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            System.err.println("Errore durante il salvataggio dell'Evento."+ e);
            throw e;
        }
    }

    public Rivista getById(long id) {
        return em.find(Rivista.class, id);
    }

    public void delete(long id ) {
        Rivista p = em.find(Rivista.class, id);
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
