package dao;

import entities.Libro;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class LibroDAO {
    private final EntityManager em;

    public LibroDAO(EntityManager em) {this.em=em;}
    public void save(Libro p) {
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

    public Libro getById(long id) {
        return em.find(Libro.class, id);
    }

    public void delete(long id ) {
        Libro p = em.find(Libro.class, id);
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
