import dao.LibroDAO;
import entities.Libro;
import utils.JpaUtils;

import javax.persistence.EntityManager;

public class Application {

    public static void main(String[] args) {
        EntityManager em= JpaUtils.getEmf().createEntityManager();
        try {
            Libro libro = new Libro(1234567890, "Il mio libro", 2023, 200, "Romanzo", "Autore del libro");
            LibroDAO libroDAO = new LibroDAO(em);
            libroDAO.save(libro);
            System.out.println("Libro creato e aggiunto al database: " + libro);
        } finally {
            em.close();
        }
    }
}