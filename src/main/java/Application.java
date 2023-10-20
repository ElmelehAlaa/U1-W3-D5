import dao.LibroDAO;
import dao.RivistaDAO;
import entities.Enum.TipoPeriodicita;
import entities.Libro;
import entities.Pubblicazione;
import entities.Rivista;
import utils.JpaUtils;

import javax.persistence.EntityManager;
import javax.persistence.Query;

public class Application {

    public static void main(String[] args) {
        EntityManager em= JpaUtils.getEmf().createEntityManager();
        try {
            /////////////////CREAZIONE LIBRI E RIVISTE//////////////////////
//            LibroDAO libroDAO = new LibroDAO(em);
//            RivistaDAO rivistaDAO=  new RivistaDAO(em);
//            Libro libro1 = new Libro(1234567890L, "Il mio libro", 2023, 200, "Romanzo", "Autore del libro");
//            Libro libro2 = new Libro(1234234890L, "Libro 2", 2023, 200, "Romanzo", "Autore 2");
//            Libro libro3 = new Libro(9876543210L, "Libro 3", 2022, 250, "Fantascienza", "Autore 3");
//            Rivista rivista1 = new Rivista(1111222233L, "Rivista 1", 2023, 50, TipoPeriodicita.MENSILE);
//            Rivista rivista2 = new Rivista(4444555566L, "Rivista 2", 2023, 40, TipoPeriodicita.SETTIMANALE);
//            Rivista rivista3 = new Rivista(7777888899L, "Rivista 3", 2023, 60, TipoPeriodicita.SEMESTRALE);
//            libroDAO.save(libro1);
//            libroDAO.save(libro2);
//            libroDAO.save(libro3);
//            rivistaDAO.save(rivista1);
//            rivistaDAO.save(rivista2);
//            rivistaDAO.save(rivista3);

            ////////////////////////sout Libri//////////////////////////////
//            System.out.println("Libro creato e aggiunto al database: " + libro1);
//            System.out.println("Libro creato e aggiunto al database: " + libro2);
//            System.out.println("Libro creato e aggiunto al database: " + libro3);
//            System.out.println("Rivista creata e aggiunto al database: " + rivista1);
//            System.out.println("Rivista creata e aggiunto al database: " + rivista2);
//            System.out.println("Rivista creata e aggiunto al database: " + rivista3);


            Query pubblicazioneQuery = em.createNamedQuery("Pubblicazione.findByCodiceISBN");
            pubblicazioneQuery.setParameter("isbn", 7777888899L);



            Pubblicazione elemento = (Pubblicazione) pubblicazioneQuery.getSingleResult();
            if (elemento!= null){
                if(elemento instanceof Libro){
                    Libro libroTrovato = (Libro) elemento;
                    System.out.println("L'elemento trovato è un "+ libroTrovato);
                }else if (elemento instanceof Rivista){
                    Rivista rivistaTrovata = (Rivista) elemento;
                    System.out.println("L'elemento trovato è una " + rivistaTrovata +" titolo: "+  rivistaTrovata.getTitolo()+ " codice: "+ rivistaTrovata.getCodiceISBN() + " numero pagine:  "+  rivistaTrovata.getNumeroPagine() + "  annoPubblicazione:  "+  rivistaTrovata.getAnnoPubblicazione());
                }
            }else {
                System.out.println("Non è stato trovato un elemento con questo ISBN");
            }
        } finally {
            em.close();
            JpaUtils.close();

        }
    }
}